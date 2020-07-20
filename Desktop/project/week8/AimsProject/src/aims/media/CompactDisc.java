class CompactDisc extends Disc implements Comparable{
    private String artist;
    private int length;
    private ArrayList<Track> tracks=new ArrayList<Track>();
	
    public CompactDisc(String title){
		super(title);
	}
	
	public CompactDisc(String title, String category){
		super(title, category);
	}
	
	public CompactDisc(String title, String category, String director){
		super(title, category, director);
	}
	
	public CompactDisc(String title, String category, String director, int length, float cost){
		super(title, category, director, length, cost);
  }
  public void setArtist(String artist) {
    this.artist = artist;
  }
  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }
    public void addTrack(Track track) {
        tracks.add(track);
        System.out.println("done");
      }
    
      public void removeTrack(Track track) {
        if (tracks.remove(track)) {
          System.out.println("done");
          return;
        }
      }
      public int compareTo(CompactDisc disc) {
      if (this.getArtist() >disc.getArtist()) return 1;
        else if ((this.getArtist() <disc.getArtist()) return -1;
          return 0;
        }
    
}