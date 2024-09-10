import java.util.Scanner;

class Hanoi_String {
  static String[] arr = { "A 기둥", "B 기둥", "C 기둥" };

  // no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
  static void move(int no, int x, int y) {
    if (no > 1)
      move(no - 1, x, 6 - x - y);

    System.out.printf("원반[%d]을(를) %s에서 %s으로 옮김\n", no, arr[x - 1], arr[y - 1]);

    if (no > 1)
      move(no - 1, 6 - x - y, y);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("하노이의 탑");
    System.out.print("원반의 개수 : ");
    int n = scanner.nextInt();

    move(n, 1, 3);
  }
}