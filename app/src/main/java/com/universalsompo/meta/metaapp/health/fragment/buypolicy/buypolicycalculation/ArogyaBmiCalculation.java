package com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.universalsompo.meta.metaapp.health.fragment.buypolicy.arogya.Arogya_Member_info;

import org.joda.time.Period;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class ArogyaBmiCalculation {
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
    static double MotherCm = 0.0;
    static double MotherKg = 0.0;
    static double MotherBMI = 0.0;
    static double FatherKg = 0.0;
    static double FatherBMI = 0.0;
    static double FatherCm = 0.0;
    static double MotherLawCm = 0.0;
    static double MotherLawKg = 0.0;
    static double MotherLawBMI = 0.0;
    static double FatherLawKg = 0.0;
    static double FatherLawBMI = 0.0;
    static double FatherLawCm = 0.0;
    static public Period period;
    static Date date;
    static Format formatter;
    static String today;
    static int  daysLeft,daysLeftChild2,daysLeftChild3,daysLeftChild4;
  public static double ArogyaCalculation(String str_edt_name, String str_gender, String str_occupation, String str_edit_dob, String str_ft, String str_inches, String str_weight_edit,String str_edit_dob3String,String strThirdDString,int selectYearAdult,Context context){
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
              if (selectYearAdult < 18 || (selectYearAdult > 55)) {
                  Toast.makeText(context, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
              } else if(!str_ft.equals("Ft") && !str_inches.equals("Inches")) {
                  cm=convertFeetandInchesToCentimeter(str_ft, str_inches);
                  kg= Double.parseDouble(str_weight_edit);
                  BMI=calculateBMI(kg,cm);

              }

//              int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_edit_dob3String);
//              if (dateValidation <= 17 || (dateValidation >= 56)) {
//                  Toast.makeText(context, "Age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
//              }
//
          }
      }

       return BMI;
   }

    public static double ArogyaCalculationAdult(String str_edt_Spouse_name, String str_spouse_gender, String str_spouse_occupation_spinner, String str_spouse_edit_dob_dob, String str_spouse_ft_spinner, String str_spouse_inches_spinner, String str_spouse_weight_edit,String str_edit_dob3StringSpouse,String strThirdDString,int selectYearSecondAdult,Context context){
        if (str_edt_Spouse_name.equals("")){
            Toast.makeText(context, "Enter 2nd Adult Name", Toast.LENGTH_SHORT).show();
        }else if(str_spouse_edit_dob_dob.equals("")){
            Toast.makeText(context, "Enter 2nd Adult Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (str_spouse_gender.equals("Select Gender")){
            Toast.makeText(context, "Select 2nd Adult Gender", Toast.LENGTH_SHORT).show();

        }else if (str_spouse_occupation_spinner.equals("Occupation")){
            Toast.makeText(context, "Select 2nd Adult Occupation", Toast.LENGTH_SHORT).show();

        }else if (str_spouse_ft_spinner.equals("Ft")){
            Toast.makeText(context, "Select 2nd Adult Ft", Toast.LENGTH_SHORT).show();

        }else if (str_spouse_inches_spinner.equals("Inches")){
            Toast.makeText(context, "Select 2nd Adult Inches", Toast.LENGTH_SHORT).show();

        }else if (str_spouse_weight_edit.equals("")){
            Toast.makeText(context, "Enter 2nd Adult Weight in Kg", Toast.LENGTH_SHORT).show();
        }else {
            if (str_edit_dob3StringSpouse != null){
                if (selectYearSecondAdult < 18 || (selectYearSecondAdult > 55)) {
                    Toast.makeText(context, "2nd Adult age must be between 18 to 55 years ", Toast.LENGTH_SHORT).show();
                }else {
                    AdultCm=convertFeetandInchesToCentimeter(str_spouse_ft_spinner, str_spouse_inches_spinner);
                    AdultKg= Double.parseDouble(str_spouse_weight_edit);
                    AdultBMI=calculateBMI(AdultKg,AdultCm);

                }
            }
        }
        return AdultBMI;
    }
    public static double ArogyacalculationOne(String str_OneEditName, String strOneChild, String str_oneGenderSpinner, String str_oneOccupationSpinner, String str_oneFtSpinner, String str_oneInchesSpinner, String str_oneWeightEdit,String strChildOne,String strThirdDString,int selectYearChild,Context context){
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date);
        if (str_OneEditName.equals("")){
            Toast.makeText(context, "Enter 1st Child Name", Toast.LENGTH_SHORT).show();
        }else if(strOneChild.equals("")){
            Toast.makeText(context, "Enter 1st Child Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (str_oneGenderSpinner.equals("Select Gender")){
            Toast.makeText(context, "Select 1st Child  Gender", Toast.LENGTH_SHORT).show();

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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strOneChild,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeft= Integer.parseInt(days);
                Log.e("daysleft", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }

            if (strChildOne != null){
//                if (selectYearChild < 1 || (selectYearChild > 25)) {
//                    Toast.makeText(context, "1st Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
//                }
                if (daysLeft < 91) {
                    Toast.makeText(context, "1st Child Age must be greater than 3 month", Toast.LENGTH_SHORT).show();
                }else {
                    OneChildCm=convertFeetandInchesToCentimeter(str_oneFtSpinner, str_oneInchesSpinner);
                    OneChildBMIKg= Double.parseDouble(str_oneWeightEdit);
                    OneChildBMI=calculateBMI(OneChildBMIKg,OneChildCm);

                }
            }
        }
        return OneChildBMI;
    }
    public static double ArogyacalculationTwo(String str_twoChildEditName,String strtwoDob,String str_twoGenderSpinner,String str_twoOccupationSpinner,String str_twoFtSpinner,String str_twoInchesSpinner,String strtwoWeightEdit,String strChildTwo,String strThirdDString,int selectYearChildTwo,Context context){
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strtwoDob,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild2= Integer.parseInt(days);
                Log.e("daysLeftChild2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }

            if (strChildTwo != null){
//                if (selectYearChildTwo < 1 || (selectYearChildTwo > 25)) {
//                    Toast.makeText(context, "2nd Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
//                }
                if (daysLeftChild2 < 91) {
                    Toast.makeText(context, "2nd Child Age must be greater than 3 month", Toast.LENGTH_SHORT).show();
                } else {
                    TwoChildCm=convertFeetandInchesToCentimeter(str_twoFtSpinner, str_twoInchesSpinner);
                    TwoChildBMIKg= Double.parseDouble(strtwoWeightEdit);
                    TwoChildBMI=calculateBMI(TwoChildBMIKg,TwoChildCm);

                }
            }
        }
        return TwoChildBMI;
    }
    public static double ArogyacalculationThree(String str_thirdNameEdit,String strthreeDob,String str_thirdGenderSpinner,String str_thirdOccupationSpinner,String str_thirdFtSpinner,String str_thirdInchesSpinner,String str_thirdWeightEdit,String strChildThree,String strThirdDString,int selectYearChildThird,Context context){
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strthreeDob,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild3= Integer.parseInt(days);
                Log.e("daysLeftChild2", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strChildThree != null){
//                if (selectYearChildThird < 1 || (selectYearChildThird > 25)) {
//                    Toast.makeText(context, "3rd Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
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

    public static double Arogyacalculationfour(String str_fourNameEdit,String strfourDob,String str_fourGenderSpinner,String str_fourOccupationSpinner,String str_fourFtSpinner,String str_fourInchesSpinner,String strFourWeightEdit,String strChildFour,String strThirdDString,int selectYearChildFour,Context context){
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate start = LocalDate.parse(strfourDob,formatter);
                LocalDate end = LocalDate.parse(today,formatter);
                String days=String.valueOf(ChronoUnit.DAYS.between(start, end));
                daysLeftChild4= Integer.parseInt(days);
                Log.e("daysLeftChild4", String.valueOf(ChronoUnit.DAYS.between(start, end)));
            }
            if (strChildFour != null){
//                if (selectYearChildFour < 1 || (selectYearChildFour > 25)) {
//                    Toast.makeText(context, "4th Child Age must be between 1 to 25 years", Toast.LENGTH_SHORT).show();
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
    public static double ArogyaCalculationMother(String strMotherName, String strMotherDob, String strMotherEdit, String strMotherOccupationEdit, String strMotherFtEdit, String strMotherInchesEdit, String strMotherWeightEdit,String strMotherDobString,String strThirdDString,int selectYearMother,Context context){
        if (strMotherName.equals("")){
            Toast.makeText(context, "Enter Mother Name", Toast.LENGTH_SHORT).show();
        }else if(strMotherDob.equals("")){
            Toast.makeText(context, "Enter Mother Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (strMotherEdit.equals("Select Gender")){
            Toast.makeText(context, "Select Mother Gender", Toast.LENGTH_SHORT).show();

        }else if (strMotherOccupationEdit.equals("Occupation")){
            Toast.makeText(context, "Select Mother Occupation", Toast.LENGTH_SHORT).show();

        }else if (strMotherFtEdit.equals("Ft")){
            Toast.makeText(context, "Select Mother Ft", Toast.LENGTH_SHORT).show();

        }else if (strMotherInchesEdit.equals("Inches")){
            Toast.makeText(context, "Select Mother Inches", Toast.LENGTH_SHORT).show();

        }else if (strMotherWeightEdit.equals("")){
            Toast.makeText(context, "Enter Mother Weight in Kg", Toast.LENGTH_SHORT).show();
        }else {
            if (strMotherDobString != null){
                if (selectYearMother < 36 || (selectYearMother > 55)) {
                    Toast.makeText(context, "Mother age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                }else {
                    MotherCm=convertFeetandInchesToCentimeter(strMotherFtEdit, strMotherInchesEdit);
                    MotherKg= Double.parseDouble(strMotherWeightEdit);
                    MotherBMI=calculateBMI(MotherKg,MotherCm);

                }
            }
        }
        return MotherBMI;
    }
    public static double ArogyaCalculationFather(String strFatherName, String strFatherDob, String strFatherEdit, String strFatherOccupationEdit, String strFatherFtEdit, String strFatherInchesEdit, String strFatherWeightEdit,String strFatherDobString,String strThirdDString,int selectYearFather,Context context){
        if (strFatherName.equals("")){
            Toast.makeText(context, "Enter Father Name", Toast.LENGTH_SHORT).show();
        }else if(strFatherDob.equals("")){
            Toast.makeText(context, "Enter Father Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (strFatherEdit.equals("Select Gender")){
            Toast.makeText(context, "Select Father Gender", Toast.LENGTH_SHORT).show();

        }else if (strFatherOccupationEdit.equals("Occupation")){
            Toast.makeText(context, "Select Father Occupation", Toast.LENGTH_SHORT).show();

        }else if (strFatherFtEdit.equals("Ft")){
            Toast.makeText(context, "Select Father Ft", Toast.LENGTH_SHORT).show();

        }else if (strFatherInchesEdit.equals("Inches")){
            Toast.makeText(context, "Select Father Inches", Toast.LENGTH_SHORT).show();

        }else if (strFatherWeightEdit.equals("")){
            Toast.makeText(context, "Enter Father Weight in Kg", Toast.LENGTH_SHORT).show();
        }else {
            if (strFatherDobString != null){
                if (selectYearFather < 36 || (selectYearFather > 55)) {
                    Toast.makeText(context, "Father age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                }else {
                    FatherCm=convertFeetandInchesToCentimeter(strFatherFtEdit, strFatherInchesEdit);
                    FatherKg= Double.parseDouble(strFatherWeightEdit);
                    FatherBMI=calculateBMI(FatherKg,FatherCm);

                }
            }
        }
        return FatherBMI;
    }

    public static double ArogyaCalculationMotherLaw(String strMotherLawName, String strMotherLawDob, String strMotherLawEdit, String strMotherLawOccupationEdit, String strMotherLawFtEdit, String strMotherLawInchesEdit, String strMotherLawWeightEdit,String strMotherLawDobString,String strThirdDString,int selectYearMotherLaw,Context context){
        if (strMotherLawName.equals("")){
            Toast.makeText(context, "Enter Mother Name", Toast.LENGTH_SHORT).show();
        }else if(strMotherLawDob.equals("")){
            Toast.makeText(context, "Enter Mother Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (strMotherLawEdit.equals("Select Gender")){
            Toast.makeText(context, "Select Mother Gender", Toast.LENGTH_SHORT).show();

        }else if (strMotherLawOccupationEdit.equals("Occupation")){
            Toast.makeText(context, "Select Mother Occupation", Toast.LENGTH_SHORT).show();

        }else if (strMotherLawFtEdit.equals("Ft")){
            Toast.makeText(context, "Select Mother Ft", Toast.LENGTH_SHORT).show();

        }else if (strMotherLawInchesEdit.equals("Inches")){
            Toast.makeText(context, "Select Mother Inches", Toast.LENGTH_SHORT).show();

        }else if (strMotherLawWeightEdit.equals("")){
            Toast.makeText(context, "Enter Mother Weight in Kg", Toast.LENGTH_SHORT).show();
        }else {
            if (strMotherLawDobString != null){
                if (selectYearMotherLaw < 36 || (selectYearMotherLaw > 55)) {
                    Toast.makeText(context, "Mother age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                }else {
                    MotherLawCm=convertFeetandInchesToCentimeter(strMotherLawFtEdit, strMotherLawInchesEdit);
                    MotherLawKg= Double.parseDouble(strMotherLawWeightEdit);
                    MotherLawBMI=calculateBMI(MotherLawKg,MotherLawCm);

                }
            }
        }
        return MotherLawBMI;
    }
    public static double ArogyaCalculationFatherLaw(String strFatherLawName, String strFatherLawDob, String strFatherLawEdit, String strFatherLawOccupationEdit, String strFatherLawFtEdit, String strFatherLawInchesEdit, String strFatherLawWeightEdit,String strFatherLawDobString,String strThirdDString,int selectYearFatherLaw,Context context){
        if (strFatherLawName.equals("")){
            Toast.makeText(context, "Enter Father Name", Toast.LENGTH_SHORT).show();
        }else if(strFatherLawDob.equals("")){
            Toast.makeText(context, "Enter Father Date of Birth", Toast.LENGTH_SHORT).show();
        }else if (strFatherLawEdit.equals("Select Gender")){
            Toast.makeText(context, "Select Father Gender", Toast.LENGTH_SHORT).show();

        }else if (strFatherLawOccupationEdit.equals("Occupation")){
            Toast.makeText(context, "Select Father Occupation", Toast.LENGTH_SHORT).show();

        }else if (strFatherLawFtEdit.equals("Ft")){
            Toast.makeText(context, "Select Father Ft", Toast.LENGTH_SHORT).show();

        }else if (strFatherLawInchesEdit.equals("Inches")){
            Toast.makeText(context, "Select Father Inches", Toast.LENGTH_SHORT).show();

        }else if (strFatherLawWeightEdit.equals("")){
            Toast.makeText(context, "Enter Father Weight in Kg", Toast.LENGTH_SHORT).show();
        }else {
            if (strFatherLawDobString != null){
                if (selectYearFatherLaw < 36 || (selectYearFatherLaw > 55)) {
                    Toast.makeText(context, "Father age must be between 36 to 55 years ", Toast.LENGTH_SHORT).show();
                }else {
                    FatherLawCm=convertFeetandInchesToCentimeter(strFatherLawFtEdit, strFatherLawInchesEdit);
                    FatherLawKg= Double.parseDouble(strFatherLawWeightEdit);
                    FatherLawBMI=calculateBMI(FatherLawKg,FatherLawCm);

                }
            }
        }
        return FatherLawBMI;
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
