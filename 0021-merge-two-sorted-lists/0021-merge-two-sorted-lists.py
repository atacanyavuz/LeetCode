class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        head = ListNode()
        traverse = head
        while list1 and list2:
            if list1.val < list2.val:
                traverse.next = list1
                traverse = traverse.next
                list1 = list1.next
            else:
                traverse.next = list2
                traverse = traverse.next
                list2 = list2.next
        if list1:
            traverse.next = list1
        elif list2:
            traverse.next = list2
        return head.next
