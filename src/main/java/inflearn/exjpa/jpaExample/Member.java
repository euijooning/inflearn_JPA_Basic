package inflearn.exjpa.jpaExample;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Member {

  @Id
  @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;

  @Column(name = "USERNAME")
  private String username;

  //기간 묶기 Period
  @Embedded
  private Period workPeriod;

  // 주소 묶기 Address
  @Embedded
  private Address homeAddress;

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }


  public Period getWorkPeriod() {
    return workPeriod;
  }

  public Address getHomeAddress() {
    return homeAddress;
  }

}