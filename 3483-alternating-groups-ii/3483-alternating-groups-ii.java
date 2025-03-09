class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        List<Integer> colorsList = Arrays.stream(colors).boxed().collect(Collectors.toList()); 
        for (int i = 0; i < colors.length - 1; i++) {
            colorsList.add(colors[i]);
        }
        
        int counter = 0;
        int left = 0, right = 1;
        while (right < colors.length + k - 1) {
            if (colorsList.get(right) == colorsList.get(right - 1)) {
                left = right;
                right++;
                continue;
            }
            if (right - left >= k - 1) {
                counter++;
                left++;                
            }
            right++;
        }
        return counter;
    }
}