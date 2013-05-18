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
public class ControllerTest {

	private Controller controller;

	@Mock
	private Robot robot;

	@Mock
	private Meseta plat;
	
	@Mock
	private List<Direction> mockOrders;
	
    @Mock
    private ReadSystem in;

	@Before
	public void update(){
	    controller = new Controller(plat,robot, mockOrders, in);
	}
	
	@Test
	public void startCallProcessAndShowSituationTest(){
	    given(plat.validPosition(anyInt(), anyInt())).willReturn(true);
	    given(mockOrders.get(anyInt())).willReturn(Direction.L);
	    given(mockOrders.size()).willReturn(3);
	    given(robot.process(plat, Direction.L)).willReturn(true);

	    controller.start();

	    verify(mockOrders, Mockito.times(3)).get(anyInt());
        verify(robot, Mockito.times(3)).process(plat, Direction.L);
	    verify(robot, Mockito.times(1)).showSituation();
	}

	@Test
    public void initDirectionsTest(){
	    //Given
	    given(in.nextLine()).willReturn("mmr");
	    controller.setDirections(mockOrders);

	    //When
	    controller.initDirections();
	    controller.start();

	    //Then
	    verify(mockOrders, Mockito.times(3)).add(any(Direction.class));
        
    }

	@Test
    public void initPlatTest(){
        //Given
	    int value = 5;
        given(in.nextInt()).willReturn(value);
        given(in.nextLine()).willReturn("");

        //When
        controller.initPlat();

        //Then
        verify(plat, Mockito.times(1)).setX(value);
        verify(plat, Mockito.times(1)).setY(anyInt());
    }

	@Test
	public void initRobotTest(){
	    //Given
        int value = 5;
        given(in.nextInt()).willReturn(value);
        given(in.nextLine()).willReturn("N");

        //When
        controller.initRobot();

        //Then
        verify(robot, Mockito.times(1)).setPosX(value);
        verify(robot, Mockito.times(1)).setPosY(value);
        verify(robot, Mockito.times(1)).setCardinalPoint(CardinalPoint.N);
	}

	@Test
    public void isContinue() {
        given(in.nextLine()).willReturn("y");
        boolean respContinue =controller.isContinue();
        assertTrue(respContinue);
    }

}
