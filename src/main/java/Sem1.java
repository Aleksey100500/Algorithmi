import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sem1 {

    public static void main(String[] args) {

        System.out.println(findSum(10));
        delimiter();
        System.out.println(findEasyNum(100));
        delimiter();
        System.out.println(findChanseBox());
        delimiter();
        System.out.println(combinationCount(2, 6));
        delimiter();
        System.out.println(fib(8));
        delimiter();
        System.out.println(fibCicle(8));
        testDate();
    }


    private static int findSum(int N) {
        /* Алгоритм считающий сумму от 0 до N
         * Согласно свойствам линейной сложности, количество итераций цикла будет линейно изменяться относительно изменения N
         * сложность линейная O(n)*/
        int result = 0;
        for (int i = 0; i <= N; i++) result += i;
        return result;
    }


    public static void delimiter() {
        String delim = "-";
        for(int i = 0; i <= 150; i++) System.out.print(delim);
        System.out.println();
    }

    private static List<Integer> findEasyNum(int N) {
        /* Алгоритм по поиску простых чисел от 1 до N , сложность квадратичная O(n^2) */
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            boolean simple = true;
            for(int j = 2; j < i; j++) {
                if(i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        return result;
    }


    private static int findChanseBox() {
        /* Нахождение шанса определенной суммы числа на 4 х игральных кубиках,
        сложность экспоненциальная с неизвестным количество кграней*/
        int count = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j ++) {
                for (int k = 1; k <= 6; k++ ) { // график экспоненциальной зависимости
                    for (int l = 1; l <= 6; l++) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static int combinationCount(int count, int faces) {
        /* принимает кол кубиков, кол во граней
        * вызывает функцию которая считает кол во граней recursiveCounter(int depth, int maxDepth, int faces)*/
        if (count > 0) return recursiveCounter(1, count, faces);
        else return 0;
    }
    // depth = 1 maxDepth = 3 faces = 2 сложность алгоритма faces в степени count O(faces^count)
    private static int recursiveCounter(int depth, int maxDepth, int faces) {
        int count = 0;
        for (int i = 1; i <= faces; i++) {
            if (depth == maxDepth) {
                count++;
            } else {
                count += recursiveCounter(depth + 1, maxDepth, faces);
            }
        }
        return count;
    }

    /* Алгоритм поиска последующего числа фиббоначе с помощью рекурсии */
    private static int fib (int N) { /* O(2^n - 1) */
        if (N <= 2) return 1;
        return fib(N - 1) + fib(N - 2);
    }

    /*Циклом*/
    private static int fibCicle(int N) { /* O(n) */
        int result = 1;
        int prevision = 1;
        int prePrevision = 1;

        for (int i = 2; i < N; i++) {
            result = prePrevision + prevision;
            prePrevision = prevision;
            prevision = result;
        }
        return result;
    }

    public static void testDate() {
        for (int i = 10; i <= 50; i = i + 10) {
            Date startDate = new Date();
            fibCicle(i);
            Date endDate = new Date();
            long lineDuration = endDate.getTime() - startDate.getTime();
            startDate = new Date();
            fib(i);
            endDate = new Date();
            long recursiveDuration = endDate.getTime() - startDate.getTime();
            System.out.printf("i: %s, line duration: %s, recursive duration: %s%n", i, lineDuration, recursiveDuration);
        }
    }
}
