import java.util.Random;

public class Testcase_generator {
    private static int value = 0;
    public static int bn(int[] a, int cur, int parent) {
        if (cur > a.length) return 0;
        if (a[cur-1]==Integer.MAX_VALUE) return 0;

        int child = bn(a, cur*2, parent + a[cur-1]) + bn(a, cur*2 + 1, parent + a[cur-1]);
        if (parent == child) {
            value++;
        }
        return child + a[cur-1];
    }
    public static void main(String[] args) {
        Random ri = new Random();
        int height = 5;
        int n = (int)(Math.pow(2, height));
        int re = (int)(n*0.3);
        System.out.println("height: " + height + " n: " + n + " re: " + re);

        int[] a = new int[n];

        do {
            value = 0;
            for (int i = 0; i < n; i++) {
                if (i > 0)
                    if (a[((i+1)/2 - 1)] == Integer.MAX_VALUE) {
                        a[i] = Integer.MAX_VALUE;
                        continue;
                    }
                a[i] = ri.nextInt(2*n + 1) - n;
                if (a[i] > n/2 || a[i] < -n/2) a[i] = Integer.MAX_VALUE;
            }
            bn(a, 1, 0);
        } while (value < re);

        for (int i : a) {
            if (i > n/2 || i < -n/2)
                System.out.print("None,");
            else {
                System.out.print(i + ",");}
        }
        System.out.println();
    }
}