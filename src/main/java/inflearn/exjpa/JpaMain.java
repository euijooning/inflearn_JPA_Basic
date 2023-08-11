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

//    // 회원 등록
//        try {
//      Member member = new Member();
//      member.setId(3L);
//      member.setName("Danille");
//      em.persist(member);
//      tx.commit();
//    } catch (Exception e) {
//      tx.rollback();
//    } finally {
//      em.close();
//    }
//    emf.close();
//  }


//    // 조회
//    try {
//      Member findmember = em.find(Member.class, 1L); //민지찾기
//      System.out.println("findMember.id = " + findmember.getId());
//      System.out.println("findMember.name = " + findmember.getName());
//      tx.commit();
//    } catch (Exception e) {
//      tx.rollback();
//    } finally {
//      em.close();
//    }
//    emf.close();
//  }

//    // 수정
//    try {
//      Member findmember = em.find(Member.class, 1L); //민지찾기
//
//      findmember.setName("Kimminji");
//      // em.persist(findmember); ==> 이게 필요가 없다!!!
//
//      tx.commit();
//    } catch (Exception e) {
//      tx.rollback();
//    } finally {
//      em.close();
//    }
//    emf.close();

    try {
    // JPQL
    List<Member> result = em.createQuery("select m from Member as m", Member.class)
        .setFirstResult(5) //페이징 처리에 도움  시작위치
        .setMaxResults(10) //가져올 결과의 개수
        .getResultList();

    /*
    그런데 JPA에서는 테이블을 대상으로 절대 쿼리를 짜지 않는다.
    => 즉, 위의 쿼리문은 테이블이 대상이 아니라, 객체가 대상인 것이다.
     */

    for (Member member : result) { //iter 누르면 자동 생성 ㅋ
      System.out.println("member.name = " + member.getName()); // soutv 누르면 형식 자동 생성 ㅋ
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
