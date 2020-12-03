package Day03;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<String>();

        try(BufferedReader bReader = new BufferedReader(new FileReader("input03.txt"))){
            String line;
            while((line = bReader.readLine()) != null){
                lines.add(line);
            }
        } catch (Exception e) {
            
        }

        String[] input = lines.toArray(new String[0]);

        int numLines = input.length;
        int currentY = 1;
        int currentX = 3;
        int trees = 0;

        for(int x = 0; x < numLines; x++){
            while(input[x].length() < numLines * 3){
                input[x] += input[x];
            }
        }
        while(currentY < numLines){
            if(input[currentY].charAt(currentX) == '#'){
                trees++;
            }
            currentY++;
            currentX += 3;
        }
        System.out.println(" - - - PART ONE - - - ");
        System.out.println("Number of trees: " + trees);
        //System.out.println("Lines: " + input.length);
        //System.out.println("Rows: " + input[0].length());

        //part two
        System.out.println(" - - - PART TWO - - - ");
        int[] right = {1,3,5,7,1};
        int[] down = {1,1,1,1,2};
        int[] secondTrees = new int[5];
        for(int x = 0; x < 5; x++){
            secondTrees[x] = CalculateTrees(input, right[x], down[x]);
            System.out.printf("Number of trees(R: %d, D: %d): " + secondTrees[x] + "\r\n", right[x], down[x]);
        }
        long multiply = secondTrees[0];
        for(int x = 1; x < secondTrees.length; x++){
            multiply = multiply * secondTrees[x];
        }
        System.out.println("Mulitply of trees is: " + multiply);
    }

    public static int CalculateTrees(String[] input,int right, int down){
        int trees = 0;
        int currentDown = down;
        int currentRight = right;
        for(int x = 0; x < input.length / down; x += down){
            while(input[x].length() < input.length * right){
                input[x] += input[x];
            }
        }
        while(currentDown < input.length){
            if(input[currentDown].charAt(currentRight) == '#'){
                trees++;
            }
            currentDown += down;
            currentRight += right;
        }
        return trees;
    }
}
