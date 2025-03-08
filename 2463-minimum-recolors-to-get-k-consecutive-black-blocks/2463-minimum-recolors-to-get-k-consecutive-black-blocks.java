class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minWhiteNum = k;
        int whiteInSlider = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteInSlider++;
            }
        }
        minWhiteNum = whiteInSlider;
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                whiteInSlider++;
            }  
            if (blocks.charAt(i - k) == 'W') {
                whiteInSlider--;
            }  
            if (minWhiteNum > whiteInSlider) {
                minWhiteNum = whiteInSlider;                
            } 
        }
        return minWhiteNum;
        
    }
}