package app;

public class ProgramMain {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = (int) (Math.random() * 50) + 1;
            }
        }

        System.out.println("Матриця:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }

        int evenRowSum = 0, oddRowSum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i % 2 == 0) {
                    evenRowSum += matrix[i][j];
                } else {
                    oddRowSum += matrix[i][j];
                }
            }
        }

        int evenColumnProduct = 1, oddColumnProduct = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j % 2 == 0) {
                    evenColumnProduct *= matrix[i][j];
                } else {
                    oddColumnProduct *= matrix[i][j];
                }
            }
        }

        System.out.println("Сума елементів у парних рядках (0, 2): " + evenRowSum);
        System.out.println("Сума елементів у непарних рядках (1, 3): " + oddRowSum);
        System.out.println("Добуток елементів у парних стовпцях (0, 2): " + evenColumnProduct);
        System.out.println("Добуток елементів у непарних стовпцях (1, 3): " + oddColumnProduct);

        if (isMagicSquare(matrix)) {
            System.out.println("Матриця - це магічний квадрат.");
        } else {
            System.out.println("Матриця не є магічним квадратом.");
        }
    }

    public static boolean isMagicSquare(int[][] matrix) {
        int magicSum = 0;
        for (int j = 0; j < 4; j++) {
            magicSum += matrix[0][j];
        }

        for (int i = 1; i < 4; i++) {
            int rowSum = 0;
            for (int j = 0; j < 4; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != magicSum) return false;
        }

        for (int j = 0; j < 4; j++) {
            int columnSum = 0;
            for (int i = 0; i < 4; i++) {
                columnSum += matrix[i][j];
            }
            if (columnSum != magicSum) return false;
        }

        int diag1Sum = 0, diag2Sum = 0;
        for (int i = 0; i < 4; i++) {
            diag1Sum += matrix[i][i];
            diag2Sum += matrix[i][3 - i];
        }

        return diag1Sum == magicSum && diag2Sum == magicSum;
    }
}