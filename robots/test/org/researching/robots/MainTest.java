package org.researching.robots;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.fail;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class MainTest {

    @Mock
    private Controller controller;

    @Mock
    private ReadSystem in;

    @Before
    public void update(){
        given(in.nextLine()).willReturn("anyline");
        given(in.nextInt()).willReturn(1);
        try {
            given(in.nextUnsignedInt()).willReturn(1);
        } catch (IOException e) {
            fail("it should not throw a exception");
        }
        controller.setIn(in);
        Main.setController(controller);
    }

    @Test
    public void platDoNotinitializedTest(){
        given(controller.initPlat()).willReturn(false);

        Main.main(null);
        
        verify(controller,times(1)).initPlat();
        verify(controller,times(0)).initRobot();
        verify(controller,times(0)).initDirections();
        verify(controller,times(0)).start();
    }

    @Test
    public void robotDoNotinitializedTest(){
        given(controller.initPlat()).willReturn(true);
        given(controller.initRobot()).willReturn(false);
        Main.main(null);
        
        
        verify(controller,times(1)).initPlat();
        verify(controller,times(1)).initRobot();
        verify(controller,times(0)).initDirections();
        verify(controller,times(0)).start();
    }
    
    @Test
    public void directionsDoNotinitializedTest(){
        given(controller.initPlat()).willReturn(true);
        given(controller.initRobot()).willReturn(true);
        given(controller.initDirections()).willReturn(false);
        Main.main(null);
        
        verify(controller,times(1)).initPlat();
        verify(controller,times(1)).initRobot();
        verify(controller,times(1)).initDirections();
        verify(controller,times(0)).start();
    }
    
    @Test
    public void allinitializedTest(){
        given(controller.initPlat()).willReturn(true);
        given(controller.initRobot()).willReturn(true);
        given(controller.initDirections()).willReturn(true);
        Main.main(null);
        
        verify(controller,times(1)).initPlat();
        verify(controller,times(1)).initRobot();
        verify(controller,times(1)).initDirections();
        verify(controller,times(1)).start();
    }
}
