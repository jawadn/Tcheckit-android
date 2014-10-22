package com.tcheckit.utils;

import java.util.Comparator;

import com.fortutech.tcheckit.ejb.sessions.Mission;

public class CustomComparator implements Comparator<Mission> {
	@Override
	public int compare(Mission m1, Mission m2) {
		if (m1.getDistance() < m2.getDistance()) {
			return -1;
		} else if (m1.getDistance() == m2.getDistance()) {
			return 0;
		} else {
			return 1;
		}
	}
}
