package com.argot.start;

import com.argot.*;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestWritingAndReading {

    @Test
    public void readDataIsEqualToWhatWasWritten() throws TypeException, IOException {
        Colour input = new Colour((short)120,(short)10,(short)30);
        StartHere subject = new StartHere();
        byte[] data = subject.writeColour(input);
        Colour output = subject.readColour(data);
        assertEquals(input.red, output.red);
        assertEquals(input.green, output.green);
        assertEquals(input.blue, output.blue);
    }
}
