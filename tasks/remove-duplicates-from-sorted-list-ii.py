from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        current = head
        is_copy = False
        new_head = None
        last_new_head = None
        while current.next:
            if current.val != current.next.val:
                if not is_copy:
                    if new_head:
                        last_new_head.next = current
                        last_new_head = current
                    else:
                        new_head = current
                        last_new_head = current
                is_copy = False
            else:
                is_copy = True
            current = current.next

        if is_copy:
            if new_head:
                last_new_head.next = None
        else:
            if not new_head:
                new_head = current
            else:
                last_new_head.next = current

        return new_head


def print_list(head: ListNode):
    while head:
        print(head.val, end=' -> ')
        head = head.next
    print()


node8 = ListNode(5)
node7 = ListNode(5, None)
node6 = ListNode(5, None)
node5 = ListNode(4, node6)
node4 = ListNode(4, node5)
node3 = ListNode(3, node4)
node2 = ListNode(2, None)
node1 = ListNode(1, node2)
node0 = ListNode(1, node1)

print_list(node0)
a = Solution().deleteDuplicates(node0)
print_list(a)
