package com.tcheckit.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

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
public class MarshalGregorianCalendar implements Marshal 
{


    public Object readInstance(XmlPullParser parser, String namespace, String name, 
            PropertyInfo expected) throws IOException, XmlPullParserException {
    	Calendar result = GregorianCalendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
    	
    	try {
			result.setTime(sdf.parse(parser.nextText()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result;
    }


    public void register(SoapSerializationEnvelope cm) {
         cm.addMapping(cm.xsd, "gregoriancalendar", GregorianCalendar.class, this);
         cm.addMapping(cm.xsd, "gregorianCalendar", GregorianCalendar.class, this);
         
        
    }


    public void writeInstance(XmlSerializer writer, Object obj) throws IOException {
    	//2014-02-24T18:12:02+01:00
    	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
    	StringBuffer formatted = new StringBuffer(format1.format(((GregorianCalendar)obj).getTime()));
    	formatted  = formatted.insert(formatted.length()-2, ':');
           writer.text(formatted.toString());
        }
    
}
