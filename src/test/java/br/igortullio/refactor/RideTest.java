package br.igortullio.refactor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RideTest {

  private final FareCalculator fareCalculator = new FridayNoonFareCalculator(new DefaultFareCalculator(new OvernightFareCalculator(new SundayFareCalculator(new OvernightSundayFareCalculator()))));

  private Ride ride;

  @BeforeEach
  void setup() {
    ride = new Ride(fareCalculator);
  }

  @ParameterizedTest
  @MethodSource
  void shouldCalculateRideFare(int distance, LocalDateTime dateTime, BigDecimal expected) {
    ride.addSegment(distance, dateTime);

    ride.calculateFare();

    assertEquals(expected, ride.getFare());
  }

  static Stream<Arguments> shouldCalculateRideFare() {
    return Stream.of(
        Arguments.of(10, LocalDateTime.of(2021, Month.MARCH, 1, 10, 0), BigDecimal.valueOf(21.0)),
        Arguments.of(10, LocalDateTime.of(2021, Month.MARCH, 1, 23, 0), BigDecimal.valueOf(39.0)),
        Arguments.of(10, LocalDateTime.of(2021, Month.MARCH, 1, 5, 0), BigDecimal.valueOf(39.0)),
        Arguments.of(10, LocalDateTime.of(2021, Month.MARCH, 7, 10, 0), BigDecimal.valueOf(29.0)),
        Arguments.of(10, LocalDateTime.of(2021, Month.MARCH, 7, 23, 0), BigDecimal.valueOf(50.0)),
        Arguments.of(1, LocalDateTime.of(2021, Month.MARCH, 1, 10, 0), BigDecimal.valueOf(10.0)),
        Arguments.of(153, LocalDateTime.of(2021, Month.MARCH, 5, 12, 0), BigDecimal.valueOf(153.0))
    );
  }

}
