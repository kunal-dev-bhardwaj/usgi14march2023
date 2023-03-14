package com.universalsompo.meta.metaapp.utilities;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

public class FragmentsTransactionsUtils {

    public static void addFragment(Context context, Fragment fragment, int layout, String Tag) {
        FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        boolean fragmentPopped = fm.popBackStackImmediate(Tag, 0);
        if (!fragmentPopped) {
            ft.addToBackStack(Tag);
            ft.add(layout, fragment, Tag).commit();
        }
    }

    public static void replaceFragmentKeepPrevious(Context context, Fragment fragment, int layout, String Tag) {
        FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        boolean fragmentPopped = fm.popBackStackImmediate(Tag, 0);
        if (!fragmentPopped) {
            ft.replace(layout, fragment, Tag);
            ft.addToBackStack(Tag);
            ft.commit();
        }

    }
    public static void replaceFragmentKeepPrevious1(Context context, Fragment fragment, int layout) {
        FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(layout, fragment);
        ft.commit();

    }
    public static void replaceFragmentRemovePrevious(Context context, Fragment fragment, int layout, String Tag) {
        FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        fm.popBackStack();
        ft.replace(layout, fragment, Tag);
        ft.addToBackStack(Tag);
        ft.commit();
    }

    public static void popFragment(Context context) {
        FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();
        fm.popBackStack();
    }


    public static void addFragmentAgain(Context context, Fragment fragment, int layout, String Tag) {
        FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();
        int count = fm.getBackStackEntryCount();
        for (int i = 0; i < count; ++i) {
            fm.popBackStackImmediate();
        }
        addFragment(context, fragment, layout, Tag);
    }


    public static void notInStack(Context context, Fragment fragment, int layout, String Tag) {
        FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        boolean fragmentPopped = fm.popBackStackImmediate(Tag, 0);
        if (!fragmentPopped) {
            ft.replace(layout, fragment, Tag);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    public static void addNotificationsFragment2(Context context, Fragment fragment, int layout, String Tag, String Tag2, String Tag3, String Tag4, String Tag5) {
        boolean status = false;
        String InTag=null;
        FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        for (int entry = 0; entry < fm.getBackStackEntryCount(); entry++) {
             LogUtils.showLog("@@@@@@@@@@", fm.getBackStackEntryAt(entry).getName());
            if (Tag2.equals(fm.getBackStackEntryAt(entry).getName())) {
                status = true;
                InTag = Tag2;
                break;
            } else if (Tag3.equals(fm.getBackStackEntryAt(entry).getName())) {
                status = true;
                InTag = Tag3;
                break;
            } else if (Tag4.equals(fm.getBackStackEntryAt(entry).getName())) {
                status = true;
                InTag = Tag4;
                break;
            } else if (Tag5.equals(fm.getBackStackEntryAt(entry).getName())) {
                status = true;
                InTag = Tag5;
                break;
            }
        }
        if (status) {
            fm.popBackStack(InTag, 1);
        }
        boolean fragmentPopped = fm.popBackStackImmediate(Tag, 0);
        if (!fragmentPopped) {
            ft.replace(layout, fragment, Tag);
            ft.addToBackStack(Tag);
            ft.commit();
        }
    }

}

