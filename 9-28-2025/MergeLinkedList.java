import java.util.*;

public class MergeLinkedList {
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
        int m = sc.nextInt();
        Node head1 = new Node(0);
        Node curr1 = head1;
        Node head2 = new Node(0);
        Node curr2 = head2;
        for(int i=0;i<n;i++){
            int v = sc.nextInt();
            Node nNode = new Node(v);
            curr1.next = nNode;
            curr1 = curr1.next;
        }
        for(int i=0;i<m;i++){
            int v = sc.nextInt();
            Node nNode = new Node(v);
            curr2.next = nNode;
            curr2 = curr2.next;
        }
        head1 = head1.next;
        head2 = head2.next;
        Node head = merge(head1,head2);
        printList(head);
        sc.close();
    }
    public static Node merge(Node l1,Node l2){
        Node head = new Node(0);
        Node c = head;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                c.next = new Node(l1.val);
                c = c.next;
                l1 = l1.next;
            }
            else{
                c.next = new Node(l2.val);
                c = c.next;
                l2 = l2.next;
            }
        }
        while(l1!=null){
            c.next = new Node(l1.val);
            c = c.next;
            l1 = l1.next;
        }
        while(l2!=null){
            c.next = new Node(l2.val);
            c = c.next;
            l2 = l2.next;
        }
        return head.next;
    }
    public static void printList(Node node){
        while(node!=null){
            System.out.print(node.val+((node.next!=null)?"->":""));
            node = node.next;
        }
        System.out.println();
    }
}

//Time Complexity: O(n+m)
//Space Complexity: O(n+m)