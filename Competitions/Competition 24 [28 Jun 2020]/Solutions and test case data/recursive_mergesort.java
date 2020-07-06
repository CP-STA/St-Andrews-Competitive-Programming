import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class recursive_mergesort {
    static Random rand = new Random();
    static File file;
    static PrintStream stream;
    public static void call_print(int arr[]) {
        for (int i = 0; i < arr.length; i++)
        {
            if (i != arr.length - 1)
            {
                System.out.print(arr[i] + " ");
            }
            else
            {
                System.out.println(arr[i]);
            }
        }
        System.out.println();
    }

    public static int[] merge(int left[], int right[]) {
        // perform a merge
        int lp = 0;
        int rp = 0;
        int res[] = new int[left.length + right.length];
        int index = 0;
        while (lp < left.length && rp < right.length) {
            if (left[lp] > right[rp]) {
                res[index++] = left[lp++];
            } else {
                res[index++] = right[rp++];
            }
        }
        while (lp < left.length) {
            res[index++] = left[lp++];
        }
        while (rp < right.length) {
            res[index++] = right[rp++];
        }
        call_print(res);
        return res;
    }

    public static int[] sort(int arr[]) {
        // arr is input array
        // find middle point
        if (arr.length < 2) {
            //       call_print(arr);
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }
        // print recursive call
        call_print(left);
        left = sort(left);
        call_print(right);
        right = sort(right);
        return merge(left, right);
    }

    public static int[] generator(int size) {
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000000);
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 60; i++) {
            int num = rand.nextInt(15000);
            StringBuilder input_name = new StringBuilder();
            input_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\recursive_mergesort_data\\input\\input");
            if (num < 10)
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
            output_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\recursive_mergesort_data\\output\\output");
            if (num < 10)
                output_name.append("0");
            output_name.append(i);
            output_name.append(".txt");
            file = new File(output_name.toString());
            //Instantiating the PrintStream class
            stream = new PrintStream(file);
            System.setOut(stream);
            // a string with the output
            int[] output = sort(inputarr);
            stream.close();
        }
        System.out.println("hello");
    }
}
