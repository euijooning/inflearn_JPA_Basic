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
      // 순서도 조금 바꿔서
      Team team = new Team();
      team.setName("TeamA");
      em.persist(team);

      Member member = new Member();
      member.setUsername("member1");
      member.changeTeam(team);
      em.persist(member);

//      team.getMembers().add(member); 이거를 가져다가

      em.flush();
      em.clear();

      // 더 안전하게, 양쪽에 다 값을 세팅
      Team findTeam = em.find(Team.class, team.getId());
      List<Member> members = findTeam.getMembers();
      for (Member m : members) {
        System.out.println("m = " + m.getUsername());
      }
      // 이렇게 해도(현재 리스트에 값을 세팅한 게 없어도) 값이 출력이 된다.
      // jpa에서 select 쿼리를멤버를 조회하면서 한번 더 보냄.

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}