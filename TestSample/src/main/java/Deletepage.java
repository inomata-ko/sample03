

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deletepage
 */
@WebServlet("/Deletepage")
public class Deletepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deletepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID = request.getParameter("id");
		
		
		String url = "jdbc:postgresql://localhost:5432/sampledb";
		String user = "postgres";
		String password = "Hiro0714";
		String SQL = "DELETE FROM nogizakamember WHERE id="+ID;

	try {
		Class.forName("org.postgresql.Driver");

		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement preStatement = con.prepareStatement(SQL)) {
			
			int count = preStatement.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	request.getRequestDispatcher("/infulencer").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ID = request.getParameter("id");
		request.setAttribute("id", ID);
		
		String url = "jdbc:postgresql://localhost:5432/sampledb";
		String user = "postgres";
		String password = "Hiro20020714";
		String SQL = "DELETE FROM nogizakamember WHERE ID="+ID;

	try {
		Class.forName("org.postgresql.Driver");

		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement preStatement = con.prepareStatement(SQL)) {
			
			int count = preStatement.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	request.getRequestDispatcher("/infulencer").forward(request, response);
	}
}

