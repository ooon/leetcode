package Tree;

public class ConvertlIST_TO_BST {
	public static void main(String[] args) {
		ConvertlIST_TO_BST c = new ConvertlIST_TO_BST();
		ListNode head = new ListNode(1);
		head.next =  new ListNode(2);
		head.next.next =  new ListNode(3);
		head.next.next.next =  new ListNode(3);
		c.deleteDuplicates(head);
	}
	  /**
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
	        if(head ==null) return null;
	        //以下两个用作去重
	        ListNode tail = head;
	        ListNode p = head;
	        ListNode q = head.next;
	        if(p.val == q.val) {
	            head = null;
	            tail = null;
	        }
	        while(q != null){
	            while(q.next != null && p.val == q.val){
	                p = p.next;
	                q = q.next; 
	            }  
	            if(q.next == null  && p.val != q.val){
	               if(tail == null) head = q;
	               else tail.next = q;
	               break;
	            }
	            if(q.next == null && p.val == q.val && tail !=null) tail.next =null;
	            if(q.next == null) break;
	            if(q.next.val == q.val){
	                p = p.next;
	                q =q.next;
	            }else{
	                if(tail == null) {
	                       head = q;
	                       tail = q;
	                   }else{
	                        tail.next = q;
	                        tail = tail.next;
	                   }
	                    p = p.next;
	                    q=q.next; 
	            }
	        }
	        return head;
	    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public String toString(){
    	return this.val+""	;
    }
}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
      public String toString(){
    	  return val+"";
      }
 }
 
