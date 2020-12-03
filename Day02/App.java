package Day02;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<String> lines = new ArrayList<String>();

        try(BufferedReader bReader = new BufferedReader(new FileReader("input02.txt"))){
            String line;
            while((line = bReader.readLine()) != null){
                lines.add(line);
            }
        } catch (Exception e) {
            
        }

        String[] input = lines.toArray(new String[0]);
        int validPasswords = 0;
        for (String password : input) {
            String range = password.split(" ")[0];
            int minimum = Integer.parseInt(range.split("-")[0]);
            int maximum = Integer.parseInt(range.split("-")[1]);
            String text = password.split(": ")[1];
            String symbol = password.split(":")[0].split(" ")[1];
            int num = text.length() - text.replaceAll(symbol, "").length();
            if(num >= minimum && num <= maximum){
                validPasswords++;
            }
        }
        System.out.println("Valid passwords part one: " + validPasswords);
        // part two
        int validPasswordsSecond = 0;
        for (String password : input) {
            String range = password.split(" ")[0];
            int minimum = Integer.parseInt(range.split("-")[0]) - 1;
            int maximum = Integer.parseInt(range.split("-")[1]) - 1;
            String text = password.split(": ")[1];
            String symbol = password.split(":")[0].split(" ")[1];
            if(text.charAt(minimum) != text.charAt(maximum)){
                if(text.charAt(minimum) == symbol.charAt(0) || text.charAt(maximum) == symbol.charAt(0)){
                    validPasswordsSecond++;
                }
            }
        }
        System.out.println("Valid passwords part two: " + validPasswordsSecond);
    }
}
