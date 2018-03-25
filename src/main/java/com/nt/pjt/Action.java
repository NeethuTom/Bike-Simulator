package com.nt.pjt;

import com.nt.pjt.components.*;
import com.nt.pjt.exception.PrintException;

import static com.nt.pjt.Constants.ErrorConstants.*;

public class Action {
    Grid grid;
    MyBike bike;

    /**
     * Constructor
     * @param grid
     * @param bike
     */
    public Action(Grid grid, MyBike bike) {
        this.grid = grid;
        this.bike = bike;
    }

    /**
     * This method is for executing each command
     * @param actionLine
     * @throws PrintException
     */
    public void execute(String actionLine) throws PrintException {
        String[] args = actionLine.split(" ");
        Command command;

        // here, the code checks the format of inputted command.
        try {
            command = Command.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            throw new PrintException(INVALID_COMMAND);
        }
        /*
        The below switch case deals with all commands inputted
        If the command is PLACE, the bike is placed in the location
        If the command is FORWARD, the bike is moved  to  the next cell
        If the command is TURN_LEFT, the bike is turned  to left
        If the command is TURN_RIGHT, the bike is turned  to right
         */
        switch (command) {
            case PLACE:
                validateAndPlaceBike(args);
                break;
            case FORWARD:
                validateAndForwardBike();
                break;
            case TURN_LEFT:
                checksForBikePosition();
                bike.rotateLeft();
                break;
            case TURN_RIGHT:
                checksForBikePosition();
                bike.rotateRight();
                break;
            case GPS_REPORT:
                checksForBikePosition();
                report();
                break;
            default:
                throw new PrintException(INVALID_COMMAND);
        }

    }


    /**
     * validateAndPlaceBike
     * This method is for placing the bike in correct position
     * Here,it first checks the format of the inputted command
     * Then checks the position inputted is within the grid
     * If all good,place the bike in the respective cell
     * else throws the corresponding exception
     * @param args
     * @throws PrintException
     */
    public void validateAndPlaceBike(String[] args) throws PrintException {

        //validate the input command
        String[] params;
        int x = 0;
        int y = 0;
        
        Direction direction = null;
        if (args.length < 2) {
            throw new PrintException(INVALID_COMMAND);
        }else{
            params = args[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                direction = Direction.valueOf(params[2]);
            } catch (Exception e) {
                throw new PrintException(INVALID_COMMAND);
            }

            Cell gps=new Cell(x,y,direction);
            //validate inputted position
            if(!grid.validateCell(gps)){
                throw new PrintException(INVALID_POSITION);
            }else{
            bike.setCell(gps);
            }

        }
    }

    /**
     * validateAndForwardBike
     * The method is for moving the bike forward.
     * The method first check whether the bike is now positioned in
     * cell of grid
     * Next finds out the new position to be held
     * Validate the new position
     * If the new position is valid,Place bike is new position
     * @throws PrintException
     */
    public void validateAndForwardBike() throws PrintException {
        checksForBikePosition();
        Cell newGPS=bike.getCell().getNextPosition();
        System.out.println(newGPS.getY());
        if(!grid.validateCell(newGPS)){
            throw new PrintException(INVALID_POSITION);
        }
            bike.setCell(newGPS);
    }

    /**
     * checksForBikePosition
     * The method checks whether the bike is positioned in the grid now
     * @throws PrintException
     */
    public  void checksForBikePosition() throws PrintException {
        if(bike.getCell()==null){
            throw new PrintException(POSITION_NOT_SET);
        }
    }

    /**
     * The method is for displaying
     * the GPS position of the bike
     */
    public void report() {
        System.out.println("GPS POSITION:(" + bike.getCell().getX() + "," + bike.getCell().getY() + ")," + bike.getCell().getDirection());
    }
}
