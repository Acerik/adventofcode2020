package Day04;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<String>();
        int emptyLines = 0;
        try(BufferedReader bReader = new BufferedReader(new FileReader("./Day04/input.txt"))){
            String line;
            while((line = bReader.readLine()) != null){
                lines.add(line);
                if(line.isBlank()){
                    emptyLines++;
                }
            }
        } catch (Exception e) {
            System.err.println("Read error: " + e);
        }

        String[] input = lines.toArray(new String[0]);
        String[] editInput = new String[emptyLines + 1];

        int newLine = 0;
        for(int x = 0; x < input.length; x++ ){
            if(editInput[newLine] == null){
                editInput[newLine] = "";
            }
            if(!input[x].isBlank()){
                if(editInput[newLine] == ""){
                    editInput[newLine] += input[x];
                } else {
                    editInput[newLine] += " " + input[x];
                }
            } else {
                newLine++;
            }
        }
        int validPassportsPartOne = 0;
        int validPassportsPartTwo = 0;
        String[] keysTemp = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        List<String> keys = Arrays.asList(keysTemp);
        for(int x = 0; x < editInput.length; x++){
            String[] pair = editInput[x].split(" ");
            int validKeysPartOne = 0;
            for(int y = 0; y < pair.length; y++){
                String key = pair[y].split(":")[0];
                if(keys.contains(key)){
                    validKeysPartOne++;
                }
            }
            if(validKeysPartOne >= keysTemp.length){
                validPassportsPartOne++;
                int validValues = 0;
                for(int y = 0; y < pair.length; y++){
                    String key = pair[y].split(":")[0];
                    String value = pair[y].split(":")[1];
                    switch(key) {
                        case "byr":
                            int byr = Integer.parseInt(value);
                            if(byr >= 1920 && byr <= 2002){
                                validValues++;
                            }
                            break;
                        case "iyr":
                            int iyr = Integer.parseInt(value);
                            if(iyr >= 2010 && iyr <= 2020){
                                validValues++;
                            }
                            break;
                        case "eyr":
                            int eyr = Integer.parseInt(value);
                            if(eyr >= 2020 && eyr <= 2030){
                                validValues++;
                            }
                            break;
                        case "hgt":
                            if(value.contains("in")){
                                int hgt = Integer.parseInt(value.replace("in",""));
                                if(hgt >= 59 && hgt <= 76){
                                    validValues++;
                                }
                            } else if(value.contains("cm")){
                                int hgt = Integer.parseInt(value.replace("cm", ""));
                                if(hgt >= 150 && hgt <= 193){
                                    validValues++;
                                }
                            }
                            break;
                        case "hcl":
                            Pattern p = Pattern.compile("[#][0-9|a-f][0-9|a-f][0-9|a-f][0-9|a-f][0-9|a-f][0-9|a-f]");
                            Matcher m = p.matcher(value);
                            if(m.matches()){
                                validValues++;
                            }
                            break;
                        case "ecl": 
                            String[] eclValidTemp = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
                            List<String> eclValid = Arrays.asList(eclValidTemp);
                            if(eclValid.contains(value)){
                                validValues++;
                            }
                            break;
                        case "pid":
                            Pattern pp = Pattern.compile("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
                            Matcher mm = pp.matcher(value);
                            if(mm.matches()){
                                validValues++;
                            }
                            break;
                    }
                }
                if(validValues >= keysTemp.length){
                    validPassportsPartTwo++;
                }
            }
            
        }
        System.out.println(" - - - PART ONE - - - ");
        System.out.println("Valid passports: " + validPassportsPartOne);
        System.out.println(" - - - PART TWO - - - ");
        System.out.println("Valid passports: " + validPassportsPartTwo);
    }
}
