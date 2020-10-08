import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class graph_paths {
    static ArrayList<Integer>[] alist; // core arraylist
    static int numleaves[]; // take a walk at the end
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
    public static int solver(int vertex)
    {
        /*
        when we get a leaf, the answer is 1 and returned.
        Else the number of leaves is the sum of the number of leaves at all the nodes
        (well if they exist, otherwise it's essentially a leaf)
         */
        if (alist[vertex].size() == 0)
        {
            numleaves[vertex] = 0;
            return 1; // it's a leaf!
        }
        else {
            int sum = 0;
            for (int i : alist[vertex]) {
                sum += solver(i);
            }
            numleaves[vertex] = sum;
            return sum;
        }
    }
    public static void main(String[] args) throws IOException {
    FastReader keyboard = new FastReader();
    int N = keyboard.nextInt();
    alist = new ArrayList[N + 1];
    numleaves = new int[N + 1];
    for (int i = 0; i < N + 1; i++)
        alist[i] = new ArrayList<>();
    // construct the adjacency list
    for (int i = 0; i < N; i++)
    {
        int a, b;
        a = keyboard.nextInt();
        b = keyboard.nextInt();
        alist[a].add(b); // adding edge a -> b
    }
    int rootnode = keyboard.nextInt();
    // check if it's already a leaf
    int ans = 0;
    if (alist[rootnode].size() == 0)
        ans = 0;
    else
    {
        solver(rootnode);
        for (int i: numleaves)
            ans+=i;
    }
    System.out.println(ans);
    }
}