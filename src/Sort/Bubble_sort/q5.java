import java.util.Scanner;

class BubbleSort2 {
  static void swap(int[] a, int idx1, int idx2) {
    int tmp = a[idx1];
    a[idx1] = a[idx2];
    a[idx2] = tmp;
  }

  static void bubbleSort(int[] a, int n) {
    int k = 0;
    int q = n - 1;

    while (k != q) {
      if ((n - 1) % 2 == 0) {
        int min = a[k];
        int key1 = k;
        for (int j = k + 1; j < q; j++) {
          if (a[j] < min) {
            min = a[j];
            key1 = j;
          }
        }
        swap(a, key1, k);
        k++;
      }

      if ((n - 1) % 2 != 0) {
        int max = a[q];
        int key2 = q;
        for (int j = q - 1; j > k; j--) {
          if (a[j] > max)
            max = a[j];
          key2 = j;
        }
        swap(a, key2, q);
        q--;
      }
      n--;
    }
  }

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    System.out.print("요솟수 : ");
    int nx = stdIn.nextInt();
    int[] x = new int[nx];

    for (int i = 0; i < nx; i++) {
      System.out.print("x[" + i + "] : ");
      x[i] = stdIn.nextInt();
    }

    bubbleSort(x, nx);

    System.out.println("오름차순으로 정렬했습니다.");
    for (int i = 0; i < nx; i++)
      System.out.println("x[" + i + "] : " + x[i]);
  }
}