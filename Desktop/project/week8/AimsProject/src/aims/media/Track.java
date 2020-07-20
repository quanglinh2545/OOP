
public class Track implements Comparable{
private String title;
private int length;
public  void setTitle(String title){
    this.title = title;
}
public String getTitle(){
    return title;
}
public void setLength(int length){
    this.length = length;
}
public int getLength(){
    return length;
}
public int compareTo(Track t){
    if (this.getTitle() > t.getTitle()) return 1;
else if ( this.getTitle() < t.getTitle()) return -1;
return 0;
}
}