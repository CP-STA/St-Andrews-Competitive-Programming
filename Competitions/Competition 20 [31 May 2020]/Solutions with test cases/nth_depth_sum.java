import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class nth_depth_sum {
    static ArrayList<Integer>[] alist;
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
    static int sum = 0;
    static int desired_depth;
    public static void myDFS(int index, int depth_no)
    {
        // given a yummy adjacency list
        if (depth_no == desired_depth)
            sum+=index;
        else {
            for (int i : alist[index])
                myDFS(i, (depth_no + 1));
        }
    }
    public static void main(String[] args) {
        FastReader keyboard = new FastReader();
        // first generate adjacency list
        int n = keyboard.nextInt();
        alist = new ArrayList[n]; // new arraylist of n
        for (int i = 0; i < n; i++)
        {
            alist[i] = new ArrayList<>();
        }
        // now generate the adjacency list
        for (int i = 0; i < n; i++)
        {
            int from = keyboard.nextInt();
            int to = keyboard.nextInt();
            alist[from].add(to);
        }
        // note the root number
        int rn = keyboard.nextInt();
        desired_depth = keyboard.nextInt();
        // do DFS
        myDFS(rn, 0);
        System.out.println(sum);
    }
}
