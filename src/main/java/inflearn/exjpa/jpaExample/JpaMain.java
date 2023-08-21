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

      // iter지우고 수정 예제
      //이렇게 하면 일단 안 된다. sideEffect 발생
//      findMember.getHomeAddress().setCity("newCity");

      // 답은, 아예 새로 넣기다.(통으로 값 타입을 갈아끼운다. 완전한 교체
      // 도시명만 바꾸고 나머지는 그대로 하고싶다고 가정.
      Address origin = findMember.getHomeAddress();
      findMember.setHomeAddress(new Address("newCity", origin.getStreet(), origin.getZipcode()));

      // 이제 값 타입 컬렉션 업데이트
      // 컬렉션 내의 치킨 => 힌식으로 변경
      findMember.getFavoriteFoods().remove("치킨");
      findMember.getFavoriteFoods().add("한식");

      // 이제 주소 바꾸기 , 값 타입 인스턴스를 통으로 갈아끼워야한다는 것 명심.
      // 컬렉션들은 값을 찾을 때 equals()로 찾느다.
      findMember.getAddressHistory().remove(new Address("oldCity1", "street", "10000"));
      // equals And hashcode 앞서 구현해놓았기 때문에 사용 가능
      // 그리고 add도 해주기
      findMember.getAddressHistory().add(new Address("newCity1", "street", "10000"));

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