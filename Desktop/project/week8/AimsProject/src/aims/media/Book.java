package hust.soict.ictglobal.aims.media;
public class Book extends Media implements Comparable{
    private List<String> authors= new ArrayList<String>();
    
	public Book() {
		super();
	}
	public Book(String title) {
		super(title);
	}
	public Book(String title,String category) {
		super(title,category);
	}
    public Book(String title,String category,List<String>authors) {
    	super(title,category);
    	this.authors=authors;
    }
	public List<String> getAuthors() {
		return authors;
	}
    public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public void addAuthor(String authorName) {
			authors.add(authorName);
		}
	}
	public void removeAuthor(String authorName) {
		if((authors.contains(authorName))) {
			authors.remove(authorName);
		}
	}
	public int compareTo(Book book){
		if (this.getTitle() > book.getTitle()) return 1;
		else if ( this.getTitle() < book.getTitle()) return -1;
		return 0;
	}
}
