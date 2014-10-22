package com.tcheckit.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
/**
* 
* @author Vladimir
* Used to marshal Doubles - crucial to serialization for SOAP
*/
public class MarshalCalendar implements Marshal 
{


    public Object readInstance(XmlPullParser parser, String namespace, String name, 
            PropertyInfo expected) throws IOException, XmlPullParserException {
    	Calendar result = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    	
    	try {
			result.setTime(sdf.parse(parser.nextText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result;
    }


    public void register(SoapSerializationEnvelope cm) {
         cm.addMapping(cm.xsd, "calendar", Calendar.class, this);
         
        
    }


    public void writeInstance(XmlSerializer writer, Object obj) throws IOException {
    	//2014-02-24T18:12:02+01:00
    	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    	String formatted = format1.format(((Calendar)obj).getTime());
           writer.text(formatted);
        }
    
}
