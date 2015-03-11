package com.yaxuansheng.leetcode.online;

public class RemoveDuplicates {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode tmpHead = new ListNode(80111);
        tmpHead.next = head;
        ListNode prev = tmpHead;
        ListNode curr = prev.next;
        while(curr != null && curr.next != null)
        {
            ListNode next = curr.next;
            if (curr.val == next.val)
            {
                ListNode p = next.next;
                
                while(p != null)
                {
                    if (curr.val != p.val)
                        break;
                    p = p.next;
                }
                
                prev.next = p;
                curr = p;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return tmpHead.next;
    }
	
	public static void main(String[] args) {
		ListNode f = new ListNode(1);
		ListNode s = new ListNode(1);
		//ListNode t = new ListNode(3);
		f.next = s;
		s.next = null;

		ListNode c = deleteDuplicates(f);
		while (c != null) {
			System.out.println(c.val + " ");
			c = c.next;
		}
	}

}
