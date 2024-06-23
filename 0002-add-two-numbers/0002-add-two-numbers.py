# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

def LinkedListToInteger(l):
    number = 0
    step = 0
    while l.next != None:
        number = number + l.val * (10 ** step)
        step += 1
        l = l.next
    result = number + l.val * (10 ** step)
    return result

def IntegerToLinkedList(number):
    head = ListNode()
    point = head
    while number > 9:
        point.val = number % 10
        number = number // 10
        point.next = ListNode()
        point = point.next
    point.val = number % 10
    return head


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        n1 = LinkedListToInteger(l1)
        n2 = LinkedListToInteger(l2)
        return IntegerToLinkedList(n1 + n2)
