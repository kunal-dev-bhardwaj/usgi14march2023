package com.universalsompo.meta.metaapp.health.fragment.buypolicy.newchi;


public class NewCHICalculation {
    static String Amount;
    static String ParentsAmount;

    public static String AdultOneChild(int selectYearAdult, String strSumInsured) {
        if (selectYearAdult >= 18 && (selectYearAdult <= 75)) {
            if (selectYearAdult >= 18 && (selectYearAdult <= 25)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "3490";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "4230";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "6070";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "6820";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "7630";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "8340";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "9330";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "9830";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "10830";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "12820";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "15090";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "15610";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "17440";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "17700";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "18760";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "19520";
                }
            }
            else if (selectYearAdult >= 26 && (selectYearAdult <= 30)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "3600";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "4360";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "6270";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "7040";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "7860";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "8610";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "9640";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "10160";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "11200";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "13270";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "15570";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "16120";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "17970";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "18240";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "19320";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "20110";
                }
            }
            else if (selectYearAdult >= 31 && (selectYearAdult <= 35)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "3760";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "4560";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "6560";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "7380";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "8200";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "9020";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "10110";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "10660";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "11750";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "13930";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "16290";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "16870";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "18740";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "19030";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "20130";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "20920";
                }
            }
            else if (selectYearAdult >= 36 && (selectYearAdult <= 40)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "3950";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "4810";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "6910";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "7780";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "8650";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "9500";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "10670";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "11250";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "12410";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "14730";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "17180";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "17790";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "19700";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "20010";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "21140";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "21950";
                }
            }
            else if (selectYearAdult >= 41 && (selectYearAdult <= 45)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "4130";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "5040";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "7250";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "8180";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "9100";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "9980";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "11220";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "11830";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "13060";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "15520";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "18050";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "18690";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "20630";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "20950";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "22120";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "22940";
                }
            }
            else if (selectYearAdult >= 46 && (selectYearAdult <= 50)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "5420";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "6600";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "9280";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "10460";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "11650";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "12890";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "14680";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "15290";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "17130";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "20090";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "23130";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "23960";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "26120";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "26550";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "27910";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "28790";
                }
            }
            else if (selectYearAdult >= 51 && (selectYearAdult <= 55)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "6530";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "8020";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "11310";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "12800";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "14350";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "15770";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "17780";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "18780";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "20790";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "24820";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "28310";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "29360";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "31710";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "32250";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "33800";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "34800";
                }
            }
            else if (selectYearAdult >= 56 && (selectYearAdult <= 60)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "8350";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "10260";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "14580";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "16520";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "18530";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "20050";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "22640";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "23930";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "26510";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "31680";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "35860";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "37210";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "39800";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "40480";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "42290";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "43570";
                }
            }
            else if (selectYearAdult >= 61 && (selectYearAdult <= 65)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "11370";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "14110";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "19900";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "22640";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "25450";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "27810";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "31500";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "33350";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "37040";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "44420";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "49290";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "51200";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "54270";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "55230";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "57500";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "59060";
                }
            }
            else if (selectYearAdult >= 66 && (selectYearAdult <= 70)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "16010";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "21350";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "27540";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "30220";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "33960";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "37010";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "41930";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "44400";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "49320";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "59170";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "65270";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "67810";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "71200";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "72490";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "75270";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "76830";
                }
            }
            else if (selectYearAdult >= 71 && (selectYearAdult <= 75)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "23340";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "28210";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "36970";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "39690";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "44670";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "48140";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "54660";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "57920";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "64440";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "77480";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "85080";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "88440";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "91510";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "93190";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "95590";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "97520";
                }
            }
            else if (selectYearAdult >= 76) {
                if (strSumInsured.equals("100000")) {
                    Amount = "29100";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "33680";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "43650";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "46970";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "52900";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "56990";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "64780";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "68680";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "76470";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "92060";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "100800";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "104810";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "108210";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "110210";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "112940";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "115200";
                }
            }
          }
        return Amount;
        }
    public static String AdultTwoChild(int selectYearAdult, String strSumInsured) {
        if (selectYearAdult >= 18 && (selectYearAdult <= 75)) {
            if (selectYearAdult >= 18 && (selectYearAdult <= 25)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "5060";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "6120";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "8790";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "9860";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "11000";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "12220";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "13680";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "14410";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "15870";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "18790";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "22130";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "22890";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "25960";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "26350";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "27920";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "29060";
                }
            }
            else if (selectYearAdult >= 26 && (selectYearAdult <= 30)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "5160";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "6250";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "8970";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "10080";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "11220";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "12490";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "13990";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "14740";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "16230";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "19230";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "22600";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "23390";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "26480";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "26890";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "28480";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "29650";
                }
            }
            else if (selectYearAdult >= 31 && (selectYearAdult <= 35)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "5320";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "6450";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "9260";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "10400";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "11550";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "12890";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "14450";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "15220";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "16780";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "19880";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "23310";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "24130";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "27250";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "27670";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "29290";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "30460";
                }
            }
            else if (selectYearAdult >= 36 && (selectYearAdult <= 40)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "5530";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "6710";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "9640";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "10840";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "12050";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "13430";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "15060";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "15880";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "17510";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "20760";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "24300";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "25150";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "28330";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "28770";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "30430";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "31610";
                }
            }
            else if (selectYearAdult >= 41 && (selectYearAdult <= 45)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "5710";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "6940";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "9970";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "11230";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "12480";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "13910";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "15600";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "16450";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "18150";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "21540";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "25150";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "26040";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "29260";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "29720";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "31410";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "32600";
                }
            }
            else if (selectYearAdult >= 46 && (selectYearAdult <= 50)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "6690";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "8130";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "11430";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "12860";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "14300";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "15870";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "17980";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "18780";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "20940";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "24610";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "28510";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "29520";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "32920";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "33440";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "35250";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "36470";
                }
            }
            else if (selectYearAdult >= 51 && (selectYearAdult <= 55)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "7820";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "9560";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "13470";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "15210";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "17070";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "18770";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "21120";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "22300";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "24660";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "29360";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "33730";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "34970";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "38640";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "39270";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "41290";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "42650";
                }
            }
            else if (selectYearAdult >= 56 && (selectYearAdult <= 60)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "9260";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "11330";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "16110";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "18210";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "20440";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "22410";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "25250";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "26670";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "29510";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "35180";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "40130";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "41620";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "45570";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "46330";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "48580";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "50190";
                }
            }
            else if (selectYearAdult >= 61 && (selectYearAdult <= 65)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "12440";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "15360";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "21660";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "24580";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "27640";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "30250";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "34190";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "36170";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "40110";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "48000";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "54300";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "56360";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "61010";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "62070";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "64840";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "66740";
                }
            }
            else if (selectYearAdult >= 66 && (selectYearAdult <= 70)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "17440";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "22970";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "29980";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "33010";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "37100";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "40480";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "45790";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "48450";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "53760";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "64390";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "72320";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "75090";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "80330";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "81750";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "85130";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "87070";
                }
            }
            else if (selectYearAdult >= 71 && (selectYearAdult <= 75)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "25000";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "30230";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "39930";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "43080";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "48500";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "52860";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "59940";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "63480";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "70560";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "84720";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "94600";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "98290";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "103410";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "105270";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "108220";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "110590";
                }
            }
            else if (selectYearAdult >= 76) {
                if (strSumInsured.equals("100000")) {
                    Amount = "30900";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "35900";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "46900";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "50670";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "57070";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "62180";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "70600";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "74810";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "83220";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "100050";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "111330";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "115720";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "120110";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "122300";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "125570";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "128280";
                }
            }
        }
        return Amount;
    }
    public static String AdultThreeChild(int selectYearAdult, String strSumInsured) {
        if (selectYearAdult >= 18 && (selectYearAdult <= 75)) {
            if (selectYearAdult >= 18 && (selectYearAdult <= 25)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "6450";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "7790";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "11160";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "12530";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "13950";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "15530";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "17380";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "18300";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "20150";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "23850";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "28080";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "29050";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "32550";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "33050";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "35050";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "36530";
                }
            }
            else if (selectYearAdult >= 26 && (selectYearAdult <= 30)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "6540";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "7910";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "11340";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "12730";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "14160";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "15780";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "17670";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "18610";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "20490";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "24260";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "28540";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "29530";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "33050";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "33550";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "35580";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "37080";
                }
            }
            else if (selectYearAdult >= 31 && (selectYearAdult <= 35)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "6690";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "8100";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "11610";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "13040";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "14470";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "16170";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "18100";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "19070";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "21010";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "24890";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "29210";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "30230";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "33780";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "34290";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "36340";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "37840";
                }
            }
            else if (selectYearAdult >= 36 && (selectYearAdult <= 40)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "7010";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "8500";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "12200";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "13720";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "15230";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "17000";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "19050";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "20070";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "22120";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "26220";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "30740";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "31810";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "35450";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "35990";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "38110";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "39630";
                }
            }
            else if (selectYearAdult >= 41 && (selectYearAdult <= 45)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "7190";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "8730";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "12530";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "14090";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "15650";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "17460";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "19570";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "20630";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "22750";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "26980";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "31570";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "32670";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "36340";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "36900";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "39040";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "40580";
                }
            }
            else if (selectYearAdult >= 46 && (selectYearAdult <= 50)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "8090";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "9810";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "13990";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "15740";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "17480";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "19430";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "21960";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "22970";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "25550";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "30060";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "34950";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "36180";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "39980";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "40610";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "42880";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "44450";
                }
            }
            else if (selectYearAdult >= 51 && (selectYearAdult <= 55)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "9400";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "11470";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "16400";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "18500";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "20780";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "22840";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "25690";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "27110";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "29950";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "35630";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "41100";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "42590";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "46650";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "47400";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "49920";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "51650";
                }
            }
            else if (selectYearAdult >= 56 && (selectYearAdult <= 60)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "10980";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "13410";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "19100";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "21560";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "24210";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "26570";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "29900";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "31570";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "34900";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "41570";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "47650";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "49400";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "53670";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "54550";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "57320";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "59300";
                }
            }
            else if (selectYearAdult >= 61 && (selectYearAdult <= 65)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "13120";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "16130";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "23030";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "26090";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "29340";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "32150";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "36280";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "38350";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "42480";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "50750";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "57740";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "59900";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "64550";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "65650";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "68780";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "70980";
                }
            }
            else if (selectYearAdult >= 66 && (selectYearAdult <= 70)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "18210";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "23740";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "31610";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "34880";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "39210";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "42830";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "48390";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "51170";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "56720";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "67830";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "76610";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "79520";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "84700";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "86160";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "89960";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "92210";
                }
            }
                else if (selectYearAdult >= 71 && (selectYearAdult <= 75)) {
                    if (strSumInsured.equals("100000")) {
                        Amount = "25940";
                    } else if (strSumInsured.equals("200000")) {
                        Amount = "31370";
                    } else if (strSumInsured.equals("300000")) {
                        Amount = "42170";
                    } else if (strSumInsured.equals("400000")) {
                        Amount = "45670";
                    } else if (strSumInsured.equals("500000")) {
                        Amount = "51420";
                    } else if (strSumInsured.equals("600000")) {
                        Amount = "56100";
                    } else if (strSumInsured.equals("700000")) {
                        Amount = "63530";
                    } else if (strSumInsured.equals("800000")) {
                        Amount = "67250";
                    } else if (strSumInsured.equals("900000")) {
                        Amount = "74680";
                    } else if (strSumInsured.equals("1000000")) {
                        Amount = "89550";
                    } else if (strSumInsured.equals("1500000")) {
                        Amount = "100520";
                    } else if (strSumInsured.equals("2000000")) {
                        Amount = "104400";
                    } else if (strSumInsured.equals("2500000")) {
                        Amount = "110450";
                    } else if (strSumInsured.equals("3000000")) {
                        Amount = "112400";
                    } else if (strSumInsured.equals("4000000")) {
                        Amount = "117020";
                    } else if (strSumInsured.equals("5000000")) {
                        Amount = "119770";
                    }
                }
                else if (selectYearAdult >= 76) {
                    if (strSumInsured.equals("100000")) {
                        Amount = "32250";
                    } else if (strSumInsured.equals("200000")) {
                        Amount = "37590";
                    } else if (strSumInsured.equals("300000")) {
                        Amount = "49970";
                    } else if (strSumInsured.equals("400000")) {
                        Amount = "54170";
                    } else if (strSumInsured.equals("500000")) {
                        Amount = "61020";
                    } else if (strSumInsured.equals("600000")) {
                        Amount = "66540";
                    } else if (strSumInsured.equals("700000")) {
                        Amount = "75460";
                    } else if (strSumInsured.equals("800000")) {
                        Amount = "79920";
                    } else if (strSumInsured.equals("900000")) {
                        Amount = "88840";
                    } else if (strSumInsured.equals("1000000")) {
                        Amount = "106680";
                    } else if (strSumInsured.equals("1500000")) {
                        Amount = "119270";
                    } else if (strSumInsured.equals("2000000")) {
                        Amount = "123930";
                    } else if (strSumInsured.equals("2500000")) {
                        Amount = "130620";
                    } else if (strSumInsured.equals("3000000")) {
                        Amount = "132970";
                    } else if (strSumInsured.equals("4000000")) {
                        Amount = "138200";
                    } else if (strSumInsured.equals("5000000")) {
                        Amount = "141350";
                    }
                }

        }
        return Amount;
    }
    public static String AdultFourChild(int selectYearAdult, String strSumInsured) {
        if (selectYearAdult >= 18 && (selectYearAdult <= 75)) {
            if (selectYearAdult >= 18 && (selectYearAdult <= 25)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "7810";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "9430";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "13510";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "15150";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "16850";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "18780";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "21010";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "22120";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "24350";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "28810";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "33940";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "35110";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "39400";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "40000";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "42440";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "44260";
                }
            }
            else if (selectYearAdult >= 26 && (selectYearAdult <= 30)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "7900";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "9540";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "13680";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "15350";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "17060";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "19030";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "21290";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "22420";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "24690";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "29220";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "34380";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "35570";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "39880";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "40490";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "42950";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "44800";
                }
            }
            else if (selectYearAdult >= 31 && (selectYearAdult <= 35)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "8040";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "9730";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "13940";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "15650";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "17360";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "19400";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "21710";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "22870";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "25190";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "29830";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "35040";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "36250";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "40590";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "41200";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "43690";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "45540";
                }
            }
            else if (selectYearAdult >= 36 && (selectYearAdult <= 40)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "8410";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "10180";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "14610";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "16410";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "18210";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "20330";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "22780";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "24000";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "26440";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "31320";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "36750";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "38030";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "42470";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "43120";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "45690";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "47560";
                }
            }
            else if (selectYearAdult >= 41 && (selectYearAdult <= 45)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "8580";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "10400";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "14920";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "16770";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "18620";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "20780";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "23280";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "24540";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "27040";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "32060";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "37560";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "38870";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "43340";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "44000";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "46600";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "48490";
                }
            }
            else if (selectYearAdult >= 46 && (selectYearAdult <= 50)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "9490";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "11490";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "16390";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "18420";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "20450";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "22770";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "25680";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "26890";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "29850";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "35150";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "40970";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "42410";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "47010";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "47740";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "50470";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "52390";
                }
            }
            else if (selectYearAdult >= 51 && (selectYearAdult <= 55)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "10890";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "13260";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "18960";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "21370";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "24020";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "26420";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "29680";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "31310";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "34570";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "41100";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "47550";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "49260";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "54160";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "55020";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "58020";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "60120";
                }
            }
            else if (selectYearAdult >= 56 && (selectYearAdult <= 60)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "12480";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "15220";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "21690";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "24470";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "27490";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "30180";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "33940";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "35820";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "39580";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "47100";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "54180";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "56150";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "61280";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "62270";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "65520";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "67880";
                }
            }
            else if (selectYearAdult >= 61 && (selectYearAdult <= 65)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "14580";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "17890";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "25570";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "28930";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "32530";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "35680";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "40220";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "42500";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "47040";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "56130";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "64110";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "66500";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "72000";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "73210";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "76830";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "79390";
                }
            }
            else if (selectYearAdult >= 66 && (selectYearAdult <= 70)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "19120";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "24710";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "33140";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "36630";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "41170";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "45030";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "50810";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "53710";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "59490";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "71050";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "80600";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "83630";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "89580";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "91110";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "95320";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "97890";
                }
            }
            else if (selectYearAdult >= 71 && (selectYearAdult <= 75)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "26650";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "32220";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "43540";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "47310";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "53260";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "58170";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "65800";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "69620";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "77250";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "92520";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "104300";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "108299";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "115150";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "117160";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "122210";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "125270";
                }
            }
            else if (selectYearAdult >= 76) {
                if (strSumInsured.equals("100000")) {
                    Amount = "33080";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "38670";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "51700";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "56200";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "63310";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "69090";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "78270";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "82870";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "92050";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "110420";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "123960";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "128750";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "136310";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "138730";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "144460";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "147930";
                }
            }

        }
        return Amount;
    }
    public static String TwoAdult(int selectYearAdult, String strSumInsured) {
        if (selectYearAdult >= 18 && (selectYearAdult <= 75)) {
            if (selectYearAdult >= 18 && (selectYearAdult <= 25)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "3910";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "4750";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "6750";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "7580";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "8550";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "9400";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "10530";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "11100";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "12230";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "14500";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "17030";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "17630";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "19330";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "19630";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "20510";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "21310";
                }
            }
            else if (selectYearAdult >= 26 && (selectYearAdult <= 30)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "4140";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "5040";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "7170";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "8070";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "9060";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "10000";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "11210";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "11820";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "13040";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "15470";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "18090";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "18740";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "20480";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "20800";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "21710";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "22570";
                }
            }
            else if (selectYearAdult >= 31 && (selectYearAdult <= 35)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "4490";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "5490";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "7800";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "8800";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "9790";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "10900";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "12240";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "12920";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "14260";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "16950";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "19680";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "20390";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "22150";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "22500";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "23440";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "24300";
                }
            }
            else if (selectYearAdult >= 36 && (selectYearAdult <= 40)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "4800";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "5880";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "8360";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "9430";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "10510";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "11680";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "13140";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "13870";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "15330";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "18250";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "21100";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "21870";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "23660";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "24040";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "25000";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "25880";
                }
            }
            else if (selectYearAdult >= 41 && (selectYearAdult <= 45)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "5200";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "6390";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "9090";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "10280";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "11470";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "12730";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "14340";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "15140";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "16750";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "19970";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "22980";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "23820";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "25650";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "26070";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "27070";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "27970";
                }
            }
            else if (selectYearAdult >= 46 && (selectYearAdult <= 50)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "6970";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "8510";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "11910";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "13450";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "15000";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "16520";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "18990";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "19650";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "22210";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "25910";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "29440";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "30530";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "32490";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "33030";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "34150";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "35110";
                }
            }
            else if (selectYearAdult >= 51 && (selectYearAdult <= 55)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "8840";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "10900";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "15310";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "17360";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "19420";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "21340";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "24120";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "25510";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "28300";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "33860";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "38140";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "39600";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "41730";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "42450";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "43760";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "44900";
                }
            }
            else if (selectYearAdult >= 56 && (selectYearAdult <= 60)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "11650";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "14350";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "20020";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "22720";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "25420";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "27830";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "31480";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "33300";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "36950";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "44240";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "49470";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "51380";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "53670";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "54620";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "56150";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "57760";
                }
            }
            else if (selectYearAdult >= 61 && (selectYearAdult <= 65)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "15870";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "19730";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "27690";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "31550";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "35410";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "38710";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "43930";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "46540";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "51750";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "62190";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "69120";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "71840";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "74540";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "75910";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "77840";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "79870";
                }
            }
            else if (selectYearAdult >= 66 && (selectYearAdult <= 70)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "22590";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "30420";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "38460";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "41980";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "47070";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "51320";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "58200";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "61640";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "68510";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "82270";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "91000";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "94590";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "97310";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "99100";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "101470";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "103270";
                }
            }
            else if (selectYearAdult >= 71 && (selectYearAdult <= 75)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "33350";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "40150";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "51900";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "55340";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "62180";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "67790";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "77030";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "81650";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "90900";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "109390";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "120670";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "125500";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "128830";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "131240";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "134230";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "136650";
                }
            }
            else if (selectYearAdult >= 76) {
                if (strSumInsured.equals("100000")) {
                    Amount = "42390";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "48750";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "62400";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "66770";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "75100";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "81880";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "93140";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "98780";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "110050";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "132580";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "146020";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "151900";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "155770";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "158710";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "162230";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "165170";
                }
            }

        }
        return Amount;
    }
    public static String TwoAdultOneChild(int selectYearAdult, String strSumInsured) {
        if (selectYearAdult >= 18 && (selectYearAdult <= 75)) {
            if (selectYearAdult >= 18 && (selectYearAdult <= 25)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "4860";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "5870";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "8420";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "9450";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "10590";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "11710";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "13110";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "13810";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "15210";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "18010";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "21170";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "21900";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "24520";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "24890";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "26400";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "27530";
                }
            }
            else if (selectYearAdult >= 26 && (selectYearAdult <= 30)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "5040";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "6110";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "8770";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "9850";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "11010";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "12220";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "13680";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "14420";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "15890";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "18820";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "22060";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "22840";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "25500";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "25890";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "27440";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "28620";
                }
            }
            else if (selectYearAdult >= 31 && (selectYearAdult <= 35)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "5330";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "6480";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "9300";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "10460";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "11630";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "12970";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "14550";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "15330";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "16910";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "20060";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "23390";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "24220";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "26930";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "27350";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "28940";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "30120";
                }
            }
            else if (selectYearAdult >= 36 && (selectYearAdult <= 40)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "5750";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "7000";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "10060";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "11340";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "12610";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "14050";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "15770";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "16630";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "18360";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "21810";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "25360";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "26260";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "29060";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "29520";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "31190";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "32400";
                }
            }
            else if (selectYearAdult >= 41 && (selectYearAdult <= 45)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "6100";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "7440";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "10700";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "12070";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "13440";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "14950";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "16810";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "17730";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "19590";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "23300";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "26990";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "27960";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "30820";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "31310";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "33040";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "34270";
                }
            }
            else if (selectYearAdult >= 46 && (selectYearAdult <= 50)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "7880";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "9580";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "13580";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "15310";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "17040";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "18840";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "21510";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "22340";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "25110";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "29360";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "33630";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "34850";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "37960";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "38580";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "40550";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "41840";
                }
            }
            else if (selectYearAdult >= 51 && (selectYearAdult <= 55)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "9730";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "11940";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "16990";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "19230";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "21530";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "23680";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "26710";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "28230";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "31260";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "37320";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "42380";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "43970";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "47410";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "48210";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "50510";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "52000";
                }
            }
            else if (selectYearAdult >= 56 && (selectYearAdult <= 60)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "12620";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "15480";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "21900";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "24810";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "27770";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "30440";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "34370";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "36330";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "40260";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "48120";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "54210";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "56260";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "60060";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "61100";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "63820";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "65800";
                }
            }
            else if (selectYearAdult >= 61 && (selectYearAdult <= 65)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "16940";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "20980";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "29850";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "33960";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "38120";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "41720";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "47270";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "50040";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "55590";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "66680";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "74580";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "77480";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "82020";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "83480";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "86950";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "89350";
                }
            }
            else if (selectYearAdult >= 66 && (selectYearAdult <= 70)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "23350";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "31140";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "40220";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "44000";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "49350";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "53860";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "61000";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "64570";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "71710";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "85990";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "95630";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "99360";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "104190";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "106080";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "110270";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "112440";
                }
            }
            else if (selectYearAdult >= 71 && (selectYearAdult <= 75)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "34410";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "41440";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "54550";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "58360";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "65580";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "71540";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "81220";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "86060";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "95740";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "115100";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "127500";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "132550";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "138500";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "141060";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "146380";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "149230";
                }
            }
            else if (selectYearAdult >= 76) {
                if (strSumInsured.equals("100000")) {
                    Amount = "43210";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "49790";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "64910";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "69630";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "78330";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "85440";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "97120";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "102950";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "114630";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "137980";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "152510";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "158610";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "165430";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "168520";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "174750";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "178130";
                }
            }

        }
        return Amount;
    }
    public static String TwoAdultTwoChild(int selectYearAdult, String strSumInsured) {
        if (selectYearAdult >= 18 && (selectYearAdult <= 75)) {
            if (selectYearAdult >= 18 && (selectYearAdult <= 25)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "6240";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "7530";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "10800";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "12110";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "13540";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "15020";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "16800";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "17700";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "19480";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "23050";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "27120";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "28060";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "31480";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "31950";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "33900";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "35380";
                }
            }
            else if (selectYearAdult >= 26 && (selectYearAdult <= 30)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "6240";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "7760";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "11140";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "12500";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "13940";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "15500";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "17360";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "18280";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "20140";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "23840";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "27980";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "28960";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "32430";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "32920";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "34910";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "36440";
                }
            }
            else if (selectYearAdult >= 31 && (selectYearAdult <= 35)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "6700";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "8120";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "11650";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "13090";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "14540";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "16230";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "18190";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "19170";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "21130";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "25040";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "29280";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "30300";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "33810";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "34330";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "36370";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "37890";
                }
            }
            else if (selectYearAdult >= 36 && (selectYearAdult <= 40)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "7160";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "8690";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "12480";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "14040";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "15610";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "17400";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "19520";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "20580";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "22700";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "26940";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "31410";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "32530";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "36140";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "36700";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "38830";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "40380";
                }
            }
            else if (selectYearAdult >= 41 && (selectYearAdult <= 45)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "7490";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "9120";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "13100";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "14750";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "16410";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "18280";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "20520";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "21650";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "23890";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "28380";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "33000";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "34170";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "37840";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "38440";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "40620";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "42200";
                }
            }
            else if (selectYearAdult >= 46 && (selectYearAdult <= 50)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "9290";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "11270";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "15990";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "18010";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "20030";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "22190";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "25250";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "26280";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "29420";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "34470";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "39690";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "41120";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "45050";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "45780";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "48210";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "49850";
                }
            }
            else if (selectYearAdult >= 51 && (selectYearAdult <= 55)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "11180";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "13680";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "19490";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "22030";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "24690";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "27160";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "30600";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "32320";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "35760";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "42630";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "48660";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "50460";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "54750";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "55660";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "58440";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "60290";
                }
            }
            else if (selectYearAdult >= 56 && (selectYearAdult <= 60)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "14050";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "17200";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "24370";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "27570";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "30890";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "33880";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "38210";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "40370";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "44700";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "53360";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "60430";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "62690";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "67340";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "68490";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "71700";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "74030";
                }
            }
            else if (selectYearAdult >= 61 && (selectYearAdult <= 65)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "18300";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "22610";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "32200";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "36580";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "41080";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "44980";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "50900";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "53860";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "59780";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "71620";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "80500";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "83600";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "88990";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "90560";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "94510";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "97270";
                }
            }
            else if (selectYearAdult >= 66 && (selectYearAdult <= 70)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "24560";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "32510";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "42310";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "46370";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "52010";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "56810";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "64280";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "68010";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "75480";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "90420";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "100990";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "104900";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "110570";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "112550";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "117220";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "119730";
                }
            }
            else if (selectYearAdult >= 71 && (selectYearAdult <= 75)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "35840";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "43170";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "57120";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "61280";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "68870";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "75180";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "85270";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "90320";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "100420";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "120620";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "134100";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "139370";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "146230";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "148900";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "154740";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "157960";
                }
            }
            else if (selectYearAdult >= 76) {
                if (strSumInsured.equals("100000")) {
                    Amount = "44520";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "51410";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "67330";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "72390";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "81440";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "88880";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "100950";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "106990";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "119050";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "143190";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "158770";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "165080";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "172800";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "176000";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "182730";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "186480";
                }
            }

        }
        return Amount;
    }
    public static String TwoAdultThreeChild(int selectYearAdult, String strSumInsured) {
        if (selectYearAdult >= 18 && (selectYearAdult <= 75)) {
            if (selectYearAdult >= 18 && (selectYearAdult <= 25)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "7420";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "8940";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "12800";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "14350";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "16010";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "17790";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "19900";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "20960";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "23060";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "27280";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "32100";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "33210";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "37360";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "37920";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "40260";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "42060";
                }
            }
            else if (selectYearAdult >= 26 && (selectYearAdult <= 30)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "7590";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "9160";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "13120";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "14720";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "16390";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "18250";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "20430";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "21510";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "23690";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "28030";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "32920";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "34070";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "38260";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "38840";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "41220";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "43070";
                }
            }
            else if (selectYearAdult >= 31 && (selectYearAdult <= 35)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "7850";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "9500";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "13160";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "15280";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "16960";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "18950";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "21220";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "22360";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "24630";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "29170";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "34150";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "35340";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "39570";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "40180";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "42610";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "44460";
                }
            }
            else if (selectYearAdult >= 36 && (selectYearAdult <= 40)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "8470";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "10270";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "14730";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "16560";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "18390";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "20530";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "23010";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "25250";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "26740";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "31700";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "37040";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "38350";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "42740";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "43400";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "45960";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "47860";
                }
            }
            else if (selectYearAdult >= 41 && (selectYearAdult <= 45)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "8790";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "10680";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "15330";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "17250";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "19170";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "21370";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "23980";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "25280";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "27890";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "33100";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "38570";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "39940";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "44390";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "45080";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "47700";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "49610";
                }
            }
            else if (selectYearAdult >= 46 && (selectYearAdult <= 50)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "10450";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "12650";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "17970";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "20210";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "22460";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "24930";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "28280";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "29490";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "32920";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "38620";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "44620";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "46210";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "50900";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "51710";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "54540";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "56510";
                }
            }
            else if (selectYearAdult >= 51 && (selectYearAdult <= 55)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "12530";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "15300";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "21820";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "24630";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "27620";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "30390";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "34210";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "36120";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "39930";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "47560";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "54500";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "56500";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "61590";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "62610";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "65840";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "68040";
                }
            }
            else if (selectYearAdult >= 56 && (selectYearAdult <= 60)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "15600";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "19070";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "27050";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "30580";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "34280";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "37610";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "42380";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "44760";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "49530";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "59070";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "67180";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "69680";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "75200";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "76460";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "80170";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "82870";
                }
            }
            else if (selectYearAdult >= 61 && (selectYearAdult <= 65)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "19570";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "24130";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "34370";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "39000";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "43810";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "48000";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "54270";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "57400";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "63660";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "76180";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "85970";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "89250";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "95470";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "97130";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "101540";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "104640";
                }
            }
            else if (selectYearAdult >= 66 && (selectYearAdult <= 70)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "25670";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "33760";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "44210";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "48540";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "54450";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "59520";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "67290";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "71170";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "78930";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "94470";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "105910";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "109970";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "116460";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "118520";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "123640";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "126480";
                }
            }
            else if (selectYearAdult >= 71 && (selectYearAdult <= 75)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "36740";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "44250";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "58790";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "63230";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "71070";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "77620";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "87980";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "93150";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "103510";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "124220";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "138560";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "143970";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "151650";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "154390";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "160680";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "164220";
                }
            }
            else if (selectYearAdult >= 76) {
                if (strSumInsured.equals("100000")) {
                    Amount = "45160";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "52250";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "68710";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "74030";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "83280";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "90950";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "103220";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "109350";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "121620";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "146160";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "162550";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "168970";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "177510";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "180760";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "187930";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "191980";
                }
            }

        }
        return Amount;
    }
    public static String TwoAdultFourChild(int selectYearAdult, String strSumInsured) {
        if (selectYearAdult >= 18 && (selectYearAdult <= 75)) {
            if (selectYearAdult >= 18 && (selectYearAdult <= 25)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "8590";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "10350";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "14800";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "16590";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "18480";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "20580";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "23010";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "24220";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "26660";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "31520";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "37090";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "38370";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "43240";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "43890";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "46630";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "48760";
                }
            }
            else if (selectYearAdult >= 26 && (selectYearAdult <= 30)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "8760";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "10560";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "15110";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "16950";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "18850";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "21020";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "23520";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "24760";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "27260";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "32250";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "37880";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "39200";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "44120";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "44780";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "47560";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "49740";
                }
            }
            else if (selectYearAdult >= 31 && (selectYearAdult <= 35)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "9010";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "10890";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "15590";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "17490";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "19400";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "21690";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "24280";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "25570";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "28160";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "33340";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "39070";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "40430";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "45390";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "46080";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "48900";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "51080";
                }
            }
            else if (selectYearAdult >= 36 && (selectYearAdult <= 40)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "9690";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "11730";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "16820";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "18890";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "20970";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "23420";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "26240";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "27650";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "30470";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "36110";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "42250";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "43730";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "48870";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "49620";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "52590";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "54820";
                }
            }
            else if (selectYearAdult >= 41 && (selectYearAdult <= 45)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "10000";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "12130";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "17390";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "19560";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "21720";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "24240";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "27180";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "28650";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "31590";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "37460";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "43730";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "45270";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "50460";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "51250";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "54270";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "56520";
                }
            }
            else if (selectYearAdult >= 46 && (selectYearAdult <= 50)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "11640";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "14090";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "20010";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "22500";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "24980";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "27760";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "31430";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "32810";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "36560";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "42920";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "49720";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "51490";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "56920";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "57820";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "61070";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "63360";
                }
            }
            else if (selectYearAdult >= 51 && (selectYearAdult <= 55)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "13790";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "16810";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "23970";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "27040";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "30330";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "33380";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "37550";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "39630";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "43790";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "52110";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "59880";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "62070";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "67940";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "69050";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "72710";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "75260";
                }
            }
            else if (selectYearAdult >= 56 && (selectYearAdult <= 60)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "16870";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "20580";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "29220";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "33000";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "37000";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "40620";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "45740";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "48290";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "53410";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "63640";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "72610";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "75290";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "81610";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "82970";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "87120";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "90170";
                }
            }
            else if (selectYearAdult >= 61 && (selectYearAdult <= 65)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "20740";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "25520";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "36370";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "41230";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "46310";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "50780";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "57350";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "60640";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "67210";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "80360";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "90990";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "94440";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "101450";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "103190";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "108040";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "111490";
                }
            }
            else if (selectYearAdult >= 66 && (selectYearAdult <= 70)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "26690";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "34900";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "45950";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "50510";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "56670";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "61990";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "70020";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "74040";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "82070";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "98130";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "110370";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "114580";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "121850";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "123980";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "129530";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "132700";
                }
            }
            else if (selectYearAdult >= 71 && (selectYearAdult <= 75)) {
                if (strSumInsured.equals("100000")) {
                    Amount = "38050";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "45840";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "61140";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "65900";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "74080";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "80950";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "91690";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "97050";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "107790";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "129260";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "144600";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "150210";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "158760";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "161600";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "168380";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "172280";
                }
            }
            else if (selectYearAdult >= 76) {
                if (strSumInsured.equals("100000")) {
                    Amount = "46360";
                } else if (strSumInsured.equals("200000")) {
                    Amount = "53720";
                } else if (strSumInsured.equals("300000")) {
                    Amount = "70910";
                } else if (strSumInsured.equals("400000")) {
                    Amount = "76540";
                } else if (strSumInsured.equals("500000")) {
                    Amount = "86120";
                } else if (strSumInsured.equals("600000")) {
                    Amount = "94090";
                } else if (strSumInsured.equals("700000")) {
                    Amount = "106710";
                } else if (strSumInsured.equals("800000")) {
                    Amount = "113020";
                } else if (strSumInsured.equals("900000")) {
                    Amount = "125640";
                } else if (strSumInsured.equals("1000000")) {
                    Amount = "150890";
                } else if (strSumInsured.equals("1500000")) {
                    Amount = "168260";
                } else if (strSumInsured.equals("2000000")) {
                    Amount = "174860";
                } else if (strSumInsured.equals("2500000")) {
                    Amount = "184260";
                } else if (strSumInsured.equals("3000000")) {
                    Amount = "187600";
                } else if (strSumInsured.equals("4000000")) {
                    Amount = "195260";
                } else if (strSumInsured.equals("5000000")) {
                    Amount = "199660";
                }
            }

        }
        return Amount;
    }
    public static String ParentsMother(int selectYearAdult, String strSumInsured) {
        if (selectYearAdult >= 36 && (selectYearAdult <= 75)) {
             if (selectYearAdult >= 36 && (selectYearAdult <= 40)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "2730";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "3360";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "4800";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "5430";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "6060";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "6650";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "7490";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "7910";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "8740";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "10420";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "11930";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "12360";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "13310";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "13520";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "14070";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "14500";
                }
            }
            else if (selectYearAdult >= 41 && (selectYearAdult <= 45)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "2970";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "3660";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "5230";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "5920";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "6620";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "7250";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "8170";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "8640";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "9560";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "11410";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "12990";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "13470";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "14440";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "14670";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "15240";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "15680";
                }
            }
            else if (selectYearAdult >= 46 && (selectYearAdult <= 50)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "3920";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "4820";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "6790";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "7690";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "8590";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "9360";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "10770";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "11150";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "12630";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "14750";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "16590";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "17200";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "18240";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "18550";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "19190";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "19670";
                }
            }
            else if (selectYearAdult >= 51 && (selectYearAdult <= 55)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "5010";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "6200";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "8770";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "9970";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "11170";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "12120";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "13720";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "14520";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "16120";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "19310";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "21520";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "22340";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "23480";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "23890";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "24630";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "25220";
                }
            }
            else if (selectYearAdult >= 56 && (selectYearAdult <= 60)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "6570";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "8140";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "11440";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "13010";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "14580";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "15780";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "17870";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "18920";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "21020";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "25210";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "27870";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "28950";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "30190";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "30730";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "31590";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "32410";
                }
            }
            else if (selectYearAdult >= 61 && (selectYearAdult <= 65)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "9020";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "11270";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "15910";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "18150";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "20400";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "22030";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "25030";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "26520";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "29520";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "35510";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "39000";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "40550";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "42020";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "42790";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "43890";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "44940";
                }
            }
            else if (selectYearAdult >= 66 && (selectYearAdult <= 70)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "12770";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "17330";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "22010";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "24060";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "27020";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "29110";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "33060";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "35030";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "38980";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "46880";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "51250";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "53280";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "54820";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "55840";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "57180";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "58200";
                }
            }
            else if (selectYearAdult >= 71 && (selectYearAdult <= 75)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "19030";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "22990";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "29830";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "31830";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "35820";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "38570";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "43880";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "46530";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "51840";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "62460";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "68060";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "70800";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "72690";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "74050";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "75750";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "77110";
                }
            }
            else if (selectYearAdult >= 76) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "24300";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "27990";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "35940";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "38490";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "43340";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "46660";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "53130";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "56370";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "62840";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "75780";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "82430";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "85760";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "87950";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "89620";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "91610";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "93280";
                }
            }

        }
        return ParentsAmount;
    }
    public static String ParentsFather(int selectYearAdult, String strSumInsured) {
        if (selectYearAdult >= 36 && (selectYearAdult <= 75)) {
            if (selectYearAdult >= 36 && (selectYearAdult <= 40)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "2730";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "3360";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "4800";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "5430";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "6060";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "6650";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "7490";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "7910";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "8740";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "10420";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "11930";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "12360";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "13310";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "13520";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "14070";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "14500";
                }
            }
            else if (selectYearAdult >= 41 && (selectYearAdult <= 45)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "2970";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "3660";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "5230";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "5920";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "6620";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "7250";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "8170";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "8640";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "9560";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "11410";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "12990";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "13470";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "14440";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "14670";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "15240";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "15680";
                }
            }
            else if (selectYearAdult >= 46 && (selectYearAdult <= 50)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "3920";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "4820";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "6790";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "7690";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "8590";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "9360";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "10770";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "11150";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "12630";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "14750";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "16590";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "17200";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "18240";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "18550";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "19190";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "19670";
                }
            }
            else if (selectYearAdult >= 51 && (selectYearAdult <= 55)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "5010";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "6200";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "8770";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "9970";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "11170";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "12120";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "13720";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "14520";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "16120";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "19310";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "21520";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "22340";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "23480";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "23890";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "24630";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "25220";
                }
            }
            else if (selectYearAdult >= 56 && (selectYearAdult <= 60)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "6570";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "8140";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "11440";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "13010";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "14580";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "15780";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "17870";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "18920";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "21020";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "25210";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "27870";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "28950";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "30190";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "30730";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "31590";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "32410";
                }
            }
            else if (selectYearAdult >= 61 && (selectYearAdult <= 65)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "9020";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "11270";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "15910";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "18150";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "20400";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "22030";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "25030";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "26520";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "29520";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "35510";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "39000";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "40550";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "42020";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "42790";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "43890";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "44940";
                }
            }
            else if (selectYearAdult >= 66 && (selectYearAdult <= 70)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "12770";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "17330";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "22010";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "24060";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "27020";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "29110";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "33060";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "35030";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "38980";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "46880";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "51250";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "53280";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "54820";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "55840";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "57180";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "58200";
                }
            }
            else if (selectYearAdult >= 71 && (selectYearAdult <= 75)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "19030";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "22990";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "29830";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "31830";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "35820";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "38570";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "43880";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "46530";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "51840";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "62460";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "68060";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "70800";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "72690";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "74050";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "75750";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "77110";
                }
            }
            else if (selectYearAdult >= 76) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "24300";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "27990";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "35940";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "38490";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "43340";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "46660";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "53130";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "56370";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "62840";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "75780";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "82430";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "85760";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "87950";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "89620";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "91610";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "93280";
                }
            }

        }
        return ParentsAmount;
    }
    public static String ParentsMotherInLaw(int selectYearAdult, String strSumInsured) {
        if (selectYearAdult >= 36 && (selectYearAdult <= 75)) {
            if (selectYearAdult >= 36 && (selectYearAdult <= 40)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "2730";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "3360";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "4800";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "5430";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "6060";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "6650";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "7490";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "7910";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "8740";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "10420";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "11930";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "12360";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "13310";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "13520";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "14070";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "14500";
                }
            }
            else if (selectYearAdult >= 41 && (selectYearAdult <= 45)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "2970";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "3660";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "5230";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "5920";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "6620";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "7250";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "8170";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "8640";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "9560";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "11410";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "12990";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "13470";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "14440";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "14670";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "15240";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "15680";
                }
            }
            else if (selectYearAdult >= 46 && (selectYearAdult <= 50)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "3920";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "4820";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "6790";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "7690";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "8590";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "9360";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "10770";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "11150";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "12630";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "14750";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "16590";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "17200";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "18240";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "18550";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "19190";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "19670";
                }
            }
            else if (selectYearAdult >= 51 && (selectYearAdult <= 55)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "5010";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "6200";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "8770";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "9970";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "11170";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "12120";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "13720";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "14520";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "16120";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "19310";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "21520";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "22340";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "23480";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "23890";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "24630";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "25220";
                }
            }
            else if (selectYearAdult >= 56 && (selectYearAdult <= 60)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "6570";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "8140";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "11440";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "13010";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "14580";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "15780";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "17870";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "18920";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "21020";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "25210";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "27870";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "28950";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "30190";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "30730";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "31590";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "32410";
                }
            }
            else if (selectYearAdult >= 61 && (selectYearAdult <= 65)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "9020";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "11270";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "15910";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "18150";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "20400";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "22030";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "25030";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "26520";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "29520";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "35510";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "39000";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "40550";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "42020";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "42790";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "43890";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "44940";
                }
            }
            else if (selectYearAdult >= 66 && (selectYearAdult <= 70)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "12770";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "17330";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "22010";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "24060";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "27020";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "29110";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "33060";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "35030";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "38980";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "46880";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "51250";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "53280";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "54820";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "55840";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "57180";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "58200";
                }
            }
            else if (selectYearAdult >= 71 && (selectYearAdult <= 75)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "19030";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "22990";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "29830";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "31830";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "35820";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "38570";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "43880";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "46530";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "51840";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "62460";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "68060";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "70800";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "72690";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "74050";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "75750";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "77110";
                }
            }
            else if (selectYearAdult >= 76) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "24300";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "27990";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "35940";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "38490";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "43340";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "46660";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "53130";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "56370";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "62840";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "75780";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "82430";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "85760";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "87950";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "89620";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "91610";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "93280";
                }
            }

        }
        return ParentsAmount;
    }
    public static String ParentsFatherInLaw(int selectYearAdult, String strSumInsured) {
        if (selectYearAdult >= 36 && (selectYearAdult <= 75)) {
            if (selectYearAdult >= 36 && (selectYearAdult <= 40)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "2730";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "3360";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "4800";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "5430";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "6060";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "6650";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "7490";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "7910";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "8740";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "10420";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "11930";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "12360";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "13310";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "13520";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "14070";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "14500";
                }
            }
            else if (selectYearAdult >= 41 && (selectYearAdult <= 45)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "2970";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "3660";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "5230";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "5920";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "6620";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "7250";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "8170";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "8640";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "9560";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "11410";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "12990";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "13470";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "14440";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "14670";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "15240";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "15680";
                }
            }
            else if (selectYearAdult >= 46 && (selectYearAdult <= 50)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "3920";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "4820";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "6790";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "7690";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "8590";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "9360";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "10770";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "11150";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "12630";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "14750";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "16590";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "17200";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "18240";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "18550";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "19190";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "19670";
                }
            }
            else if (selectYearAdult >= 51 && (selectYearAdult <= 55)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "5010";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "6200";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "8770";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "9970";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "11170";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "12120";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "13720";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "14520";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "16120";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "19310";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "21520";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "22340";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "23480";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "23890";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "24630";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "25220";
                }
            }
            else if (selectYearAdult >= 56 && (selectYearAdult <= 60)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "6570";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "8140";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "11440";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "13010";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "14580";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "15780";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "17870";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "18920";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "21020";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "25210";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "27870";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "28950";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "30190";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "30730";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "31590";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "32410";
                }
            }
            else if (selectYearAdult >= 61 && (selectYearAdult <= 65)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "9020";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "11270";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "15910";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "18150";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "20400";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "22030";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "25030";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "26520";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "29520";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "35510";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "39000";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "40550";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "42020";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "42790";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "43890";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "44940";
                }
            }
            else if (selectYearAdult >= 66 && (selectYearAdult <= 70)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "12770";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "17330";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "22010";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "24060";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "27020";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "29110";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "33060";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "35030";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "38980";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "46880";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "51250";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "53280";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "54820";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "55840";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "57180";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "58200";
                }
            }
            else if (selectYearAdult >= 71 && (selectYearAdult <= 75)) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "19030";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "22990";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "29830";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "31830";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "35820";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "38570";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "43880";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "46530";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "51840";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "62460";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "68060";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "70800";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "72690";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "74050";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "75750";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "77110";
                }
            }
            else if (selectYearAdult >= 76) {
                if (strSumInsured.equals("100000")) {
                    ParentsAmount = "24300";
                } else if (strSumInsured.equals("200000")) {
                    ParentsAmount = "27990";
                } else if (strSumInsured.equals("300000")) {
                    ParentsAmount = "35940";
                } else if (strSumInsured.equals("400000")) {
                    ParentsAmount = "38490";
                } else if (strSumInsured.equals("500000")) {
                    ParentsAmount = "43340";
                } else if (strSumInsured.equals("600000")) {
                    ParentsAmount = "46660";
                } else if (strSumInsured.equals("700000")) {
                    ParentsAmount = "53130";
                } else if (strSumInsured.equals("800000")) {
                    ParentsAmount = "56370";
                } else if (strSumInsured.equals("900000")) {
                    ParentsAmount = "62840";
                } else if (strSumInsured.equals("1000000")) {
                    ParentsAmount = "75780";
                } else if (strSumInsured.equals("1500000")) {
                    ParentsAmount = "82430";
                } else if (strSumInsured.equals("2000000")) {
                    ParentsAmount = "85760";
                } else if (strSumInsured.equals("2500000")) {
                    ParentsAmount = "87950";
                } else if (strSumInsured.equals("3000000")) {
                    ParentsAmount = "89620";
                } else if (strSumInsured.equals("4000000")) {
                    ParentsAmount = "91610";
                } else if (strSumInsured.equals("5000000")) {
                    ParentsAmount = "93280";
                }
            }

        }
        return ParentsAmount;
    }


}

