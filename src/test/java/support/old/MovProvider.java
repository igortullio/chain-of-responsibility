package support.old;

import br.igortullio.old.CalculateRide.Mov;
import java.time.LocalDateTime;

public class MovProvider {

  public static Mov create(Integer dist, LocalDateTime ds) {
    Mov mov = new Mov();
    mov.dist = dist;
    mov.ds = ds;
    return mov;
  }

}
