package inflearn.exjpa.jpaExample;


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
      //저장
//      Member member = new Member();
//      member.setUsername("member1");
//      em.persist(member);
//
//      Team team = new Team();
//      team.setName("TeamA");
//      team.getMembers().add(member);
//      em.persist(team);

      // 순서도 조금 바꿔서
      Team team = new Team();
      team.setName("TeamA");
      em.persist(team);

      Member member = new Member();
      member.setUsername("member1");
      member.setTeam(team);
      em.persist(member);

      em.flush();
      em.clear();

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}