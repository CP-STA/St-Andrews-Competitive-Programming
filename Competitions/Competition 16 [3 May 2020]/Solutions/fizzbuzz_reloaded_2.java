import java.io.FileWriter;
import java.io.IOException;

public class fizzbuzz_reloaded_2 {
    public static long getanswer(long n)
    {
        // if n < 15, need to handle it differently
        long ans = 0;
        if (n < 15)
        {
            double max_value = 0;
            for (int i = 1; i <= n; i++)
            {
                if (4*(Math.floorDiv(i,3) + Math.floorDiv(i,5))/(double)i >= max_value)
                {
                    max_value = 4*(Math.floorDiv(i,3) + Math.floorDiv(i,5))/(double)i;
                    ans = i;
                }
            }
            return ans;
        }
        else
        {
            return 15*(n/15);
        }
    }
    public static void main(String[] args) throws IOException {
    // get input
    // n up to 34
    for (int j = 70; j <= 78; j++)
    {
        int i = j - 69;
        int num = j;
        long val = (long)Math.pow(15,i);
        StringBuilder input_name = new StringBuilder();
        input_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\fizzbuzz_reloaded_2_data\\input\\input");
        if (num < 10)
            input_name.append("0");
        input_name.append(num);
        input_name.append(".txt");
        FileWriter fw = new FileWriter(input_name.toString());
        fw.write(Long.toString(val));
        fw.write('\n');
        fw.close();
        long res = getanswer(val);
        StringBuilder output_name = new StringBuilder();
        output_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\fizzbuzz_reloaded_2_data\\output\\output");
        if (num < 10)
            output_name.append("0");
        output_name.append(num);
        output_name.append(".txt");
        fw = new FileWriter(output_name.toString());
        fw.write(Long.toString(res));
        fw.write('\n');
        fw.close();
    }
    }
}
