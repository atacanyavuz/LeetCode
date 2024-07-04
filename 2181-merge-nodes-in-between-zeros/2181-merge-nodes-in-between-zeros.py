# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        traverse = head
        result = ListNode()
        tail = result
        mergeSum = 0
        while traverse.next:
            if traverse.val != 0:
                mergeSum = mergeSum + traverse.val
            else:
                newNode = ListNode(val=mergeSum)
                tail.next = newNode
                tail = tail.next

                mergeSum = 0
            traverse = traverse.next

        newNode = ListNode(val=mergeSum)
        tail.next = newNode
        tail = tail.next

        oldNode = result
        result = result.next.next
        del oldNode.next
        del oldNode

        return result
