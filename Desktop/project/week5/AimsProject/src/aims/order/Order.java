package aims.order;
import java.util.Date;
import aims.disc.DigitalVideoDisc;
public class Order {
  public static final int MAX_NUMBERS_ORDERED = 10;
  private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
  private int qtyOrdered;
private MyDate dateOrderd= new MyDate();
  public int getQtyOrdered() {
    return qtyOrdered;
  }

  public void setQtyOrdered(int qtyOrdered) {
    this.qtyOrdered = qtyOrdered;
  }

  public void addDigitalVideoDisc(DigitalVideoDisc disc) {
    if (qtyOrdered < 10) {
      itemsOrdered[qtyOrdered] = disc;
      qtyOrdered++;
      System.out.println("The disc has been added!");
    } else {
      System.out.println("The order is almost full!");
    }
  }

  public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
    if (qtyOrdered > 0) {
      int index = -1;

      for (int i = 0; i < qtyOrdered; i++) {
        if (itemsOrdered[i].equals(disc)) {
          index = i;
          break;
        }
      }

      if (index == -1) {
        System.out.println("Disc is not in order!");
      } else {
        qtyOrdered--;
        for (int i = index; i < qtyOrdered; i++) {
          itemsOrdered[i] = itemsOrdered[i + 1];
        }
        System.out.println("The disc has been removed!");
      }
    } else {
      System.out.println("There is no disc in order!");
    }
  }

  public float totalCost() {
    float total = 0;

    for (int i = 0; i < qtyOrdered; i++) {
      total += itemsOrdered[i].getCost();
    }
    return total;
  }
public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
		 for(int i = 0; i < dvdList.length; i++)
		 {
			 if(this.qtyOrdered<MAX_NUMBERS_ORDERED) {
				 addDigitalVideoDisc(dvdList[i]);
			 }
			 else
			 {
				 System.out.println("Full disc");
				 break;
			 }
		 }
	}
public void printItemOfOrders() {
		System.out.println("***********************Order***********************");
		System.out.print("Date:");
		dateOrderd.print();
		for(int i = 1; i<=this.qtyOrdered; i++) {
			System.out.println(i+"-DVD-"+itemsOrdered[i].getTitle()+"-"+itemsOrdered[i].getCategory()+"-"+itemsOrdered[i].getDirector()+"-"+itemsOrdered[i].getLength()+":"+itemsOrdered[i].getCost()+"$"    );
		}
		System.out.println("Total cost:"+this.totalCost());
		System.out.println("***************************************************");
}
public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
                addDigitalVideoDisc(dvd2);

	}
	public MyDate getDateOrderd() {
		return dateOrderd;
	}

	public void setDateOrderd(MyDate dateOrderd) {
		this.dateOrderd = dateOrderd;
	}
}


