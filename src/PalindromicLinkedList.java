
class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

public class PalindromicLinkedList {

  public static boolean isPalindrome(ListNode head) {
    // TODO: Write your code here
    ListNode fNode = head;
    ListNode sNode = head;
    int listSize = 0;
    ListNode cNode = head;
    ListNode pNode = null;
    ListNode temp = head;
    
    while(fNode!=null && fNode.next!=null ){
      fNode = fNode.next.next;
      temp  =  sNode;
      sNode = sNode.next;
      
      //cNode = cNode.next;
      temp.next = pNode;
      pNode = temp;
      listSize++;
    }
    System.out.println(sNode.value);
    System.out.println(listSize);
    System.out.println(pNode.value);
    return false;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

    head.next.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
  }
}