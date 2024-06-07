package entertainment.entity.annotations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //mark this class as an entity
@Table(name = "Movie_Master_Details") //mapped with database table
public class Movie {
	
	@Id //marks this field as an identity
	@Column(name = "movie_id") //mapped with column
	private Integer movieId;
	@Column(name = "movie_title")
	private String title;
	@Column(name = "movie_genre")
	private String genre;
	@Column(name = "movie_year")
	private int year;

	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(Integer movieId, String title, String genre, int year) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.year = year;
	}

//	@Id  we can do like this also
	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", year=" + year + "]";
	}

}
