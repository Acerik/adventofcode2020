package Day05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class App {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<String>();
        try(BufferedReader bReader = new BufferedReader(new FileReader("./Day05/input.txt"))){
            String line;
            while((line = bReader.readLine()) != null){
                lines.add(line);
            }
        } catch (Exception e) {
            System.err.println("Read error: " + e);
        }
        String[] input = lines.toArray(new String[0]);

        ArrayList<Integer> seatIDs = new ArrayList<>();

        int highestID = -1;
        for(int x = 0; x < input.length; x++){
            char[] line = input[x].toCharArray();
            int row = 127;
            int rangeRow = 127;
            int column = 7;
            int rangeColumn = 7;
            for(char c : line){
                switch(c){
                    case 'F':
                        row -= rangeRow / 2 + 1;
                    case 'B':
                        rangeRow /= 2;
                        break;
                    case 'L':
                        column -= rangeColumn / 2 + 1;
                    case 'R':
                        rangeColumn /= 2;
                        break;
                }
            }
            int actualID = row * 8 + column;
            System.out.println(x + "|Row: " + row + " Column: " + column + " ID: " + actualID);
            if(highestID < actualID){
                highestID = actualID;
            }
            seatIDs.add(actualID);
        }

        System.out.println(" - - - PART ONE - - - ");
        System.out.println("Highest ID seat: " + highestID);
        int partTwoID = 0;
        Collections.sort(seatIDs);
        for(int x = 0; x < seatIDs.size() - 1; x++){
            if(seatIDs.get(x + 1) - seatIDs.get(x) != 1){
                partTwoID = seatIDs.get(x) + 1;
            }
        }
        System.out.println(" - - - PART TWO - - - ");
        System.out.println("ID seat: " + partTwoID);
    }
}
