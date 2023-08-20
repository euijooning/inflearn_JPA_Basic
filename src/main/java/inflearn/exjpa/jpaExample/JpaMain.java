package inflearn.exjpa.jpaExample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.hibernate.Hibernate;

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

      Member refMember = em.getReference(Member.class, member1.getId());
      System.out.println("refMember = " + refMember.getClass()); // Proxy
      // 강제 초기화
      Hibernate.initialize(refMember);

//      Member refMember = em.getReference(Member.class, member1.getId());
////      System.out.println("refMember" + refMember.getClass()); // Proxy
//      System.out.println("refMember 클래스 이름 = " + refMember.getClass().getName()); // Proxy
//      refMember.getUsername(); //초기화 수행

//      // 프록시 인스턴스의 초기화 여부 확인
//      // 위에서 초기화 수행
//      System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));

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