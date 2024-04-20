package br.igortullio.refactor;

import java.math.BigDecimal;

public class FridayNoonFareCalculator extends FareCalculator {

  private static final BigDecimal FARE = BigDecimal.valueOf(1);

  protected FridayNoonFareCalculator(FareCalculator next) {
    super(next);
  }

  protected FridayNoonFareCalculator() {
    super(null);
  }

  @Override
  protected BigDecimal calculate(Segment segment) {
    return BigDecimal.valueOf(segment.distance).multiply(FARE);
  }

  @Override
  protected boolean validate(Segment segment) {
    return segment.isNoon() && segment.isFriday();
  }

}
