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
      Member member1 = new Member();
      member1.setUsername("member1");
      em.persist(member1);

      em.flush();
      em.clear();

//      Member referMember = em.getReference(Member.class, member1.getId());
//      System.out.println("refMember = " + referMember.getClass()); // Proxy
//
////      em.detach(referMember); // 여기서 영속성 컨텍스트와 연결을 해지함
//      referMember.getUsername(); // 유저네임 호출한 상태


//      Member findM1 = em.find(Member.class, member1.getId());
//      System.out.println("findM1 = " + findM1.getClass()); // 클래스가 정확하게 나온다.
//      // 프록시가 아니라 진짜 멤버 타입이므로
//      // 여기다가 추가
//      Member referenceM = em.getReference(Member.class, member1.getId());
//      System.out.println("referenceM = " + referenceM.getClass());
//      System.out.println("a == a : " + (findM1 == referenceM));

//      Member findRm1 = em.getReference(Member.class, member1.getId());
//      System.out.println("findRm1 = " + findRm1.getClass());
//      findRm1.getUsername(); // 이걸 호출
//
//      Member rfM = em.getReference(Member.class, member1.getId());
//      System.out.println("rfM = " + rfM.getClass());
//
//      System.out.println("a == a : " + (findRm1 == rfM));

//      Member refMember = em.getReference(Member.class, member1.getId());
//      System.out.println("refMember = " + refMember.getClass());
//
//
//      Member findMember = em.getReference(Member.class, member1.getId());
//      System.out.println("findMember = " + findMember.getClass());
//
//      System.out.println("a == a : " + (refMember == findMember));

//      Member member = new Member();
//      member.setUsername("hello");
//      em.persist(member);

//      Member member1 = new Member();
//      member1.setUsername("member1");
//      em.persist(member1);
//
//      Member member2 = new Member();
//      member2.setUsername("member2");
//      em.persist(member2);
//
//      em.flush();
//      em.clear();

//      Member fm1 = em.find(Member.class, member1.getId());
////      Member fm2 = em.find(Member.class, member2.getId());
//      Member fm2 = em.getReference(Member.class, member2.getId());
//      System.out.println("fm1 == fm2 의 비교 값 : " + (fm1.getClass() == fm2.getClass()));

//      Member fm1 = em.find(Member.class, member1.getId());
//      Member fm2 = em.getReference(Member.class, member2.getId());
//      logic(fm1, fm2);

      //
////      Member findMember = em.find(Member.class, member.getId());
//      Member findMember = em.getReference(Member.class, member.getId()); // getReference로 변경함.
////      System.out.println("findMember = " + findMember.getClass());
//      System.out.println("findMember.id = " + findMember.getId());
//
//      System.out.println("before findMember = " + findMember.getClass());
//      System.out.println("findMember.username = " + findMember.getUsername());
//      System.out.println("after findMember = " + findMember.getClass());



//      Member member = em.find(Member.class, 1L);
//      printMember(member);

//      printMemberAndTeam(member);
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace(); // 하나 찍어봄
    } finally {
      em.close();
    }
    emf.close();
  }

//  private static void logic(Member fm1, Member fm2) {
//    System.out.println("fm1 == fm2 : " + (fm1 instanceof Member));
//    System.out.println("fm1 == fm2 : " + (fm2 instanceof Member));
//  }

//  private static void printMember(Member member) {
//    System.out.println("member = " + member.getUsername());
//  }
//
//  private static void printMemberAndTeam(Member member) {
//    String username = member.getUsername();
//    System.out.println("username = " + username);
//
//    Team team = member.getTeam();
//    System.out.println("team = " + team.getName());
//  }
}