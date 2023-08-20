package inflearn.exjpa.jpaExample;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Parent {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL) // 양방향 매핑 완료, CASCADE옵션 추가
  private List<Child> childList = new ArrayList<>();

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

  public List<Child> getChildList() {
    return childList;
  }

  public void setChildList(List<Child> childList) {
    this.childList = childList;
  }

  // 연관관계 편의 메서드 만들기
  public void addChild(Child child) {
    childList.add(child);
    child.setParent(this);
  }

}
