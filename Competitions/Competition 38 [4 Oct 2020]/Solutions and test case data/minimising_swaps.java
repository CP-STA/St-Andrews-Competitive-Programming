import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class minimising_swaps {
    static File file;
    static PrintStream stream;
    static Random rand = new Random();

    public static void reverse (int[] arr, int i)
    {
        // System.out.println("Input array: " + " i = " + i);
        // for (int t:arr)
        //     System.out.print(t + " ");
        // System.out.println();
        for (int j= 0; j <= i/2; j++)
        {
            int temp = arr[j];
            arr[j] = arr[i - j];
            arr[i - j] = temp;
        }
        // System.out.println("Output array: ");
        // for (int t:arr)
        //     System.out.print(t + " ");
        // System.out.println();
    }
    public static ArrayList<Integer> solver (int[] A)
    {
        boolean check = false;
        ArrayList<Integer> sorted = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i:A)
        {
            sorted.add(i);
        }
        Collections.sort(sorted);
        int index = sorted.size() - 1;
        for (int i = 0; i < A.length; i++)
        {
            // locate the (largest - i)th element
            int jind = -1;
            for (int j = 0; j < A.length; j++)
            {
                if (A[j] == sorted.get(index))
                {
                    jind = j;
                    break;
                }
            }
            if (jind != index)
            {
                // need to fix it
                // can be done in two steps
                // bring to head
                // so for example, 1,3,4,2 -> 4,3,1,2
                reverse(A, jind);
                ans.add(jind + 1);
                // reverse to desired position
                reverse(A, index);
                ans.add(index + 1);
            }
            // for (int t:A)
            //     System.out.print(t + " ");
            //   System.out.println();
            index--;
        }
        return ans;
    }
    public static int[] testcasegenerator(int size)
    {
        int arr[] = new int[size];
        for (int i = 0; i < arr.length; i++)
            arr[i] = rand.nextInt(100000);
        return arr;
    }
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 60; i++) {
            StringBuilder input_name = new StringBuilder();
            StringBuilder output_name = new StringBuilder();
            input_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\minimising_swaps_data\\input\\input");
            if (i < 10)
                input_name.append("0");
            input_name.append(i);
            input_name.append(".txt");
            file = new File(input_name.toString());
            //Instantiating the PrintStream class
            stream = new PrintStream(file);
            System.setOut(stream);
            int inp[] = testcasegenerator(rand.nextInt(2000));
            System.out.println(inp.length);
            for (int t : inp)
                System.out.println(t);
            stream.close();
            output_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\minimising_swaps_data\\output\\output");
            if (i < 10)
                output_name.append("0");
            output_name.append(i);
            output_name.append(".txt");
            file = new File(output_name.toString());
            //Instantiating the PrintStream class
            stream = new PrintStream(file);
            System.setOut(stream);
            stream.close(); // useless
        }
    }
}