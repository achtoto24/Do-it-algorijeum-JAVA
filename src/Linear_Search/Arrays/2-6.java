import java.util.Arrays;
import java.util.Scanner;

class CardConv {
  static int cardConv(int num, int cd, char[] cno) {
    int digit = 0;
    String dchar = "01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    System.out.printf("%d|%8d\n", cd, num);

    while (num != 0) {
      int tmp = num % cd;
      cno[digit++] = dchar.charAt(tmp);
      num /= cd;

      System.out.println(" + -------");
      if (num == 0) {
        System.out.printf("%10d   ...%d\n", num, tmp);
        break;
      }
      System.out.printf("%d|%8d   ...%d\n", cd, num, tmp);
    }

    for (int i = 0; i < digit / 2; i++) {
      char t = cno[i];
      cno[i] = cno[digit - 1 - i];
      cno[digit - 1 - i] = t;
    }

    return digit;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num;
    int cd;
    int digit;
    char[] cno = new char[50];

    System.out.println("10진수를 기수 변환합니다.");
    do {
      System.out.print("변환하는 양의 정수 : ");
      num = scanner.nextInt();
    } while (num <= 0);

    do {
      System.out.print("어떤 진수로 변환할까요?(2 ~ 36) : ");
      cd = scanner.nextInt();
    } while (cd < 2 || cd > 36);

    digit = cardConv(num, cd, cno);

    System.out.print(cd + "진수로 ");
    for (int i = 0; i < digit; i++)
      System.out.print(cno[i]);
    System.out.println("입니다.");
  }
}