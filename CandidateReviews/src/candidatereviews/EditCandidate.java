package candidatereviews;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import candidatereviews.CandidateEntry;

@WebServlet("/EditCandidate")
public class EditCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditCandidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CandidateEntry entry = new CandidateEntry();

		int id = Integer.valueOf(request.getParameter("id"));
		Connection c = null;
		try {

			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu39?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu39";
			String password = "5M21ZE.e";

			c = DriverManager.getConnection(url, username, password);

			String sql = "select * from Candidate where id=?";
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				entry = (new CandidateEntry(rs.getInt("id"), rs.getString("name"), rs.getString("specialty"),
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

		request.setAttribute("entry", entry);
		request.setAttribute("id", id);
		request.getRequestDispatcher("/WEB-INF/EditCandidate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.valueOf(request.getParameter("id"));

		String name = request.getParameter("name");
		String specialities = request.getParameter("specialty");
		String presentation = request.getParameter("presentation");

		Connection c = null;
		try {

			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu39?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu39";
			String password = "5M21ZE.e";

			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();

			String sql = "update Candidate set name=?,specialty=?,presentation=? where id=? ";

			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, specialities);
			pstmt.setString(3, presentation);
			pstmt.setInt(4, id);

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