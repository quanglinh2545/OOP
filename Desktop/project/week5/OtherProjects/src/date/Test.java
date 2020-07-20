package date;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;  

public class DateTest {
	public static void main(String[] args){
		MyDate testDate1=new MyDate();
                DateUtils dateUtils=new DateUtils();

		String s1="09/05/1999";  
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(s1);
		String s2="11/12/2013";  
		Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(s2);
		dateUtils.getCompareTwoDates(date1, date2);
                
                MyDate testDatePrintFormat=new MyDate();
		testDatePrintFormat.print(1);
		testDatePrintFormat.print(2);
		testDatePrintFormat.print(3);
}
}
