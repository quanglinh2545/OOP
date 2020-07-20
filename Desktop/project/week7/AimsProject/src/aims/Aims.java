package aims;
import aims.disc.DigitalVideoDisc;
import aims.order.Order;
public class Aims {
  public static void main(String[] args) {
    public static void showMenu() {
      System.out.println("\n\nOrder Management Application: ");
      System.out.println("-----------------------------------");
      System.out.println("1.Create order");
      System.out.println("2.Add item to the order");
      System.out.println("3.Delete item by id");
      System.out.println("4.Display the items list of order");
      System.out.println("0.Exit");
      System.out.println("-----------------------------------");
      System.out.println("Please choose a number: 0-1-2-3-4");
    }
    int k;
    Order order = null;
		Scanner input =  new Scanner(System.in);
			do {
				showMenu();
				choiceNumber = input.nextInt();
				switch (k) {
					case 1:
						System.out.println("ok");
						break;
					case 2:
							int type = input.nextInt();
							if(type == 1) {
								System.out.println("Nhap so luong: ");
								int n = input.nextInt();
								Book [] book = new Book[n];
								order.getInforBooks(book);
								order.addMediaList(book);
								System.out.println("ok");
			
						}
						break;
					case 3:
						if(order == null) {
							System.out.println("fail");
						}else {
							System.out.println("nhap vao stt:");
							int stt = input.nextInt();
							order.removeMediaByID(stt);
						}
						break;
					case 4:
						if(order == null) {
							System.out.println("fail!");
						}else {
							order.showOrder();
						}
						break;
					case 0:
						System.exit(0);
				}
			}while(k != 0);
		
	}
	   
}

