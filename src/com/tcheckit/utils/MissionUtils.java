package com.tcheckit.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.location.Location;

import com.fortutech.tcheckit.ejb.sessions.Mission;
import com.fortutech.tcheckit.ejb.sessions.Sign;

public class MissionUtils {

	public static Mission[] sort(ArrayList<Mission> param, Location loc) {
		ArrayList<Mission> list = new ArrayList<Mission>();
		if (param != null && param.size() > 0) {
			for (Mission mi : param) {
				for (Sign si : mi.getListSign()) {
					Mission mi2 = new Mission(mi);
					if (mi2.getListSign() != null && mi2.getListSign().length > 0 && mi2.getListSign()[0] != null && mi2.getListSign()[0].getAddress() != null
							&& mi2.getListSign()[0].getAddress().getLatitude() != null && mi2.getListSign()[0].getAddress().getLongitude() != null) {
						Location loc1 = new Location("");
						loc1.setLatitude(si.getAddress().getLatitude());
						loc1.setLongitude(si.getAddress().getLongitude());
						mi2.setDistance((int) loc1.distanceTo(loc));
					}
					
					//Sign si2 = new Sign(si);
					mi2.setListSign(new Sign[] { si });
					list.add(mi2);
				}
			}
		}

		
		Collections.sort(list, new CustomComparator()); 
		Mission[] result = list.toArray(new Mission[] {});
		return result;
	}	
}
