import java.util.*;
import java.io.*;

class GFG {

    static int[][] getZig_Zag(int[][][][] matrix, int[][] result) {
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[0].length; i1++) {
                diagonalOrder(matrix[i][i1], result[k++]);
            }
        }
        return result;
    }

    public static int[][] inverseZigzag(int[] array, int rows, int cols) {
        int[][] matrix = new int[rows][cols]; // Создаем пустую матрицу нужного размера
        int currentIndex = 0; // Индекс для элементов входного массива
        int total = rows + cols - 1; // Общее количество диагоналей

        for (int currentSum = 0; currentSum < total; currentSum++) {
            if (currentSum % 2 == 0) {
                for (int i = Math.min(currentSum, rows - 1); i >= Math.max(0, currentSum - cols + 1); i--) {
                    matrix[currentSum -i][ i] = array[currentIndex];
                    currentIndex++;
                }
            } else {
                for (int i = Math.max(0, currentSum - cols + 1); i <= Math.min(currentSum, rows - 1); i++) {
                    matrix[currentSum -i][ i] = array[currentIndex];
                    currentIndex++;
                }
            }
        }
        return matrix;
    }
    public static void diagonalOrder(int[][] arr, int[] result) {
        int n = arr.length;
        int m = arr[0].length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(n + m - 1);
        for (int i = 0; i < n + m - 1; i++) {
            ans.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans.get(i + j).add(arr[i][j]);
            }
        }

        int index = 0; // Индекс для записи в массив result
        for (int i = 0; i < ans.size(); i++) {
            if (i % 2 == 0) { // Если диагональ четная, печатаем сверху вниз
                for (int j = 0; j < ans.get(i).size(); j++) {
                    result[index++] = ans.get(i).get(j);
                }
            } else { // Если диагональ нечетная, печатаем снизу вверх
                for (int j = ans.get(i).size() - 1; j >= 0; j--) {
                    result[index++] = ans.get(i).get(j);
                }
            }
        }
    }

//    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//        int[] result = new int[matrix.length * matrix[0].length];
//        diagonalOrder(matrix, result);
//
//        // Вывод результата
//        for (int value : result) {
//            System.out.print(value + " ");
//        }
//    }
}


