

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
 * Servlet implementation class Updatepage
 */
@WebServlet("/Updatepage")
public class Updatepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
		String id_ = request.getParameter("id");
		request.setAttribute("id", id_);
		request.getRequestDispatcher("WEB-INF/update.jsp").forward(request, response);
		
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String url = "jdbc:postgresql://localhost:5432/sampledb";
		String user = "postgres";
		String password = "Hiro0714";


	try {
		Class.forName("org.postgresql.Driver");

		try (Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement preStatement = con.prepareStatement("update  Nogizakamember set Name=?,Dateofbirth=?,Old=?,Birthplace=?,Detail=? WHERE id = ?")) {
		String id_ = request.getParameter("id");
		String Name = request.getParameter("Name");
		String Dateofbirth =  request.getParameter("Dateofbirth");
		String Old = request.getParameter("Old");
		String Birthplace = request.getParameter("Birthplace");
		String Detail = request.getParameter("Detail");
		int old = Integer.parseInt(Old);
		int dateofbirth = Integer.parseInt(Dateofbirth);
		int id = Integer.parseInt(id_);
		
		
		preStatement.setString(1, Name);
		preStatement.setInt(2,dateofbirth);
		preStatement.setInt(3, old);
		preStatement.setString(4,Birthplace);
		preStatement.setString(5, Detail);
		preStatement.setInt(6, id);
		
		preStatement.executeUpdate();

	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
				
				// 次の画面に遷移
				request.getRequestDispatcher("/infulencer").forward(request, response);
	}
}catch(ClassNotFoundException e) {
	e.printStackTrace();
}
	}

}
