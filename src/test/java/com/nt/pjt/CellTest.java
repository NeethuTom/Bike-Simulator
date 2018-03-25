package com.nt.pjt;

import com.nt.pjt.components.Cell;
import com.nt.pjt.components.Direction;
import org.junit.Assert;
import org.junit.Test;

public class CellTest {
    @Test
    public void testCell() throws Exception {
        Cell cell=new Cell(0,0, Direction.EAST);

        Cell nextCell=cell.getNextPosition();
        Assert.assertEquals(nextCell.getX(),1);
        Assert.assertEquals(nextCell.getY(),0);
        Assert.assertEquals(nextCell.getDirection(),Direction.EAST);

        nextCell=nextCell.getNextPosition();
        Assert.assertEquals(nextCell.getX(),2);
        Assert.assertNotEquals(nextCell.getY(),1);
        Assert.assertNotEquals(nextCell.getDirection(),Direction.WEST);

        //VALIDATION FOR GRID IS NOT DONE IN THIS METHOD
        nextCell=new Cell(2,7, Direction.NORTH);
        nextCell=nextCell.getNextPosition();
        Assert.assertEquals(nextCell.getX(),2);
        Assert.assertEquals(nextCell.getY(),8);
        Assert.assertEquals(nextCell.getDirection(),Direction.NORTH);




    }
}
