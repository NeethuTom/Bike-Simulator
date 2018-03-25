package com.nt.pjt;

import com.nt.pjt.components.Cell;
import com.nt.pjt.components.Direction;
import com.nt.pjt.components.Grid;
import org.junit.Assert;

public class GridTest {

    public void testValidCell() throws Exception {

        Cell cellTest = new Cell(0, 0, Direction.EAST);
        Grid testGrid = new Grid(7, 7);
        Assert.assertTrue(testGrid.validateCell(cellTest));

        cellTest=new Cell(8, 0, Direction.EAST);
        Assert.assertFalse(testGrid.validateCell(cellTest));

    }

}

