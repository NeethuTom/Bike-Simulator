package com.nt.pjt.components;

public class Grid {

    int rows;
    int columns;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    /**
     * validateCell
     * This method validates the cell
     * If the cell position exceeds grid
     *
     * @param cell
     * @return
     */
    public boolean validateCell(Cell cell) {
        return !(
                cell.getX() > this.columns || cell.getX() < 0 ||
                        cell.getY() > this.rows || cell.getY() < 0
        );
    }


}
