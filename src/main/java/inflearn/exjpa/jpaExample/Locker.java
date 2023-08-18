package inflearn.exjpa.jpaExample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Locker {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  //양방향으로 만들고 싶다면
  @OneToOne(mappedBy = "locker")
  private Member member;
}
// 실습 X
