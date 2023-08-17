package inflearn.exjpa.jpaExample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "MEMBER_ID")
  private Long id;

  @Column(name = "USERNAME")
  private String username;

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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Team getTeam() {
    return team;
  }

//  public void setTeam(Team team) {
//    this.team = team;
//    team.getMembers().add(this);
//  }

  // set 대신에 새롭게
    public void changeTeam(Team team) {
    this.team = team;
    team.getMembers().add(this);
  }

//  @Override
//  public String toString() {
//    return "Member{" +
//        "id=" + id +
//        ", username='" + username + '\'' +
//        ", team=" + team +
//        '}';
//  } // stackovarflow 나옴.
}