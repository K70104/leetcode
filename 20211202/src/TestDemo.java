


class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}

public class TestDemo {
    public ListNode FindFirstCommonNode(ListNode head1, ListNode head2) {
        if(head1 == null || head2 == null) {
            return null;
        }
        ListNode pl = head1;
        ListNode ps = head2;
        int len1 = 0;
        int len2 = 0;
        while(pl != null) {
            len1++;
            pl = pl.next;
        }
        pl = head1;
        while(ps != null) {
            len2++;
            ps = ps.next;
        }
        ps = head2;
        int len = len1 - len2;
        if(len < 0) {
            pl = head2;
            ps = head1;
            len = len2 - len1;
        }
        // pl走差值步
        while(len != 0) {
            pl = pl.next;
            len--;
        }
        while(pl != ps) {
            pl = pl.next;
            ps = ps.next;
        }
        return pl;
    }

    public ListNode Merge(ListNode head1, ListNode head2) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                tmp.next = head1;
                tmp = tmp.next;
                head1 = head1.next;
            } else {
                tmp.next = head2;
                tmp = tmp.next;
                head2 = head2.next;
            }
        }
        if(head1 != null) {
            tmp.next = head1;
        }
        if(head2 != null) {
            tmp.next = head2;
        }
        return newHead.next;
    }

    public ListNode Merge1(ListNode list1,ListNode list2) {
        if(list1 == null || list2 == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;

    }

    public ListNode deleteDuplicates2 (ListNode head) {
        // write code here
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        ListNode cur = head;
        while(cur != null) {
            if(cur.next != null && cur.val == cur.next.val) {
                while(cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        // 防止最后一个节点也是重复 将最后一个不重复的节点置为空
        tmp.next = null;
        return newHead.next;
    }

    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        ListNode cur = head;
        while(cur != null) {
            if(cur.next != null && cur.val == cur.next.val) {
                while(cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
            } else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {

    }
}
