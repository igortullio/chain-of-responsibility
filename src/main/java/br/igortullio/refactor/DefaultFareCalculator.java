package br.igortullio.refactor;

import java.math.BigDecimal;

public class DefaultFareCalculator extends FareCalculator {

  private static final BigDecimal FARE = BigDecimal.valueOf(2.10);

  public DefaultFareCalculator(FareCalculator next) {
    super(next);
  }

  public DefaultFareCalculator() {
    super(null);
  }

  @Override
  protected BigDecimal calculate(Segment segment) {
    return BigDecimal.valueOf(segment.distance).multiply(FARE);
  }

  @Override
  protected boolean validate(Segment segment) {
    return !segment.isOvernight() && !segment.isSunday();
  }

}
