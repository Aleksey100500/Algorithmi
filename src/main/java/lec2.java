public class lec2 {
    /* Что такое структуры данных
     *  Алгоритмы сортировки массивов
     *  Оценка сложности алгоритмов массива
     *  Особенности структуры массивов
     *  Алгоритмы поиска по массиву */
    public static void main(String[] args) {
        /* Структурами данных называют некоторый контейнер с данными, обладающий специфическим внутренним устройством
        (макетом) и логикой хранения. Различные макеты могут быть эффективны для некоторых операций и неэффективны для
        других */

        /* Массив - это контейнер, хранящий данные идентифицируемые по индексу.
    К любому элементу массива всегда можно обратиться по его индексу и
    достать или заменить его.
    Особенностью массива является то, что доступ к элементам по индексу
    осуществляется за константное время, т.е. имеет сложность O(1) */
        /* Основные операции с массивом ПОИСК и СОРТИРОВКА*/

        /*Пузырьковая сортировка
        ● Сортировка выбором
        ● Сортировка вставками*/

        int[] array = new int[] {
            4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5
        } ;
        insertSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        Sem1.delimiter();
        System.out.println(binarySearch(array, 9));
    }
    // Пузырьковая
    private static void bubbleSort(int[] array) { /* O(n^2) */
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    finish = false;
                }
            }
        } while (!finish);
    }

    // Выбором
    private static void directSort(int[] array) { /* O(n^2) */
        for (int i = 0; i < array.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            if (i != minPosition) {
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
    }

    // Вставками
    private static void insertSort(int[] array) { /* O(n^2) */
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // Алгоритмы поиска - Простой перебор, Бинарный поиск

    private static int find(int[] array, int value) { /* O(n) */
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // Бинарный поиск
    private static int binarySearch( int[] array, int value) { // Перегрузка метода binarySearch(int[] array, int value, int min, int max)
        return binarySearch(array, value, 0, array.length - 1);
    }
    private static int binarySearch(int[] array, int value, int min, int max) { // O(log n)
        int midpoint;
        if (max < min) {
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }

        if (array[midpoint] < value) {
            return binarySearch(array, value, midpoint + 1, max);
        } else {
            if (array[midpoint] > value) {
                return binarySearch(array, value, min, midpoint - 1);
            } else {
                return midpoint;
            }
        }
    }
    // Продвинутые алгоритмы сортировки
    // Быстрая сортировка
    // Пирамидальная сортировка

    //Разделяй и властвуй (от анг. divide and conquer) — парадигма разработки алгоритмов, заключающаяся в
    //рекурсивном разбиении решаемой задачи на две или более подзадачи того же типа, но меньшего размера, и
    //комбинировании их решений для получения ответа к исходной задаче; разбиения выполняются до тех пор,
    //пока все подзадачи не окажутся элементарными.
    //Пивот (от анг. pivot - поворот) - Элемент, служащий точкой сравнения элементов и их “поворота”, в случае
    //необходимости

    // Быстрая сортировка
    private static void sort (int[] array, int startPos, int endPos) { // o(n * log n)
        int leftPos = startPos;
        int rightPos = endPos;

        int pivot = array[(startPos + endPos) /2];
        do {
            while (array[leftPos] < pivot) {
                leftPos ++;
            }
            while (array[rightPos] > pivot) {
                rightPos --;
            }
            if (leftPos <= rightPos) {
                if (leftPos < rightPos) {
                    int temp = array[leftPos];
                    array[leftPos] = array[rightPos];
                    array[rightPos] = temp;
                }
                leftPos++;
                rightPos--;
            }
        } while (leftPos <= rightPos);

        if (leftPos < endPos) {
            sort(array, leftPos, endPos);
        }
        if (startPos < rightPos) {
            sort(array, startPos, rightPos);
        }
    }

    // Пирамидальная сортировка
    // Бинарная куча. Если принять элемент с индексом i за родителя, то индексы его дочерних элементов будут 2 * i
    //+ 1 и 2 * i + 2

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
