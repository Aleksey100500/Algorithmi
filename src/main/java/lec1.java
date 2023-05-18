import java.util.ArrayList;
import java.util.List;

public class lec1 {

    public static void main (String[] args) {
//        double number = findSum(4);
//        System.out.println(number);
//        List<Integer> avaliableDivider = findDivider(10);
//        for (Integer integer: avaliableDivider) {
//            System.out.println(integer);
//        }
    }
// Нахождение четных чисел
    public static List<Integer> findDivider(int number) {
        int count = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i ++) {  // сложность алгоритма перебора массива циклом for имеет сложность O(n)
            count++;                            // имеет линейную сложность
            if (number % i == 0) {
                result.add(i);
            }
        }
        System.out.println("Counter: " + count);
        return result;
    }

    public static List<Integer> findSimpleNumbers(int max) {
        int counter = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                counter++;                  // перебор с вложенным циклом for имеет сложность O(n^2)
                if (i % j == 0) {
                    simple = false;
                }
            }
            if (simple) {   // если simple остался true
                result.add(i);
            }
        }
        System.out.println("Counter: " + counter);
        return result;
    }
    // сложность алгоритма растет в квадратичной зависимости,
    // такая зависимость характеризуется резким ростом сложности относительного роста размера входных данных
    // Нахождение определенной суммы числа на 3 х игральных кубиках
    public static double findSum( int sum ) {
        int count = 0;
        int successResult = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j ++) {
                for (int k = 1; k <= 6; k++ ) { // график экспоненциальной зависимости
                    if (i + j + k == sum) {
                        successResult++;
                    }
                    count++;
                }
            }
        }
        return ((double) successResult) / ((double) count);
    }
}
