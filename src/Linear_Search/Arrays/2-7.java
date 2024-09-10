//class PrimeNumber1 {
//  public static void main(String[] args) {
//    for (int n = 2; n <= 1000; n++) {
//      int i;
//      for (i = 2; i < n; i++) {
//        if (n % i == 0)
//          break;
//      }
//      if (n == i)
//        System.out.println(n);
//    }
//  }
//}

//class PrimeNumber2 {
//  public static void main(String[] args) {
//    int ptr = 0;
//    int[] prime = new int[500];
//
//    prime[ptr++] = 2;
//
//    for (int n = 3; n <= 1000; n += 2) {
//      int i;
//      for (i = 0; i < ptr; i++) {
//        if (n % prime[i] == 0)
//          break;
//      }
//      if (ptr == i)
//        prime[ptr++] = n;
//    }
//
//    for (int i = 0; i < ptr; i++)
//      System.out.println(prime[i]);
//    ;
//  }
//}

class PrimeNumber3 {
  public static void main(String[] args) {
    int ptr = 0;
    int[] prime = new int[500];

    prime[ptr++] = 2;
    prime[ptr++] = 3;

    for (int n = 5; n <= 1000; n += 2) {
      boolean flag = false;

      for (int i = 1; prime[i] * prime[i] <= n; i++) {
        if (n % prime[i] == 0) {
          flag = true;
          break;
        }
      }
      if (!flag) {
        prime[ptr++] = n;
      }
    }

    for (int i = 0; i < ptr; i++)
      System.out.println(prime[i]);
  }
}