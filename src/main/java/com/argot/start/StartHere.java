package com.argot.start;

import com.argot.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class StartHere 
{
	public static void main(String[] args) 
	{
		try 
		{
			StartHere main = new StartHere();
			main.writeColour();
		} 
		catch (TypeException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	private TypeLibrary typeLibrary;
	
	public StartHere()
	throws TypeException
	{
		// Create the type library and compile/bind the switch data types.
		typeLibrary = new TypeLibrary( );
        ResourceDictionaryLoader loader = new ResourceDictionaryLoader("light.dictionary")
		{
			public void bind( TypeLibrary library )
			throws TypeException
			{
				library.bind( library.getTypeId(Colour.TYPENAME, "1.0"), Colour.class );
				library.bind( library.getTypeId(SetColour.TYPENAME, "1.0"), SetColour.class );
			}
		};
		typeLibrary.loadLibrary(loader);
	}
	
	public void writeColour() 
	throws TypeException, IOException
	{
		// Prepare the stream.
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		TypeMap typeMap = new TypeMap( typeLibrary, new TypeMapperDynamic(new TypeMapperCore(new TypeMapperError())));
		TypeOutputStream typeOut = new TypeOutputStream( out, typeMap );
				
		// Write the object.
		System.out.println("\nCreating Colour object with red:120, green:10, blue:30");
		Colour colour = new Colour((short)120,(short)10,(short)30);
		SetColour setColour = new SetColour(colour);
		typeOut.writeObject( SetColour.TYPENAME, setColour );
		
		out.close();
		
		System.out.println("\nBytes written to output stream");
		byte[] data = out.toByteArray();
		for (int x=0;x<data.length;x++)
		{
			System.out.println("data["+x+"] = " + data[x]);
		}
		
		// Read the object from the stream.
		ByteArrayInputStream in = new ByteArrayInputStream(data);
		TypeInputStream typeIn = new TypeInputStream( in, typeMap );
		SetColour readSetColour = (SetColour) typeIn.readObject( SetColour.TYPENAME );
		
		System.out.println("\nValues read into SetColour object");
		System.out.println("Read red:" + readSetColour.colour.red );
		System.out.println("Read green:" + readSetColour.colour.green );
		System.out.println("Read blue:" + readSetColour.colour.blue );
	}
	
	
	
}
