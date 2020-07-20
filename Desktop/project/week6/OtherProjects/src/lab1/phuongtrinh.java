import java.text.DecimalFormat;
import java.util.Scanner;
public class phuongtrinh{
    public static void main(String [] args){
        int a,b,c,d;
        float x;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        Scanner get = new Scanner(System.in);
        System.out.println(" Phương trình có dạng: Ax + b = c");
        System.out.println("Nhập vào a: ");
        a = get.nextInt();
        System.out.println("Nhập vào b: ");
        b = get.nextInt();
        System.out.println("Nhập vào c: ");
        c = get.nextInt();
        x =  (float)(c-b)/a;
        System.out.println(" x = " + x);
        get.close();
System.exit(0);

    }
}