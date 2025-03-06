class Solution {
    public int minSwaps(int[] data) {
        int numberOfOne = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                numberOfOne++;
            }
        }

        int minZeroInSlidingWindow = 0;
        for (int i = 0; i < numberOfOne; i++) {
            if (data[i] == 0) {
                minZeroInSlidingWindow++;
            }
        }
        int numOfSlidingWindowZero = minZeroInSlidingWindow;

        for (int i = numberOfOne; i < data.length; i++) {
            if (data[i] == 0) {
                numOfSlidingWindowZero++;
            }
            if (data[i - numberOfOne] == 0) {
                numOfSlidingWindowZero--;
            }
            if (numOfSlidingWindowZero < minZeroInSlidingWindow) {
                minZeroInSlidingWindow = numOfSlidingWindowZero;
            }
        }

        return minZeroInSlidingWindow;
    }
}