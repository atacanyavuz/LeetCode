class Solution {
    private void fillRomanMap(LinkedHashMap<Integer, String> romanMap){
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");
    }

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        LinkedHashMap<Integer, String> romanMap = new LinkedHashMap<>();
        fillRomanMap(romanMap);
        for (int key : romanMap.sequencedKeySet()) {
            while (num >= key) {
                result.append(romanMap.get(key));
                num = num - key;
            }
        }
        return result.toString();
    }
}