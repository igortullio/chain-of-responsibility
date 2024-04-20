package br.igortullio.refactor;

import java.math.BigDecimal;

public class OvernightSundayFareCalculator extends FareCalculator {

  private static final BigDecimal FARE = BigDecimal.valueOf(5);

  public OvernightSundayFareCalculator(FareCalculator next) {
    super(next);
  }

  public OvernightSundayFareCalculator() {
    super(null);
  }

  @Override
  protected BigDecimal calculate(Segment segment) {
    return BigDecimal.valueOf(segment.distance).multiply(FARE);
  }

  @Override
  protected boolean validate(Segment segment) {
    return segment.isOvernight() && segment.isSunday();
  }

}
