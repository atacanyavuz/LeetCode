# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def findCenter(self, head):
        center, fast = head, head
        while fast and fast.next:
            center, fast = center.next, fast.next.next
        return center

    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head or not head.next:
            return
        center = self.findCenter(head)

        # Reverse After Center
        pre = None
        while center:
            center.next, pre, center = pre, center, center.next
        
        # Order
        left, right = head, pre
        while right.next:
            left.next, left = right, left.next
            right.next, right = left, right.next
            