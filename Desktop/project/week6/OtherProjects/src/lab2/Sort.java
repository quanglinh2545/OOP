import java.util.Scanner;
import java.text.DecimalFormat;
public class Sort{
	public static void main(String[] args) {
		
        int n =0, i,j,t,min;
        int tong = 0;
        int[] arr = new int[20];
        float averge;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        Scanner getInput = new Scanner(System.in);
		System.out.println("Nhap vao so phan tu: ");
		n = getInput.nextInt();
		//int[] arr = new int[n];
		for (i = 0; i < n; i++) {
			System.out.println("Nhap phan tu A["+ i +"]: ");
            arr[i] = getInput.nextInt();
            
		}
        min = arr[0];
        for(i =0;i<n;i++){
            for(j=i;j<n;j++){
                if (arr[j] < arr[i]){
                    t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }
        }
		
        for (i=0;i<n;i++) {
            tong += arr[i];
        System.out.print(arr[i]+" ");}
        averge = (float) tong/n;
System.out.print("\n");
System.out.println(" Sum = " + tong);
System.out.println("Averge = " + decimalFormat.format(averge));
    
		getInput.close();
		System.exit(0);
	}
}
