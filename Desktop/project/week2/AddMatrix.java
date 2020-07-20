import java.util.Scanner;

public class AddMatrix {
	public static void main(String[] args) {
		Scanner getInput = new Scanner(System.in);
		int m, n, i, j;
		System.out.println("Two matrices size (mxn). Please enter m: ");
		m = getInput.nextInt();
		System.out.println("Two matrices size (mxn). Please enter n: ");
		n = getInput.nextInt();
		int[][] myArray1 = new int[m][n];
		int[][] myArray2 = new int[m][n];
		int[][] result = new int[m][n];

		for (i = 1; i <= m; i++)
			for (j = 1; j <= n; j++) {
				System.out.print("Enter elements A[" + i + "][" + j + "]: ");
				myArray1[i - 1][j - 1] = getInput.nextInt();
				System.out.print("Enter elements B[" + i + "][" + j + "]: ");
				myArray2[i - 1][j - 1] = getInput.nextInt();
				result[i - 1][j - 1] = myArray1[i - 1][j - 1] + myArray2[i - 1][j - 1];
			}
		System.out.println("--------------------------------------------");
		for (i = 1; i <= m; i++) {
			for (j = 1; j <= n; j++) {
				System.out.print(myArray1[i - 1][j - 1] + " ");
			}
			System.out.print("    ");
			
			for (j = 1; j <= n; j++) {
				System.out.print(myArray2[i - 1][j - 1] + " ");
			}
			System.out.print("    ");
			for (j = 1; j <= n; j++)
			{
				System.out.print(result[i - 1][j - 1] + " ");
			}
			System.out.println("");
		}
		getInput.close();
		System.exit(0);
	}
}
