package Linkedlist;
public class SinglyLinkedList {
    private static class ListNode {
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        private int data; // generic type
        private ListNode next;
    }

    private ListNode head;

    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtPos(int value, int pos) {
        ListNode newNode = new ListNode(value);
        ListNode previous = head;
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        int count = 1;
        while (count < pos - 1) {
            previous = previous.next;
            count++;
        }
        ListNode current = previous.next;
        newNode.next = current;
        previous.next = newNode;
    }

    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public ListNode deleteFirst() {
        if (head == null)
            return null;
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public ListNode deleteLast() {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    public void deleteAtPos(int pos) {
        if (pos == 1) {
            head = head.next;
            return;
        }
        ListNode previous = head;
        int count = 1;
        while (count < pos - 1) {
            previous = previous.next;
            count++;
        }
        ListNode current = previous.next;
        previous.next = current.next;
    }

    public boolean find(ListNode head, int searchkey) {
        if (head == null) {
            return false;
        }
        ListNode current = head;
        while (current != null) {
            if (current.data == searchkey) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertFirst(11);
        sll.insertFirst(8);
        sll.insertFirst(1);
        sll.insertAtPos(20, 4);
        System.out.println("length of linkedlist is " + sll.length());
        sll.display();
        // if(sll.find(sll.head, 11)){
        // System.out.println();
        // System.out.println("Search key found");
        // }
    }

    public int length() {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}