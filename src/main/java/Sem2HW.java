public class Sem2HW {
    Node head;
    Node tail;
    public class Node {
        int value;
        Node next;
        Node previous;
    }

    // Метод разворота двухсвязного списка

    public void revert () {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }
}
