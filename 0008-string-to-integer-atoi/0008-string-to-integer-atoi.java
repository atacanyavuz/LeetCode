class Solution {
    private String trimUselessZeros(String s){
        int zeroCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeroCounter++;                
            }
            else {
                break;
            }
        }
        if (zeroCounter == 0) {
            return s;
        }
        else if (zeroCounter == s.length()) {
            return "0";            
        }
        if (Character.isDigit(s.charAt(zeroCounter))) {
            return s.substring(zeroCounter);
        }
        else{
            return s.substring(zeroCounter - 1);
        }

    }
    public int myAtoi(String s) {
        if (s.equals("")) {
            return 0;
        }

        s = s.trim();
        boolean negative;

        if (s.length() > 0) {
            negative = s.charAt(0) == '-' ? true : false;
        }
        else{
            return 0;
        }
        
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        s = trimUselessZeros(s);

        int end = -1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                end++;
            } else {
                break;
            }
        }

        if (end == -1) {
            return 0;
        } else if (end > 9) {
            if (negative) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        } else if (end == 9) {
            if ((s.substring(0, end + 1)).compareTo(String.valueOf(Integer.MAX_VALUE)) > 0) {
                if (negative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        } 
        return negative ? Integer.parseInt(s.substring(0, end + 1)) * -1 : Integer.parseInt(s.substring(0, end + 1));
    }
}