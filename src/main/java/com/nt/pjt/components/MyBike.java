package com.nt.pjt.components;

import com.nt.pjt.exception.PrintException;

public class MyBike {

    private Cell cell;
    //constructor
    public MyBike() {
    }

    /**
     * getCell
     * @return cell
     */
    public Cell getCell() {
        return cell;
    }

    /**
     * set cell
     * @param cell
     */
    public void setCell(Cell cell) {
        this.cell = cell;
    }


    //constructor
    public MyBike(Cell cell) {
        this.cell = cell;
    }

    /**
     * rotateLeft
     *the method rotates the bike to left
     */
    public void rotateLeft()  {
        this.cell.direction = this.cell.direction.leftDirection();
    }

    /**
     * rotateRight
     * the method rotates the bike to right
     */
    public void rotateRight() {
        this.cell.direction = this.cell.direction.rightDirection();
    }
}
