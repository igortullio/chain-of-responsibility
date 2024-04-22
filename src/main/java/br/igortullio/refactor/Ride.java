package br.igortullio.refactor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ride {

  private final List<Segment> segments;
  private BigDecimal fare;

  private final FareCalculator fareCalculator;

  public Ride(FareCalculator fareCalculator) {
    this.segments = new ArrayList<>();
    this.fare = new BigDecimal(0);
    this.fareCalculator = fareCalculator;
  }

  public BigDecimal getFare() {
    return fare.setScale(1, RoundingMode.HALF_UP);
  }

  public void addSegment(int distance, LocalDateTime dateTime) {
    Segment segment = new Segment(distance, dateTime);
    this.segments.add(segment);
    this.calculateFare();
  }

  private void calculateFare() {
    BigDecimal newFare = segments.stream()
        .map(fareCalculator::calculateFare)
        .reduce(BigDecimal.ZERO, BigDecimal::add);

    this.fare = newFare.compareTo(BigDecimal.valueOf(10)) < 0 ? BigDecimal.valueOf(10) : newFare;
  }

}
