package nilam.com;
import java.util.ArrayList;

public interface MovieDAO {

	public int insertMovie(Movie movie ) ;
	public int updateMovie(Movie movie );
	public int movieExist(int id) ;
	public Movie findMovieById(int id) ;
	public Movie findMovieByName(String name);
	public int deleteMovie(Movie movie );
	public ArrayList<Movie> getAllMovies();

}
