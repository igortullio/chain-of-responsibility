package support.refactor;

import br.igortullio.refactor.Segment;
import java.time.LocalDateTime;

public class SegmentProvider {

  public static Segment create(Integer distance, LocalDateTime dateTime) {
    return new Segment(distance, dateTime);
  }

}
