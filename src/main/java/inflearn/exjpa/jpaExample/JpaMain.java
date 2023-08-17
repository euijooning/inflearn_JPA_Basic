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
      //팀 저장
      Team team = new Team();
      team.setName("TeamA");
      em.persist(team);

      //회원 저장
      Member member = new Member();
      member.setNane("member1");
      member.setTeamId(team.getId()); // member.setTeam(); 이 아니다.
      em.persist(member);


      Member findMember = em.find(Member.class, member.getId());

      Long findTeamId = findMember.getTeamId();;;
      Team findTeam = em.find(Team.class, findTeamId);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}