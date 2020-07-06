import sun.awt.image.ImageWatched;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class converting_number_systems {
    public static String solver (String input)
    {
        // one way is to detect the numbering system
        if (input.length() < 7)
        {
            // useless as the number is same either way
            return input;
        }
        else
        {
            boolean isIndian = false;
            if (input.charAt(input.length() - 7) == ',')
            {
                // 123,456 (international) vs 1,23,456 (indian) -> attacking the seventh from last character is enough
                isIndian = true;
            }
            // now get the number as-is
            LinkedList<Character> sb = new LinkedList<>();
            // convert
            if (isIndian)
            {
                // indian to international
                int charno = 0;
                for (int i = input.length() - 1; i >= 0; i--)
                {
                // add the comma after every 3n characters
                    if (input.charAt(i) != ',')
                    {
                        sb.addFirst(input.charAt(i));
                        charno++;
                        if (charno % 3 == 0)
                            sb.addFirst(',');
                    }
                }
            }
            else
            {
                // international to indian
                int charno = 0;
                for (int i = input.length() - 1; i >= 0; i--)
                {
                    // add the comma after every 2n + 1 characters
                    if (input.charAt(i) != ',')
                    {
                        sb.addFirst(input.charAt(i));
                        charno++;
                        if (charno % (2) == 1 && charno != 1)
                            sb.addFirst(',');
                    }
                }
            }
            // remove prefix comma if it exists
            if (sb.get(0) == ',')
                sb.pollFirst();
            // return the string
            StringBuilder fin = new StringBuilder();
            while (sb.size() > 0)
            {
                fin.append(sb.pollFirst());
            }
            return fin.toString();
        }
    }

    public static String generator(int max_val) {
        // generate a string up to max_val length
        Random rand = new Random();
        boolean isIndian = rand.nextBoolean(); // determine system
        int strlength = rand.nextInt(max_val);
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < strlength; i++)
        {
            sb2.append(rand.nextInt(9) + 1);
        }
        String input = sb2.toString();
        LinkedList<Character> sb = new LinkedList<>();
        // convert
        if (isIndian)
        {
            // indian to international
            int charno = 0;
            for (int i = input.length() - 1; i >= 0; i--)
            {
                // add the comma after every 3n characters
                if (input.charAt(i) != ',')
                {
                    sb.addFirst(input.charAt(i));
                    charno++;
                    if (charno % 3 == 0)
                        sb.addFirst(',');
                }
            }
        }
        else
        {
            // international to indian
            int charno = 0;
            for (int i = input.length() - 1; i >= 0; i--)
            {
                // add the comma after every 2n + 1 characters
                if (input.charAt(i) != ',')
                {
                    sb.addFirst(input.charAt(i));
                    charno++;
                    if (charno % (2) == 1 && charno != 1)
                        sb.addFirst(',');
                }
            }
        }
        // remove prefix comma if it exists
        if (sb.get(0) == ',')
            sb.pollFirst();
        // return the string
        StringBuilder fin = new StringBuilder();
        while (sb.size() > 0)
        {
            fin.append(sb.pollFirst());
        }
        return fin.toString();
    }

    public static void main(String[] args) throws IOException {
//    System.out.println(solver("1,23,456"));
//    System.out.println(solver("123,456"));
//    System.out.println(solver("123"));
//    System.out.println(solver("1,23,45,67,890"));
//    System.out.println(solver("1,234,567,890"));
      // System.out.println (generator(6000));
        for (int num = 0; num < 50; num++) {
            StringBuilder input_name = new StringBuilder();
            input_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\converting_number_systems_data\\input\\input");
            if (num < 10)
                input_name.append("0");
            input_name.append(num);
            input_name.append(".txt");
            FileWriter fw = new FileWriter(input_name.toString());
            String input = generator(25000);
            fw.write(input);
            fw.write('\n');
            fw.close();
            String output = solver(input);
            StringBuilder output_name = new StringBuilder();
            output_name.append("C:\\Users\\vishn\\OneDrive\\Documents\\IntelliJ\\competitivestandrews\\src\\converting_number_systems_data\\output\\output");
            if (num < 10)
                output_name.append("0");
            output_name.append(num);
            output_name.append(".txt");
            fw = new FileWriter(output_name.toString());
            fw.write(output);
            fw.write('\n');
            fw.close();
        }
    }
}
