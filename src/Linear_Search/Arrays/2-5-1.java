import java.util.Arrays;
import java.util.Scanner;

class CopyArray {
  static void copy(int[] a, int[] b) {
    for (int i = 0; i < a.length; i++)
      a[i] = b[i];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("요소수 : ");
    int num = scanner.nextInt();

    int[] a = new int[num];
    int[] b = new int[num];

    for (int i = 0; i < num; i++) {
      System.out.print("b[" + i + "] : ");
      int factor = scanner.nextInt();
      b[i] = factor;
    }

    copy(a, b);

    System.out.printf("배열 b : %s\n", Arrays.toString(b));
    System.out.printf("배열 a : %s\n", Arrays.toString(a));
  }
}