

class ListNode {
    public int val;
    public ListNode next;
}

public class TestDemo {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        if(head == null || n < 0) {
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(n-1 != 0) {
            fast = fast.next;
            if(fast == null) {
                break;
            }
            n--;
        }
        if(fast == null) {
            head = head.next;
            return head;
        }
        if(fast.next == null) {
            head.next = head.next.next;
            return head;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public ListNode partition (ListNode head, int x) {
        // write code here
        if(head == null) {
            return null;
        }
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = head;
        while(cur != null) {
            if(cur.val < x) {
                if(bs == null) {
                    bs = cur;
                    be = cur;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if(as == null) {
                    as = cur;
                    ae = cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if(bs == null) {
            return as;
        }
        be.next = as;
        if(as != null) {
            ae.next = null;
        }
        return bs;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            }else if(nums[mid] > target) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return left;
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        int i = 0;
        int j = 0;
        int lenHay = haystack.length();
        int lenNee = needle.length();
        while (i < lenHay && j < lenNee) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j >= lenNee) {
            return i - j;
        }
        return -1;
    }

    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        while(fast < nums.length) {
            if(nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
