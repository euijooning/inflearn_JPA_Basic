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
      //비영속
//      Member member = new Member();
////      member.setId(100L);
//      member.setId(101L);
//      member.setName("Haerin");

      //영속
//      System.out.println("BEFORE================");
////      em.persist(member); //그런데 이 때 DB에 저장되는 건 아니다.
//      em.persist(member);
//      System.out.println("AFTER================");

//      Member findMember = em.find(Member.class, 101L);
//      System.out.println("findMember.id = " + findMember.getId());
//      System.out.println("findMember.name = " + findMember.getName());
//      Member findMember1 = em.find(Member.class, 101L);
//      Member findMember2 = em.find(Member.class, 101L);
//
//      System.out.println("result = " + (findMember1 == findMember2));

// 롬복 의존성 추가 후 생성자 Member 클래스에 만들어놓고
//      Member member1 = new Member(150L, "A");
//      Member member2 = new Member(160L, "B");
//
//      em.persist(member1);
//      em.persist(member2); // 여기까지 영속성 컨텍스트에 쌓임
//      System.out.println("==========쿼리 나가는 거 구분선==========");

//      Member member = em.find(Member.class, 150L); // 현재 이름은 A
//      member.setName("ZZZAAA");

//      Member member = new Member(200L, "member200");
//      em.persist(member);
//      //미리 보고싶으면
//      em.flush();//강제로 호출

      //영속 상태
      Member member = em.find(Member.class, 150L);
      member.setName("AAAAA");
      em.detach(member); // 준영속 상태로 만듦

      System.out.println("===================");
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
