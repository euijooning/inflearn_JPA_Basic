package inflearn.exjpa.jpaExample;

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