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
      //팀도 세팅
      Team team = new Team();
      team.setName("teamA");
      em.persist(team);

      Member member1 = new Member();
      member1.setUsername("member1");
      member1.setTeam(team);
      em.persist(member1);

      em.flush();
      em.clear();

      Member m = em.find(Member.class, member1.getId());
      System.out.println("m = " + m.getTeam().getClass());

      System.out.println("이전===================");
//      m.getTeam().getName(); // 쿼리 나가는 시점(초기화) => 여기서는 필요x
      System.out.println("teamName = " + m.getTeam().getName()); // 실제 팀이름 teamA가 출력됨.
      System.out.println("이후===================");

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace(); // 하나 찍어봄
    } finally {
      em.close();
    }
    emf.close();
  }
}