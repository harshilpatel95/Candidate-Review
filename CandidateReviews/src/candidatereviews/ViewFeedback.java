package candidatereviews;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import candidatereviews.CandidateEntry;
import candidatereviews.Feedback;

@WebServlet("/ViewFeedback")
public class ViewFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewFeedback() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CandidateEntry entry = new CandidateEntry();
		List<Feedback> feedback = new ArrayList<Feedback>();
		int id = Integer.valueOf(request.getParameter("id"));

		Connection c = null;
		try {

			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu39?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu39";
			String password = "5M21ZE.e";

			c = DriverManager.getConnection(url, username, password);

			String sql = "select * from Candidate where id=? ";
			String sql1 = "select * from Feedback where owner_id=?";

			PreparedStatement pstmt = c.prepareStatement(sql);
			PreparedStatement pstmt1 = c.prepareStatement(sql1);

			pstmt.setInt(1, id);
			pstmt1.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			ResultSet rs1 = pstmt1.executeQuery();

			while (rs.next()) {
				entry = (new CandidateEntry(rs.getInt("id"), rs.getString("name"), rs.getString("specialty"),
						rs.getString("rating"), rs.getString("presentation")));
			}

			while (rs1.next()) {
				feedback.add(new Feedback(rs1.getInt("rate"), rs1.getString("name1"), rs1.getString("comment"),
						rs1.getDate("date")));

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
		request.setAttribute("feedback", feedback);

		request.setAttribute("id", id);

		request.getRequestDispatcher("/WEB-INF/Feedback.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Feedback> feedback = new ArrayList<Feedback>();

		Integer id = Integer.valueOf(request.getParameter("id"));
		int rate = Integer.parseInt(request.getParameter("rate"));
		String name1 = request.getParameter("name1");
		String comment = request.getParameter("comment");

		Connection c = null;
		try {

			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu39?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu39";
			String password = "5M21ZE.e";

			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();

			String sql = "insert into Feedback (name1,comment,rate,date,owner_id) values (?, ?, ?, now(),?)";

			PreparedStatement pstmt = c.prepareStatement(sql);

			pstmt.setString(1, name1);
			pstmt.setString(2, comment);
			pstmt.setInt(3, rate);
			pstmt.setInt(4, id);
			pstmt.executeUpdate();

			String sql1 = "select * from Feedback where owner_id=?";

			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			pstmt1.setInt(1, id);

			ResultSet rs1 = pstmt1.executeQuery();

			while (rs1.next()) {
				feedback.add(new Feedback(rs1.getInt("rate"), rs1.getString("name1"), rs1.getString("comment"),
						rs1.getDate("date")));

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

		float r = 0;
		int n = 0;
		for (Feedback rate_f : feedback) {

			r += rate_f.getRate();
			n = feedback.size();
		}

		String rating = Float.toString(r / n);

		try {

			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu39?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu39";
			String password = "5M21ZE.e";

			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();

			String sql = "update Candidate set rating=? where id=?";

			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, rating);
			pstmt.setInt(2, id);

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

		doGet(request, response);

	}
}