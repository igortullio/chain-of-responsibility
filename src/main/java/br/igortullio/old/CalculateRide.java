package br.igortullio.old;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class CalculateRide {

  public static class Input {
    public List<Mov> movArray;
  }

  public static class Mov {
    public Integer dist;
    public LocalDateTime ds;
  }

  public BigDecimal calc(Input movArray) {
    BigDecimal result = new BigDecimal(0);
    for (Mov mov : movArray.movArray) {
      if (Objects.nonNull(mov.dist) && mov.dist > 0) {
        if (Objects.nonNull(mov.ds)) {

          // overnight

          if (mov.ds.getHour() >= 22 || mov.ds.getHour() <= 6) {

            // not sunday
            if (mov.ds.getDayOfWeek().getValue() != 7) {
              result = result.add(BigDecimal.valueOf(mov.dist).multiply(BigDecimal.valueOf(3.90)));

            // sunday
            } else {
              result = result.add(BigDecimal.valueOf(mov.dist).multiply(BigDecimal.valueOf(5)));
            }

          } else {
            // sunday
            if (mov.ds.getDayOfWeek().getValue() == 7) {

              result = result.add(BigDecimal.valueOf(mov.dist).multiply(BigDecimal.valueOf(2.9)));

            } else {
              result = result.add(BigDecimal.valueOf(mov.dist).multiply(BigDecimal.valueOf(2.10)));

            }
          }

        } else {
          System.out.println("mov.ds is invalid");
          return BigDecimal.valueOf(-2).setScale(1, RoundingMode.UP);
        }
      } else {
        System.out.println("mov.dist is invalid");
        return BigDecimal.valueOf(-1).setScale(1, RoundingMode.UP);
      }
    }

    if (result.compareTo(BigDecimal.valueOf(10)) < 0) {
      return BigDecimal.valueOf(10).setScale(1, RoundingMode.UP);
    } else {
      return result.setScale(1, RoundingMode.UP);
    }
  }

}
