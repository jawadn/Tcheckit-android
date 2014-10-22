package com.tcheckit.utils;

import java.io.IOException;

import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.fortutech.tcheckit.ejb.sessions.Consumer;
/**
* 
* @author Vladimir
* Used to marshal Doubles - crucial to serialization for SOAP
*/
public class MarshalConsumer implements Marshal 
{


    public Object readInstance(XmlPullParser parser, String namespace, String name, 
            PropertyInfo expected) throws IOException, XmlPullParserException {
        
        return Long.parseLong(parser.nextText());
    }


    public void register(SoapSerializationEnvelope cm) {
         cm.addMapping(cm.xsd, "consumer", Consumer.class, this);
         cm.addMapping(cm.xsd, "Consumer", Consumer.class, this);
    }


    public void writeInstance(XmlSerializer writer, Object obj) throws IOException {
           writer.text(obj.toString());
        }
    
}
