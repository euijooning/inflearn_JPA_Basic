package inflearn.exjpa;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Member {

  @Id
  private Long id;

  @Column(name = "name") // db에는 name이라고 쓰고 싶을 때.
  private String username;

  private Integer age;

  @Enumerated(EnumType.STRING) //DB에는 기본적으로 Enum 타입이 없다.
  private RoleType roleType;

  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;

  @Temporal(TemporalType.TIMESTAMP)
  private Date lastModifiedDate;

  @Lob
  private String description;

}