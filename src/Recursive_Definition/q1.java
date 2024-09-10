import java.util.Scanner;

class Factorial2 {
  static int factorial(int n) {
    int result = 1;
    for (int i = n; i > 0; i--) {
      result *= i;
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num = 0;
    do {
      System.out.print(" 0이 아닌 정수를 입력하세요 : ");
      int x = scanner.nextInt();
      num = x;
    } while (num == 0);

    System.out.println(num + "! = " + factorial(num));
  }
}