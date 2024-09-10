//8퀸 문제 완성

class EightQueen {
  // 배열 flag_a,b,c를 같은 체스판 위에 있다고 생각하지 말고 각각 독립적인 체스판에 있다고 생각할 것
  static boolean[] flag_a = new boolean[8];
  static boolean[] flag_b = new boolean[15];
  static boolean[] flag_c = new boolean[15];
  static int[] pos = new int[8];

  static void print() {
    for (int i = 0; i < 8; i++)
      System.out.printf("%2d", pos[i]);
    System.out.println();
  }

  static void set(int i) {
    for (int j = 0; j < 8; j++) {
      if (flag_a[j] == false && // 가로(j행)에 아직 배치하지 않음
          flag_b[i + j] == false && // (/)대각선에 아직 배치하지 않음
          flag_c[i - j + 7] == false) { // (\)대각선에 아직 배치하지 않음
        pos[i] = j;
        if (i == 7)
          print();
        else {
          flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
          set(i + 1);
          flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
        }
      }
    }
  }

  public static void main(String[] args) {
    set(0);
  }
}