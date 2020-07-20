public class Order {
  public static final int MAX_NUMBERS_ORDERED = 10;
  private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
  private int qtyOrdered;

  public int getQtyOrdered() {
    return qtyOrdered;
  }

  public void setQtyOrdered(int qtyOrdered) {
    this.qtyOrdered = qtyOrdered;
  }

  public void addDigitalVideoDisc(DigitalVideoDisc disc) {
    if (qtyOrdered < MAX_NUMBERS_ORDERED) {
      itemsOrdered[qtyOrdered] = disc;
      qtyOrdered++;
      System.out.println("disc "+qtyOrdered+ " has been added!");
    } else {
      System.out.println("The order is almost full!");
    }
  }
public void addDigitalVideoDisc( DigitalVideoDisc [] dvdList){
for (int i =0;i<dvdList.length;i++){
  if(this.qtyOrdered < MAX_NUMBERS_ORDERED){
   addDigitalVideoDisc(dvdList[i]);
  }
  else {
    System.out.println("The order is full!");
    break;
  }
}
}
public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
if(this.qtyOrdered == MAX_NUMBERS_ORDERED)
  System.out.println("dvd1 and dvd2 could not be added!");
else{
  addDigitalVideoDisc(dvd1);
  if (this.qtyOrdered == MAX_NUMBERS_ORDERED)
  System.out.println("dvd2 could not be added!");
  else
addDigitalVideoDisc(dvd2);
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
public void printOrder(){
if(qtyOrdered > 0)
for(int i = 0;i<qtyOrdered;i++){
  System.out.println("---------------------------------------------------");
System.out.println(" Disc " +(i+1)+":");
itemsOrdered[i].printDisc();

}
}
}


