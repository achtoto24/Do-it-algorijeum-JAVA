import java.util.Arrays;
import java.util.Scanner;

class BinarySearchTester {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("요솟수: ");
    int num = scanner.nextInt();
    int[] x = new int[num];

    System.out.println("오름차순으로 입력하세요.");
    System.out.print("x[0]: ");
    x[0] = scanner.nextInt();

    for (int i = 1; i < num; i++) {
      do {
        System.out.print("x[" + i + "]: ");
        x[i] = scanner.nextInt();
      } while (x[i] < x[i - 1]);
    }

    System.out.print("검색할 값: ");
    int key = scanner.nextInt();

    int idx = Arrays.binarySearch(x, key);

    if (idx < 0)
      System.out.println(-idx - 1);
    else
      System.out.println("그 값은 x[" + idx + "]에 있습니다.");
  }
}