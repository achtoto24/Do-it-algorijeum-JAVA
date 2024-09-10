//분기 한정법 (분기조작 + 한정조작)

class QueenBB {
  static boolean[] flag = new boolean[8];  //각 행에 퀸을 배치했는지 체크
  static int[] pos = new int[8];

  static void print() {
    for (int i = 0; i < 8; i++)
      System.out.printf("%2d", pos[i]);
    System.out.println();
  }

  static void set(int i) {
    for (int j = 0; j < 8; j++) {
      if (flag[j] == false) {  //j행에 퀸을 아직 배치하지 않음
        pos[i] = j;
        if (i == 7)
          print();
        else {
          flag[j] = true;
          set(i + 1);
          flag[j] = false;
        }
      }
    }
  }

  public static void main(String[] args) {
    set(0);
  }
}
