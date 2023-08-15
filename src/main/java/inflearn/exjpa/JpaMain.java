package inflearn.exjpa;


import java.util.List;
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
//      Member member1 = new Member();
//      member1.setId(1L);
//      member1.setUsername("A");
//      member1.setRoleType(RoleType.USER);
//      em.persist(member1);
//
//      Member member2 = new Member();
//      member2.setId(2L);
//      member2.setUsername("B");
//      member2.setRoleType(RoleType.ADMIN);
//      em.persist(member2);
//
//      Member member3 = new Member();
//      member3.setId(3L);
//      member3.setUsername("C");
//      member3.setRoleType(RoleType.GUEST);
//      em.persist(member3);

//      Member member4 = new Member();
//      member4.setId(4L);
//      member4.setUsername("D");
//      member4.setRoleType(RoleType.BEST_USER);
//      em.persist(member4);
      Member member = new Member();
      member.setId(5L);
      member.setUsername("E");
      member.setRoleType(RoleType.ADMIN);
      em.persist(member);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
