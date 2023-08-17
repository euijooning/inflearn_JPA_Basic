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
      //팀 저장
      Team team = new Team();
      team.setName("TeamA");
      em.persist(team);

      //회원 저장
      Member member = new Member();
      member.setUsername("member1");
//      member.setTeamId(team.getId()); // member.setTeam(); 이 아니다.
      member.setTeam(team);
      // 이러면 Jpa가 팀에서 알아서 pk값을 꺼내서 Insert할 때 FK 값으로 사용한다.

      em.persist(member);

      em.flush();
      em.clear();

      Member findMember = em.find(Member.class, member.getId());
      List<Member> members = findMember.getTeam().getMembers();

      for (Member m1 : members) {
        System.out.println("m = " + member.getUsername());
      }

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}