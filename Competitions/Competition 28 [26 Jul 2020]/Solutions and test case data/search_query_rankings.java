import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.io.PrintStream;

public class search_query_rankings {
    static Random rand = new Random();
    static File file;
    static PrintStream stream;
    public static int edit_distance (String a, String b) {
        int insert = 1;
        int delete = 1;
        int sub = 1;
        int dp[][] = new int[a.length() + 1][b.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= a.length(); i++)
        {
            dp[i][0] = dp[i - 1][0] + insert; // insert only
        }
        for (int i = 1; i <= b.length(); i++)
        {
            dp[0][i] = dp[0][i - 1] + delete; // delete only
        }
        for (int i = 1; i <= a.length(); i++)
        {
            for (int j = 1; j <= b.length(); j++)
            {
                int minval = Integer.MAX_VALUE;
                if (i != 0) {
                    minval = Math.min(minval, dp[i - 1][j] + delete);
                }
                if (j != 0) {
                    minval = Math.min(minval, dp[i][j - 1] + insert);
                }
                if (i != 0 && j != 0) {
                    minval = Math.min(minval, dp[i - 1][j - 1] + ((a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : sub));
                }
                dp[i][j] = minval;
            }
        }
        return dp[a.length()][b.length()];
    }
    public static List<String> solver(String target, List<String> candidates)
    {
        // compute the edit distance for each candidate
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            { int ed1 = edit_distance(target, o1);
            int ed2 = edit_distance(target, o2);
            if (ed1 != ed2)
                return ed1 - ed2;
            else
                return o1.compareTo(o2);
            }
        });
        pq.addAll(candidates);
        // now spit the output that's already sorted the way we want
        ArrayList<String> out = new ArrayList<>();
        // print the output, one by one due to structure of priority queue
        while(pq.size() > 0)
        {
            out.add(pq.poll());
        }
        return out;
    }
    public static String word_generator()
    {
        int str_len = rand.nextInt(250);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str_len; i++)
        {
            sb.append((char)(rand.nextInt(25) + 97));
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
       for (int i = 0; i < 50; i++)
       {
           int num_words = rand.nextInt(500);
           String target_word = word_generator();
           ArrayList<String> candidates = new ArrayList<>();
           for (int j = 0; j < num_words; j++)
               candidates.add(word_generator());
           List<String> res = solver(target_word, candidates);
           // print them
           StringBuilder input_name = new StringBuilder();
           input_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\search_query_rankings_data\\input\\input");
           if (i < 10)
               input_name.append("0");
           input_name.append(i);
           input_name.append(".txt");
           file = new File(input_name.toString());
           //Instantiating the PrintStream class
           stream = new PrintStream(file);
           System.setOut(stream);
           // target string
           System.out.println(target_word);
           System.out.println(num_words);
           for (String s:candidates)
               System.out.println(s);
           stream.close();
           StringBuilder output_name = new StringBuilder();
           output_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\search_query_rankings_data\\output\\output");
           if (i < 10)
               output_name.append("0");
           output_name.append(i);
           output_name.append(".txt");
           file = new File(output_name.toString());
           stream = new PrintStream(file);
           System.setOut(stream);
           for (String s:res)
               System.out.println(s);
           stream.close();
       }
    }
}
