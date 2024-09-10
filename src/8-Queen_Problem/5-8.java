//분할정복법 (분기조작)

class Queen8 {
  static int[] pos = new int[8]; // 나열된 숫자 순서(인덱스)는 '열'을 의미하고 숫자 자체(요솟값)는 '행'을 의미함

  static void print() {
    for (int i = 0; i < 8; i++)
      System.out.printf("%2d", pos[i]);
    System.out.println();
  }

  // 퀸을 i열에 배치
  static void set(int i) {
    for (int j = 0; j < 8; j++) {
      pos[i] = j; // 퀸을 j행에 배치
      if (i == 7) // 모든 열에 배치했다면...
        print();
      else
        set(i + 1); // 다음 열에 퀸을 배치
    }
  }

  public static void main(String[] args) {
    set(0);
  }
}