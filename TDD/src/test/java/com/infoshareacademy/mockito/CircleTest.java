package com.infoshareacademy.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CircleTest {

    @Mock
    public Point point;

    @InjectMocks
    public Circle testee;

    @Test
    public void test() {

        //GIVEN
        String expected = "(2,3)";

        //WHEN
        Mockito.when(point.getX()).thenReturn(2);
        Mockito.when(point.getY()).thenReturn(3);

        String result = testee.getCenterAsDescription();

        //THEN
        Mockito.verify(point, Mockito.times(1)).getX();
        assertEquals(expected, result);
    }

}