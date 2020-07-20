import java.util.Date;  
public class DateUtils {
	static int Compare(Date date1, Date date2) {  
        int comp=date1.compareTo(date2);  
        return comp;
	}
	
	public void GetCompare(Date date1, Date date2) {
		int comp=Compare(date1, date2);
		if(comp==0) System.out.println("equal");
		else if(comp<0) System.out.println(date2+" > "+date1);
        else System.out.println(date1+" < "+date2);
	}
	
	static void compareArrayDates(Date[] date, int length) {
		for(int i=0; i<length-1; i++)
			for(int j=length-1; j>i; j--)
				for(int k=i; k<length-1; k++)
				if(Compare(date[k],date[k+1])>0) {
						Date t;
						t=date[k];
						date[k]=date[k+1];
						date[k+1]=t;
					}
	}
}

