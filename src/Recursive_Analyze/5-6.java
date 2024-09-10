
//재귀 알고리즘의 메모화
import java.util.Scanner;

class RecurMemo {
  static String[] memo;
  static int cnt = 0;

  static void recur(int n) {
    cnt++;
    if (memo[n + 1] != null)
      System.out.print(memo[n + 1]);
    else {
      if (n > 0) {
        recur(n - 1);
        System.out.println(n);
        recur(n - 2);
        memo[n + 1] = memo[n] + n + "\n" + memo[n - 1];
      } else {
        memo[n + 1] = "";
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("정수를 입력하세요. : ");
    int x = scanner.nextInt();

    memo = new String[x + 2];
    recur(x);
    System.out.println("메서드 호출 횟수 : " + cnt);
  }
}