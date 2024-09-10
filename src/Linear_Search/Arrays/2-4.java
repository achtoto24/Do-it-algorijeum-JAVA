import java.util.Random;
import java.util.Scanner;

class MaxArray {
  static int maxOf(int[] a) {
    int max = a[0];

    for (int i = 1; i < a.length; i++) {
      if (a[i] > max)
        max = a[i];
    }

    return max;
  }

  public static void main(String[] args) {
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    System.out.println("키의 최댓값을 구하기");
    int num = rand.nextInt(15);
    System.out.printf("사람 수 : %d\n", num);
    int[] height = new int[num];

    if (num == 0) {
      System.out.println("그만");
    } else {
      for (int i = 0; i < num - 1; i++) {
        height[i] = 100 + rand.nextInt(90);
        System.out.print(height[i] + ", ");
      }
      height[num - 1] = 100 + rand.nextInt(90);
      System.out.printf("%d\n", height[num - 1]);

      System.out.println("최댓값은 " + maxOf(height) + "입니다.");
    }
  }
}