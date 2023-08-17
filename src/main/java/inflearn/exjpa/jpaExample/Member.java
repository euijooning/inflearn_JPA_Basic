package inflearn.exjpa.jpaExample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "MEMBER_ID")
  private Long id;

  @Column(name = "USERNAME")
  private String nane;

  @Column(name = "TEAM_ID")
  private Long teamId;
  //멤버와 팀을 레퍼런스로 가져가야 하는데 지금은 그냥 DB에 맞춰서 모델링을 한 것.


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String usernane() {
    return nane;
  }

  public void setNane(String nane) {
    this.nane = nane;
  }

  public Long getTeamId() {
    return teamId;
  }

  public void setTeamId(Long teamId) {
    this.teamId = teamId;
  }
}