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
      Child child1 = new Child();
      Child child2 = new Child();

      Parent parent = new Parent();
      parent.addChild(child1);
      parent.addChild(child2);

      em.persist(parent);
      em.persist(child1);
      em.persist(child2);

      em.flush();
      em.clear();

      Parent findParent = em.find(Parent.class, parent.getId());
//      findParent.getChildList().remove(0); // 첫 번째 것 지움
      em.remove(findParent); // 조회한 parent를 지워버림
      // 그럼 orphanRemoval 입장에서는 이 컬렉션은 다 날아간 것임. 그래서 자식까지 다 delete 된다.


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