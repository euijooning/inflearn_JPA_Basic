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
      Member member = new Member();
      member.setUsername("member1");

      em.persist(member);
      //여기까지 하면 멤버가 저장

      Team team = new Team();
      team.setName("TeamA");
      // 여기까지 팀 테이블에 인서트

      // 얘가 좀 애매함.
      // 팀 테이블에 인서트 될 수 있는 상황이 아님.
      // 이 외래키는 MEMBER 테이블에 있음.
      // 그럼 MEMBER 테이블에 있는 TEAM_ID(FK)를 업데이트 쳐줘야 함.)
      team.getMembers().add(member);

      em.persist(team);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}