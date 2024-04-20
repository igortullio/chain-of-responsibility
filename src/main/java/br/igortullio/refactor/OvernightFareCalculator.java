package br.igortullio.refactor;

import java.math.BigDecimal;

public class OvernightFareCalculator extends FareCalculator {

  private static final BigDecimal FARE = BigDecimal.valueOf(3.90);

  public OvernightFareCalculator(FareCalculator next) {
    super(next);
  }

  public OvernightFareCalculator() {
    super(null);
  }

  @Override
  protected BigDecimal calculate(Segment segment) {
    return BigDecimal.valueOf(segment.distance).multiply(FARE);
  }

  @Override
  protected boolean validate(Segment segment) {
    return segment.isOvernight() && !segment.isSunday();
  }

}
