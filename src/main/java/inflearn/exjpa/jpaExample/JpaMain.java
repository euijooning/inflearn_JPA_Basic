package inflearn.exjpa.jpaExample;


import inflearn.exjpa.jpaExample.item.Item;
import inflearn.exjpa.jpaExample.item.Movie;
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
      Movie movie = new Movie();
      movie.setDirector("김AB");
      movie.setActor("한BC");
      movie.setName("무빙");
      movie.setPrice(10000);

      em.persist(movie);

      //조회해보기 - 먼저 1차캐시 날리기
      em.flush();
      em.clear();

//      Movie findMovie = em.find(Movie.class, movie.getId());
//      System.out.println("findMovie = "+ findMovie);

      Item findItem = em.find(Item.class, movie.getId());
      System.out.println("item = " + findItem);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}