package br.igortullio.refactor;

import java.math.BigDecimal;
import java.util.Objects;

public class SundayFareCalculator extends FareCalculator {

  private static final BigDecimal FARE = BigDecimal.valueOf(2.9);

  public SundayFareCalculator(FareCalculator next) {
    super(next);
  }

  public SundayFareCalculator() {
    super(null);
  }

  @Override
  protected BigDecimal calculate(Segment segment) {
    return BigDecimal.valueOf(segment.distance).multiply(FARE);
  }

  @Override
  protected boolean validate(Segment segment) {
    return !segment.isOvernight() && segment.isSunday();
  }

}
