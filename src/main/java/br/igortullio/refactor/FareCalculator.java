package br.igortullio.refactor;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class FareCalculator {

  protected final FareCalculator next;

  protected FareCalculator(FareCalculator next) {
    this.next = next;
  }

  public BigDecimal calculateFare(Segment segment) {
    if (validate(segment)) return calculate(segment);
    if (Objects.isNull(next)) throw new IllegalStateException("Next calculator is required");
    return next.calculateFare(segment);
  }

  protected abstract BigDecimal calculate(Segment segment);

  protected abstract boolean validate(Segment segment);

}
