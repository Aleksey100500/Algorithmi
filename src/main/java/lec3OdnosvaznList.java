public class lec3OdnosvaznList {
    // Односвязные списки

    // // Стек и очередь
    //    // Стек - работает по принципу LIFO -
    //    // Last In - First Out
    //
    //    // Очередь - работает по принципу FIFO -
    //    // First In - First Out
    Node head;
    Node tail;

    public void push (int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }

    public Integer peek() {
        Integer result = null;
        if (tail != null) {
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }

    public Integer pop() {
        Integer result = null;
        if ( head != null) {
            result = head.value;
            head = head.next;
        }
        return result;
    }


    public void revert() {
        if (head != null && head.next != null) {
            revert(head.next, head);
        }
    }
    private void revert(Node currentNode, Node previousNode) {
        if (currentNode.next == null) {
            head = currentNode;
        } else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
    }
    public class Node {
        int value;
        Node next;

        Node previous;
    }
}
