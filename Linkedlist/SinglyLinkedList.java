package Linkedlist;

import java.sql.Ref;

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

    public ListNode reverse(ListNode head) {
        if (head == null)
            return head;
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode getMiddleNode() {
        if (head == null)
            return null;
        ListNode slowptr = head;
        ListNode fastptr = head;
        while (fastptr != null && fastptr.next != null) {
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
        }
        return slowptr;
    }

    public ListNode getNthNodeFromEnd(int n) {
        if (head == null)
            return null;
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid value of n" + n);
        }
        ListNode mainptr = head;
        ListNode refPtr = head;
        int count = 0;
        while (count < n) {
            if (refPtr == null) {
                throw new IllegalArgumentException("n is greater than the no of nodes in  list");
            }
            refPtr = refPtr.next;
            count++;
        }
        while (refPtr != null) {
            refPtr = refPtr.next;
            mainptr = mainptr.next;
        }

        return mainptr;

    }

    public void removeDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public ListNode insertInSortedList(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            return newNode;
        }
        ListNode current = head;
        ListNode temp = null;
        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
    }

    public void removeKey(int value) {
        if (head == null)
            return;
        ListNode current = head;
        ListNode temp = null;
        if (current != null && current.data == value) {
            head = current.next;
            return;
        }
        while (current != null && current.data != value) {
            temp = current;
            current = current.next;
        }
        if (current == null)
            return;
        temp.next = current.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertFirst(16);
        sll.insertFirst(10);
        sll.insertFirst(8);
        sll.insertFirst(1);
        sll.insertFirst(0);
        System.out.println("length of linkedlist is " + sll.length());
        // ListNode revListHead = sll.reverse(sll.head);
        // ListNode middleNode = sll.getMiddleNode();
        // System.out.println();
        // System.out.println("Middle node is " + middleNode.data);
        // ListNode nthNode = sll.getNthNodeFromEnd(5);
        // System.out.println("nth node from end is " + nthNode.data);
        // sll.removeDuplicates(sll.head);
        // if(sll.find(sll.head, 11)){
        // System.out.println();
        // System.out.println("Search key found");
        // }
        // sll.insertInSortedList(11);
        // sll.removeKey(0);
        sll.display(sll.head);
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

    public void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}