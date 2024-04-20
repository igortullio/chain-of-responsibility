package br.igortullio.refactor;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SegmentTest {

  @ParameterizedTest
  @MethodSource
  void notShouldCreateSegment(int distance, LocalDateTime dateTime, String message) {
    assertThrows(IllegalArgumentException.class, () -> new Segment(distance, dateTime), message);
  }

  static Stream<Arguments> notShouldCreateSegment() {
    return Stream.of(
        Arguments.of(-10, LocalDateTime.of(2021, Month.MARCH, 1, 10, 0), "Distance is invalid"),
        Arguments.of(10, null, "Date is invalid")
    );
  }

}
