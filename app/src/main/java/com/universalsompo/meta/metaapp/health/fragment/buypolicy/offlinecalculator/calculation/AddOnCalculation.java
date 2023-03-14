package com.universalsompo.meta.metaapp.health.fragment.buypolicy.offlinecalculator.calculation;

public class AddOnCalculation {
    static String OutpatientDentalCoverPremium;
    static String RestCureCoverPremium;
    static String HomeCareCoverPremium;
    static String WellnessBenefitCoverPremium;
    static String SterilityInfertilityCoverPremium;
    static String ObesityWeightCoverPremium;
    static String SecondOpinionCoverPremium;
    static String EmergencyTravellingCoverPremium;
    static String DailyHospitalCoverPremium;
    static String CriticalIllnessCoverPremium;
    static String MedicallyAdvisedCoverPremium;
    static String EnhancedCoverPremium;
    static String CoverageNonMedicalCoverPremium;
    public static String OutPatientPremium(String strSumInsured) {
        if (strSumInsured.equals("100000") || strSumInsured.equals("200000")){
            OutpatientDentalCoverPremium="410";
        }else if (strSumInsured.equals("300000")|| strSumInsured.equals("400000")|| strSumInsured.equals("500000")){
            OutpatientDentalCoverPremium="410";
        }else if (strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")||strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
            OutpatientDentalCoverPremium="530";
        }else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
            OutpatientDentalCoverPremium="630";
        }
        return OutpatientDentalCoverPremium;
    }
    public static String RestCureCoverPremium(String strSumInsured) {
        if (strSumInsured.equals("100000") || strSumInsured.equals("200000")||strSumInsured.equals("300000")|| strSumInsured.equals("400000")|| strSumInsured.equals("500000")){
            RestCureCoverPremium="700";
        }else if (strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
            RestCureCoverPremium="1050";
        }else if (strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
            RestCureCoverPremium="1400";
        }else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
            RestCureCoverPremium="2450";
        }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
            RestCureCoverPremium="3500";
        }
        return RestCureCoverPremium;
    }
    public static String HomeCareCoverPremium(String strSumInsured) {
        if (strSumInsured.equals("100000")){
            HomeCareCoverPremium="150";
        }else if (strSumInsured.equals("200000")){
            HomeCareCoverPremium="310";
        }else if (strSumInsured.equals("300000")){
            HomeCareCoverPremium="460";
        }else if (strSumInsured.equals("400000")){
            HomeCareCoverPremium="620";
        }else if (strSumInsured.equals("500000")||strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")||strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")||strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
            HomeCareCoverPremium="770";
        }
        return HomeCareCoverPremium;
    }
    public static String WellnessBenefitCoverPremium(String strSumInsured) {
        if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")||strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")){
            WellnessBenefitCoverPremium="140";
        }else if (strSumInsured.equals("1000000")||strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")||strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
            WellnessBenefitCoverPremium="330";
        }
        return WellnessBenefitCoverPremium;
    }
    public static String SterilityInfertilityCoverPremium(String strSumInsured) {
        if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")||strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
            SterilityInfertilityCoverPremium="0.0";
        }else if (strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
            SterilityInfertilityCoverPremium="5130";
        }else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
            SterilityInfertilityCoverPremium="10260";
        }
        return SterilityInfertilityCoverPremium;
    }
    public static String ObesityWeightCoverPremium(String strSumInsured) {
        if (strSumInsured.equals("100000") || strSumInsured.equals("200000")||strSumInsured.equals("300000")|| strSumInsured.equals("400000")|| strSumInsured.equals("500000")){
            ObesityWeightCoverPremium="2560";
        }else if (strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
            ObesityWeightCoverPremium="5130";
        }else if (strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")||strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
            ObesityWeightCoverPremium="10260";
        }
        return ObesityWeightCoverPremium;
    }
    public static String SecondOpinionCoverPremium(String strSumInsured) {
        if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")||strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
            SecondOpinionCoverPremium="200";
        }else if (strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")||strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
            SecondOpinionCoverPremium="350";
        }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
            SecondOpinionCoverPremium="600";
        }
        return SecondOpinionCoverPremium;
    }
    public static String EmergencyTravellingCoverPremium(String strSumInsured) {
        if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
            EmergencyTravellingCoverPremium="50";
        }else if (strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
            EmergencyTravellingCoverPremium="110";
        }else if (strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
            EmergencyTravellingCoverPremium="160";
        }else if(strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
            EmergencyTravellingCoverPremium="220";
        }else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
            EmergencyTravellingCoverPremium="270";
        }else if(strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
            EmergencyTravellingCoverPremium="340";
        }
        return EmergencyTravellingCoverPremium;
    }
    public static String DailyHospitalCoverPremium(int selectYearAdult,String strSumInsured) {
        if (selectYearAdult >= 18 && (selectYearAdult <= 75)){
            if (selectYearAdult >= 18 && (selectYearAdult <= 30)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    DailyHospitalCoverPremium="40";
                }else if (strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    DailyHospitalCoverPremium="100";
                }else if (strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                    DailyHospitalCoverPremium="200";
                }else if(strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                    DailyHospitalCoverPremium="400";
                }else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                    DailyHospitalCoverPremium="700";
                }else if(strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    DailyHospitalCoverPremium="100";
                }
            } else if (selectYearAdult >= 31 && (selectYearAdult <= 35)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    DailyHospitalCoverPremium="40";
                }else if (strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    DailyHospitalCoverPremium="100";
                }else if (strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                    DailyHospitalCoverPremium="180";
                }else if(strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                    DailyHospitalCoverPremium="360";
                }else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                    DailyHospitalCoverPremium="630";
                }else if(strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    DailyHospitalCoverPremium="900";
                }
            }else if (selectYearAdult >= 36 && (selectYearAdult <= 40)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    DailyHospitalCoverPremium="40";
                }else if (strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    DailyHospitalCoverPremium="100";
                }else if (strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                    DailyHospitalCoverPremium="190";
                }else if(strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                    DailyHospitalCoverPremium="370";
                }else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                    DailyHospitalCoverPremium="650";
                }else if(strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    DailyHospitalCoverPremium="930";
                }
            }else if (selectYearAdult >= 41 && (selectYearAdult <= 45)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    DailyHospitalCoverPremium="40";
                }else if (strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    DailyHospitalCoverPremium="100";
                }else if (strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                    DailyHospitalCoverPremium="190";
                }else if(strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                    DailyHospitalCoverPremium="390";
                }else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                    DailyHospitalCoverPremium="680";
                }else if(strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    DailyHospitalCoverPremium="970";
                }
            }else if (selectYearAdult >= 46 && (selectYearAdult <= 50)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    DailyHospitalCoverPremium="50";
                }else if (strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    DailyHospitalCoverPremium="130";
                }else if (strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                    DailyHospitalCoverPremium="250";
                }else if(strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                    DailyHospitalCoverPremium="510";
                }else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                    DailyHospitalCoverPremium="890";
                }else if(strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    DailyHospitalCoverPremium="1270";
                }
            }else if (selectYearAdult >= 51 && (selectYearAdult <= 55)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    DailyHospitalCoverPremium="70";
                }else if (strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    DailyHospitalCoverPremium="170";
                }else if (strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                    DailyHospitalCoverPremium="330";
                }else if(strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                    DailyHospitalCoverPremium="660";
                }else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                    DailyHospitalCoverPremium="1160";
                }else if(strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    DailyHospitalCoverPremium="1660";
                }
            }else if (selectYearAdult >= 56 && (selectYearAdult <= 60)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    DailyHospitalCoverPremium="90";
                }else if (strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    DailyHospitalCoverPremium="220";
                }else if (strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                    DailyHospitalCoverPremium="440";
                }else if(strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                    DailyHospitalCoverPremium="880";
                }else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                    DailyHospitalCoverPremium="1540";
                }else if(strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    DailyHospitalCoverPremium="2200";
                }
            }else if (selectYearAdult >= 61 && (selectYearAdult <= 65)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    DailyHospitalCoverPremium="130";
                }else if (strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    DailyHospitalCoverPremium="320";
                }else if (strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                    DailyHospitalCoverPremium="640";
                }else if(strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                    DailyHospitalCoverPremium="1270";
                }else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                    DailyHospitalCoverPremium="2230";
                }else if(strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    DailyHospitalCoverPremium="3180";
                }
            }else if (selectYearAdult >= 66 && (selectYearAdult <= 70)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    DailyHospitalCoverPremium="170";
                }else if (strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    DailyHospitalCoverPremium="420";
                }else if (strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                    DailyHospitalCoverPremium="850";
                }else if(strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                    DailyHospitalCoverPremium="1700";
                }else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                    DailyHospitalCoverPremium="2970";
                }else if(strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    DailyHospitalCoverPremium="4250";
                }
            }else if (selectYearAdult >= 71 && (selectYearAdult <= 75)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    DailyHospitalCoverPremium="230";
                }else if (strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    DailyHospitalCoverPremium="580";
                }else if (strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                    DailyHospitalCoverPremium="1150";
                }else if(strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                    DailyHospitalCoverPremium="2310";
                }else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                    DailyHospitalCoverPremium="4040";
                }else if(strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    DailyHospitalCoverPremium="5770";
                }
            }else if (selectYearAdult >= 76){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    DailyHospitalCoverPremium="280";
                }else if (strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    DailyHospitalCoverPremium="700";
                }else if (strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                    DailyHospitalCoverPremium="1400";
                }else if(strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                    DailyHospitalCoverPremium="2800";
                }else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                    DailyHospitalCoverPremium="4900";
                }else if(strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    DailyHospitalCoverPremium="7000";
                }
            }
        }
        else{
            if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                DailyHospitalCoverPremium="50";
            }else if (strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                DailyHospitalCoverPremium="120";
            }else if (strSumInsured.equals("600000")|| strSumInsured.equals("700000")|| strSumInsured.equals("800000")|| strSumInsured.equals("900000")|| strSumInsured.equals("1000000")){
                DailyHospitalCoverPremium="240";
            }else if(strSumInsured.equals("1500000")|| strSumInsured.equals("2000000")){
                DailyHospitalCoverPremium="480";
            }else if (strSumInsured.equals("2500000")|| strSumInsured.equals("3000000")){
                DailyHospitalCoverPremium="850";
            }else if(strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                DailyHospitalCoverPremium="1210";
            }
        }
        return DailyHospitalCoverPremium;
    }
    public static String CriticalIllnessCoverPremium(int selectYearAdult,String strSumInsured) {
        if (selectYearAdult >= 18 && (selectYearAdult <= 75)){
            if (selectYearAdult >= 18 && (selectYearAdult <= 35)){
                if (strSumInsured.equals("100000")){
                    CriticalIllnessCoverPremium="300";
                }else if(strSumInsured.equals("200000")){
                    CriticalIllnessCoverPremium="600";
                }else if (strSumInsured.equals("300000")){
                    CriticalIllnessCoverPremium="900";
                }else if (strSumInsured.equals("400000")){
                    CriticalIllnessCoverPremium="1200";
                }else if (strSumInsured.equals("500000")||strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CriticalIllnessCoverPremium="1500";
                }
            } else if (selectYearAdult >= 36 && (selectYearAdult <= 45)){
                if (strSumInsured.equals("100000")){
                    CriticalIllnessCoverPremium="550";
                }else if(strSumInsured.equals("200000")){
                    CriticalIllnessCoverPremium="1100";
                }else if (strSumInsured.equals("300000")){
                    CriticalIllnessCoverPremium="1650";
                }else if (strSumInsured.equals("400000")){
                    CriticalIllnessCoverPremium="2200";
                }else if (strSumInsured.equals("500000")||strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CriticalIllnessCoverPremium="2750";
                }
            }else if (selectYearAdult >= 46 && (selectYearAdult <= 50)){
                if (strSumInsured.equals("100000")){
                    CriticalIllnessCoverPremium="1200";
                }else if(strSumInsured.equals("200000")){
                    CriticalIllnessCoverPremium="2400";
                }else if (strSumInsured.equals("300000")){
                    CriticalIllnessCoverPremium="3600";
                }else if (strSumInsured.equals("400000")){
                    CriticalIllnessCoverPremium="4800";
                }else if (strSumInsured.equals("500000")||strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CriticalIllnessCoverPremium="6000";
                }
            }else if (selectYearAdult >= 51 && (selectYearAdult <= 55)){
                if (strSumInsured.equals("100000")){
                    CriticalIllnessCoverPremium="1250";
                }else if(strSumInsured.equals("200000")){
                    CriticalIllnessCoverPremium="2500";
                }else if (strSumInsured.equals("300000")){
                    CriticalIllnessCoverPremium="3750";
                }else if (strSumInsured.equals("400000")){
                    CriticalIllnessCoverPremium="5000";
                }else if (strSumInsured.equals("500000")||strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CriticalIllnessCoverPremium="6250";
                }
            }else if (selectYearAdult >= 56 && (selectYearAdult <= 60)){
                if (strSumInsured.equals("100000")){
                    CriticalIllnessCoverPremium="3000";
                }else if(strSumInsured.equals("200000")){
                    CriticalIllnessCoverPremium="6000";
                }else if (strSumInsured.equals("300000")){
                    CriticalIllnessCoverPremium="9000";
                }else if (strSumInsured.equals("400000")){
                    CriticalIllnessCoverPremium="12000";
                }else if (strSumInsured.equals("500000")||strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CriticalIllnessCoverPremium="15000";
                }
            }else if (selectYearAdult >= 61 && (selectYearAdult <= 65)){
                if (strSumInsured.equals("100000")){
                    CriticalIllnessCoverPremium="3200";
                }else if(strSumInsured.equals("200000")){
                    CriticalIllnessCoverPremium="6400";
                }else if (strSumInsured.equals("300000")){
                    CriticalIllnessCoverPremium="9600";
                }else if (strSumInsured.equals("400000")){
                    CriticalIllnessCoverPremium="12800";
                }else if (strSumInsured.equals("500000")||strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CriticalIllnessCoverPremium="16000";
                }
            }else if (selectYearAdult >= 66 && (selectYearAdult <= 70)){
                if (strSumInsured.equals("100000")){
                    CriticalIllnessCoverPremium="5560";
                }else if(strSumInsured.equals("200000")){
                    CriticalIllnessCoverPremium="11110";
                }else if (strSumInsured.equals("300000")){
                    CriticalIllnessCoverPremium="16670";
                }else if (strSumInsured.equals("400000")){
                    CriticalIllnessCoverPremium="22230";
                }else if (strSumInsured.equals("500000")){
                    CriticalIllnessCoverPremium="27790";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CriticalIllnessCoverPremium="27785";
                }
            }else if (selectYearAdult >= 71 && (selectYearAdult <= 75)){
                if (strSumInsured.equals("100000")){
                    CriticalIllnessCoverPremium="7890";
                }else if(strSumInsured.equals("200000")){
                    CriticalIllnessCoverPremium="15780";
                }else if (strSumInsured.equals("300000")){
                    CriticalIllnessCoverPremium="23670";
                }else if (strSumInsured.equals("400000")){
                    CriticalIllnessCoverPremium="31560";
                }else if (strSumInsured.equals("500000")){
                    CriticalIllnessCoverPremium="39450";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CriticalIllnessCoverPremium="39447";
                }
            }else if (selectYearAdult >= 76){
                if (strSumInsured.equals("100000")){
                    CriticalIllnessCoverPremium="8000";
                }else if(strSumInsured.equals("200000")){
                    CriticalIllnessCoverPremium="16000";
                }else if (strSumInsured.equals("300000")){
                    CriticalIllnessCoverPremium="24000";
                }else if (strSumInsured.equals("400000")){
                    CriticalIllnessCoverPremium="32000";
                }else if (strSumInsured.equals("500000")||strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CriticalIllnessCoverPremium="40000";
                }
            }
        }
        else{
            if (strSumInsured.equals("100000")){
                CriticalIllnessCoverPremium="200";
            }else if(strSumInsured.equals("200000")){
                CriticalIllnessCoverPremium="400";
            }else if (strSumInsured.equals("300000")){
                CriticalIllnessCoverPremium="600";
            }else if (strSumInsured.equals("400000")){
                CriticalIllnessCoverPremium="800";
            }else if (strSumInsured.equals("500000")||strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                CriticalIllnessCoverPremium="1000";
            }
        }
        return CriticalIllnessCoverPremium;
    }
    public static String MedicallyAdvisedCoverPremium(int selectYearAdult,String strSumInsured) {
        if (selectYearAdult >= 18 && (selectYearAdult <= 75)){
            if (selectYearAdult >= 18 && (selectYearAdult <= 35)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")||strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    MedicallyAdvisedCoverPremium="70";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    MedicallyAdvisedCoverPremium="120";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    MedicallyAdvisedCoverPremium="240";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    MedicallyAdvisedCoverPremium="490";
                }
            } else if (selectYearAdult >= 36 && (selectYearAdult <= 45)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")||strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    MedicallyAdvisedCoverPremium="120";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    MedicallyAdvisedCoverPremium="200";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    MedicallyAdvisedCoverPremium="400";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    MedicallyAdvisedCoverPremium="790";
                }
            }else if (selectYearAdult >= 46 && (selectYearAdult <= 55)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")||strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    MedicallyAdvisedCoverPremium="180";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    MedicallyAdvisedCoverPremium="300";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    MedicallyAdvisedCoverPremium="600";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    MedicallyAdvisedCoverPremium="1200";
                }
            }else if (selectYearAdult >= 56 && (selectYearAdult <= 60)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")||strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    MedicallyAdvisedCoverPremium="240";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    MedicallyAdvisedCoverPremium="400";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    MedicallyAdvisedCoverPremium="800";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    MedicallyAdvisedCoverPremium="1600";
                }
            }else if (selectYearAdult >= 61 && (selectYearAdult <= 65)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")||strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    MedicallyAdvisedCoverPremium="310";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    MedicallyAdvisedCoverPremium="520";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    MedicallyAdvisedCoverPremium="1040";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    MedicallyAdvisedCoverPremium="2090";
                }
            }else if (selectYearAdult >= 66 && (selectYearAdult <= 70)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")||strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    MedicallyAdvisedCoverPremium="390";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    MedicallyAdvisedCoverPremium="640";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    MedicallyAdvisedCoverPremium="1280";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    MedicallyAdvisedCoverPremium="2570";
                }
            }else if (selectYearAdult >= 71 && (selectYearAdult <= 75)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")||strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    MedicallyAdvisedCoverPremium="540";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    MedicallyAdvisedCoverPremium="890";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    MedicallyAdvisedCoverPremium="1790";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    MedicallyAdvisedCoverPremium="3570";
                }
            }else if (selectYearAdult >= 76){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")||strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    MedicallyAdvisedCoverPremium="540";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    MedicallyAdvisedCoverPremium="890";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    MedicallyAdvisedCoverPremium="1790";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    MedicallyAdvisedCoverPremium="3570";
                }
            }
        }
        else{
            if (strSumInsured.equals("100000")||strSumInsured.equals("200000")||strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")||strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                MedicallyAdvisedCoverPremium="70";
            }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                MedicallyAdvisedCoverPremium="120";
            }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                MedicallyAdvisedCoverPremium="230";
            }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                MedicallyAdvisedCoverPremium="470";
            }
        }
        return MedicallyAdvisedCoverPremium;
    }
    public static String EnhancedCoverPremium(int selectYearAdult,String strSumInsured) {
        if (selectYearAdult >= 18 && (selectYearAdult <= 75)){
            if (selectYearAdult >= 18 && (selectYearAdult <= 25)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    EnhancedCoverPremium="230";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    EnhancedCoverPremium="460";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    EnhancedCoverPremium="920";
                }
            }
            else if (selectYearAdult >= 26 && (selectYearAdult <= 30)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    EnhancedCoverPremium="270";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    EnhancedCoverPremium="540";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    EnhancedCoverPremium="1080";
                }
            }else if (selectYearAdult >= 31 && (selectYearAdult <= 35)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    EnhancedCoverPremium="310";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    EnhancedCoverPremium="620";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    EnhancedCoverPremium="1230";
                }
            }else if (selectYearAdult >= 36 && (selectYearAdult <= 40)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    EnhancedCoverPremium="380";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    EnhancedCoverPremium="770";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    EnhancedCoverPremium="1540";
                }
            }else if (selectYearAdult >= 41 && (selectYearAdult <= 45)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    EnhancedCoverPremium="460";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    EnhancedCoverPremium="920";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    EnhancedCoverPremium="1850";
                }
            }else if (selectYearAdult >= 46 && (selectYearAdult <= 50)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    EnhancedCoverPremium="540";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    EnhancedCoverPremium="1080";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    EnhancedCoverPremium="2150";
                }
            }else if (selectYearAdult >= 51 && (selectYearAdult <= 55)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    EnhancedCoverPremium="1230";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    EnhancedCoverPremium="2460";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    EnhancedCoverPremium="4920";
                }
            }else if (selectYearAdult >= 56 && (selectYearAdult <= 60)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    EnhancedCoverPremium="1150";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    EnhancedCoverPremium="2310";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    EnhancedCoverPremium="4620";
                }
            }else if (selectYearAdult >= 61 && (selectYearAdult <= 65)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    EnhancedCoverPremium="1000";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    EnhancedCoverPremium="2000";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    EnhancedCoverPremium="4000";
                }
            }else if (selectYearAdult >= 66 && (selectYearAdult <= 70)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    EnhancedCoverPremium="770";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    EnhancedCoverPremium="1540";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    EnhancedCoverPremium="3080";
                }
            }else if (selectYearAdult >= 71 && (selectYearAdult <= 75)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    EnhancedCoverPremium="80";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    EnhancedCoverPremium="150";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    EnhancedCoverPremium="310";
                }
            }else if (selectYearAdult >= 76){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    EnhancedCoverPremium="80";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    EnhancedCoverPremium="150";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    EnhancedCoverPremium="310";
                }
            }
        }
        else{
            if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                EnhancedCoverPremium="150";
            }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                EnhancedCoverPremium="310";
            }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")||strSumInsured.equals("1500000")||strSumInsured.equals("2000000")||strSumInsured.equals("2500000")||strSumInsured.equals("3000000")||strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                EnhancedCoverPremium="620";
            }
        }
        return EnhancedCoverPremium;
    }
    public static String NoMedicalPremiumTxt(int selectYearAdult,String strSumInsured) {
        if (selectYearAdult >= 18 || (selectYearAdult <= 75)){
            if (selectYearAdult >= 18 && (selectYearAdult <= 30)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    CoverageNonMedicalCoverPremium="110";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    CoverageNonMedicalCoverPremium="220";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    CoverageNonMedicalCoverPremium="560";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    CoverageNonMedicalCoverPremium="840";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    CoverageNonMedicalCoverPremium="1120";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CoverageNonMedicalCoverPremium="2230";
                }
            } else if (selectYearAdult >= 31 && (selectYearAdult <= 35)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    CoverageNonMedicalCoverPremium="100";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    CoverageNonMedicalCoverPremium="200";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    CoverageNonMedicalCoverPremium="500";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    CoverageNonMedicalCoverPremium="750";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    CoverageNonMedicalCoverPremium="1000";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CoverageNonMedicalCoverPremium="2000";
                }
            }else if (selectYearAdult >= 36 && (selectYearAdult <= 40)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    CoverageNonMedicalCoverPremium="100";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    CoverageNonMedicalCoverPremium="210";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    CoverageNonMedicalCoverPremium="520";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    CoverageNonMedicalCoverPremium="780";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    CoverageNonMedicalCoverPremium="1040";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CoverageNonMedicalCoverPremium="2080";
                }
            }else if (selectYearAdult >= 41 && (selectYearAdult <= 45)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    CoverageNonMedicalCoverPremium="110";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    CoverageNonMedicalCoverPremium="220";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    CoverageNonMedicalCoverPremium="540";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    CoverageNonMedicalCoverPremium="810";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    CoverageNonMedicalCoverPremium="1080";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CoverageNonMedicalCoverPremium="2150";
                }
            }else if (selectYearAdult >= 46 && (selectYearAdult <= 50)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    CoverageNonMedicalCoverPremium="130";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    CoverageNonMedicalCoverPremium="250";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    CoverageNonMedicalCoverPremium="630";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    CoverageNonMedicalCoverPremium="690";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    CoverageNonMedicalCoverPremium="1270";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CoverageNonMedicalCoverPremium="2540";
                }
            }else if (selectYearAdult >= 51 && (selectYearAdult <= 55)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    CoverageNonMedicalCoverPremium="160";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    CoverageNonMedicalCoverPremium="320";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    CoverageNonMedicalCoverPremium="790";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    CoverageNonMedicalCoverPremium="1180";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    CoverageNonMedicalCoverPremium="1580";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CoverageNonMedicalCoverPremium="3150";
                }
            }else if (selectYearAdult >= 56 && (selectYearAdult <= 60)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    CoverageNonMedicalCoverPremium="200";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    CoverageNonMedicalCoverPremium="400";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    CoverageNonMedicalCoverPremium="1000";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    CoverageNonMedicalCoverPremium="1500";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    CoverageNonMedicalCoverPremium="2000";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CoverageNonMedicalCoverPremium="4000";
                }
            }else if (selectYearAdult >= 61&& (selectYearAdult <= 65)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    CoverageNonMedicalCoverPremium="280";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    CoverageNonMedicalCoverPremium="550";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    CoverageNonMedicalCoverPremium="1380";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    CoverageNonMedicalCoverPremium="2080";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    CoverageNonMedicalCoverPremium="2770";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CoverageNonMedicalCoverPremium="5540";
                }
            }else if (selectYearAdult >= 66 && (selectYearAdult <= 70)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    CoverageNonMedicalCoverPremium="350";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    CoverageNonMedicalCoverPremium="710";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    CoverageNonMedicalCoverPremium="1770";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    CoverageNonMedicalCoverPremium="2650";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    CoverageNonMedicalCoverPremium="3540";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CoverageNonMedicalCoverPremium="7080";
                }
            }else if (selectYearAdult >= 71 && (selectYearAdult <= 75)){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    CoverageNonMedicalCoverPremium="460";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    CoverageNonMedicalCoverPremium="920";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    CoverageNonMedicalCoverPremium="2310";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    CoverageNonMedicalCoverPremium="3460";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    CoverageNonMedicalCoverPremium="4620";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CoverageNonMedicalCoverPremium="9230";
                }
            }else if (selectYearAdult >= 76){
                if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                    CoverageNonMedicalCoverPremium="540";
                }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                    CoverageNonMedicalCoverPremium="1080";
                }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                    CoverageNonMedicalCoverPremium="2690";
                }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                    CoverageNonMedicalCoverPremium="4040";
                }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                    CoverageNonMedicalCoverPremium="5380";
                }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                    CoverageNonMedicalCoverPremium="10770";
                }
            }
        }
        else{
            if (strSumInsured.equals("100000")||strSumInsured.equals("200000")){
                CoverageNonMedicalCoverPremium="120";
            }else if(strSumInsured.equals("300000")||strSumInsured.equals("400000")||strSumInsured.equals("500000")){
                CoverageNonMedicalCoverPremium="230";
            }else if (strSumInsured.equals("600000")||strSumInsured.equals("700000")||strSumInsured.equals("800000")||strSumInsured.equals("900000")||strSumInsured.equals("1000000")){
                CoverageNonMedicalCoverPremium="580";
            }else if (strSumInsured.equals("1500000")||strSumInsured.equals("2000000")){
                CoverageNonMedicalCoverPremium="870";
            }else if (strSumInsured.equals("2500000")||strSumInsured.equals("3000000")){
                CoverageNonMedicalCoverPremium="1150";
            }else if (strSumInsured.equals("4000000")||strSumInsured.equals("5000000")){
                CoverageNonMedicalCoverPremium="2310";
            }
        }
        return CoverageNonMedicalCoverPremium;
    }

}
