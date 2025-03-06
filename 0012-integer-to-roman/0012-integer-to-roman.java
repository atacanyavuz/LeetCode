class Solution {
    private static final int[] numbers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    private static final String[] romanValue = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (num != 0) {
            while (num >= numbers[index]) {
                result.append(romanValue[index]);
                num -= numbers[index];
            }
            index++;
        }

        return result.toString();
    }
}