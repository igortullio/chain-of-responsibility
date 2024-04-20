package support.old;

import br.igortullio.old.CalculateRide;

public class CalculateRideInputProvider {

  public static CalculateRide.Input create() {
    CalculateRide.Input input = new CalculateRide.Input();
    input.movArray = new java.util.ArrayList<>();
    return input;
  }

}
