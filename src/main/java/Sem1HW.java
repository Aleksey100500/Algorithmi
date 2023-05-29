import java.util.ArrayList;
import java.util.Arrays;

public class Sem1HW {
    public static void main(String[] args) {
        int[] array = new int[] {
                0, 5, 6, 2, 1, 3, 4, 9, 8, 7
        };
        sortHeapify(array);
        System.out.println(Arrays.toString(array));
    }
    private static void sortHeapify(int[] array) { // o(n * log n)
        // Построение кучи (перегруппируем массив)
        for (int i = array.length/2 - 1; i >= 0 ; i--) {
            heapify(array, array.length, i);
        }

        // Один за другим извлекаем элементы кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Выззываем процедуру heapify на уже уменьшенной куче
            heapify(array, i, 0);
        }
    }
    private static void heapify( int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // инициалиируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1; // левый = 2 * rootIndex + 1
        int rightChild = 2 * rootIndex + 2;// правый = 2 * rootIndex + 2

        // Если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;

        // Если самый большой элемент не корень
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддрево
            heapify(array, heapSize, largest);
        }
    }
}
