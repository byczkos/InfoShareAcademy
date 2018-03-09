package com.infoshareacademy.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CarTest {

    @Mock
    public Type type;

    @InjectMocks
    public Car car;

    @Test

    public void carTest() {

    //GIVEN
    String expectedName = "Volkswagen Golf";

    //WHEN
        Mockito.when(type.getName()).thenReturn("Volkswagen");
        Mockito.when(type.getModel()).thenReturn("Golf");

        String resultName = car.generateName();
    //THEN
        assertEquals(expectedName, resultName);
    }

}