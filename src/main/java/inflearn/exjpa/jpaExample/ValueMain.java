package inflearn.exjpa.jpaExample;

public class ValueMain {

  public static void main(String[] args) {

    int a = 10;
    int b = a; // 이 타이밍에 a = 10이 복사가 되어서 b로 넘어간다.
    // 즉, 둘은 완전히 따로따로 값을 가진다.

    a = 20; // a값 변경 => a만 값을 변경한다.
    System.out.println("a = " + a); // a = 20
    System.out.println("b = " + b); // b = 10 출력됨
    // 값이 변경이 안 된다.

    Integer c = new Integer(10);
    Integer d = c; // 이때는 주솟값(참조값)만 넘어간다.

    // 만약 여기서 c의 값을 20으로 바꾼다면

    // 여기서 c, d 모두 출력했을 때 20이 나올 것이다. 같은 인스턴스를 공유하기 때문
    System.out.println("c = " + c);
    System.out.println("d = " + d);

    // 하지만 바꿀 수 있는 방법은 없습니다.
  }

}
