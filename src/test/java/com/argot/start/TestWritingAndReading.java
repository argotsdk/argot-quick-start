package com.argot.start;

import com.argot.TypeException;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestWritingAndReading {

    @Test
    public void readDataIsEqualToWhatWasWritten() throws TypeException, IOException {
        Colour input = new Colour((short) 120, (short) 10, (short) 30);
        StartHere subject = new StartHere();
        byte[] data = subject.writeColour(input);
        System.out.println(Arrays.toString(data));
        Colour output = subject.readColour(data);
        assertEquals(input.red, output.red);
        assertEquals(input.green, output.green);
        assertEquals(input.blue, output.blue);
    }

    @Test
    public void writingAColorGivesThreeByteArray() throws TypeException, IOException {
        Colour input = new Colour((short) 120, (short) 10, (short) 30);
        StartHere subject = new StartHere();
        byte[] data = subject.writeColour(input);

        assertEquals(input.red, data[0]);
        assertEquals(input.green, data[1]);
        assertEquals(input.blue, data[2]);
    }

    @Test
    public void readingAThreeByteArrayGivesColour() throws TypeException, IOException {
        StartHere subject = new StartHere();
        byte[] data = new byte[]{120, 10, 30};
        System.out.println(Arrays.toString(data));
        Colour output = subject.readColour(data);
        assertEquals(120, output.red);
        assertEquals(10, output.green);
        assertEquals(30, output.blue);
    }
}
