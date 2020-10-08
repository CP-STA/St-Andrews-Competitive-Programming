import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

public class filling_milk {
    static Random rand = new Random();
    static File file;
    static PrintStream stream;
    static class Node
    {
        int capacity;
        int profit;
        Node (int a, int b)
        {
            capacity = a;
            profit = b;
        }
    }
    public static int solver(int[] capacity, int[] profit, int limit)
    {
        ArrayList<Node> core = new ArrayList<>();
        for (int i = 0; i < capacity.length; i++)
        {
            core.add(new Node (capacity[i], profit[i]));
        }
        // greedy sort
        core.sort((o1, o2) -> Double.compare((double)o2.profit/(double)o2.capacity, (double)o1.profit/(double)o1.capacity));
        double ans = 0;
        for (Node N: core)
        {
            // fill the entire jar unless this is impossible
            if (limit >= N.capacity)
            {
                limit -= N.capacity;
                ans+=N.profit;
            }
            else if (limit > 0)
            {
                // then fill as much as you can
                ans = ans + ((double)limit/(double)N.capacity) * (double)N.profit;
                limit = 0;
            }
            else
            {
                // can't proceed
                break;
            }
        }
        return (int)ans;
    }
    public static void main(String[] args) throws IOException {
    for (int i = 0; i < 60; i++)
    {
        int arrsize = rand.nextInt(35000);
        int caparr[] = new int[arrsize];
        int profit[] = new int[arrsize];
        for (int j = 0; j < arrsize; j++)
        {
            caparr[j] = rand.nextInt(5000);
            profit[j] = rand.nextInt(50) + 1;
        }
        int limit = rand.nextInt(arrsize * 5000);
        int result = solver(caparr, profit, limit);
        // input
        StringBuilder input_name = new StringBuilder();
        input_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\filling_milk_data\\input\\input");
        if (i < 10)
            input_name.append("0");
        input_name.append(i);
        input_name.append(".txt");
        file = new File(input_name.toString());
        //Instantiating the PrintStream class
        stream = new PrintStream(file);
        System.setOut(stream);
        System.out.println(arrsize);
        for (int j:caparr)
            System.out.print(j + " ");
        System.out.println();
        for (int j:profit)
            System.out.print(j + " ");
        System.out.println();
        System.out.println(limit);
        stream.close();
        StringBuilder output_name = new StringBuilder();
        output_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\filling_milk_data\\output\\output");
        if (i < 10)
            output_name.append("0");
        output_name.append(i);
        output_name.append(".txt");
        file = new File(output_name.toString());
        //Instantiating the PrintStream class
        stream = new PrintStream(file);
        System.setOut(stream);
        System.out.println(result);
        stream.close();
    }
    }
}
