import java.util.Scanner;

public class PeakColumn {

    int[][] matrixA;
    int matrixA_row, matrixA_col;
    Scanner input;

    public PeakColumn() {
        input = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns for Matrix A: ");
        while (!input.hasNextInt()) {
            System.out.println("Please enter a valid value (1 - 100)");
            input.next();  // Discard invalid input
        }
        matrixA_row = input.nextInt();
        matrixA_col = input.nextInt();

        peakColumnSearch();
    }

    private void peakColumnSearch() {
        matrixA = new int[matrixA_row][matrixA_col];

        System.out.println("Enter " + matrixA_row * matrixA_col + " digits for matrix A:");

        for (int row = 0; row < matrixA_row; row++) {
            for (int col = 0; col < matrixA_col; col++) {
                System.out.printf("Enter number at [%d][%d]: ", row, col);
                while (!input.hasNextInt()) {
                    System.out.println("Please enter a valid integer value.");
                    input.next();  // Discard invalid input
                }
                matrixA[row][col] = input.nextInt();
            }
        }

        for (int row = 0; row < matrixA_row; row++) {
            // Find the maximum value in the current row (handling possible ties)
            int maxInRow = matrixA[row][0];
            for (int col = 1; col < matrixA_col; col++) {
                if (matrixA[row][col] > maxInRow) {
                    maxInRow = matrixA[row][col];
                }
            }

            //check each occurrence of maxInRow in the row
            for (int col = 0; col < matrixA_col; col++) {
                if (matrixA[row][col] == maxInRow) {
                    // Check if the value is the minimum in its column
                    boolean isMinInColumn = true;
                    for (int checkRow = 0; checkRow < matrixA_row; checkRow++) {
                        if (matrixA[checkRow][col] < maxInRow) {
                            isMinInColumn = false;
                            break;
                        }
                    }

                    // If it's both the max in its row and the min in its column, it's a peak-column
                    if (isMinInColumn) {
                        System.out.printf("A (%d,%d) = %d\n", row + 1, col + 1, maxInRow);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PeakColumn peakColumn = new PeakColumn();
    }
}
