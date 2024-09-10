import java.util.Scanner;

class EuclidGCD2 {
  static int gcd(int x, int y) {
    while (y != 0) {
      int tmp = x;
      x = y;
      y = tmp % y;
    }
    return x;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("정수를 입력하세요 : ");
    int x = scanner.nextInt();

    System.out.print("정수를 입력하세요 : ");
    int y = scanner.nextInt();

    System.out.println("최대공약수 : " + gcd(x, y));
  }
}