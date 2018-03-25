package com.nt.pjt.components;

public class Cell {
    int x;
    int y;

    Direction direction;

    /**
     * getX cordinate
     * @return X
     */
    public int getX() {
        return x;
    }

    /**
     * set X cordinate
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * get Y cordinate
     * @return Y
     */
    public int getY() {
        return y;
    }

    /**
     * set Y coordinate
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * get direction
     * @return direction
     */
    public Direction getDirection() {

        return direction;
    }

    /**
     * set direction
     * @param direction
     */
    public void setDirection(Direction direction) {

        this.direction = direction;
    }

    //constructor
    public Cell(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    public Cell(Cell cell) {
        this.x = cell.getX();
        this.y = cell.getY();
        this.direction = cell.getDirection();
    }

    /**
     * getNextPosition
     * @return the next position
     * here validation isnot done
     */
    public Cell getNextPosition() {
        Cell newCell = new Cell(this);
        switch (this.direction) {
            case NORTH:
                newCell.y = this.y + 1;
                break;
            case EAST:
                newCell.x = this.x + 1;
                break;
            case SOUTH:
                newCell.y = this.y -1;
                break;
            case WEST:
                newCell.x = this.x -1;
                break;
        }

        return newCell;
    }
}
