class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int nums1Index = 0;
        int nums2Index = 0;
        List<int[]> resultList = new ArrayList(); 

        while (nums1Index < nums1.length && nums2Index < nums2.length ) {
            if (nums1[nums1Index][0] == nums2[nums2Index][0]) {
                resultList.add(new int[]{nums1[nums1Index][0], (nums1[nums1Index][1] + nums2[nums2Index][1])});
                nums1Index++;
                nums2Index++;
            }
            else if (nums1[nums1Index][0] < nums2[nums2Index][0]) {
                resultList.add(new int[]{nums1[nums1Index][0], nums1[nums1Index][1]});
                nums1Index++;
            }
            else{
                resultList.add(new int[]{nums2[nums2Index][0], nums2[nums2Index][1]});
                nums2Index++;
            }
        }
        while (nums1Index < nums1.length) {
            resultList.add(new int[]{nums1[nums1Index][0], nums1[nums1Index][1]});
            nums1Index++;
        }
        while (nums2Index < nums2.length) {
            resultList.add(new int[]{nums2[nums2Index][0], nums2[nums2Index][1]});
            nums2Index++;
        }
        int[][] res = resultList.toArray(new int[resultList.size()][]);
        return res;
    }
}