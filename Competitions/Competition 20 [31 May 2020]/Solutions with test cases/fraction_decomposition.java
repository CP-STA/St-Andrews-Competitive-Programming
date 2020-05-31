import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class fraction_decomposition {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void isDone(int check, int min_sum)
    {
        if (check != 0)
        {
            System.out.println(min_sum);
            exit(0);
        }
    }
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        FastReader keyboard = new FastReader();
        m = keyboard.nextInt();
        n = keyboard.nextInt();
        int MAX_DEN = 1001;
        int min_sum = Integer.MAX_VALUE;
        int check = 0;
        // m and n represent fraction
        // is there a combination of size 1?
        for (int a = 1; a < MAX_DEN; a++)
        {
            if (1d/(double)m == (double)a/(double)n)
            {
                min_sum = Math.min(min_sum, a); // update minimum sum
                check = 1;
            }
        }
        isDone(check, min_sum);
        // is there a combination of size 2?
        // m/n = 1/a + 1/b -> m/n = (b + a)/ba

        // WLOG a > b > c > d > e
        for (int a = 1; a < MAX_DEN; a++) {
            for (int b = a + 1; b < MAX_DEN; b++) {
                if ((double)(b + a) / (double)m == (double)(b * a) / (double)n) {
                    min_sum = Math.min(min_sum, a + b); // update minimum sum
                    check = 1;
                }
            }
        }
        isDone(check, min_sum);
        // is there a combination of size 3?
        // m/n = 1/a + 1/b + 1/c -> m/n = (bc + ac+ ab)/abc
        for (int a = 1; a < MAX_DEN; a++) {
            for (int b = a + 1; b < MAX_DEN; b++) {
                if (a + b > min_sum)
                    break;
                for (int c = b + 1; c < MAX_DEN; c++) {
                    if (a + b + c > min_sum)
                        break;
                    if ((double)(b * c + a * c + a * b) / (double)m ==  (double)(a * b * c) / (double)n) {
                        min_sum = Math.min(min_sum, a + b + c); // update minimum sum
                        check = 1;
                    }
                }
            }
        }
        isDone(check, min_sum);
        // is there a combination of size 4?
        // m/n = 1/a + 1/b + 1/c + 1/d -> m/n  (abc+bcd+acd+abd)/abcd
        for (int a = 1; a < MAX_DEN; a++) {
            if (a > min_sum)
                break;
            for (int b = a + 1; b < MAX_DEN; b++) {
                if (a + b> min_sum)
                    break;
                for (int c = b + 1; c < MAX_DEN; c++) {
                    if (a + b + c > min_sum)
                        break;
                    for (int d = c + 1; d < MAX_DEN; d++) {
                        if (a + b + c + d > min_sum)
                            break;
                        if ((double)(a * b * c + a * b * d + b * c * d + a * c * d) / (double)m == (double)(a * b * c * d) / (double)n) {
                            min_sum = Math.min(min_sum, a + b + c + d); // update minimum sum
                            check = 1;
                        }
                    }
                }
            }
        }
        isDone(check, min_sum);
        // is there a combination of size 5?
        // m/n = 1/a + 1/b + 1/c + 1/d + 1/e -> m/n  (abcd+abce+bcde+acde+abde)/abcde
        for (int a = 1; a < MAX_DEN; a++) {
            if (a > min_sum)
                break;
            for (int b = a + 1; b < MAX_DEN; b++) {
                if (a + b > min_sum)
                    break;
                for (int c = b + 1; c < MAX_DEN; c++) {
                    if (a + b + c > min_sum)
                        break;
                    for (int d = c + 1; d < MAX_DEN; d++) {
                        if (a + b + c + d > min_sum)
                            break;
                        for (int e = d + 1; e < MAX_DEN; e++) {
                            if (a + b + c + d + e > min_sum)
                                break;
                            if ((double)(a*b*c*d+a*b*c*e+b*c*d*e+a*c*d*e+a*b*d*e)/(double)m == (double)(a * b * c * d*e)/(double)n) {
                                min_sum = Math.min(min_sum, a + b + c + d + e); // update minimum sum
                                check = 1;
                            }
                        }
                    }
                }
            }
        }
        if (check != 0)
        {
            System.out.println(min_sum);
        }
        else
            System.out.println(-1);
    }
}
