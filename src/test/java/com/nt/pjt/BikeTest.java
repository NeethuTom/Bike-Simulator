package com.nt.pjt;

import com.nt.pjt.components.Cell;
import com.nt.pjt.components.Direction;
import com.nt.pjt.components.MyBike;
import org.junit.Assert;
import org.junit.Test;

public class BikeTest {
    @Test
    public void testBikePosition() throws Exception {
        MyBike bikeTest=new MyBike(new Cell(0,0, Direction.WEST));
        bikeTest.rotateRight();
        Assert.assertEquals(bikeTest.getCell().getX(),0);
        Assert.assertEquals(bikeTest.getCell().getY(),0);
        Assert.assertEquals(bikeTest.getCell().getDirection(),Direction.NORTH);

        bikeTest.rotateLeft();
        Assert.assertEquals(bikeTest.getCell().getX(),0);
        Assert.assertEquals(bikeTest.getCell().getY(),0);
        Assert.assertEquals(bikeTest.getCell().getDirection(),Direction.WEST);

    }
}
