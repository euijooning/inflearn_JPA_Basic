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
      Address address = new Address("seoul", "street", "10000");
      // 현재 member1과 member2는 같은 address를 쓰고 있다.

      Member memberA = new Member();
//      memberA.setUsername("member1");
//      memberA.setHomeAddress(address);
      em.persist(memberA);

      //해결책
      Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());

      Member memberB = new Member();
//      memberB.setUsername("member2");
//      memberB.setHomeAddress(copyAddress); // 여기 copyAddress 대입.
      em.persist(memberB);


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