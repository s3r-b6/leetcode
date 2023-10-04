public class ReverseLinkedList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {}

		ListNode(int val) {this.val = val;}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode reverseListRec(ListNode head) {
		return reverseListHelper(head, null);
	}

	public static ListNode reverseListHelper(ListNode head, ListNode prev) {
		if (head == null) return null;

		ListNode next = head.next;
		head.next = prev;

		if (next == null) return head; // If it is the last item, return it after swapping
		return reverseListHelper(next, head); // Else, continue until last
	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null, curr = head;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return head;
	}
}
