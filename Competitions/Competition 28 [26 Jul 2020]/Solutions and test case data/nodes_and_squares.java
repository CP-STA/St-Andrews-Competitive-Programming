import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.Math.pow;

public class nodes_and_squares {
    static File file;
    static PrintStream stream;
    public static double solver (int n)
    {
        if (n == 1)
            return 0.25;
        else if (n == 2)
            return 0.75;
        else
        {
            double ans = (pow(2, 2*n - 3) - 1)/pow((pow(2, n - 1) - 1), 2);
            return Math.round(ans * pow(10, 8))/pow(10, 8);
        }
    }
    public static void main(String[] args) throws IOException {
  //  System.out.println(Math.round(solver(16) * pow(10, 8))/pow(10,8));
        for (int i = 1; i <= 32; i++) {
            StringBuilder input_name = new StringBuilder();
            input_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\nodes_and_squares_data\\input\\input");
            if (i < 10)
                input_name.append("0");
            input_name.append(i);
            input_name.append(".txt");
            file = new File(input_name.toString());
            //Instantiating the PrintStream class
            stream = new PrintStream(file);
            System.setOut(stream);
            System.out.println(i);
            stream.close();
            StringBuilder output_name = new StringBuilder();
            output_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\nodes_and_squares_data\\output\\output");
            if (i < 10)
                output_name.append("0");
            output_name.append(i);
            output_name.append(".txt");
            file = new File(output_name.toString());
            stream = new PrintStream(file);
            System.setOut(stream);
            // a string with the output
            System.out.println(solver(i));
            stream.close();
        }
    }
}
