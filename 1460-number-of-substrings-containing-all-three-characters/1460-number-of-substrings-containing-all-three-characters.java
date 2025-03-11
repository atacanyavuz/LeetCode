class Solution {
    int[] charCounter = new int[3];

    private void addRemoveCharToCounter(char c, boolean isRemove) {
        if (isRemove) {
            if (c == 'a') {
                charCounter[0]--;
            } else if (c == 'b') {
                charCounter[1]--;
            } else if (c == 'c') {
                charCounter[2]--;
            }
        }
        else {
            if (c == 'a') {
                charCounter[0]++;
            } else if (c == 'b') {
                charCounter[1]++;
            } else if (c == 'c') {
                charCounter[2]++;
            }
        }

    }
    private boolean controlCounter(){
        return charCounter[0] > 0 && charCounter[1] > 0 && charCounter[2] > 0; 
    }

    public int numberOfSubstrings(String s) {
        int totalNumber = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (true) {
            System.out.println(charCounter[0] + "-" + charCounter[1] + "-" + charCounter[2] );
            if (controlCounter()) {
                totalNumber += (s.length() - (rightIndex) + 1);
                addRemoveCharToCounter(s.charAt(leftIndex), true);
                leftIndex++;
                continue;
            }
            if (rightIndex >= s.length()) {
                break;
            }
            addRemoveCharToCounter(s.charAt(rightIndex), false);
            rightIndex++;
        }
        return totalNumber;
    }
}