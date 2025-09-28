import java.util.*;

/*
 Reverse a LinkedList
 */

public class ReverseLinkedList {

    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            next = null;
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node node = new Node(0);
        Node curr = node;
        for(int i=0;i<n;i++){
            int v = sc.nextInt();
            Node newNode = new Node(v);
            curr.next = newNode;
            curr = curr.next;
        }
        Node head = node.next;
        printList(head);
        head = reverse(head);
        printList(head);
        sc.close();
    }
    public static Node reverse(Node node){
        Node prev = null;
        Node ans = null;
        while(node!=null){
            ans = node;
            Node fut = node.next;
            node.next = prev;
            prev = node;
            node = fut;
        }
        return ans;
    }
    public static void printList(Node node){
        while(node!=null){
            System.out.print(node.val+((node.next!=null)?"->":""));
            node = node.next;
        }
        System.out.println();
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)
