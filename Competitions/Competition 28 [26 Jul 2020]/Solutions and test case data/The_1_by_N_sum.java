import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class The_1_by_N_sum {
    static Random rand = new Random();
    static File file;
    static PrintStream stream;
    public static int solver (double k)
    {
        if (k == 1)
            return 1;
        else
        {
            double sum = 1d;
            int n = 1;
            while (sum < k)
            {
                n++;
                sum = sum + Math.pow(n, -1);
            }
            return n;
        }
    }
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 60; i++) {
            StringBuilder input_name = new StringBuilder();
            input_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\The_1_by_N_sum\\input\\input");
            if (i < 10)
                input_name.append("0");
            input_name.append(i);
            input_name.append(".txt");
            file = new File(input_name.toString());
            //Instantiating the PrintStream class
            stream = new PrintStream(file);
            System.setOut(stream);
            double num = 15d*rand.nextDouble() + 1d;
            System.out.println(num);
            stream.close();
            StringBuilder output_name = new StringBuilder();
            output_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\The_1_by_N_sum\\output\\output");
            if (i < 10)
                output_name.append("0");
            output_name.append(i);
            output_name.append(".txt");
            file = new File(output_name.toString());
            stream = new PrintStream(file);
            System.setOut(stream);
            // a string with the output
            System.out.println(solver(num));
            stream.close();
        }
    }
}
