
class Disc extends Media {
    private int length;
    private String director;
    public int getLength(){
        return length;
    }
    public void setLength(int length){
        this.length = length;
    }
    public String getDirector(){
        return director;
    }
    public void setDirector(String director){
        this.director = director;
    }
    public Disc(String title){
		super(title);
	}
	
	public Disc(String title, String category){
		super(title, category);
	}
	
	public Disc(String title, String category, String director){
		super(title, category);
		setDirector(director);
	}
	
	public Disc(String title, String category, String director, int length, float cost){
		super(title, category, cost);
		setDirector(director);
		setLength(length);
	}


}