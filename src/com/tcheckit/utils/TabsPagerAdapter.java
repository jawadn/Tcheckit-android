package com.tcheckit.utils;


import com.tcheckit.MissionAutreActivity;
import com.tcheckit.MissionDescriptionActivity;
import com.tcheckit.MissionQuestionnaireActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
 
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            // Top Rated fragment activity
            return new MissionAutreActivity();
        case 1:
            // Games fragment activity
            return new MissionDescriptionActivity();
        case 2:
            // Movies fragment activity
            return new MissionQuestionnaireActivity();
        }
 
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
