package inflearn.exjpa.jpaExample;

import java.time.LocalDateTime;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor // 기본 생성자 반드시 있어야 한다.
@AllArgsConstructor
public class Period {

  private LocalDateTime startDate;
  private LocalDateTime endDate;

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }
}
