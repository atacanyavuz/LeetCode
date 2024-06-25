class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        mergedArray = list()
        counter = 0
        while len(nums1) or len(nums2):
            if len(nums1) == 0:
                mergedArray.append(nums2.pop(0))
            elif len(nums2) == 0:
                mergedArray.append(nums1.pop(0))
            elif nums1[0] < nums2[0]:
                mergedArray.append(nums1.pop(0))
            elif nums1[0] >= nums2[0]:
                mergedArray.append(nums2.pop(0))
            counter += 1
        
        if counter % 2:
            return mergedArray[counter // 2]
        else:
            return (mergedArray[counter // 2 - 1] + mergedArray[counter // 2]) / 2
