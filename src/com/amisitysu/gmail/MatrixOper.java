package com.amisitysu.gmail;

import java.util.Random;

public class MatrixOper {

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        Random random = new Random();

        fillMatrixWithRandomNumbers(matrix, random);
        printMatrix(matrix);

        int evenRowSum = calculateRowSum(matrix, true);
        int oddRowSum = calculateRowSum(matrix, false);
        int evenColumnProduct = calculateColumnProduct(matrix, true);
        int oddColumnProduct = calculateColumnProduct(matrix, false);

        System.out.println("Сума елементів у парних рядках: " + evenRowSum);
        System.out.println("Сума елементів у непарних рядках: " + oddRowSum);
        System.out.println("Добуток елементів парних стовпців: " + evenColumnProduct);
        System.out.println("Добуток елементів непарних стовпців: " + oddColumnProduct);

        boolean isMagicSquare = checkMagicSquare(matrix);
        System.out.println("Матриця є магічним квадратом? -- " + (isMagicSquare ? "Так" : "Ні"));
    }

    private static void fillMatrixWithRandomNumbers(int[][] matrix, Random random) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(50) + 1;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Матриця 4х4:");
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    private static int calculateRowSum(int[][] matrix, boolean even) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (even && i % 2 != 0) continue;
            if (!even && i % 2 == 0) continue;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private static int calculateColumnProduct(int[][] matrix, boolean even) {
        int product = 1;
        for (int j = 0; j < matrix[0].length; j++) {
            if (even && j % 2 != 0) continue;
            if (!even && j % 2 == 0) continue;
            for (int i = 0; i < matrix.length; i++) {
                product *= matrix[i][j];
            }
        }
        return product;
    }

    private static boolean checkMagicSquare(int[][] matrix) {
        int magicSum = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            magicSum += matrix[0][j];
        }

        for (int i = 1; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != magicSum) {
                return false;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            int colSum = 0;
            for (int i = 0; i < matrix.length; i++) {
                colSum += matrix[i][j];
            }
            if (colSum != magicSum) {
                return false;
            }
        }

        int diag1Sum = 0;
        int diag2Sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            diag1Sum += matrix[i][i];
            diag2Sum += matrix[i][matrix.length - 1 - i];
        }
        return diag1Sum == magicSum && diag2Sum == magicSum;
    }
}