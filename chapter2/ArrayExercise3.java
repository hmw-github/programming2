package programming2.chapter2;

public class ArrayExercise3 {
	public static void main(String[] args) {
		// Definition of matrices as 2D arrays
		int[][] matrix1 = { { 1, 2 }, // row 1
				{ 3, 4 } // row 2
		};

		int[][] matrix2 = new int[2][2]; // all 0's
		matrix2[0][0] = -10;
		matrix2[0][1] = -20;
		matrix2[1][0] = 0;
		matrix2[1][1] = 4;

		// initialise result matrix
		int[][] result = new int[2][2];

		// add matrices
		for (int row = 0; row < result.length; ++row) {
			for (int col = 0; col < result[row].length; ++col) {
				result[row][col] = matrix1[row][col] 
						+ matrix2[row][col];
			}
		}
		
		// output result matrix
		for (int row = 0; row < result.length; ++row) {
			for (int col = 0; col < result[row].length; ++col) {
				System.out.printf("\t%03d", result[row][col]);
			}
			System.out.println("");
		}
	}
}
