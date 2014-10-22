package com.tcheckit.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class SoapUtils {

	public static String getSoapString(SoapObject o, String name) {
		String result = new String();
		try {
			if (o != null && o.getProperty(name) != null && !o.getProperty(name).toString().equals("anyType{}")) {
				result = o.getProperty(name).toString();
			}
		} catch (ClassCastException e) {
			e.printStackTrace();
		}catch (java.lang.RuntimeException e) {
			
		}
		return result;
	}

	public static Long getSoapLong(SoapObject o, String name) {
		Long result = null;
		try {
			if (o != null && o.getProperty(name) != null) {
				result = Long.parseLong(o.getProperty(name).toString());
			}
		} catch (ClassCastException e) {
			e.printStackTrace();
		}catch (java.lang.RuntimeException e) {
			// TODO Auto-generated catch block
			
		}
		return result;
	}
	public static Double getSoapDouble(SoapObject o, String name) {
		Double result = null;
		try {
			if (o != null && o.getProperty(name) != null) {
				result = Double.parseDouble(o.getProperty(name).toString());
			}
		} catch (ClassCastException e) {
			e.printStackTrace();
		}catch (java.lang.RuntimeException e) {
			// TODO Auto-generated catch block
			
		}
		return result;
	}
	public static Float getSoapFloat(SoapObject o, String name) {
		Float result = null;
		try {
			if (o != null && o.getProperty(name) != null) {
				result = Float.parseFloat(o.getProperty(name).toString());
			}
		} catch (ClassCastException e) {
			
		}catch (java.lang.RuntimeException e) {
			// TODO Auto-generated catch block
			
		}
		return result;
	}
	public static Integer getSoapInteger(SoapObject o, String name) {
		Integer result = null;
		try {
			if (o != null && o.getProperty(name) != null) {
				result = Integer.parseInt(o.getProperty(name).toString());
			}
		} catch (ClassCastException e) {
			
		}catch (java.lang.RuntimeException e) {
			// TODO Auto-generated catch block
			
		}
		return result;
	}
	public static Calendar getSoapCalendar(SoapObject o, String name) {
		Calendar result = null;
		try {
			if (o != null && o.getProperty(name) != null) {
				result = Calendar.getInstance();
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); //2013-11-08T10:50:20+01:00
			    result.setTime(sdf.parse(o.getProperty(name).toString()));				
			}
		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			
		} catch (java.lang.RuntimeException e) {
			// TODO Auto-generated catch block
			
		}
		return result;
	}
	public static SoapObject getSoapObject(SoapObject o, String name) {
		SoapObject result = null;
		try {
			if (o != null && o.getProperty(name) != null) {
				result = (SoapObject)o.getProperty(name);
			}
		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (java.lang.RuntimeException e) {
			// TODO Auto-generated catch block
			
		}
		return result;
	}
	
	public static java.util.Vector<SoapObject> getSoapObjects(SoapObject o, String name) {
		java.util.Vector<SoapObject> result = null;
		try {
			if (o != null && o.getProperty(name) != null) {
				if (o.getProperty(name).getClass().equals(SoapObject.class)) {
					result = new java.util.Vector<SoapObject>();
					result.add((SoapObject)o.getProperty(name));
				} else {
				result = (java.util.Vector<SoapObject>)o.getProperty(name); }
			}
		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (java.lang.RuntimeException e) {
			// TODO Auto-generated catch block
			
		}
		return result;
	}
	
	public static Boolean getSoapBoolean(SoapObject o, String name) {
		Boolean result = null;
		try {
			if (o != null && o.getProperty(name) != null) {
				result = ((SoapPrimitive)o.getProperty(name)).getValue() == "true" ? Boolean.TRUE : Boolean.FALSE;
			}
		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (java.lang.RuntimeException e) {
			// TODO Auto-generated catch block
			
		}
		return result;
	}
}
