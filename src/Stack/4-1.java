import java.util.Scanner;

class IntStackTester {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    IntStack s = new IntStack(64);

    while (true) {
      System.out.println();
      System.out.printf("현재 데이터 개수 ; %d / %d\n", s.size(), s.getCapacity());
      System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (5) 클리어 (6) 데이터 찾기 (7) 데이터 유무 (0) 종료 : ");

      int menu = scanner.nextInt();
      if (menu == 0)
        break;

      switch (menu) {
        case 1:
          System.out.print("데이터 : ");
          int x = scanner.nextInt();
          try {
            s.push(x);
          } catch (IntStack.OverflowIntStackException e) {
            System.out.println("스택이 가득 찼습니다.");
          }
          break;

        case 2:
          try {
            x = s.pop();
            System.out.println("팝한 데이터는 " + x + "입니다.");
          } catch (IntStack.OverflowIntStackException e) {
            System.out.println("스택이 비어 있습니다.");
          }
          break;

        case 3:
          try {
            x = s.peek();
            System.out.println("피크한 데이터는 " + x + "입니다.");
          } catch (IntStack.EmptyIntStackException e) {
            System.out.println("스택이 비어 있습니다.");
          }
          break;

        case 4:
          s.dump();
          break;

        case 5:
          s.clear();
          System.out.println("스택의 사이즈는" + s.size() + "입니다.");
          break;

        case 6:
          System.out.print("찾을 데이터 : ");
          x = scanner.nextInt();
          System.out.println("찾은 데이터는 인덱스 " + s.indexOf(x) + "에 있습니다.");
          break;

        case 7:
          System.out.println("스택이 비어있는가? " + s.isEmpty());
          System.out.println("스택이 가득 차있는가?" + s.isFull());
          break;
      }
    }
  }
}