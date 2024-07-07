# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        tail = head
        traverse = head.next

        counter = 1
        critical_points = []
        while traverse.next:
            if traverse.next.val > traverse.val and tail.val > traverse.val:
                critical_points.append(counter)
            elif traverse.next.val < traverse.val and tail.val < traverse.val:
                critical_points.append(counter)
            traverse = traverse.next
            tail = tail.next
            counter = counter + 1
        if len(critical_points) < 2:
            return [-1, -1]

        minDiff = 10**5
        for i in range(len(critical_points) - 1):
            if minDiff > critical_points[i + 1] - critical_points[i]:
                minDiff = critical_points[i + 1] - critical_points[i]
        return [minDiff, critical_points[-1] - critical_points[0]]
