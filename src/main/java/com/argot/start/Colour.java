package com.argot.start;

import com.argot.auto.ArgotMarshaller;
import com.argot.auto.ArgotTag;
import com.argot.auto.TypeAnnotationMarshaller;

@ArgotMarshaller(TypeAnnotationMarshaller.class)
public class Colour 
{
	public static final String TYPENAME = "light.colour";
	
	@ArgotTag("red")
	public short red;
	
	@ArgotTag("green")
	public short green;
	
	@ArgotTag("blue")
	public short blue;
	
	
	public Colour(short red, short green, short blue)
	{
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public Colour()
	{
		// Empty constructor required for annotation marshaller.
	}
}
