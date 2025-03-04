class Solution {
    private int maxPowerOfThree(int n) {
        for (int i = 0;;i++) {
            if (n < Math.pow(3, i)) {
                return --i;
            }
        }
    }

    public boolean checkPowersOfThree(int n) {
        if (n < 3) {
            switch (n) {
                case 0:
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    break;
            }
        }

        int maxPower = maxPowerOfThree(n);
        if (n >= (int) Math.pow(3, maxPower) * 2) {
            return false;
        }
        return checkPowersOfThree(n - (int) Math.pow(3, maxPower));
    }
}