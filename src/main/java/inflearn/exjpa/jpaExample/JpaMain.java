package inflearn.exjpa.jpaExample;

import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {

      Member member = new Member();
      member.setUsername("member1");
      member.setHomeAddress(new Address("homeCity", "street", "10000")); //Member 테이블에 값들이 들어갈 거예요.

      // 이 FAVORITEFOODS 컬렉션에 세 가지가 들어간다.
      member.getFavoriteFoods().add("치킨");
      member.getFavoriteFoods().add("족발");
      member.getFavoriteFoods().add("피자");

      member.getAddressHistory().add(new Address("oldCity1", "street", "10000"));
      member.getAddressHistory().add(new Address("oldCity2", "street", "10000"));

      em.persist(member); // 저장

      em.flush();
      em.clear();

      System.out.println("============START============");
      Member findMember = em.find(Member.class, member.getId());

      // 추가한 부분, 이제서야 쿼리 나갈 것이다.
      List<Address> addresssHistory = findMember.getAddressHistory();
      for (Address address : addresssHistory) { // iter 라고만 쓰면 알아서 향상된 for문 나옴.
        System.out.println("address = " + address.getCity());
      }

      Set<String> favoriteFoods = findMember.getFavoriteFoods();
      for (String favoriteFood : favoriteFoods) {
        System.out.println("favoriteFood = " + favoriteFood);
      }

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
    } finally {
      em.close();
    }
    emf.close();
  }
}