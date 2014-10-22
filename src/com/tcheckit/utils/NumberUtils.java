package com.tcheckit.utils;

public  class NumberUtils {
	public static String fmt(double d)
	{
	    if(d == (int) d)
	        return String.format("%d",(int)d);
	    else
	        return String.format("%s",d);
	}
}
