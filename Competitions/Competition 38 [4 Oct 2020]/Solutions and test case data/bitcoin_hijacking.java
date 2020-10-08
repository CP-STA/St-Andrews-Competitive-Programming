import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class bitcoin_hijacking {
    static File file;
    static PrintStream stream;
    static Random rand = new Random();
    public static String hijack(String s)
    {
        // check if it is even a bitcoin
        if (s.length() != 26 || s.charAt(0) != '0')
            return s;
        else
        {
            StringBuilder sb = new StringBuilder(s.substring(0, 4));
            sb.append("rgtorjzwg21qyrwono56tl"); // the hijacked string
            return sb.toString();
        }
    }
    public static String solver(String s)
    {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w:split)
        {
            sb.append(hijack(w) + " ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
    public static String testcasegenerator (int length)
    {
        // P(bitcoin) = 1/10
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++)
        {

            StringBuilder bitcoin = new StringBuilder();
            if (rand.nextInt(10) == 0)
            {
                // generate a bitcoin
                bitcoin.append(0);
                // for the remaining 25 characters, generate a letter or number
                String possibilties = "abcdefghijklmnopqrstuvwxyz1234567890";
                for (int j = 0; j < 25; j++)
                {
                    bitcoin.append(possibilties.charAt(rand.nextInt(possibilties.length())));
                }
            }
            else
            {
                // go up to 100
                String possibilties = "abcdefghijklmnopqrstuvwxyz1234567890";
                int strsize = rand.nextInt(100) + 1;
                for (int j = 0; j < strsize; j++)
                {
                    bitcoin.append(possibilties.charAt(rand.nextInt(possibilties.length())));
                }
            }
            sb.append(bitcoin.toString() + " ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
    public static void main(String[] args) throws IOException {
    for (int i = 0; i < 18; i++)
    {
        StringBuilder input_name = new StringBuilder();
        StringBuilder output_name = new StringBuilder();
        input_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\bitcoin_hijacking_data\\input\\input");
        if (i < 10)
            input_name.append("0");
        input_name.append(i);
        input_name.append(".txt");
        file = new File(input_name.toString());
        //Instantiating the PrintStream class
        stream = new PrintStream(file);
        System.setOut(stream);
        String in = testcasegenerator(rand.nextInt(100000));
        System.out.print(in);
        stream.close();
        output_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\bitcoin_hijacking_data\\output\\output");
        if (i < 10)
            output_name.append("0");
        output_name.append(i);
        output_name.append(".txt");
        file = new File(output_name.toString());
        //Instantiating the PrintStream class
        stream = new PrintStream(file);
        System.setOut(stream);
        System.out.println(solver(in));
        stream.close();
    }
    }
}
