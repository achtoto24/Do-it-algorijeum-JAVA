import java.util.Scanner;

class q3 {
  static int searchIdx(int[] a, int n, int key, int[] idx) {
    int i = 0;
    int cnt = 0;

    while (i < n) {
      if (a[i] == key) {
        idx[cnt++] = i;
      }
      i++;
    }

    return cnt;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("요소수 : ");
    int num = scanner.nextInt();
    int[] x = new int[num];

    for (int i = 0; i < num; i++) {
      System.out.print("x[" + i + "] : ");
      x[i] = scanner.nextInt();
    }

    System.out.print("검색할 값 : ");
    int key = scanner.nextInt();

    int[] idx = new int[num];

    System.out.printf("일치하는 요소수 : %d\n", searchIdx(x, num, key, idx));
    System.out.println(idx);
  }
}