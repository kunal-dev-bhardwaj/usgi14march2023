package com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AllIndivisualHealth {
    static String strcriticalEdit;
    static String strhospitalEdit;
    static String strOneChildCriticalIllnessTxt;
    static String stroneChildTxt;
    static String strThirdDString;
    static String today;
    static Date date;
    static Format formatter;
    public static String AllIndividualCalculate(String str_age,String str_SumInsured) {
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date);
        String[] strTDate=  today.split("/");
        String strFirstDString = strTDate[0];
        String strSecondDString = strTDate[1];
        strThirdDString = strTDate[2];
        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_age);
        if (dateValidation < 18 || (dateValidation >35)) {
            if (str_SumInsured.equals("500000")){
                strcriticalEdit="1500";
            }else if (str_SumInsured.equals("600000")){
                strcriticalEdit="1800";
            }else if (str_SumInsured.equals("700000")){
                strcriticalEdit="2100";
            }else if (str_SumInsured.equals("800000")){
                strcriticalEdit="2400";
            }else if (str_SumInsured.equals("900000")){
                strcriticalEdit="2700";
            }else if (str_SumInsured.equals("1000000")){
                strcriticalEdit="3000";
            }
        } else if (dateValidation < 36 || (dateValidation >45)) {
            if (str_SumInsured.equals("500000")){
                strcriticalEdit="2750";
            }else if (str_SumInsured.equals("600000")){
                strcriticalEdit="3300";
            }else if (str_SumInsured.equals("700000")){
                strcriticalEdit="3850";
            }else if (str_SumInsured.equals("800000")){
                strcriticalEdit="4400";
            }else if (str_SumInsured.equals("900000")){
                strcriticalEdit="4950";
            }else if (str_SumInsured.equals("1000000")){
                strcriticalEdit="5500";
            }
        } else if (dateValidation < 46 || (dateValidation >50)) {
            if (str_SumInsured.equals("500000")){
                strcriticalEdit="6000";
            }  else if (str_SumInsured.equals("600000")){
                strcriticalEdit="7200";
            }else if (str_SumInsured.equals("700000")){
                strcriticalEdit="8400";
            } else if (str_SumInsured.equals("800000")){
                strcriticalEdit="9600";
            } else if (str_SumInsured.equals("900000")){
                strcriticalEdit="10800";
            } else if (str_SumInsured.equals("1000000")){
                strcriticalEdit="12000";
            }
        }else if (dateValidation < 51 || (dateValidation >55)) {
            if (str_SumInsured.equals("500000")){
                strcriticalEdit="6250";
            } else if (str_SumInsured.equals("600000")){
                strcriticalEdit="7500";
            }else if (str_SumInsured.equals("700000")){
                strcriticalEdit="8750";
            }else if (str_SumInsured.equals("800000")){
                strcriticalEdit="10000";
            } else if (str_SumInsured.equals("900000")){
                strcriticalEdit="11250";
            } else if (str_SumInsured.equals("1000000")){
                strcriticalEdit="12500";
            }
        }
       /* if (str_age.equals("18yrs-35yrs")){
            if (str_SumInsured.equals("500000")){
                strcriticalEdit="1500";
            }else if (str_SumInsured.equals("600000")){
                strcriticalEdit="1800";
            }else if (str_SumInsured.equals("700000")){
                strcriticalEdit="2100";
            }else if (str_SumInsured.equals("800000")){
                strcriticalEdit="2400";
            }else if (str_SumInsured.equals("900000")){
                strcriticalEdit="2700";
            }else if (str_SumInsured.equals("1000000")){
                strcriticalEdit="3000";
                }
            }
        else if (str_age.equals("36yrs-45yrs")){
            if (str_SumInsured.equals("500000")){
                strcriticalEdit="2750";
            }else if (str_SumInsured.equals("600000")){
                    strcriticalEdit="3300";
            }else if (str_SumInsured.equals("700000")){
                strcriticalEdit="3850";
            }else if (str_SumInsured.equals("800000")){
                strcriticalEdit="4400";
             }else if (str_SumInsured.equals("900000")){
                strcriticalEdit="4950";
              }else if (str_SumInsured.equals("1000000")){
                strcriticalEdit="5500";
                }
            }
        else if (str_age.equals("46yrs-50yrs")){
            if (str_SumInsured.equals("500000")){
                strcriticalEdit="6000";
            }  else if (str_SumInsured.equals("600000")){
                    strcriticalEdit="7200";
            }else if (str_SumInsured.equals("700000")){
                strcriticalEdit="8400";
            } else if (str_SumInsured.equals("800000")){
                strcriticalEdit="9600";
             } else if (str_SumInsured.equals("900000")){
                strcriticalEdit="10800";
             } else if (str_SumInsured.equals("1000000")){
                strcriticalEdit="12000";
                }
            }
        else if (str_age.equals("51yrs-55yrs")){
            if (str_SumInsured.equals("500000")){
                strcriticalEdit="6250";
            } else if (str_SumInsured.equals("600000")){
                strcriticalEdit="7500";
            }else if (str_SumInsured.equals("700000")){
                strcriticalEdit="8750";
            }else if (str_SumInsured.equals("800000")){
                strcriticalEdit="10000";
            } else if (str_SumInsured.equals("900000")){
                strcriticalEdit="11250";
             } else if (str_SumInsured.equals("1000000")){
                strcriticalEdit="12500";
                }
            }

        */
        return strcriticalEdit;
    }


    public static String AllIndividualHospitalCalculate(String str_age,String str_SumInsured) {
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date);
        String[] strTDate=  today.split("/");
        String strFirstDString = strTDate[0];
        String strSecondDString = strTDate[1];
        strThirdDString = strTDate[2];
        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_age);
        if (dateValidation < 18 || (dateValidation >35)) {
            if (str_SumInsured.equals("500000")){
                strhospitalEdit="252";
            }else if (str_SumInsured.equals("600000")){
                strhospitalEdit="504";
            }else if (str_SumInsured.equals("700000")){
                strhospitalEdit="504";
            }else if (str_SumInsured.equals("800000")){
                strhospitalEdit="504";
            }else if (str_SumInsured.equals("900000")){
                strhospitalEdit="504";
            }else if (str_SumInsured.equals("1000000")){
                strhospitalEdit="504";
            }
        } else if (dateValidation < 36 || (dateValidation >45)) {
            if (str_SumInsured.equals("500000")){
                strhospitalEdit="357";
            }else if (str_SumInsured.equals("600000")){
                strhospitalEdit="714";
            }else if (str_SumInsured.equals("700000")){
                strhospitalEdit="714";
            }else if (str_SumInsured.equals("800000")){
                strhospitalEdit="714";
            }else if (str_SumInsured.equals("900000")){
                strhospitalEdit="714";
            }else if (str_SumInsured.equals("1000000")){
                strhospitalEdit="714";
            }
        } else if (dateValidation < 46 || (dateValidation >50)) {
            if (str_SumInsured.equals("500000")){
                strhospitalEdit="389";
            }  else if (str_SumInsured.equals("600000")){
                strhospitalEdit="777";
            }else if (str_SumInsured.equals("700000")){
                strhospitalEdit="777";
            } else if (str_SumInsured.equals("800000")){
                strhospitalEdit="777";
            } else if (str_SumInsured.equals("900000")){
                strhospitalEdit="777";
            } else if (str_SumInsured.equals("1000000")){
                strhospitalEdit="777";
            }
        }else if (dateValidation < 51 || (dateValidation >55)) {
            if (str_SumInsured.equals("500000")){
                strhospitalEdit="427";
            } else if (str_SumInsured.equals("600000")){
                strhospitalEdit="854";
            }else if (str_SumInsured.equals("700000")){
                strhospitalEdit="854";
            }else if (str_SumInsured.equals("800000")){
                strhospitalEdit="854";
            } else if (str_SumInsured.equals("900000")){
                strhospitalEdit="854";
            } else if (str_SumInsured.equals("1000000")){
                strhospitalEdit="854";
            }
        }


      /*  if (str_age.equals("18yrs-35yrs")){
            if (str_SumInsured.equals("500000")){
                strhospitalEdit="252";
            }else if (str_SumInsured.equals("600000")){
                strhospitalEdit="504";
            }else if (str_SumInsured.equals("700000")){
                strhospitalEdit="504";
            }else if (str_SumInsured.equals("800000")){
                strhospitalEdit="504";
            }else if (str_SumInsured.equals("900000")){
                strhospitalEdit="504";
            }else if (str_SumInsured.equals("1000000")){
                strhospitalEdit="504";
            }
        }
        else if (str_age.equals("36yrs-45yrs")){
            if (str_SumInsured.equals("500000")){
                strhospitalEdit="357";
            }else if (str_SumInsured.equals("600000")){
                strhospitalEdit="714";
            }else if (str_SumInsured.equals("700000")){
                strhospitalEdit="714";
            }else if (str_SumInsured.equals("800000")){
                strhospitalEdit="714";
            }else if (str_SumInsured.equals("900000")){
                strhospitalEdit="714";
            }else if (str_SumInsured.equals("1000000")){
                strhospitalEdit="714";
            }
        }
        else if (str_age.equals("46yrs-50yrs")){
            if (str_SumInsured.equals("500000")){
                strhospitalEdit="389";
            }  else if (str_SumInsured.equals("600000")){
                strhospitalEdit="777";
            }else if (str_SumInsured.equals("700000")){
                strhospitalEdit="777";
            } else if (str_SumInsured.equals("800000")){
                strhospitalEdit="777";
            } else if (str_SumInsured.equals("900000")){
                strhospitalEdit="777";
            } else if (str_SumInsured.equals("1000000")){
                strhospitalEdit="777";
            }
        }
        else if (str_age.equals("51yrs-55yrs")){
            if (str_SumInsured.equals("500000")){
                strhospitalEdit="427";
            } else if (str_SumInsured.equals("600000")){
                strhospitalEdit="854";
            }else if (str_SumInsured.equals("700000")){
                strhospitalEdit="854";
            }else if (str_SumInsured.equals("800000")){
                strhospitalEdit="854";
            } else if (str_SumInsured.equals("900000")){
                strhospitalEdit="854";
            } else if (str_SumInsured.equals("1000000")){
                strhospitalEdit="854";
            }
        }

       */
        return strhospitalEdit;
    }

    public static String ChildCriticalCalculate(String str_age,String str_SumInsured) {
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date);
        String[] strTDate=  today.split("/");
        String strFirstDString = strTDate[0];
        String strSecondDString = strTDate[1];
        strThirdDString = strTDate[2];
        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_age);
        if (dateValidation < 18 || (dateValidation >35)) {
            if (str_SumInsured.equals("500000")){
                strOneChildCriticalIllnessTxt="1000";
            }else if (str_SumInsured.equals("600000")){
                strOneChildCriticalIllnessTxt="1200";
            }else if (str_SumInsured.equals("700000")){
                strOneChildCriticalIllnessTxt="1400";
            }else if (str_SumInsured.equals("800000")){
                strOneChildCriticalIllnessTxt="1600";
            }else if (str_SumInsured.equals("900000")){
                strOneChildCriticalIllnessTxt="1800";
            }else if (str_SumInsured.equals("1000000")){
                strOneChildCriticalIllnessTxt="2000";
            }
        } else if (dateValidation < 36 || (dateValidation >45)) {
            if (str_SumInsured.equals("500000")){
                strOneChildCriticalIllnessTxt="1000";
            }else if (str_SumInsured.equals("600000")){
                strOneChildCriticalIllnessTxt="1200";
            }else if (str_SumInsured.equals("700000")){
                strOneChildCriticalIllnessTxt="1400";
            }else if (str_SumInsured.equals("800000")){
                strOneChildCriticalIllnessTxt="1600";
            }else if (str_SumInsured.equals("900000")){
                strOneChildCriticalIllnessTxt="1800";
            }else if (str_SumInsured.equals("1000000")){
                strOneChildCriticalIllnessTxt="2000";
            }
        } else if (dateValidation < 46 || (dateValidation >50)) {
            if (str_SumInsured.equals("500000")){
                strOneChildCriticalIllnessTxt="1000";
            }else if (str_SumInsured.equals("600000")){
                strOneChildCriticalIllnessTxt="1200";
            }else if (str_SumInsured.equals("700000")){
                strOneChildCriticalIllnessTxt="1400";
            }else if (str_SumInsured.equals("800000")){
                strOneChildCriticalIllnessTxt="1600";
            }else if (str_SumInsured.equals("900000")){
                strOneChildCriticalIllnessTxt="1800";
            }else if (str_SumInsured.equals("1000000")){
                strOneChildCriticalIllnessTxt="2000";
            }
        }else if (dateValidation < 51 || (dateValidation >55)) {
            if (str_SumInsured.equals("500000")){
                strOneChildCriticalIllnessTxt="1000";
            }else if (str_SumInsured.equals("600000")){
                strOneChildCriticalIllnessTxt="1200";
            }else if (str_SumInsured.equals("700000")){
                strOneChildCriticalIllnessTxt="1400";
            }else if (str_SumInsured.equals("800000")){
                strOneChildCriticalIllnessTxt="1600";
            }else if (str_SumInsured.equals("900000")){
                strOneChildCriticalIllnessTxt="1800";
            }else if (str_SumInsured.equals("1000000")){
                strOneChildCriticalIllnessTxt="2000";
            }
        }

      /*  if (str_age.equals("18yrs-35yrs")){
            if (str_SumInsured.equals("500000")){
                strOneChildCriticalIllnessTxt="1000";
            }else if (str_SumInsured.equals("600000")){
                strOneChildCriticalIllnessTxt="1200";
            }else if (str_SumInsured.equals("700000")){
                strOneChildCriticalIllnessTxt="1400";
            }else if (str_SumInsured.equals("800000")){
                strOneChildCriticalIllnessTxt="1600";
            }else if (str_SumInsured.equals("900000")){
                strOneChildCriticalIllnessTxt="1800";
            }else if (str_SumInsured.equals("1000000")){
                strOneChildCriticalIllnessTxt="2000";
            }
        }
        else if (str_age.equals("36yrs-45yrs")){
            if (str_SumInsured.equals("500000")){
                strOneChildCriticalIllnessTxt="1000";
            }else if (str_SumInsured.equals("600000")){
                strOneChildCriticalIllnessTxt="1200";
            }else if (str_SumInsured.equals("700000")){
                strOneChildCriticalIllnessTxt="1400";
            }else if (str_SumInsured.equals("800000")){
                strOneChildCriticalIllnessTxt="1600";
            }else if (str_SumInsured.equals("900000")){
                strOneChildCriticalIllnessTxt="1800";
            }else if (str_SumInsured.equals("1000000")){
                strOneChildCriticalIllnessTxt="2000";
            }
        }
        else if (str_age.equals("46yrs-50yrs")){
            if (str_SumInsured.equals("500000")){
                strOneChildCriticalIllnessTxt="1000";
            }else if (str_SumInsured.equals("600000")){
                strOneChildCriticalIllnessTxt="1200";
            }else if (str_SumInsured.equals("700000")){
                strOneChildCriticalIllnessTxt="1400";
            }else if (str_SumInsured.equals("800000")){
                strOneChildCriticalIllnessTxt="1600";
            }else if (str_SumInsured.equals("900000")){
                strOneChildCriticalIllnessTxt="1800";
            }else if (str_SumInsured.equals("1000000")){
                strOneChildCriticalIllnessTxt="2000";
            }
        }
        else if (str_age.equals("51yrs-55yrs")){
            if (str_SumInsured.equals("500000")){
                strOneChildCriticalIllnessTxt="1000";
            }else if (str_SumInsured.equals("600000")){
                strOneChildCriticalIllnessTxt="1200";
            }else if (str_SumInsured.equals("700000")){
                strOneChildCriticalIllnessTxt="1400";
            }else if (str_SumInsured.equals("800000")){
                strOneChildCriticalIllnessTxt="1600";
            }else if (str_SumInsured.equals("900000")){
                strOneChildCriticalIllnessTxt="1800";
            }else if (str_SumInsured.equals("1000000")){
                strOneChildCriticalIllnessTxt="2000";
            }
        }

       */
        return strOneChildCriticalIllnessTxt;
    }


    public static String ChildHospitalCalculate(String str_age,String str_SumInsured) {
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        today = formatter.format(date);
        String[] strTDate=  today.split("/");
        String strFirstDString = strTDate[0];
        String strSecondDString = strTDate[1];
        strThirdDString = strTDate[2];
        int dateValidation = Integer.parseInt(strThirdDString) - Integer.parseInt(str_age);
        if (dateValidation < 18 || (dateValidation >35)) {
            if (str_SumInsured.equals("500000")){
                stroneChildTxt="182";
            }else if (str_SumInsured.equals("600000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("700000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("800000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("900000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("1000000")){
                stroneChildTxt="364";
            }
        } else if (dateValidation < 36 || (dateValidation >45)) {
            if (str_SumInsured.equals("500000")){
                stroneChildTxt="182";
            }else if (str_SumInsured.equals("600000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("700000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("800000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("900000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("1000000")){
                stroneChildTxt="364";
            }
        } else if (dateValidation < 46 || (dateValidation >50)) {
            if (str_SumInsured.equals("500000")){
                stroneChildTxt="182";
            }else if (str_SumInsured.equals("600000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("700000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("800000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("900000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("1000000")){
                stroneChildTxt="364";
            }
        }else if (dateValidation < 51 || (dateValidation >55)) {
            if (str_SumInsured.equals("500000")){
                stroneChildTxt="182";
            }else if (str_SumInsured.equals("600000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("700000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("800000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("900000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("1000000")){
                stroneChildTxt="364";
            }
        }



      /*  if (str_age.equals("18yrs-35yrs")){
            if (str_SumInsured.equals("500000")){
                stroneChildTxt="182";
            }else if (str_SumInsured.equals("600000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("700000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("800000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("900000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("1000000")){
                stroneChildTxt="364";
            }
        }
        else if (str_age.equals("36yrs-45yrs")){
            if (str_SumInsured.equals("500000")){
                stroneChildTxt="182";
            }else if (str_SumInsured.equals("600000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("700000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("800000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("900000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("1000000")){
                stroneChildTxt="364";
            }
        }
        else if (str_age.equals("46yrs-50yrs")){
            if (str_SumInsured.equals("500000")){
                stroneChildTxt="182";
            }else if (str_SumInsured.equals("600000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("700000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("800000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("900000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("1000000")){
                stroneChildTxt="364";
            }
        }
        else if (str_age.equals("51yrs-55yrs")){
            if (str_SumInsured.equals("500000")){
                stroneChildTxt="182";
            }else if (str_SumInsured.equals("600000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("700000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("800000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("900000")){
                stroneChildTxt="364";
            }else if (str_SumInsured.equals("1000000")){
                stroneChildTxt="364";
            }
        }

       */
        return stroneChildTxt;
    }

}
