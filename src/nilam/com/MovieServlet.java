package nilam.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MovieServlet extends HttpServlet {
	Movie movie = new Movie();

	private static final long serialVersionUID = 8680572469009018162L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		//movie.setMovieId(Integer.parseInt((req.getParameter("txtId"))));		
		movie.setMovieName(req.getParameter("txtName"));
		movie.setMovieDescription(req.getParameter("txtDescription"));
		
		MovieDAoimpl movieDAoimpl=new MovieDAoimpl();
		
		PrintWriter pw=resp.getWriter();
		int r=movieDAoimpl.insertMovie(movie);
		if(r==1) {
			//pw.println("ID:"+movie.getMovieId());
			pw.println("Name:"+movie.getMovieName());
			pw.println("Description:"+movie.getMovieDescription());
			
			pw.println("Sucessfully insert");
		}
		else {
			pw.println("Failure");
			
		}
		
		
		
		
       }

   }
