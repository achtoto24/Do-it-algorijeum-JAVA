import java.util.Scanner;

class EuclidGCD3 {
  static int gcd(int[] a) {
    int result = a[0];
    for (int i = 1; i < a.length; i++)
      result = gcd(result, a[i]);
    return result;
  }

  static int gcd(int x, int y) {
    if (y == 0)
      return x;
    else
      return gcd(y, x % y);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] arr = new int[5];

    for (int i = 0; i < arr.length; i++) {
      System.out.printf("정수를 입력하세요(%d/5) : ", i + 1);
      arr[i] = scanner.nextInt();
    }

    System.out.println("최대공약수 : " + gcd(arr));
  }
}