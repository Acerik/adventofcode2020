package Day01;
import java.io.BufferedReader;
import java.io.FileReader;

public class App{
    public static void main(String[] args) {
        //part one

        int[] inputArray;
        String input = "";
        int numOfLines = 0;
        int firstNum = 0;
        int secondNum = 0;
        //load from input file
        try(BufferedReader bReader = new BufferedReader(new FileReader("input01.txt"))){
            String line;
            while((line = bReader.readLine()) != null){
                input += line + ";";
                numOfLines++;
            }
        } catch (Exception e) {
            
        }
        inputArray = new int[numOfLines];
        for(int i = 0; i < numOfLines-1;i++){
            inputArray[i] = Integer.parseInt(input.split(";")[i]);
        }
        for(int x = 0; x < inputArray.length; x++){
            for(int y = 0; y < inputArray.length; y++){
                if((inputArray[x] + inputArray[y]) == 2020){
                    firstNum = inputArray[x];
                    secondNum = inputArray[y];
                }
            }
        }
        System.out.println("---------part one---------");
        System.out.println("First number: " + firstNum);
        System.out.println("Second number: " + secondNum);
        System.out.println(firstNum + " + " + secondNum + " = " + (firstNum + secondNum));
        System.out.println(firstNum + " * " + secondNum + " = " + (firstNum * secondNum));
        // part two
        firstNum = -1;
        secondNum = -1;
        int thirdNum = -1;
        for(int x = 0; x < inputArray.length - 1; x++){
            for(int y = 0; y < inputArray.length - 1; y++){
                for(int i = 0; i < inputArray.length - 1; i++){
                    if((inputArray[x] + inputArray[y] + inputArray[i]) == 2020){
                        firstNum = inputArray[x];
                        secondNum = inputArray[y];
                        thirdNum = inputArray[i];
                    }
                }
            }
        }
        System.out.println("---------part two---------");
        System.out.println("First number: " + firstNum);
        System.out.println("Second number: " + secondNum);
        System.out.println("Third number: " + thirdNum);
        System.out.println(firstNum + " + " + secondNum + " + " + thirdNum + " = " + (firstNum + secondNum + thirdNum));
        System.out.println(firstNum + " * " + secondNum + " * " + thirdNum + " = " + (firstNum * secondNum * thirdNum));
    }
}