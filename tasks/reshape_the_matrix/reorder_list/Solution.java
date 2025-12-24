package reshape_the_matrix.reorder_list;


class Solution {
    public void reorderList(ListNode head) {
        int count = 1;
        {
            ListNode current = head;
            while (current.next != null) {
                count++;
                current = current.next;
            }
        }

        ListNode[] nodes = new ListNode[count];
        for (int i = 0; i < count; i++) {
            nodes[i] = head;
            head = head.next;
        }

        for (int i = 0; i < count; i++) {
            ListNode current = nodes[i];
            if (i < count / 2) {
                current.next = nodes[count - i - 1];
            } else if (i > count / 2) {
                current.next = nodes[count - i];
            } else {
                current.next = null;
            }
        }
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        print(head1);
        new Solution().reorderList(head1);
        print(head1);


        ListNode head2 = new ListNode(1);
        print(head2);
        new Solution().reorderList(head2);
        print(head2);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}