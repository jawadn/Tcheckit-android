package com.tcheckit.utils;

import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;

import org.ksoap2.HeaderProperty;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.xmlpull.v1.XmlPullParserException;

public class HttpTransportSE extends org.ksoap2.transport.HttpTransportSE{

	public HttpTransportSE(String url) {
		super(url);
	}
	public HttpTransportSE(Proxy proxy, String url) {
		super(proxy, url);
		
		
	}
	
	public List call(String url, SoapSerializationEnvelope envelope) throws HttpResponseException, IOException, XmlPullParserException{
		ArrayList<HeaderProperty> headerPropertyArrayList = new ArrayList<HeaderProperty>();
		headerPropertyArrayList.add(new HeaderProperty("Connection", "close"));
		return call(url, envelope, headerPropertyArrayList);
	}

}
