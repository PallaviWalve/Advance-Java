package entertainment.bean;

public class MovieData {
	private String movieTitle;
	private int movieYear;
	
	public MovieData() {
		
	}
	
	public MovieData(String movieTitle, int movieYear) {
		super();
		this.movieTitle = movieTitle;
		this.movieYear = movieYear;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public int getMovieYear() {
		return movieYear;
	}
	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}
	@Override
	public String toString() {
		return "MovieData [movieTitle=" + movieTitle + ", movieYear=" + movieYear + "]";
	}

}
