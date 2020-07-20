import java.util.Scanner;

public class DayOfMonth {
	public static void main(String[] args) {
		Scanner getInput = new Scanner(System.in);
		int month, year, day = 0;

		do {
			System.out.println("Year = ");
			year = getInput.nextInt();
		} while (year <= 0);

		do {
			System.out.println("Month = ");
			month = getInput.nextInt();
		} while (month < 1 || month > 12);

        if ( month == 1 || month == 3 || month == 5 || month == 7 ||
        month == 8 || month == 10 || month ==12) day = 31;
        if( month == 4 || month == 6 || month == 9 || month == 11 ) day = 30;
        if( month == 2 && (year % 4 == 0) && (year % 400 == 0) ) day = 29;
        else day = 28;
		
		System.out.println("Number of days: " + day);
		getInput.close();
		System.exit(0);
	}
}
