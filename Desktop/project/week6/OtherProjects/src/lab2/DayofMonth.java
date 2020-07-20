import java.util.Scanner;

public class DayOfMonth {
	public static void main(String[] args) {
		Scanner getInput = new Scanner(System.in);
		int month, year, day = 0;

		do {
			System.out.println("Please enter the year (year>0): ");
			year = getInput.nextInt();
		} while (year <= 0);

		do {
			System.out.println("Please enter the month ( Choose 1-12): ");
			month = getInput.nextInt();
		} while (month < 1 || month > 12);

		if (year % 4 == 0 && month == 2)
			day = 28;
		else {
			if (month == 2)
				day = 29;
			else if (month == 4 || month == 6 || month == 9 || month == 11)
				day = 30;
			else
				day = 31;
		}
		System.out.println("Number of days: " + day);
		getInput.close();
		System.exit(0);
	}
}
