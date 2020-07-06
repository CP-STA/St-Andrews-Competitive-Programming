import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class qbert_reloaded_1 {
    static Random rand = new Random();
    static File file;
    static PrintStream stream;
    public static long solver(int[][] arr, int d)
    {
        // we need a DP array
        long dp[][] = new long [d][2*d - 1];
        // base case
        dp[0][(2*d - 1)/2] = arr[0][(2*d - 1)/2];
        for (int i = 1; i < d; i++)
        {
            for (int j = (2*d - 1)/2 - i, k = 0; k <= i; j+=2, k++)
            {
                if (k > 0)
                {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + arr[i][j]);
                }
                if (k < i)
                {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1] + arr[i][j]);
                }
            }
        }
        // take a walk around the last row
        long ans = 0;
        for (long i:dp[dp.length - 1])
        {
            ans = Math.max(i, ans);
        }
        return ans;
    }
    public static long create_array(int[] arr, int d)
    {
        int index = 0;
        int mainarr[][] = new int [d][2*d - 1];
        for (int i = 0; i < d; i++)
        {
            for (int j = (2*d - 1)/2 - i, k = 0; k <= i; j+=2, k++)
            {
                mainarr[i][j] = arr[index++];
            }
        }
        return solver(mainarr, d);
    }
    public static int[] generator(int size) {
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000);
        }
        return arr;
    }
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 60; i++) {
            int num;
            if (i > 10)
            num = rand.nextInt(1500) + 1;
            else
            num = rand.nextInt(10) + 1;
            int size = num;
            num = ((num) * (num + 1))/2;
            StringBuilder input_name = new StringBuilder();
            input_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\qbert_reloaded_1_data\\input\\input");
            if (i < 10)
                input_name.append("0");
            input_name.append(i);
            input_name.append(".txt");
            file = new File(input_name.toString());
            //Instantiating the PrintStream class
            stream = new PrintStream(file);
            System.setOut(stream);
            System.out.println(num);
            int inputarr[] = generator(num);
            for (int j:inputarr)
                System.out.println(j);
            stream.close();
            StringBuilder output_name = new StringBuilder();
            output_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\qbert_reloaded_1_data\\output\\output");
            if (i < 10)
                output_name.append("0");
            output_name.append(i);
            output_name.append(".txt");
            file = new File(output_name.toString());
            stream = new PrintStream(file);
            System.setOut(stream);
            // a string with the output
            System.out.println(create_array(inputarr, size));
            stream.close();
        }
    }
}
