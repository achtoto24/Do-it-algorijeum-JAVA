import java.util.Scanner;

class Recur {
  static int cnt = 0;

  static void recur(int n) {
    cnt++;
    if (n > 0) {
      recur(n - 1);
      System.out.println(n);
      recur(n - 2);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("정수를 입력하세요 : ");
    int x = scanner.nextInt();

    recur(x);
    System.out.println("메서드 호출 횟수 : " + cnt);
  }
}