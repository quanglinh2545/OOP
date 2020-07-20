package date;
import java.util.Scanner;
import java.util.Calender;
public class MyDate {
	private int day;
	private int month;
	private int year;
	public static boolean checkYear(int year){
		if(year%400==0) return true;
		if(year%4==0 && year %100!=0) return true;
		return false;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public MyDate() {
		super();
	}
	public MyDate(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public MyDate(String mydate){
		super();
		int day=0,month=0,year=0;
		String[] output = mydate.split(" ");
		year = Integer.parseInt(output[2]);
		day = Integer.parseInt(output[1].substring(0, 2));
		switch(output[0]){
		case "January":{
			month =1;
			break;
		}
		case "February":{
			month =2;
			break;
		}
		case "March":{
			month =3;
			break;
		}
		case "April":{
			month =4;
			break;
		}
		case "May":{
			month =5;
			break;
		}
		case "June":{
			month =6;
			break;
		}
		case "July":{
			month =7;
			break;
		}
		case "August":{
			month =8;
			break;
		}
		case "September":{
			month =9;
			break;
		}
		case "October":{
			month =10;
			break;
		}
		case "November":{
			month =11;
			break;
		}
		case "December":{
			month =12;
			break;
		}
		default:
		{
			System.out.println("Nhap sai");
			System.exit(-1);
		}
		}
		boolean flag=false;
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			if(day>0&&day<=31){
				flag=true;
			}
		}else if(month==4||month==6||month==9||month==11){
			if(day>0&&day<31){
				flag=true;
			}
		}else if(month ==2){
			if(checkYear(year)){
				if(day>0&&day<30){
					flag =true;
				}
			}else{
				if(day>0&&day<29){
					flag =true;
				}
			}
		}
		if(flag==false){
			System.exit(-1);
		}else{
			this.day= day;
			this.month=month;
			this.year=year;
		}
	}
	public void accept(){
		String mydate;
		Scanner sc =new Scanner(System.in);
		boolean flag=false;
		do{
			System.out.print("Nhap MyDate(month/day/year): ");
			mydate=sc.nextLine();
			String[] output = mydate.split(" ");
			year = Integer.parseInt(output[2]);
			day = Integer.parseInt(output[1].substring(0, 2));
			
			switch(output[0]){
			case "January":{
				month =1;
				break;
			}
			case "February":{
				month =2;
				break;
			}
			case "March":{
				month =3;
				break;
			}
			case "April":{
				month =4;
				break;
			}
			case "May":{
				month =5;
				break;
			}
			case "June":{
				month =6;
				break;
			}
			case "July":{
				month =7;
				break;
			}
			case "August":{
				month =8;
				break;
			}
			case "September":{
				month =9;
				break;
			}
			case "October":{
				month =10;
				break;
			}
			case "November":{
				month =11;
				break;
			}
			case "December":{
				month =12;
				break;
			}
			default:
			{
				System.out.println("Nhap sai");
				System.exit(-1);
			}
			}
			
			if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
				if(day>0&&day<=31){
					flag=true;
				}
			}else if(month==4||month==6||month==9||month==11){
				if(day>0&&day<31){
					flag=true;
				}
			}else if(month ==2){
				if(checkYear(year)){
					if(day>0&&day<30){
						flag =true;
					}
				}else{
					if(day>0&&day<29){
						flag =true;
					}
				}
			}
		}while(flag==false);
	}
	public void print(){
		System.out.println("My date is: "+day+"/"+month+"/"+year);
	}
}

