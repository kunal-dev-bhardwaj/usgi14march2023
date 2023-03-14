package com.universalsompo.meta.metaapp.health.fragment.buypolicy.buypolicycalculation;

import android.content.Context;
import android.widget.Toast;
public class IndividualHealth {
    static double amountPersonalSumInsured;
    public static double IndividualHealthCalculate(String str_age,String str_SumInsured ,String streditPASpinner, Context context) {
     final boolean b = streditPASpinner.equals("500000") || streditPASpinner.equals("400000") || streditPASpinner.equals("300000") || streditPASpinner.equals("200000") || streditPASpinner.equals("100000");
        if (str_age.equals("18yrs-35yrs")){
            if (str_SumInsured.equals("500000")){
                if (streditPASpinner.equals("600000")||streditPASpinner.equals("700000")||streditPASpinner.equals("800000")||streditPASpinner.equals("900000")||streditPASpinner.equals("1000000")){
                    Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured forPersonal Accident for Privilege Plan Should be 300000 or 400000 or 500000 only  for Self ", Toast.LENGTH_SHORT).show(); }else {
                    if (streditPASpinner.equals("300000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("400000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                        
                    }else if (streditPASpinner.equals("500000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                        }
                }
            }else {
                if (str_SumInsured.equals("600000")){
                    if (b){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else { if (streditPASpinner.equals("600000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("700000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("800000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("900000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("1000000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                       } }
                }else if (str_SumInsured.equals("700000")){
                    if (b){
                    Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show(); }else {
                    if (streditPASpinner.equals("600000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("700000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("800000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("900000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;

                    }else if (streditPASpinner.equals("1000000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                       } }
                }else if (str_SumInsured.equals("800000")){
                    if (b){
                    Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                }else { if (streditPASpinner.equals("600000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                }else if (streditPASpinner.equals("700000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;

                }else if (streditPASpinner.equals("800000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                }else if (streditPASpinner.equals("900000")){
                        double amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                }else if (streditPASpinner.equals("1000000")){
                        double amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                } }
                }else if (str_SumInsured.equals("900000")){
                    if (b){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else { if (streditPASpinner.equals("600000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("700000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("800000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("900000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("1000000")){
                         amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                       }
                    }
                } else if (str_SumInsured.equals("1000000")){
                    if (b){
                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (streditPASpinner.equals("600000")){
                             amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                        }else if (streditPASpinner.equals("700000")){
                             amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                        }else if (streditPASpinner.equals("800000")){
                             amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                        }else if (streditPASpinner.equals("900000")){
                             amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;

                        }else if (streditPASpinner.equals("1000000")){
                             amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                          } } }
            }
        }
        else if (str_age.equals("36yrs-45yrs")){
            if (str_SumInsured.equals("500000")){
                if (b){
                    Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured forPersonal Accident for Privilege Plan Should be 300000 or 400000 or 500000 only  for Self ", Toast.LENGTH_SHORT).show(); }else {
                    if (streditPASpinner.equals("300000")){
                        amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("400000")){
                        amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("500000")){
                        amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    } } }
            else if (str_SumInsured.equals("600000")){
                if (b){
                    Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                }else {
                    if (streditPASpinner.equals("600000")){
                    amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                }else if (streditPASpinner.equals("700000")){
                        amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                }else if (streditPASpinner.equals("800000")){
                        amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                }else if (streditPASpinner.equals("900000")){
                        amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                }else if (streditPASpinner.equals("1000000")){
                        amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    } }
            }
            else if (str_SumInsured.equals("700000")){
                if (b){
                    Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show(); }else {
                    if (streditPASpinner.equals("600000")){
                        amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("700000")){
                        amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("800000")){
                        amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("900000")){
                        amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    }else if (streditPASpinner.equals("1000000")){
                        amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                    } }
            }
            else if (str_SumInsured.equals("800000"))
            {
                if (b){
                Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show(); }else {
                if (streditPASpinner.equals("600000")){
                    amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4; }
                else if (streditPASpinner.equals("700000")){
                    amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                }else if (streditPASpinner.equals("800000")){
                    amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                }else if (streditPASpinner.equals("900000")){
                    amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                }else if (streditPASpinner.equals("1000000")){
                    amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                     } }
            }else if (str_SumInsured.equals("900000")){
                if (b){
                Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
            }else {
                    if (streditPASpinner.equals("600000")){
                        amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
            }else if (streditPASpinner.equals("700000")){
                        amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
            }else if (streditPASpinner.equals("800000")){
                        amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
            }else if (streditPASpinner.equals("900000")){
                        amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
            }else if (streditPASpinner.equals("1000000")){ amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4; } }
            }else if (str_SumInsured.equals("1000000")){
                if (b){
                Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
            }else { if (streditPASpinner.equals("600000")){ amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
            }else if (streditPASpinner.equals("700000")){ amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
            }else if (streditPASpinner.equals("800000")){ amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
            }else if (streditPASpinner.equals("900000")){ amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
            }else if (streditPASpinner.equals("1000000")){ amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
            } } } }
        else if (str_age.equals("46yrs-50yrs")) {
                                if (str_SumInsured.equals("500000")){
                                    if (b){
                                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured forPersonal Accident for Privilege Plan Should be 300000 or 400000 or 500000 only  for Self ", Toast.LENGTH_SHORT).show();
                                    }else {
                                        if (streditPASpinner.equals("300000")){
                                       amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4; }
                                        else if (streditPASpinner.equals("400000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4; }
                                        else if (streditPASpinner.equals("500000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        } }
                                }else if (str_SumInsured.equals("600000")){
                                    if (b){
                                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                                    }else { if (streditPASpinner.equals("600000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("700000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("800000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("900000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("1000000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4; } }
                            }else if (str_SumInsured.equals("700000")){
                                    if (b){
                                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                                    }else { if (streditPASpinner.equals("600000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("700000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("800000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("900000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("1000000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4; } }
                            }else if (str_SumInsured.equals("800000")){
                                    if (b){
                                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                                    }else { if (streditPASpinner.equals("600000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("700000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("800000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("900000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("1000000")){
                                           amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4; } }
                            }else if (str_SumInsured.equals("900000")){
                                    if (b){
                                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                                    }else { if (streditPASpinner.equals("600000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("700000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("800000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("900000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("1000000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4; } }
                            }else if (str_SumInsured.equals("1000000")){
                                    if (b){
                                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                                    }else { if (streditPASpinner.equals("600000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("700000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("800000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("900000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("1000000")){
                                           amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4; } } }
                            }
        else if (str_age.equals("51yrs-55yrs")){
                                if (str_SumInsured.equals("500000")){
                                    if (b){
                                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured forPersonal Accident for Privilege Plan Should be 300000 or 400000 or 500000 only  for Self ", Toast.LENGTH_SHORT).show();
                                    }else { if (streditPASpinner.equals("300000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("400000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("500000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4; } }
                                }else if (str_SumInsured.equals("600000")){
                                    if (b){
                                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                                    }else { if (streditPASpinner.equals("600000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("700000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("800000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("900000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("1000000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4; } }
                            }else if (str_SumInsured.equals("700000")){
                                    if (b){
                                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                                    }else { if (streditPASpinner.equals("600000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("700000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("800000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("900000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("1000000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4; } }
                            }else if (str_SumInsured.equals("800000")){
                                    if (b){
                                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                                    }else { if (streditPASpinner.equals("600000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("700000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("800000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("900000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("1000000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4; } }
                            }else if (str_SumInsured.equals("900000")){
                                    if (b){
                                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                                    }else { if (streditPASpinner.equals("600000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("700000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("800000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("900000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("1000000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4; } }
                            }else if (str_SumInsured.equals("1000000")){
                                    if (b){
                                        Toast.makeText(context, "Error In Calculate Premium  Critical Illness Sum Insured for Personal Accident for Privilege Plan Should be 600000 or 700000 or 800000 or 900000 or 1000000 only  for Self ", Toast.LENGTH_SHORT).show();
                                    }else { if (streditPASpinner.equals("600000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("700000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("800000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("900000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        }else if (streditPASpinner.equals("1000000")){amountPersonalSumInsured=(Integer.parseInt(streditPASpinner)/1000)*0.4;
                                        } } } }

        return amountPersonalSumInsured;
    }
}
