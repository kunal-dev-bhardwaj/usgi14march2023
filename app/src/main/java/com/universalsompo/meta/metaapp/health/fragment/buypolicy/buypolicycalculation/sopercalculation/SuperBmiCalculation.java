package com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation.sopercalculation;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.universalsompo.meta.metaapp.health.fragment.buypolicy.super_healthcare.Super_Member_Self;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class SuperBmiCalculation {
    static double BMI=0.0;
    static double AdultBMI=0.0;
    static double OneChildBMI=0.0;
    static double TwoChildBMI=0.0;
    static double ThreeChildBMI=0.0;
    static double FourChildBMI=0.0;
    static double kg = 0.0;
    static double AdultKg = 0.0;
    static double OneChildBMIKg = 0.0;
    static double TwoChildBMIKg = 0.0;
    static double ThreeChildBMIKg = 0.0;
    static double FourChildBMIKg = 0.0;
    static double cm=0.0;
    static double AdultCm=0.0;
    static double OneChildCm=0.0;
    static double TwoChildCm=0.0;
    static double ThreeChildCm=0.0;
    static double FourChildCm = 0.0;
    static Date date;
    static Format formatter;
    static String today;
    static int  daysLeft,daysLeftChild2,daysLeftChild3,daysLeftChild4;

    public static double SuperCalculation(String str_edt_name, String str_gender, String str_occupation, String str_edit_dob, String str_ft, String str_inches, String str_weight_edit, String str_edit_dob3String, String strThirdDString,int selectYearAdult, Context context){
        if (str_edt_name.equals("")){
            Toast.makeText(context, "Enter Your Name", Toast.LENGTH_SHORT).show();
        }else if(str_edit_dob.equals("")){
            Toast.makeText(context, "Enter Date of Birth", Toast.LENGTH_SHORT).show();
        } else if (str_gender.equals("Select Gender")){
            Toast.makeText(context, "Select Gender", Toast.LENGTH_SHORT).show();
        }else if (str_occupation.equals("Occupation")){
            Toast.makeText(context, "Select Occupation", Toast.LENGTH_SHORT).show();
        } else if(str_ft.equals("Ft") && str_inches.equals("Inches")){
            Toast.makeText(context, "Enter Ft & Inches", Toast.LENGTH_SHORT).show();
        }else if (str_weight_edit.equals("")){
            Toast.makeText(context, "Enter Weight in Kg", Toast.LENGTH_SHORT).show();
        } else {
            if (str_edit_dob3String != null){
                int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3String);
                if (selectYearAdult < 18 || (selectYearAdult > 65)) {
                    Toast.makeText(context, "Age must be between 18 to 65 years ", Toast.LENGTH_SHORT).show();
                }else if(!str_ft.equals("Ft") && !str_inches.equals("Inches")) {
                    cm=convertFeetandInchesToCentimeter(str_ft, str_inches);
                    kg= Double.parseDouble(str_weight_edit);
                    BMI=calculateBMI(kg,cm);

                }
            }
        }

        return BMI;
    }
    public static double SuperCalculationAdult(String str_edt_Spouse_name, String str_spouse_gender, String str_spouse_occupation_spinner, String str_spouse_edit_dob_dob, String str_spouse_ft_spinner, String str_spouse_inches_spinner, String str_spouse_weight_edit,String str_edit_dob3StringSpouse,String strThirdDString,int selectYearSecondAdult,Context context){
        if (str_edt_Spouse_name.equals("")){
            Toast.makeText(context, "Enter Spouse Name", Toast.LENGTH_SHORT).show();
        }else if(str_spouse_edit_dob_dob.equals("")){
            Toast.makeText(context, "Enter Spouse Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (str_spouse_gender.equals("Select Gender")){
            Toast.makeText(context, "Select Spouse Gender", Toast.LENGTH_SHORT).show();

        }else if (str_spouse_occupation_spinner.equals("Occupation")){
            Toast.makeText(context, "Select Spouse Occupation", Toast.LENGTH_SHORT).show();

        }else if (str_spouse_ft_spinner.equals("Ft")){
            Toast.makeText(context, "Select Spouse Ft", Toast.LENGTH_SHORT).show();

        }else if (str_spouse_inches_spinner.equals("Inches")){
            Toast.makeText(context, "Select Spouse Inches", Toast.LENGTH_SHORT).show();

        }else if (str_spouse_weight_edit.equals("")){
            Toast.makeText(context, "Enter Spouse Weight in Kg", Toast.LENGTH_SHORT).show();
        }else {
            if (str_edit_dob3StringSpouse != null){
                int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3StringSpouse);
                if (selectYearSecondAdult < 18 || (selectYearSecondAdult > 65)){
                    Toast.makeText(context, "2 Adult Age must be between 18 to 65 years ", Toast.LENGTH_SHORT).show();
                }else {
                    AdultCm=convertFeetandInchesToCentimeter(str_spouse_ft_spinner, str_spouse_inches_spinner);
                    AdultKg= Double.parseDouble(str_spouse_weight_edit);
                    AdultBMI=calculateBMI(AdultKg,AdultCm);

                }
            }
        }
        return AdultBMI;
    }
    public static double SuperCalculationOne(String str_OneEditName, String strOneChild, String str_oneGenderSpinner, String str_oneOccupationSpinner, String str_oneFtSpinner, String str_oneInchesSpinner, String str_oneWeightEdit,String strChildOne,String strThirdDString,int selectYearChild,Context context){
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        today = formatter.format(date);

        if (str_OneEditName.equals("")){
            Toast.makeText(context, "Enter 1st Child Name", Toast.LENGTH_SHORT).show();
        }else if(strOneChild.equals("")){
            Toast.makeText(context, "Enter 1st Child Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (str_oneGenderSpinner.equals("Select Gender")){
            Toast.makeText(context, "Select 1st Child Gender", Toast.LENGTH_SHORT).show();

        }else if (str_oneOccupationSpinner.equals("Occupation")){
            Toast.makeText(context, "Select 1st Child Occupation", Toast.LENGTH_SHORT).show();

        }else if (str_oneFtSpinner.equals("Ft")){
            Toast.makeText(context, "Select 1st Child Ft", Toast.LENGTH_SHORT).show();

        }else if (str_oneInchesSpinner.equals("Inches")){
            Toast.makeText(context, "Select 1st Child Inches", Toast.LENGTH_SHORT).show();

        }else if (str_oneWeightEdit.equals("")){
            Toast.makeText(context, "Enter 1st Child Weight in Kg", Toast.LENGTH_SHORT).show();
        }else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate start = LocalDate.parse(strOneChild,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeft= Integer.parseInt(days);
                Log.e("daysleft", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
 //                int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildOne);
//                if (selectYearChild < 1 || (selectYearChild >30) ) {
//                    Toast.makeText(context, "1st Child Age must be between 1 to 30 years", Toast.LENGTH_SHORT).show();
//                }
            if (strChildOne != null){
                if (daysLeft < 91) {
                    Toast.makeText(context, "1st Child Age must be greater than 3 month", Toast.LENGTH_SHORT).show();
                } else {
                    OneChildCm=convertFeetandInchesToCentimeter(str_oneFtSpinner, str_oneInchesSpinner);
                    OneChildBMIKg= Double.parseDouble(str_oneWeightEdit);
                    OneChildBMI=calculateBMI(OneChildBMIKg,OneChildCm);

                }
            }
        }
        return OneChildBMI;
    }
    public static double SuperCalculationTwo(String str_twoChildEditName,String strtwoDob,String str_twoGenderSpinner,String str_twoOccupationSpinner,String str_twoFtSpinner,String str_twoInchesSpinner,String strtwoWeightEdit,String strChildTwo,String strThirdDString,int selectYearChildTwo,Context context){
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        today = formatter.format(date);

        if (str_twoChildEditName.equals("")){
            Toast.makeText(context, "Enter 2nd Child Name", Toast.LENGTH_SHORT).show();
        }else if(strtwoDob.equals("")){
            Toast.makeText(context, "Enter 2nd Child Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (str_twoGenderSpinner.equals("Select Gender")){
            Toast.makeText(context, "Select 2nd Child Gender", Toast.LENGTH_SHORT).show();

        }else if (str_twoOccupationSpinner.equals("Occupation")){
            Toast.makeText(context, "Select 2nd Child Occupation", Toast.LENGTH_SHORT).show();

        }else if (str_twoFtSpinner.equals("Ft")){
            Toast.makeText(context, "Select 2nd Child Ft", Toast.LENGTH_SHORT).show();

        }else if (str_twoInchesSpinner.equals("Inches")){
            Toast.makeText(context, "Select 2nd Child Inches", Toast.LENGTH_SHORT).show();

        }else if (strtwoWeightEdit.equals("")){
            Toast.makeText(context, "Enter 2nd Child Weight in Kg", Toast.LENGTH_SHORT).show();
        }else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate start = LocalDate.parse(strtwoDob,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild2= Integer.parseInt(days);
                Log.e("daysLeftChild2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strChildTwo != null){
                int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildTwo);
                if (daysLeftChild2 < 91) {
                    Toast.makeText(context, "2nd Child Age must be greater than 3 month", Toast.LENGTH_SHORT).show();
                }else {
                    TwoChildCm=convertFeetandInchesToCentimeter(str_twoFtSpinner, str_twoInchesSpinner);
                    TwoChildBMIKg= Double.parseDouble(strtwoWeightEdit);
                    TwoChildBMI=calculateBMI(TwoChildBMIKg,TwoChildCm);

                }
//                if (selectYearChildTwo < 1 || (selectYearChildTwo >30) ) {
//                    Toast.makeText(context, "2nd Child Age must be between 1 to 30 years", Toast.LENGTH_SHORT).show();
//                }

            }
        }
        return TwoChildBMI;
    }
    public static double SuperCalculationThree(String str_thirdNameEdit,String strthreeDob,String str_thirdGenderSpinner,String str_thirdOccupationSpinner,String str_thirdFtSpinner,String str_thirdInchesSpinner,String str_thirdWeightEdit,String strChildThree,String strThirdDString,int selectYearChildThird,Context context){
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        today = formatter.format(date);

        if (str_thirdNameEdit.equals("")){
            Toast.makeText(context, "Enter 3rd Child Name", Toast.LENGTH_SHORT).show();
        }else if(strthreeDob.equals("")){
            Toast.makeText(context, "Enter 3rd Child Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (str_thirdGenderSpinner.equals("Select Gender")){
            Toast.makeText(context, "Select 3rd Child Gender", Toast.LENGTH_SHORT).show();

        }else if (str_thirdOccupationSpinner.equals("Occupation")){
            Toast.makeText(context, "Select 3rd Child Occupation", Toast.LENGTH_SHORT).show();

        }else if (str_thirdFtSpinner.equals("Ft")){
            Toast.makeText(context, "Select 3rd Child Ft", Toast.LENGTH_SHORT).show();

        }else if (str_thirdInchesSpinner.equals("Inches")){
            Toast.makeText(context, "Select 3rd Child Inches", Toast.LENGTH_SHORT).show();

        }else if (str_thirdWeightEdit.equals("")){
            Toast.makeText(context, "Enter 3rd Child Weight in Kg", Toast.LENGTH_SHORT).show();
        }else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate start = LocalDate.parse(strthreeDob,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild3= Integer.parseInt(days);
                Log.e("daysLeftChild3", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strChildThree != null){
                int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildThree);
//                if (selectYearChildThird < 1 || (selectYearChildThird >30) )  {
//                    Toast.makeText(context, "3rd Child Age must be between 1 to 30 years", Toast.LENGTH_SHORT).show();
//                }
                if (daysLeftChild3 < 91) {
                    Toast.makeText(context, "3rd Child Age must be greater than 3 month", Toast.LENGTH_SHORT).show();
                }else {
                    ThreeChildCm=convertFeetandInchesToCentimeter(str_thirdFtSpinner, str_thirdInchesSpinner);
                    ThreeChildBMIKg= Double.parseDouble(str_thirdWeightEdit);
                    ThreeChildBMI=calculateBMI(ThreeChildBMIKg,ThreeChildCm);

                }
            }
        }
        return ThreeChildBMI;
    }
    public static double SuperCalculationFour(String str_fourNameEdit,String strfourDob,String str_fourGenderSpinner,String str_fourOccupationSpinner,String str_fourFtSpinner,String str_fourInchesSpinner,String strFourWeightEdit,String strChildFour,String strThirdDString,int selectYearChildFour,Context context){
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        today = formatter.format(date);

        if (str_fourNameEdit.equals("")){
            Toast.makeText(context, "Enter 4th Child Name", Toast.LENGTH_SHORT).show();
        }else if(strfourDob.equals("")){
            Toast.makeText(context, "Enter 4th Child Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (str_fourGenderSpinner.equals("Select Gender")){
            Toast.makeText(context, "Select 4th Child Gender", Toast.LENGTH_SHORT).show();

        }else if (str_fourOccupationSpinner.equals("Occupation")){
            Toast.makeText(context, "Select 4th Child Occupation", Toast.LENGTH_SHORT).show();

        }else if (str_fourFtSpinner.equals("Ft")){
            Toast.makeText(context, "Select 4th Child Ft", Toast.LENGTH_SHORT).show();

        }else if (str_fourInchesSpinner.equals("Inches")){
            Toast.makeText(context, "Select 4th Child Inches", Toast.LENGTH_SHORT).show();

        }else if (strFourWeightEdit.equals("")){
            Toast.makeText(context, "Enter 4th Child Weight in Kg", Toast.LENGTH_SHORT).show();
        }else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate start = LocalDate.parse(strfourDob,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild4= Integer.parseInt(days);
                Log.e("daysLeftChild4", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }

            if (strChildFour != null){
                int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(strChildFour);
//                if (selectYearChildFour < 1 || (selectYearChildFour >30) )  {
//                    Toast.makeText(context, "4th Child Age must be between 1 to 30 years", Toast.LENGTH_SHORT).show();
//                }
                if (daysLeftChild4 < 91) {
                    Toast.makeText(context, "4th Child Age must be greater than 3 month", Toast.LENGTH_SHORT).show();

                }else {
                    FourChildCm=convertFeetandInchesToCentimeter(str_fourFtSpinner, str_fourInchesSpinner);
                    FourChildBMIKg= Double.parseDouble(strFourWeightEdit);
                    FourChildBMI=calculateBMI(FourChildBMIKg,FourChildCm);

                }
            }
        }
        return FourChildBMI;
    }


    private static double calculateBMI(double kg, double cm) {
        double heightMeter= cm/ 100;
        BMI = kg/ (heightMeter * heightMeter);
        Log.e("bmi", String.valueOf(BMI));
        return BMI;
    }



    public static double convertFeetandInchesToCentimeter(String feet, String inches) {
        double heightInFeet = 0;
        double heightInInches = 0;
        try {
            if (feet != null && feet.trim().length() != 0) {
                heightInFeet = Double.parseDouble(feet);
            }
            if (inches != null && inches.trim().length() != 0) {
                heightInInches = Double.parseDouble(inches);
            }

        } catch (NumberFormatException nfe) {

        }
        cm=(heightInFeet * 30.48) + (heightInInches * 2.54);
        Log.e("heightInCm", String.valueOf(cm));
        return cm;

    }
}
