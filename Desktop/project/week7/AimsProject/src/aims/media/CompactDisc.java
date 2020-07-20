class CompactDisc extends Disc {
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
    
}