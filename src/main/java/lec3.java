public class lec3 {
    //📌Что такое “связный список”
    //📌Алгоритмы разворота связного списка
    //📌Стек и очередь
    //📌Особенности структуры связного списка. Двунаправленный и однонаправленный
    //списки
    //📌Оценка сложности алгоритмов связного списка
    // Связный список
    //Базовая структура данных, состоящая из узлов, где каждый узел содержит одну или две ссылки, который
    //ссылаются на следующий или на следующий и предыдущий узел соответственно.

    // Основные операции со связным списком
    // Поиск элемента, Вставка элементов, Удаление Элементов, Разворот

    // Преимущества связного списка
    // ● Массовые вставки и удаления в конец\начало
    //списка
    // ● Массовые вставки и удаления в середину
    //списка, если операция поиска выполняется
    //единожды
    // ● Динамическая расширяемость




    Node head; // ссылка на первый элемент
    Node tail; // ссылка на последний элемент связанного списка

    private void add( int value) { //  o(1)
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void add(int value, Node node) { // o(1)
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null) {
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    private void delete(Node node) { // o(1)
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null) {
            node.previous = null;
            head = next;
        } else {
            if (next == null) {
                previous.next = null;
                tail = previous;
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }
    }
    private Node find(int value) { // o(n)
        Node currentNode = head;
        while (currentNode != null) {
            if ( currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    private void revert () {
        Node currentNode = head;
        while ( currentNode != null ) {
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

    public static void main(String[] args) {

    }
    public class Node {
        int value;
        Node next;
        Node previous;
    }
}

