package com.yaxuansheng.leetcode.online;

import java.util.Stack;

public class ReorderList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

    public static void reorderList(ListNode head) {
        int length = 0;
        Stack<ListNode> stack = new Stack<ListNode>();
        
        ListNode curr = head;
        
        while(curr != null)
        {
            stack.push(curr);
            length++;
            curr = curr.next;
        }
        
        int len = 0;
        curr = head;
        while(len < length/2)
        {
            ListNode nextNode = curr.next;
            ListNode stackNode = stack.pop();
            
            curr.next = stackNode;
            stackNode.next = nextNode;
            
            curr = nextNode;
            len++;
        }
        
        if (curr != null) curr.next = null;
    }

	public static void main(String[] args) {
		ListNode f = new ListNode(1);
		ListNode s = new ListNode(2);
		//ListNode t = new ListNode(3);
		f.next = s;
		s.next = null;

		reorderList(f);
		ListNode c = f;
		while (c != null) {
			System.out.println(c.val + " ");
			c = c.next;
		}
	}

}
