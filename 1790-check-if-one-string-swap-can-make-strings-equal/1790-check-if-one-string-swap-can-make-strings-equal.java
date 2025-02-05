class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() == 1) {
            return false;
        }

        char c1 = '0', c2 = '0';
        boolean ret = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (c1 == '0') {
                    c1 = s1.charAt(i);
                    c2 = s2.charAt(i);
                } else {
                    if (ret) {
                        return false;
                    }
                    if (s1.charAt(i) == c2 && s2.charAt(i) == c1) {
                        ret = true;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return ret;
    }
}