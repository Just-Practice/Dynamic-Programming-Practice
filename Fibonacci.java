public class Fibonacci {
    static int max = 100;
    static int counter0 = 0;
    static int[] fib1_result = new int[max];
    static int counter1 = 0;
    static int[] fib2_result = new int[max];
    static int counter2 = 0;
    static int[] fib3_result = new int[max];
    static int counter3 = 0;
    static int[] fib4_result = new int[max];
    static int counter4 = 0;

    public static void main(String[] args) {
        int n = 32;

        // fib0 - regular recursion (top-down)
        int test0 = fib0(n);
        System.out.println(test0 + " " + counter0);

        // fib1 - save and return (top-down)
        int test1 = fib1(n);
        System.out.println(test1 + " " + counter1);

        // fib2 - save only (top-down)
        fib2_result[1] = 1;
        fib2_result[2] = 1;
        fib2(n);
        System.out.println(fib2_result[n] + " " + counter2);

        // fib3 - dynamic programming with O(1) space (bottom-up)
        fib3_result[1] = 1;
        fib3_result[2] = 1;
        fib3(n);
        System.out.println(fib3_result[n % 3] + " " + counter3);

        // fib4 - deformed from matrix multiplication (top-down)
        int test4 = fib4(n);
        System.out.println(test4 + " " + counter4);

    }

    static int fib0(int n) {
        if (n <= 2)
            return n == 0 ? 0 : 1;
        int r = fib0(n - 1) + fib0(n - 2);
        counter0++;
        return r;
    }

    static int fib1(int n) {
        if (n <= 2)
            return n == 0 ? 0 : 1;
        if (fib1_result[n] != 0)
            return fib1_result[n];

        fib1_result[n] = fib1(n - 1) + fib1(n - 2);
        counter1++;
        return fib1_result[n];
    }

    static void fib2(int n) {
        if (n <= 2)
            return;
        if (fib2_result[n] != 0)
            return;

        fib2(n - 1);
        fib2(n - 2);
        fib2_result[n] = fib2_result[n - 1] + fib2_result[n - 2];
        counter2++;
    }

    static void fib3(int n) {
        for (int i = 3; i <= n; i++) {
            fib3_result[i % 3] = fib3_result[(i - 1) % 3] + fib3_result[(i - 2) % 3];
            counter3++;
        }
    }

    public static int fib4(int n) {
        if (n <= 2)
            return n == 0 ? 0 : 1;
        if (fib4_result[n] != 0)
            return fib4_result[n];

        if (n % 2 == 0) {
            int k = n / 2;
            fib4_result[n] = (2 * fib4(k - 1) + fib4(k)) * fib4(k);
        } else {
            int k = (n + 1) / 2;
            fib4_result[n] = (fib4(k) * fib4(k) + fib4(k - 1) * fib4(k - 1));
        }

        counter4++;
        return fib4_result[n];
    }
}