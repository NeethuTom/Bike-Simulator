package com.nt.pjt;

import com.nt.pjt.components.Direction;
import com.nt.pjt.components.Grid;
import com.nt.pjt.components.MyBike;
import com.nt.pjt.exception.PrintException;
import org.junit.Assert;
import org.junit.Test;

public class ActionTest {
    @Test
    public void testCommand() throws Exception {
        MyBike bikeTest=new MyBike();
        Grid grid=new Grid(7,7);
        Action myAction=new Action(grid,bikeTest);
        myAction.execute("PLACE 0,0,NORTH");
        Assert.assertEquals(bikeTest.getCell().getX(),0);
        Assert.assertEquals(bikeTest.getCell().getY(),0);


        myAction.execute("FORWARD");
        Assert.assertEquals(bikeTest.getCell().getX(),0);
        Assert.assertEquals(bikeTest.getCell().getY(),1);
        Assert.assertEquals(bikeTest.getCell().getDirection(), Direction.NORTH);

        myAction.execute("TURN_LEFT");
        Assert.assertEquals(bikeTest.getCell().getX(),0);
        Assert.assertEquals(bikeTest.getCell().getY(),1);
        Assert.assertEquals(bikeTest.getCell().getDirection(), Direction.WEST);

        myAction.execute("TURN_RIGHT");
        Assert.assertEquals(bikeTest.getCell().getX(),0);
        Assert.assertEquals(bikeTest.getCell().getY(),1);
        Assert.assertEquals(bikeTest.getCell().getDirection(), Direction.NORTH);


    }

}
