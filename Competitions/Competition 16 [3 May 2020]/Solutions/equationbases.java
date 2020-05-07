import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class equationbases {
    public static long detfinder(long[][] arr)
    {
        // go recursive till we have a 2x2 array
        long pans = 0;
        if (arr.length == 2)
        {
            // y1 - y0 = 2
            return (arr[0][0]*arr[1][1] - arr[0][1]*arr[1][0]);
        }
        else
        {
            // get smaller array
            for (int i = 0; i < arr.length; i++) {
                long[][] arr2 = new long[arr.length - 1][arr.length - 1];
                // fill in the smaller array
                // take the second row onwards and fill up all elements other than the respective columns

                for (int j = 1; j < arr.length; j++)
                {
                    int r_index = 0;
                    for (int k = 0; k < arr.length; k++)
                    {
                        if (k != i)
                        {
                            arr2[j - 1][r_index++] = arr[j][k];
                        }
                    }
                }
                // recurse on that
                long pdet = (long)Math.pow(-1, i) * arr[0][i]*detfinder(arr2);
                pans = pans + pdet;
            }
        }
        return pans;
    }
    static int N; // number of elements in the array
    public static void randomiser(int num) throws IOException {
        Random rand = new Random();
        // N = rand.nextInt(13)+2;

        long[][] dettest = new long[N][N];
        int dummy = new Random().nextInt(7);
        if (dummy % 5 == 2)
        {

            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    dettest[i][j] = dummy*(i + 1)*(j + 1);
                }
            }
        }
        else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dettest[i][j] = (long) Math.pow(-1, rand.nextInt(26)) * rand.nextInt(5);
                }
            }
        }
        StringBuilder input_name = new StringBuilder();
        input_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\equation_bases_data\\input\\input");
        if (num < 10)
            input_name.append("0");
        input_name.append(num);
        input_name.append(".txt");
        FileWriter fw = new FileWriter(input_name.toString());
        fw.write(Integer.toString(N));
        fw.write('\n');
        // print out!
        for (int i = 0; i < N; i++)
        {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++)
            {
                sb.append(dettest[i][j]);
                sb.append((char)(97+j));
                if (j < N - 1)
                    sb.append("+");
                else
                    sb.append("=0");
            }
            // another round
            for (int j = 0; j < sb.length() - 1; )
            {
                if (sb.charAt(j) == '+' && sb.charAt(j + 1) == '-')
                    sb.deleteCharAt(j);
                else
                    j++;
            }
            fw.write(sb.toString());
            fw.write('\n');
        }
        fw.close();
        StringBuilder output_name = new StringBuilder();
        output_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\equation_bases_data\\output\\output");
        if (num < 10)
            output_name.append("0");
        output_name.append(num);
        output_name.append(".txt");
        fw = new FileWriter(output_name.toString());
     //   System.out.println(detfinder(dettest));
        if (detfinder(dettest) != 0)
        {
        fw.write(Integer.toString(1)); // it IS a basis
        }
        else
        {
        fw.write(Integer.toString(0)); // it is NOT a basis
        }
        fw.close();
    }
    public static void main(String[] args) throws IOException {
        int init = 1;
        int fin = 5;
        N = 2;
        while (N <= 10) {
            for (int i = init; i <= fin; i++) {
                randomiser(i);
            }
            N++;
            init+=5;
            fin+=5;
        }
    }
}
