import java.util.Arrays;
import java.util.Scanner;

class ReverseArray {
  static void reverse(int[] a) {

    for (int i = 0; i < a.length / 2; i++) {
      System.out.printf("switch between a[%d] and a[%d]\n ", a[i], a[a.length - 1 - i]);

      int tmp = a[i];
      a[i] = a[a.length - 1 - i];
      a[a.length - 1 - i] = tmp;

      System.out.println(Arrays.toString(a));
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("요소수 : ");
    int num = scanner.nextInt();

    int[] a = new int[num];

    for (int i = 0; i < num; i++) {
      System.out.print("a[" + i + "] : ");
      int factor = scanner.nextInt();
      a[i] = factor;
    }

    reverse(a);

    System.out.printf("요소를 역순으로 정렬함 -> %s\n", Arrays.toString(a));
  }
}