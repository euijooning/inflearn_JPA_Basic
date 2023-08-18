package inflearn.exjpa.jpaExample;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Product {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  // 양방향으로 만들고 싶으면
  @ManyToMany(mappedBy = "products")
  private List<Member> members = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
