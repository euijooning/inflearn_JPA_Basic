package inflearn.exjpa.jpaExample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "MEMBER_ID")
  private Long id;

  //양방향 추가(역방향)
  @ManyToOne
  @JoinColumn(name = "TEAM_ID",insertable = false, updatable = false) // 읽기 전용화 
  private Team team;

  @Column(name = "USERNAME")
  private String username;

  @OneToOne
  @JoinColumn(name = "LOCKER_ID")
  private Locker locker;

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

}