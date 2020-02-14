package nilam.com;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.ws.Response;

public class MovieDAoimpl  implements MovieDAO{

	public MovieDAoimpl() {
		// TODO Auto-generated constructor stub
	}
	public int insertMovie(Movie movie) {
		Databaseutility databaseutility = new Databaseutility();
		int flag=0;
		try {
				System.out.println(movie.getMovieName());
				Connection con= databaseutility.getDBConnection();
				PreparedStatement ps = con.prepareStatement("INSERT INTO movie1(Name,Description)values(?,?)");			
				ps.setString(1, movie.getMovieName());
				ps.setString(2, movie.getMovieDescription());
				int response=ps.executeUpdate();
				if (response==1) {
					flag= 1;
				}else {
					flag= 0;
				}
				
				
				con.close();
			}catch (ClassNotFoundException e) {
				
			}catch (Exception e) {
			e.printStackTrace();
		    }
			return flag;
     }
	
	public int updateMovie(Movie movie ) {
		Databaseutility databaseutility = new Databaseutility();
		//Movie movie = new Movie();
		int flag=0;
		try {
				System.out.println(movie.getMovieName());
				Connection con= databaseutility.getDBConnection();
				PreparedStatement ps = con.prepareStatement("UPDATE `movie1` SET `Name`=?,`Description`=? WHERE id=?");					
				ps.setString(1, movie.getMovieName());
				ps.setString(2, movie.getMovieDescription());
				ps.setInt(3, movie.getMovieId());
				int response=ps.executeUpdate();
				if (response==1) {
					flag= 1;
				}else {
					flag= 0;
				}
				
				
				con.close();
			}catch (ClassNotFoundException e) {
				
			}catch (Exception e) {
			e.printStackTrace();
		    }
			return flag;
	}
	public int movieExist(int id) {
		Databaseutility databaseutility = new Databaseutility();
		int flag=0;
		try {
			
			Connection con=databaseutility.getDBConnection();
			String Query = "select * from movie1 where id=?";
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setInt(1, id);
			ResultSet rs =ps.executeQuery();
			
			if(rs.next()) {
				flag=1;
			} 
			con.close();
			
		}catch (ClassNotFoundException e) {
			
	    }catch (Exception e) {
	    	e.printStackTrace();
	     }
		return flag;
     }		
	public Movie findMovieById(int id) {
		Databaseutility databaseutility = new Databaseutility();
		Movie movie = new Movie();
	
		try {			
			Connection con=databaseutility.getDBConnection();
			String Query = "select * from movie1 where id=?";
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setInt(1, id);
			ResultSet rs =ps.executeQuery();
			
			if(rs.next()) {
				movie.setMovieId(rs.getInt(1));
				movie.setMovieName(rs.getString(2));
				movie.setMovieDescription(rs.getString(3));
			} else {
				movie=null;
			}
			con.close();
			
		}catch (ClassNotFoundException e) {
			
	    }catch (Exception e) {
	    	e.printStackTrace();
	     }
		return movie;
     }	
	
	public Movie findMovieByName(String name) {
		Databaseutility databaseutility = new Databaseutility();
		Movie movie = new Movie();
	
		try {			
			Connection con=databaseutility.getDBConnection();
			String Query = "select * from movie1 where name=?";
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setString(1, name);
			ResultSet rs =ps.executeQuery();
			
			if(rs.next()) {
				movie.setMovieId(rs.getInt(1));
				movie.setMovieName(rs.getString(2));
				movie.setMovieDescription(rs.getString(3));
			} else {
				movie=null;
			}
			con.close();
			
		}catch (ClassNotFoundException e) {
			
	    }catch (Exception e) {
	    	e.printStackTrace();
	     }
		return movie;
     }	
	public int deleteMovie(Movie movie  ) {
		Databaseutility databaseutility = new Databaseutility();
		int flag=0;
		try {
				
				Connection con= databaseutility.getDBConnection();
				PreparedStatement ps = con.prepareStatement("DELETE FROM `movie1` WHERE id=?");					
				ps.setInt(1, movie.getMovieId());
				int response=ps.executeUpdate();
				System.out.println(response);
				if (response==1) {
					flag= 1;
				}else {
					flag= 0;
				}
				
				
				con.close();
			}catch (ClassNotFoundException e) {
				
			}catch (Exception e) {
			e.printStackTrace();
		    }
			return flag;
	}
	public ArrayList<Movie> getAllMovies()
	{
		System.out.println("inside getallmovies");
		ArrayList<Movie> movieList=new ArrayList<>();
		
		try {
			       Databaseutility databaseutility = new Databaseutility();
			       Connection con= databaseutility.getDBConnection();
			       java.sql.Statement ps=con.createStatement();
			       String query="SELECT * from movie1";
					
					ResultSet rs=(ps.executeQuery(query));
					java.sql.ResultSetMetaData rsmd=rs.getMetaData();
					while (rs.next())
					{
						Movie movie=new Movie();
						movie.setMovieId(rs.getInt(1));
						movie.setMovieName(rs.getString(2));
						movie.setMovieDescription(rs.getString(3));
						
						movieList.add(movie);
					}
					
		} catch (Exception e) {
			// TODO: handle exception
		}
		return movieList;
	}

	
}
