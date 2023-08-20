package inflearn.exjpa.jpaExample;

public class ValueMain {

  public static void main(String[] args) {

    int a = 10;
    int b = 10;
    System.out.println("a == b : " + (a==b)); // true 출력

    Address address1 = new Address("seoul", "garosugil", "10000");
    Address address2 = new Address("seoul", "garosugil", "10000");
    System.out.println("address1 == address2 : " + (address1==address2));

    System.out.println("address1 equals address2 : " + (address1.equals(address2)));
  }
}
