package com.nt.pjt;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import com.nt.pjt.components.Grid;
import com.nt.pjt.components.MyBike;
import com.nt.pjt.exception.PrintException;

import static com.nt.pjt.Constants.ErrorConstants.FILE_NOT_FOUND;

/**
 * Main method
 */
public class App 
{
    public static void main( String[] args ) throws java.io.IOException,PrintException
    {
        MyBike bike=new MyBike();
        Grid grid=new Grid(7,7);
        Action myAction=new Action(grid,bike);

        List<String> actionList = new ArrayList<>();
        //method to fetch allthe input commands from file
        try {
            actionList=fetchFromFile();
        } catch (PrintException e) {
            e.printStackTrace();
        }
        actionList.forEach((actionLine)->{

            //method is called to execute each command in file
            try {
                myAction.execute(actionLine);
            } catch (PrintException e) {
                System.out.println(e.getMessage());
            }

        });

    }

    /**
     * fetchFronmFile
     * This method is for fetching the commends from file
     * @return the collection of input commands
     * @throws PrintException
     */
    private static List<String> fetchFromFile() throws PrintException {
        String fileName = "D://Docs/lines.txt";
        List<String> actionList = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            //br returns as stream and convert it into a List
            actionList = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            throw new PrintException(FILE_NOT_FOUND);
        }
       return  actionList;
    }
}

