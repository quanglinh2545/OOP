import java.util.Scanner;

public class DrawTriangle {
	public static void main(String[] args) {
		Scanner getInput = new Scanner(System.in);
		System.out.print("Please enter the edge of the triangle: ");
		int edge = getInput.nextInt();
		int i, j;
		for (i = 1; i <= edge; i++) {
			for (j = 1; j <= edge - i; j++)
				System.out.print(" ");
			for (j = 1; j <= i * 2 - 1; j++)
				System.out.print("*");
			System.out.println("");
		}
		getInput.close();
		System.exit(0);
	}
}
