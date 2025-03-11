class Solution {
    int[] charCounter = new int[3];
    private boolean controlCounter(){
        return charCounter[0] > 0 && charCounter[1] > 0 && charCounter[2] > 0; 
    }

    public int numberOfSubstrings(String s) {
        int totalNumber = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (rightIndex < s.length()) {
            charCounter[s.charAt(rightIndex) - 'a']++;
            while (controlCounter()) {
                totalNumber += (s.length() - rightIndex);
                charCounter[s.charAt(leftIndex) - 'a']--;
                leftIndex++;
            }
            rightIndex++;
        }
        return totalNumber;
    }
}