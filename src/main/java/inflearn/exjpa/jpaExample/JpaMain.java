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
//      member.setTeamId(team.getId()); // member.setTeam(); 이 아니다.
      member.setTeam(team);
      // 이러면 Jpa가 팀에서 알아서 pk값을 꺼내서 Insert할 때 FK 값으로 사용한다.

      em.persist(member);

      em.flush();
      em.clear();

//      Member findMember = em.find(Member.class, member.getId());
//
//      Long findTeamId = findMember.getTeamId();;;
//      Team findTeam = em.find(Team.class, findTeamId);

      // 조회할 때도 단순해짐
      Member findMember = em.find(Member.class, member.getId());
      // 1차캐시에서 가져오는 것 잊어버리지 말기

      Team findTeam = findMember.getTeam();
      System.out.println("팀찾기 = " + findTeam.getName());

//      // 수정 예시
//      Team newTeam = em.find(Team.class, 100L); // 아이디 100번인 팀이 있다고 가졍
//      findMember.setTeam(newTeam);
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}