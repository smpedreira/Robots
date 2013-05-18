package org.researching.robots;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class RobotTest {

    private Robot robot;

    @Mock
    private Meseta plat;
    
    @Mock
    private List<Direction> mockOrders;

    @Before
    public void update(){
        robot = new Robot();
    }
    
    @Test
    public void processTest(){
        
    }

    @Test
    public void processWithPlatToZero(){
        Meseta plat = new Meseta();
        plat.setX(0);
        plat.setY(0);
        
        int x = 0;
        int y = 0;
        robot.setCardinalPoint(CardinalPoint.N);
        robot.setPosX(x);
        robot.setPosY(y);

        boolean result = robot.process(plat, Direction.M);
        assertFalse(result);
        assertEquals(robot.getPosX(), x);
        assertEquals(robot.getPosY(), y);
        assertEquals(robot.getCardinalPoint(), CardinalPoint.N);
   }

    @Test
    public void processWithPlatWithValues(){
        Meseta plat = new Meseta();
        plat.setX(2);
        plat.setY(4);
        
        int x = 0;
        int y = 1;
        robot.setCardinalPoint(CardinalPoint.E);
        robot.setPosX(x);
        robot.setPosY(y);

        boolean result = robot.process(plat, Direction.M);
        assertTrue(result);
        assertEquals(robot.getPosX(), ++x);
        assertEquals(robot.getPosY(), y);
        assertEquals(robot.getCardinalPoint(), CardinalPoint.E);
        
        result = robot.process(plat, Direction.M);
        assertFalse(result);
        assertEquals(robot.getPosX(), x);
        assertEquals(robot.getPosY(), y);
        assertEquals(robot.getCardinalPoint(), CardinalPoint.E);

   }
    
    @Test
    public void processRoundOver(){
        Meseta plat = new Meseta();
        plat.setX(4);
        plat.setY(5);
        
        int x = 2;
        int y = 2;
        robot.setCardinalPoint(CardinalPoint.N);
        robot.setPosX(x);
        robot.setPosY(y);

        boolean result = robot.process(plat, Direction.R);
        assertTrue(result);
        assertEquals(robot.getPosX(), x);
        assertEquals(robot.getPosY(), y);
        assertEquals(robot.getCardinalPoint(), CardinalPoint.E);

        result = robot.process(plat, Direction.M);
        assertTrue(result);
        assertEquals(robot.getPosX(), ++x);
        assertEquals(robot.getPosY(), y);
        assertEquals(robot.getCardinalPoint(), CardinalPoint.E);
        
        result = robot.process(plat, Direction.R);
        assertTrue(result);
        assertEquals(robot.getPosX(), x);
        assertEquals(robot.getPosY(), y);
        assertEquals(robot.getCardinalPoint(), CardinalPoint.S);
        
        result = robot.process(plat, Direction.M);
        assertTrue(result);
        assertEquals(robot.getPosX(), x);
        assertEquals(robot.getPosY(), --y);
        assertEquals(robot.getCardinalPoint(), CardinalPoint.S);
        
        result = robot.process(plat, Direction.R);
        assertTrue(result);
        assertEquals(robot.getPosX(), x);
        assertEquals(robot.getPosY(), y);
        assertEquals(robot.getCardinalPoint(), CardinalPoint.W);

        result = robot.process(plat, Direction.M);
        assertTrue(result);
        assertEquals(robot.getPosX(), --x);
        assertEquals(robot.getPosY(), y);
        assertEquals(robot.getCardinalPoint(), CardinalPoint.W);

        result = robot.process(plat, Direction.R);
        assertTrue(result);
        assertEquals(robot.getPosX(), x);
        assertEquals(robot.getPosY(), y);
        assertEquals(robot.getCardinalPoint(), CardinalPoint.N);
   }

}
