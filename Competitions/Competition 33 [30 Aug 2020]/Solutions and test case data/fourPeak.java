import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class fourPeak {
    static Random rand = new Random();
    static File file;
    static PrintStream stream;
    public static boolean solver(int[] history)
    {
        /*
        AIM: we want to see at least one instance where A[i] < A[i + 1] < A[i + 2] < A[i + 3]
        but no instance where A[i] < A[i + 1] < A[i + 2] < A[i + 3] < A[i + 4]
         */
        if (history.length < 4)
            return false;
        else if (history.length == 4)
        {
            return history[0] < history[1] && history[1] < history[2] && history[2] < history[3];
        }
        else
        {
            boolean flag = false;
            for (int i = 0; i < history.length - 4; i++)
            {
                if (history[i] < history[i + 1] && history[i + 1] < history[i + 2] && history[i + 2] < history[i + 3])
                    flag = true;
                if (history[i] < history[i + 1] && history[i + 1] < history[i + 2] && history[i + 2] < history[i + 3] && history[i + 3] < history[i + 4])
                    return false;
            }
            if (history[history.length - 4] < history[history.length - 3] && history[history.length - 3] < history[history.length - 2] && history[history.length - 2] < history[history.length - 1])
            flag = true;
                return flag;
        }
    }
    public static void main(String[] args) throws IOException {
    for (int i = 0; i < 60; i++)
    {
        // print number of test cases
        int num = rand.nextInt(50) + 1;
        StringBuilder input_name = new StringBuilder();
        input_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\fourPeak_data\\input\\input");
        if (i < 10)
            input_name.append("0");
        input_name.append(i);
        input_name.append(".txt");
        file = new File(input_name.toString());
        stream = new PrintStream(file);
        System.setOut(stream);
        System.out.println(num);
        boolean[] results = new boolean[num];
        for (int j = 0; j < num; j++)
        {
            int val = 1 + rand.nextInt(500);
            int arr[] = new int [val];
            for (int k = 0; k < arr.length; k++)
            {
                arr[k] = rand.nextInt(5000);
            }
            for (int p:arr)
                System.out.print(p + " ");
            System.out.println();
            results[j] = solver(arr);
        }
        stream.close();
        StringBuilder output_name = new StringBuilder();
        output_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\fourPeak_data\\output\\output");
        if (i < 10)
            output_name.append("0");
        output_name.append(i);
        output_name.append(".txt");
        file = new File(output_name.toString());
        stream = new PrintStream(file);
        System.setOut(stream);
        for(boolean b:results)
        {
            System.out.println(b ? "NICE" : "NOT NICE");
        }
        stream.close();
    }
    }
}
