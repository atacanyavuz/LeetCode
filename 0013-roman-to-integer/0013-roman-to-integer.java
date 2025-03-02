class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanCharMap = new HashMap<>();
        romanCharMap.put('I', 1);
        romanCharMap.put('V', 5);
        romanCharMap.put('X', 10);
        romanCharMap.put('L', 50);
        romanCharMap.put('C', 100);
        romanCharMap.put('D', 500);
        romanCharMap.put('M', 1000);
        
        int totalVal = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (romanCharMap.get(s.charAt(i)) < romanCharMap.get(s.charAt(i + 1))) {
                totalVal -= romanCharMap.get(s.charAt(i));
            }
            else{
                totalVal += romanCharMap.get(s.charAt(i));
            }
        }
        totalVal += romanCharMap.get(s.charAt(s.length() - 1));
        return totalVal;
    }
}


