import java.util.Scanner;

class PhysicalExamination {
  static final int VMAX = 21;

  static class PhyscData {
    String name;
    int height;
    double vision;

    PhyscData(String name, int height, double vision) {
      this.name = name;
      this.height = height;
      this.vision = vision;
    }
  }

  static double aveHeight(PhyscData[] dat) {
    double sum = 0;

    for (int i = 0; i < dat.length; i++)
      sum += dat[i].height;

    return sum / dat.length;
  }

  static void distVision(PhyscData[] dat, int[] dist) {
    int i = 0;
    dist[i] = 0;
    for (i = 0; i < dat.length; i++) {
      if (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0)
        dist[(int) (dat[i].vision * 10)]++;
    }
  }

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    PhyscData[] x = {
        new PhyscData("안", 162, 0.3),
        new PhyscData("김", 173, 0.4),
        new PhyscData("박", 175, 2.0),
        new PhyscData("최", 171, 1.5),
        new PhyscData("이", 168, 0.4),
        new PhyscData("정", 174, 1.5),
        new PhyscData("조", 169, 0.4)
    };

    int[] vdist = new int[VMAX];

    for (int i = 0; i < x.length; i++)
      System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);

    System.out.printf("\n평균 키 : %5.1f\n", aveHeight(x));

    distVision(x, vdist);

    System.out.println("\n시력 분포");
    for (int i = 0; i < VMAX; i++) {
      System.out.printf("%3.1f~: ", i / 10.0);
      for (int j = 0; j < vdist[i]; j++)
        System.out.print("*");
      System.out.println();
    }
  }
}

