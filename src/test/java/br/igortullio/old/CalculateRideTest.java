package br.igortullio.old;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.igortullio.old.CalculateRide.Input;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import support.old.CalculateRideInputProvider;
import support.old.MovProvider;

class CalculateRideTest {

  @ParameterizedTest
  @MethodSource
  void deveCalcularValorCorrida(int dist, LocalDateTime ds, BigDecimal expected) {
    Input input = CalculateRideInputProvider.create();
    input.movArray.add(MovProvider.create(dist, ds));

    BigDecimal response = new CalculateRide().calc(input);

    assertEquals(expected, response);
  }

  static Stream<Arguments> deveCalcularValorCorrida() {
    return Stream.of(
        Arguments.of(10, LocalDateTime.of(2024, Month.JANUARY, 1, 10, 0), BigDecimal.valueOf(21.0)),
        Arguments.of(10, LocalDateTime.of(2024, Month.JANUARY, 1, 23, 0), BigDecimal.valueOf(39.0)),
        Arguments.of(10, LocalDateTime.of(2024, Month.JANUARY, 1, 5, 0), BigDecimal.valueOf(39.0)),
        Arguments.of(10, LocalDateTime.of(2024, Month.JANUARY, 7, 10, 0), BigDecimal.valueOf(29.0)),
        Arguments.of(10, LocalDateTime.of(2024, Month.JANUARY, 7, 23, 0), BigDecimal.valueOf(50.0)),
        Arguments.of(1, LocalDateTime.of(2024, Month.JANUARY, 1, 10, 0), BigDecimal.valueOf(10.0))
    );
  }

  @ParameterizedTest
  @MethodSource
  void naodeveCalcularValorCorrida(Integer dist, LocalDateTime ds, BigDecimal expected) {
    Input input = CalculateRideInputProvider.create();
    input.movArray.add(MovProvider.create(dist, ds));

    BigDecimal response = new CalculateRide().calc(input);

    assertEquals(expected, response);
  }

  static Stream<Arguments> naodeveCalcularValorCorrida() {
    return Stream.of(
        Arguments.of(null, LocalDateTime.of(2024, Month.JANUARY, 1, 10, 0), BigDecimal.valueOf(-1.0)),
        Arguments.of(-10, LocalDateTime.of(2024, Month.JANUARY, 1, 10, 0), BigDecimal.valueOf(-1.0)),
        Arguments.of(10, null, BigDecimal.valueOf(-2.0))
    );
  }

}
