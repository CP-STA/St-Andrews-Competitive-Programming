import java.io.*;
import java.util.*;
class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException  e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt()
    {
        return Integer.parseInt(next());
    }

    long nextLong()
    {
        return Long.parseLong(next());
    }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}
public class miniature_notepad_hackerrank {
    static LinkedList<Character> out = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        int index = 0;
        FastReader keyboard = new FastReader();
        LinkedList<Character> out = new LinkedList<>();
        String inputstring = keyboard.nextLine();
        for (int i = 0; i < inputstring.length(); i++)
        {
            if (inputstring.charAt(i) == '-')
            {
                // don't do anything, wait for the next character
                index = Math.max(index-1,0);
            }
            else if (inputstring.charAt(i) == '+')
            {
                index = Math.min(out.size(), index++); // add, but don't allow overflow
            }
            else if (inputstring.charAt(i) == '@')
            {
                // go to first
                index = 0;
            }
            else if (inputstring.charAt(i) == '#')
            {
                // go to end
                index = out.size();
            }
            else if (inputstring.charAt(i) == '^')
            {
                out = new LinkedList<Character>();
                index = 0;
            }
            else
            {
                out.add(index, inputstring.charAt(i));
                index++;
            }
        }
            for (Character c:out)
                System.out.print(c);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}