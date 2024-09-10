//class YMD {
//  int y, m, d;
//
//  YMD(int y, int m, int d) {
//    this.y = y;
//    this.m = m;
//    this.d = d;
//  }
//
//  int after(int n) {
//    if (this.d + n > 30) {
//      if (this.d + n > 31)
//        return this.d + n - 31;
//      return this.d + n - 30;
//    } else
//      return this.d + n;
//  }
//
//  int before(int n) {
//    if (this.d - n < 1) {
//      if (this.m % 2 == 0)
//        return 30 - (this.d - n);
//      else
//        return 31 - (this.d - n);
//    } else
//      return this.d - n;
//  }
//
//}
//
//class YMDTest {
//  public static void main(String[] args) {
//    YMD today = new YMD(2020, 2, 25);
//    System.out.println("오늘은 " + today.y + "년 " + today.m + "월 " + today.d //+ "일 입니다.");//
//    System.out.//println("내일은 " + today.after(12) + "일 입니다.");//
//    System.out.println("어제는 " + today.before(45) + "일 입니다.");//
//  }
//}

import java.util.Scanner;

class YMD {
  int y;
  int m;
  int d;

  static int[][] mdays = {
      { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년
      { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } // 윤년
  };

  static int isLeap(int year) {
    return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
  }

  YMD(int y, int m, int d) {
    this.y = y;
    this.m = m;
    this.d = d;
  }

  YMD after(int n) {
    YMD temp = new YMD(this.y, this.m, this.d);
    if (n < 0)
      return before(-n);

    temp.d += n;

    while (temp.d > mdays[isLeap(temp.y)][temp.m - 1]) {
      temp.d -= mdays[isLeap(temp.y)][temp.m - 1];
      if (++temp.m > 12) {
        temp.y++;
        temp.m = 1;
      }
    }
    return temp;
  }

  YMD before(int n) {
    YMD temp = new YMD(this.y, this.m, this.d);
    if (n < 0)
      return after(-n);

    temp.d -= n;

    while (temp.d < 1) {
      if (--temp.m < 1) {
        temp.y--;
        temp.m = 12;
      }
      temp.d += mdays[isLeap(temp.y)][temp.m - 1];
    }
    return temp;
  }

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    System.out.print("날짜를 입력하세요.\n");
    System.out.print("년 : ");
    int y = stdIn.nextInt();
    System.out.print("월 : ");
    int m = stdIn.nextInt();
    System.out.print("일 : ");
    int d = stdIn.nextInt();
    YMD date = new YMD(y, m, d);

    System.out.print("며칠 전/후의 날짜를 구할까요? : ");
    int n = stdIn.nextInt();

    YMD d1 = date.after(n);
    System.out.printf("%d일 후의 날짜는 %d년%d월%d일입니다.\n", n, d1.y, d1.m, d1.d);

    YMD d2 = date.before(n);
    System.out.printf("%d일 전의 날짜는 %d년%d월%d일입니다.\n", n, d2.y, d2.m, d2.d);
  }
}