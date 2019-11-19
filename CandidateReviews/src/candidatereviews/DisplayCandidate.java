package candidatereviews;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.Statement;

//import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

@WebServlet("/DisplayCandidate")
public class DisplayCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayCandidate() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<CandidateEntry> entries = new ArrayList<CandidateEntry>();

		Connection c = null;
		try {

			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu39?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu39";
			String password = "5M21ZE.e";

			c = DriverManager.getConnection(url, username, password);
			java.sql.Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Candidate");

			while (rs.next()) {
				entries.add(new CandidateEntry(rs.getInt("id"), rs.getString("name"), rs.getString("specialty"),
						rs.getString("rating"), rs.getString("presentation")));
			}

			c.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}

		request.setAttribute("entry", entries);
		request.getRequestDispatcher("/WEB-INF/DisplayCandidate.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}