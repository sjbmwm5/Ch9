package Ch8;


public class Matrix {
	private int numRows;
	private int numColumns;
	private double[][] data;
	
	public Matrix(int numRows, int numColumns) {
		this.setNumRows(numRows);
		this.setNumColumns(numColumns);
		setData(new double[numRows][numColumns]);
		 
		
	}
	public Matrix(double[][] data) {
        numRows = data.length;
        numColumns = data[0].length;
        this.data = new double[numRows][numColumns];
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numColumns; j++)
                    this.data[i][j] = data[i][j];
    }
	
	// Constructor that initializes an size x size matrix of all zeros
	public int size() {
		return numColumns * numRows;
	  
	}
	// Accessor Function that returns the Matrix's size
	public double get(int row, int col) {
		return 0;
	}
	// Simply return the element located in position row, col
	public void set(int row, int col, double value) {
		data[row][col] = value;
	}
	// Sets the value of the rowth, colth element to value
	// Works like mat[row][col] = value
	
	
	
	public int getNumRows() {
		return numRows;
	}
	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}
	public static int getNumColumns() {
		return numColumns;
	}
	public void setNumColumns(int numColumns) {
		this.numColumns = numColumns;
	}
	public double[][] getData() {
		return data;
	}
	public void setData(double[][] data) {
		this.data = data;
	}
	public static double matrixDeterminant (double[][] matrix) {
		double temporary[][];
		double result = 0;

		if (matrix.length == 1) {
			result = matrix[0][0];
			return (result);
		}

		if (matrix.length == 2) {
			result = ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
			return (result);
		}

		for (int i = 0; i < matrix[0].length; i++) {
			temporary = new double[matrix.length - 1][matrix[0].length - 1];

			for (int j = 1; j < matrix.length; j++) {
				for (int k = 0; k < matrix[0].length; k++) {
					if (k < i) {
						temporary[j - 1][k] = matrix[j][k];
					} else if (k > i) {
						temporary[j - 1][k - 1] = matrix[j][k];
					}
				}
			}

			result += matrix[0][i] * Math.pow (-1, (double) i) * matrixDeterminant (temporary);
		}
		return (result);
	}


}
