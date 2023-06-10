package  com.company;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pattern pattern = Pattern.compile("((\\d|1?\\d\\d|2([0-4]\\d|5[0-5]))\\.){3}(\\d|1?\\d\\d|2([0-4]\\d|5[0-5]))");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("IP_Log.txt")))
        {
            System.out.println("Input the string");
            String str = in.nextLine();
            Matcher matcher = pattern.matcher(str);
            String group;
            if (matcher.find()) {
                group = matcher.group();
                if(str.equals(group)){
                    writer.write(str + ": OK");
                    return;
                }
                writer.write(str + " : Ip is not correct");
            }
            else {
                writer.write(str + " : Error");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
