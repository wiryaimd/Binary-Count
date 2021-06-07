package com.wiryaimd.binarycount.util;

public class CountHelper {

    public static char[] hex = {'a', 'b', 'c', 'd', 'e', 'f'};

    public static String fromDecimal(int val, int radiks){

        StringBuilder sb = new StringBuilder();
        int count = val;

        for (int i = count; count > 0; count /= radiks){
            int sisa = count % radiks;
            if (sisa > 9 && radiks == 16) {
                for (int j = 10; j < hex.length + 10; j++){
                    if (sisa == j){
                        sb.append(hex[j - 10]);
                    }
                }
            }else{
                sb.append(sisa);
            }
        }

        return sb.reverse().toString();
    }

    public static int toDecimal(String val, int radiks){

        int desimal = 0;
        for (int i = 0; i < val.length(); i++){
            int value = 0;
            if (radiks == 16){
                boolean isAvailable = false;
                sloop: for (int j = 10; j < hex.length + 10; j++){
                    if (val.charAt(i) == hex[j - 10]){
                        value = j;
                        isAvailable = true;
                    }
                }
                if (!isAvailable) {
                    value = Integer.parseInt(String.valueOf(val.charAt(i)));
                }
            }else{
                value = Integer.parseInt(String.valueOf(val.charAt(i)));
            }

            desimal += value * Math.pow(radiks, val.length() - i - 1);
        }

        return desimal;
    }

    public static boolean validasi(String val, int radiks){

        for (int i = 0; i < val.length(); i ++){
            boolean available = false;
            for (int j = 0; j < radiks; j++){
                if (radiks == 16){
                    try {
                        int mv = Integer.parseInt(String.valueOf(val.charAt(i)));
                        if (mv == j){
                            available = true;
                        }
                    }catch (NumberFormatException e) {
                        boolean hexA = false;
                        for (int k = 10; k < hex.length + 10; k++) {
                            if (val.charAt(i) == hex[k - 10]) {
                                hexA = true;
                                available = true;
                            }
                        }
                        if (!hexA) {
                            return false;
                        }
                    }
                }else {
                    try {
                        int mv = Integer.parseInt(String.valueOf(val.charAt(i)));
                        if (mv == j) {
                            available = true;
                        }
                    }catch (NumberFormatException e){
                        return false;
                    }
                }
            }
            if (!available){
                return false;
            }
        }

        return true;
    }

}
