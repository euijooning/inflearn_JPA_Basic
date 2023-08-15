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
//      Member member = new Member();
//      member.setUsername("D");
//
//      System.out.println("=======================");
//      em.persist(member);
//      System.out.println("member.id = " + member.getId());
//      System.out.println("=======================");
      Member member1 = new Member();
      member1.setUsername("A");

      Member member2 = new Member();
      member2.setUsername("B");

      Member member3 = new Member();
      member3.setUsername("C");

      System.out.println("==============");

      em.persist(member1); // 1, 51
      em.persist(member2); // 메모리에서
      em.persist(member3); // 메모리에서

      System.out.println("member1 = " + member1.getId());
      System.out.println("member2 = " + member2.getId());
      System.out.println("member3 = " + member3.getId());

      System.out.println("==============");

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}