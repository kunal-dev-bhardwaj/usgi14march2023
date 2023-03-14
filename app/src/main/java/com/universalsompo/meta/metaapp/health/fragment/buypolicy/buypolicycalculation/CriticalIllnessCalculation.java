package com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation;

import android.content.Context;
import android.widget.Toast;

public class CriticalIllnessCalculation {
    static String strcriticalEdit;
    static String strOneChildCriticalIllnessTxt;

    public static String CriticalIllnessCalculate(String str_age,String str_SumInsured ,String strCriticalIllness, Context context) {
        boolean b = strCriticalIllness.equals("100000") || strCriticalIllness.equals("200000") || strCriticalIllness.equals("600000") || strCriticalIllness.equals("700000") || strCriticalIllness.equals("800000") || strCriticalIllness.equals("900000") || strCriticalIllness.equals("1000000");
        boolean b1 = strCriticalIllness.equals("500000") || strCriticalIllness.equals("400000") || strCriticalIllness.equals("300000") || strCriticalIllness.equals("200000") || strCriticalIllness.equals("100000");

        if (str_age.equals("18yrs-35yrs")){
            if (str_SumInsured.equals("500000")){
                if (b){
                    Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 300000 or 400000 or 500000 only  for Self ", Toast.LENGTH_SHORT).show();
                }else {
                    if (strCriticalIllness.equals("300000")){
                        strcriticalEdit="900";
                    }else if (strCriticalIllness.equals("400000")){
                        strcriticalEdit="1200";


                    }else if (strCriticalIllness.equals("500000")){
                        strcriticalEdit="1500";

                    }
                }
            }
            else {
                if (str_SumInsured.equals("600000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="1800";
    
                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="2100";
    
                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="2400";
    
                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="2700";
    
                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="3000";
    
                        }
                    }
    
                }
                else if (str_SumInsured.equals("700000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="1800";
    
                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="2100";
    
                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="2400";
    
                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="2700";
    
                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="3000";
    
                        }
                    }
                }
                else if (str_SumInsured.equals("800000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="1800";
    
                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="2100";
    
                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="2400";
    
                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="2700";
    
                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="3000";
    
                        }
                    }
                }
                else if (str_SumInsured.equals("900000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="1800";
    
                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="2100";
    
                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="2400";
    
                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="2700";
    
                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="3000";
    
                        }
                    }
                }
                else if (str_SumInsured.equals("1000000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="1800";
    
    
                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="2100";
    
    
                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="2400";
    
    
                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="2700";
    
                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="3000";

                        }
                    }
                }
            }
        }
        else if (str_age.equals("36yrs-45yrs")){
            if (str_SumInsured.equals("500000")){
                if (b){
                    Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 300000 or 400000 or 500000 only  for Self ", Toast.LENGTH_SHORT).show();
                }else {
                    if (strCriticalIllness.equals("300000")){
                        strcriticalEdit="1650";
                    }else if (strCriticalIllness.equals("400000")){
                        strcriticalEdit="2200";


                    }else if (strCriticalIllness.equals("500000")){
                        strcriticalEdit="2750";

                    }
                }
            }  else {
                if (str_SumInsured.equals("600000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="3300";

                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="3850";

                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="4400";

                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="4950";

                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="5500";

                        }
                    }

                }
                else if (str_SumInsured.equals("700000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="3300";

                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="3850";

                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="4400";

                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="4950";

                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="5500";

                        }
                    }
                }
                else if (str_SumInsured.equals("800000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="3300";

                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="3850";

                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="4400";

                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="4950";

                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="5500";

                        }
                    }
                }
                else if (str_SumInsured.equals("900000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="3300";

                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="3850";

                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="4400";

                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="4950";

                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="5500";

                        }
                    }
                }
                else if (str_SumInsured.equals("1000000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="3300";

                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="3850";

                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="4400";

                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="4950";

                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="5500";

                        }
                    }
                }
            }
        }
        else if (str_age.equals("46yrs-50yrs")){
            if (str_SumInsured.equals("500000")){
                if (b){
                    Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 300000 or 400000 or 500000 only  for Self ", Toast.LENGTH_SHORT).show();
                }else {
                    if (strCriticalIllness.equals("300000")){
                        strcriticalEdit="3600";
                    }else if (strCriticalIllness.equals("400000")){
                        strcriticalEdit="4800";
                    }else if (strCriticalIllness.equals("500000")){
                        strcriticalEdit="6000";

                    }
                }
            }  else {
                if (str_SumInsured.equals("600000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="7200";

                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="8400";

                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="9600";

                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="10800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="12000";

                        }
                    }

                }
                else if (str_SumInsured.equals("700000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="7200";

                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="8400";

                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="9600";

                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="10800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="12000";

                        }
                    }
                }
                else if (str_SumInsured.equals("800000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="7200";

                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="8400";

                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="9600";

                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="10800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="12000";

                        }
                    }
                }
                else if (str_SumInsured.equals("900000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="7200";

                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="8400";

                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="9600";

                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="10800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="12000";

                        }
                    }
                }
                else if (str_SumInsured.equals("1000000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="7200";

                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="8400";

                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="9600";

                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="10800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="12000";

                        }
                    }
                }
            }
        }
        else if (str_age.equals("51yrs-55yrs")){
            if (str_SumInsured.equals("500000")){
                if (b){
                    Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 300000 or 400000 or 500000 only  for Self ", Toast.LENGTH_SHORT).show();
                }else {
                    if (strCriticalIllness.equals("300000")){
                        strcriticalEdit="3750";
                    }else if (strCriticalIllness.equals("400000")){
                        strcriticalEdit="5000";
                    }else if (strCriticalIllness.equals("500000")){
                        strcriticalEdit="6250";

                    }
                }
            }  else {
                if (str_SumInsured.equals("600000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="7500";

                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="8750";

                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="10000";

                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="11250";

                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="12500";

                        }
                    }

                }
                else if (str_SumInsured.equals("700000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="7500";

                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="8750";

                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="10000";

                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="11250";

                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="12500";

                        }
                    }
                }
                else if (str_SumInsured.equals("800000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="7500";

                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="8750";

                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="10000";

                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="11250";

                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="12500";

                        }
                    }
                }
                else if (str_SumInsured.equals("900000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="7500";

                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="8750";

                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="10000";

                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="11250";

                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="12500";

                        }
                    }
                }
                else if (str_SumInsured.equals("1000000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (strCriticalIllness.equals("600000")){
                            strcriticalEdit="7500";

                        }else if (strCriticalIllness.equals("700000")){
                            strcriticalEdit="8750";

                        }else if (strCriticalIllness.equals("800000")){
                            strcriticalEdit="10000";

                        }else if (strCriticalIllness.equals("900000")){
                            strcriticalEdit="11250";

                        }else if (strCriticalIllness.equals("1000000")){
                            strcriticalEdit="12500";

                        }
                    }
                }
            }
        }
        return strcriticalEdit;
    }


    public static String ChildCriticalIllnessCalculate(String str_age,String str_SumInsured ,String strCriticalIllness, Context context) {
        boolean b = strCriticalIllness.equals("100000") || strCriticalIllness.equals("200000") || strCriticalIllness.equals("600000") || strCriticalIllness.equals("700000") || strCriticalIllness.equals("800000") || strCriticalIllness.equals("900000") || strCriticalIllness.equals("1000000");
        boolean b1 = strCriticalIllness.equals("500000") || strCriticalIllness.equals("400000") || strCriticalIllness.equals("300000") || strCriticalIllness.equals("200000") || strCriticalIllness.equals("100000");

        if (str_age.equals("18yrs-35yrs")){
            if (str_SumInsured.equals("500000")){
                if (b){
                    Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 300000 or 400000 or 500000 only  for Self ", Toast.LENGTH_SHORT).show();
                }else {
                    if (strCriticalIllness.equals("300000")){
                        strOneChildCriticalIllnessTxt="600";
                    }else if (strCriticalIllness.equals("400000")){
                        strOneChildCriticalIllnessTxt="800";
                    }else if (strCriticalIllness.equals("500000")){
                        strOneChildCriticalIllnessTxt="1000";

                    }
                }
            }
            else {
                if (str_SumInsured.equals("600000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }

                }
                else if (str_SumInsured.equals("700000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }
                }
                else if (str_SumInsured.equals("800000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }
                }
                else if (str_SumInsured.equals("900000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }
                }
                else if (str_SumInsured.equals("1000000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }
                }
            }
        }
        else if (str_age.equals("36yrs-45yrs")){
            if (str_SumInsured.equals("500000")){
                if (b){
                    Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 300000 or 400000 or 500000 only  for Self ", Toast.LENGTH_SHORT).show();
                }else {
                    if (strCriticalIllness.equals("300000")){
                        strOneChildCriticalIllnessTxt="600";
                    }else if (strCriticalIllness.equals("400000")){
                        strOneChildCriticalIllnessTxt="800";
                    }else if (strCriticalIllness.equals("500000")){
                        strOneChildCriticalIllnessTxt="1000";
                    }
                }
            }  else {
                if (str_SumInsured.equals("600000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }

                }
                else if (str_SumInsured.equals("700000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }
                }
                else if (str_SumInsured.equals("800000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }
                }
                else if (str_SumInsured.equals("900000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }
                }
                else if (str_SumInsured.equals("1000000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }
                }
            }
        }
        else if (str_age.equals("46yrs-50yrs")){
            if (str_SumInsured.equals("500000")){
                if (b){
                    Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 300000 or 400000 or 500000 only  for Self ", Toast.LENGTH_SHORT).show();
                }else {
                    if (strCriticalIllness.equals("300000")){
                        strOneChildCriticalIllnessTxt="600";
                    }else if (strCriticalIllness.equals("400000")){
                        strOneChildCriticalIllnessTxt="800";
                    }else if (strCriticalIllness.equals("500000")){
                        strOneChildCriticalIllnessTxt="1000";

                    }
                }
            }  else {
                if (str_SumInsured.equals("600000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }

                }
                else if (str_SumInsured.equals("700000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }
                }
                else if (str_SumInsured.equals("800000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }
                }
                else if (str_SumInsured.equals("900000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }
                }
                else if (str_SumInsured.equals("1000000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }
                }
            }
        }
        else if (str_age.equals("51yrs-55yrs")){
            if (str_SumInsured.equals("500000")){
                if (b){
                    Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 300000 or 400000 or 500000 only  for Self ", Toast.LENGTH_SHORT).show();
                }else {
                    if (strCriticalIllness.equals("300000")){
                        strOneChildCriticalIllnessTxt="600";
                    }else if (strCriticalIllness.equals("400000")){
                        strOneChildCriticalIllnessTxt="800";
                    }else if (strCriticalIllness.equals("500000")){
                        strOneChildCriticalIllnessTxt="1000";

                    }
                }
            }  else {
                if (str_SumInsured.equals("600000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }

                }
                else if (str_SumInsured.equals("700000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }
                }
                else if (str_SumInsured.equals("800000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }
                }
                else if (str_SumInsured.equals("900000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }
                }
                else if (str_SumInsured.equals("1000000")){
                    if (b1){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for ESSENTIAL Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (strCriticalIllness.equals("600000")){
                            strOneChildCriticalIllnessTxt="1200";

                        }else if (strCriticalIllness.equals("700000")){
                            strOneChildCriticalIllnessTxt="1400";

                        }else if (strCriticalIllness.equals("800000")){
                            strOneChildCriticalIllnessTxt="1600";

                        }else if (strCriticalIllness.equals("900000")){
                            strOneChildCriticalIllnessTxt="1800";

                        }else if (strCriticalIllness.equals("1000000")){
                            strOneChildCriticalIllnessTxt="2000";

                        }
                    }
                }
            }
        }
        return strOneChildCriticalIllnessTxt;
    }

}
