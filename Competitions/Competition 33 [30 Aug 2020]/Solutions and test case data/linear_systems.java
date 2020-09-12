import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Random;

public class linear_systems {
    static File file;
    static PrintStream stream;
    public static double rounder(double value)
    {
        return (double)Math.round(value * 100000000d) / 100000000d;
    }
    public static double solver(int a, int b, int c, int d, long k)
    {
        // note that
        // x_n = a(x_(n - 1)) + b(y_(n - 1))
        // y_n = c(x_(n - 1)) + d(y_(n - 1))
        // x_0 = 1, y_0 = 1
        if (k < 50)
        {
            // DP-like approach
            BigInteger xn[] = new BigInteger[(int) (k + 1)];
            BigInteger yn[] = new BigInteger[(int) (k + 1)];
            xn[0] = BigInteger.ONE;
            yn[0] = BigInteger.ONE;
            for (int i = 1; i <= k; i++)
            {
                xn[i] = xn[i - 1].multiply(BigInteger.valueOf(a)).add(yn[i - 1].multiply(BigInteger.valueOf(b)));
              //  xn[i] = a*(xn[i - 1]) + b*(yn[i - 1];
               // yn[i] = c*(xn[i - 1]) + d*(yn[i - 1]);
                yn[i] = xn[i - 1].multiply(BigInteger.valueOf(c)).add(yn[i - 1].multiply(BigInteger.valueOf(d)));
            }
            return xn[(int) k].doubleValue() / yn[(int)k].doubleValue();
        }
        else
        {
            /*
            Solve a quadratic.
            Let (x_n/y_n) = t. Then we get
            t = (at + b)/(ct + d)
            ct^2 + (d - a) t - b = 0
             */
            // is the discriminant positive?
            if ((int)Math.pow(d - a, 2) + 4*b*c < 0)
            {
                return -1; // impossible
            }
            else
            {
                // get the expected value
                double exp = (double)(a - d) + Math.sqrt(Math.pow(d - a, 2) + 4*b*c);
                exp = exp / 2d*(double)c;
                if (exp <= 0)
                    return -1; // only negative
                else
                    return exp;
            }
        }
    }
    public static void main(String[] args) throws IOException {
       // System.out.println(rounder(solver(1,2,1,1,15)));
      //  System.out.println(rounder(solver(2,1,1,1,100000000)));
        for (int i = 0; i < 60; i++)
        {
            long k = 0;
            Random rand = new Random();
            if (i < 15)
            {
                k = rand.nextInt(20);
            }
            else
            {
                k = rand.nextInt(1000000000);
            }
            int a, b, c, d;
            a = rand.nextInt(100);
            b = rand.nextInt(100);
            c = rand.nextInt(100);
            d = rand.nextInt(100);
            StringBuilder input_name = new StringBuilder();
            input_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\linear_systems_data\\input\\input");
            if (i < 10)
                input_name.append("0");
            input_name.append(i);
            input_name.append(".txt");
            file = new File(input_name.toString());
            //Instantiating the PrintStream class
            stream = new PrintStream(file);
            System.setOut(stream);
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
            System.out.println(k);
            stream.close();
            StringBuilder output_name = new StringBuilder();
            output_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\linear_systems_data\\output\\output");
            if (i < 10)
                output_name.append("0");
            output_name.append(i);
            output_name.append(".txt");
            file = new File(output_name.toString());
            // Instantiating the PrintStream class
            stream = new PrintStream(file);
            System.setOut(stream);
            System.out.println(rounder(solver(a, b, c, d, k)));
            stream.close();
        }
    }
    }
