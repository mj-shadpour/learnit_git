package CafeApp;

import java.util.ArrayList;
import java.util.List;

class DrinkLinkedList {
    static class Node {
        Drink value;
        Node next;
        Node(Drink d) { this.value = d; this.next = null; }
    }

    Node head;
    int size;

    public DrinkLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(Drink d) {
        Node n = new Node(d);
        if (head == null) head = n;
        else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = n;
        }
        size++;
    }


    public Drink removeAt(int index) {
        if (index < 0 || index >= size) return null;
        if (index == 0) {
            Drink val = head.value;
            head = head.next;
            size--;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < index - 1; i++) prev = prev.next;
        Node toRemove = prev.next;
        prev.next = toRemove.next;
        size--;
        return toRemove.value;
    }

    public Drink getAt(int index) {
        if (index < 0 || index >= size) return null;
        Node cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        return cur.value;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }


    public List<String> toNameList() {
        List<String> out = new ArrayList<>();
        Node cur = head;
        while (cur != null) {
            out.add(cur.value.name);
            cur = cur.next;
        }
        return out;
    }
}