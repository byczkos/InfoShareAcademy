package com.infoshareacademy.jjdd3.env;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EnvironmentPrinterTest {
    private IEnvironmentReader mockedReader;

    @BeforeEach
    void beforeEach() {
        mockedReader = mock(IEnvironmentReader.class);
    }

    @Test
    void shouldPrintCurrentEnvironment() {
        // Given
        when(mockedReader.read()).thenReturn("TEST");

        EnvironmentPrinter printer = new EnvironmentPrinter(mockedReader);
        // When
        String message = printer.print();
        //Then
        Assertions.assertEquals("Current environment is TEST",message);
    }

    @Test
    void shouldPrintProductionEnvironment() {

        when(mockedReader.read()).thenReturn("PRODUCTION");

        EnvironmentPrinter printer = new EnvironmentPrinter(mockedReader);

        Assertions.assertEquals("Current environment is PRODUCTION",printer.print());
    }


}
