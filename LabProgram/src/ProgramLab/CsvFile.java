/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramLab;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author tuandung
 */
public class CsvFile {
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER =",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    
    //CSV file header
    private static final String FILE_HEADER =
            "name,age,speed,current_position,atk";
    public static void writeCsvFile(String fileName, Set<Police> treeSet) throws IOException{
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(FILE_HEADER+"\n");
        for (Police police : treeSet){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            String str_date=sdf.format(police.getDob());
            fileWriter.write(police.getName()+COMMA_DELIMITER+str_date+COMMA_DELIMITER+police.getCurrent_position().toString()+COMMA_DELIMITER+police.getSpeed()+COMMA_DELIMITER+police.getCurrent_position()+COMMA_DELIMITER+police.getAtk()+"\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }
    //Reader
    public static void loadCsvFile(String fileName, Set<Police> treeSet) throws IOException, ParseException{
        Scanner scanner = new Scanner(new File(fileName));
        scanner.useDelimiter(",|\n|\r");
        System.out.println(scanner.nextLine());
        //Police p = new Police(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        
        while(scanner.hasNext()){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            Police p = new Police(scanner.next(), sdf.parse(scanner.next()), 
                    Point.parse(scanner.next()), 
                    scanner.nextInt(), 
                    scanner.nextInt());
            scanner.nextLine();
            System.out.println(p);
            treeSet.add(p);
        }
        System.out.println(treeSet.size());
        scanner.close();
    }
}   

