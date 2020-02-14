package nilam.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchMovieServlet
 */
@WebServlet("/SearchMovieServlet")
public class SearchMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDAoimpl movieDAoimpl=new MovieDAoimpl();
		Movie movie=new Movie();
		String radio_choice=request.getParameter("movieradio");
		String txtdata=request.getParameter("txtSearch");
		PrintWriter pw=response.getWriter();
		      if (radio_choice.equalsIgnoreCase("Id")) {
		    	  if (!txtdata.isEmpty()) {
		    		  movie= movieDAoimpl.findMovieById(Integer.parseInt(txtdata));
		    		  if (movie!= null) {
		    			 
		    			  pw.println("Id"+movie.getMovieId());
		    			  pw.println("Name"+movie.getMovieName());
		    			  pw.println("Description"+movie.getMovieDescription());
		    			  
					}else {
						 pw.println("No data found");
					}
		    		 
		    	  }else if (radio_choice=="Name") {
		    		  if (!txtdata.isEmpty()) {
		    			   movie=movieDAoimpl.findMovieByName(txtdata);
		    			   if (movie!= null) {
				    			 
				    			  pw.println("Id"+movie.getMovieId());
				    			  pw.println("Name"+movie.getMovieName());
				    			  pw.println("Description"+movie.getMovieDescription());
				    			  
							}else {
								 pw.println("No data found");
							}
						
					}
					
				}
		    	  
					
				}
				
			}
	
	}


