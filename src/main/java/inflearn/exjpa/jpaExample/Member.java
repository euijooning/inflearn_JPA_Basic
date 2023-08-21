package inflearn.exjpa.jpaExample;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

  @Embedded
  private Address homeAddress;

  @ElementCollection
  @CollectionTable(name = "FAVORITE_FOOD",
                  joinColumns = @JoinColumn(name = "MEMBER_ID"))
  @Column(name = "FOOD_NAME") // 얘는 값이 String 하나고 내가 정의한 게 아니므로. 예외적 허용.
  private Set<String> favoriteFoods = new HashSet<>();

//  @ElementCollection
//  @CollectionTable(name = "ADDRESS",
//                  joinColumns = @JoinColumn(name = "MEMBER_ID")) // 이러면 얘를 외래키로 잡게 됨.
//  private List<Address> addressHistory = new ArrayList<>();

  //위에 것을 아래처럼 만들 수 있음.
  // 일대다 단방향 매핑으로 만들자.
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "MEMBER_ID")
  private List<AddressEntity> addressHistory = new ArrayList<>();

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

  public Address getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(Address homeAddress) {
    this.homeAddress = homeAddress;
  }

  public Set<String> getFavoriteFoods() {
    return favoriteFoods;
  }

  public void setFavoriteFoods(Set<String> favoriteFoods) {
    this.favoriteFoods = favoriteFoods;
  }

//  public List<Address> getAddressHistory() {
//    return addressHistory;
//  }
//
//  public void setAddressHistory(List<Address> addressHistory) {
//    this.addressHistory = addressHistory;
//  }

  public List<AddressEntity> getAddressHistory() {
    return addressHistory;
  }

  public void setAddressHistory(List<AddressEntity> addressHistory) {
    this.addressHistory = addressHistory;
  }
}