package inflearn.exjpa.jpaExample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

//  @Column(name = "TEAM_ID")
//  private Long teamId;
//  //멤버와 팀을 레퍼런스로 가져가야 하는데 지금은 그냥 DB에 맞춰서 모델링을 한 것.

  @ManyToOne
  @JoinColumn(name = "TEAM_ID")
  private Team team;
  //Member 입장에서는 여러 멤버가 하나의 팀에 소속될 수 있으므로.
  // 그리고 객체에 있는 Team team;레퍼런스랑. Member 테이블의 TEAM_ID(FK)랑 매핑을 해야.


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNane() {
    return nane;
  }

  public void setNane(String nane) {
    this.nane = nane;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }
}