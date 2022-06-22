

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nogizaka.Nogizakalist;
/**
 * Servlet implementation class infulencer
 */
@WebServlet("/infulencer")
public class infulencer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public infulencer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "jdbc:postgresql://localhost:5432/sampledb";
		String user = "postgres";
		String password = "Hiro0714";

		// 本のタイトルを格納するList
		List<Nogizakalist> books = new ArrayList<>();

		// データベースに接続する
		try {
			Class.forName("org.postgresql.Driver");

			try (Connection con = DriverManager.getConnection(url, user, password);
					Statement st = con.createStatement();){

				// SQLを実行して、テーブルから本のタイトルを取得する
				ResultSet res = st.executeQuery("SELECT * from nogizakamember");

				// 取得した件数分繰り返す
				while(res.next()) {
					// リストに乃木坂46メンバーの詳細を追加
					int id = res.getInt("id");
					String name = res.getString("Name");
					int dateofbirth = res.getInt("Dateofbirth");
					int old = res.getInt("Old");
					String birthplace = res.getString("Birthplace");
					String detail = res.getString("Detail");
					books.add(new Nogizakalist(id, name, dateofbirth, old, birthplace, detail));
				}
				res.close();
				st.close();

			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		// リクエストスコープへオブジェクト設定する
		request.setAttribute("books", books);

		// 次の画面に遷移
		request.getRequestDispatcher("WEB-INF/list.jsp").forward(request, response);
		}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
