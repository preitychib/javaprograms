package ConvexHull;

class Node {
    Point data;
    Node next, prev;

    Node(Point data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DLL {
    Node first;

    DLL() {
        first = null;
    }

    int size() {
        if (first == null)
            return 0;
        int sz = 1;
        Node cur = first.next;
        while (cur != first) {
            cur = cur.next;
            sz++;
        }
        return sz;
    }

    void create(Point[] a, int n) {
        Node cur = null, pr = null;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                first = cur = new Node(a[i]);
            } else {
                cur.next = new Node(a[i]);
                pr = cur;
                cur = cur.next;
                cur.prev = pr;
            }
        }
        first.prev = cur;
        cur.next = first;
    }

    void del(Node ad) {
        Node dl = ad;
        Node nxt = dl.next;
        Node pr = dl.prev;
        if (size() == 1)
            first = null;
        else {
            pr.next = nxt;
            nxt.prev = pr;
            if (ad == first)
                first = nxt;
        }
        dl.next = dl.prev = null;
    }

    void display() {
        Node cur = first;
        System.out.print("[");
        while (cur.next != first) {
            System.out.print("(" + cur.data.x + ", " + cur.data.y + "), ");
            cur = cur.next;
        }
        System.out.print("(" + cur.data.x + ", " + cur.data.y + ")]");
    }

    Node getFirst() {
        return first;
    }
}
