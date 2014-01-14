package com.argot.start;

import com.argot.auto.ArgotMarshaller;
import com.argot.auto.ArgotTag;

@ArgotMarshaller(ArgotMarshaller.Marshaller.ANNOTATION)
public class SetColour 
{
	public static final String TYPENAME = "light.set_colour";
	
	@ArgotTag("colour")
	public Colour colour;
	
	public SetColour(Colour colour)
	{
		this.colour = colour;
	}
	
	public SetColour()
	{
		// Empty constructor required for annotation marshaller.
	}
}
