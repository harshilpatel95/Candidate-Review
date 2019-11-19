package candidatereviews;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import candidatereviews.CandidateEntry;
import candidatereviews.Feedback;

@WebServlet("/AddCandidate")
public class AddCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCandidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/AddCandidate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String specialities = request.getParameter("specialty");
		String presentation = request.getParameter("presentation");
		String rating = "N/A";

		Connection c = null;
		try {

			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu39?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu39";
			String password = "5M21ZE.e";

			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();

			String sql = "insert into Candidate (name,specialty,rating,presentation) values (?, ?, ?, ?)";

			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, specialities);
			pstmt.setString(3, rating);
			pstmt.setString(4, presentation);

			pstmt.executeUpdate();

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

		response.sendRedirect("DisplayCandidate");
	}

}
