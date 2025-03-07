class Solution {
    private boolean isPrime(int x){
        if (x == 1) {
            return false;
        }
        if (x == 2) {
            return true;
        }
        if (x % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= (int)Math.ceil(Math.sqrt(x)); i+=2) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int[] closestPrimes(int left, int right) {
        int[] controlArray = {-1, -1};
        int[] smallestArray = {-1, -1};

        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (controlArray[0] == -1) { 
                    controlArray[0] = i;
                    continue;
                }
                if(controlArray[1] == -1) { 
                    controlArray[1] = i;
                    smallestArray[0] = controlArray[0];
                    smallestArray[1] = controlArray[1];
                    continue;
                }
                controlArray[0] = controlArray[1];
                controlArray[1] = i;

                if (controlArray[1] - controlArray[0] < smallestArray[1] - smallestArray[0] ) {
                    smallestArray[0] = controlArray[0];
                    smallestArray[1] = controlArray[1];
                }
            }   
        }

        if (smallestArray[0] == -1 || smallestArray[1] == -1) {
            smallestArray[0] = -1;
            return smallestArray;            
        }
        return smallestArray;
    }
}