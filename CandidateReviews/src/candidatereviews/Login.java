package candidatereviews;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import candidatereviews.CandidateEntry;
import candidatereviews.Feedback;
import candidatereviews.LoginDetails;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

	public void init() throws ServletException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.sendRedirect("Login.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String Username = request.getParameter("n1");
		String password1 = request.getParameter("n2");

		ArrayList<LoginDetails> userDetails = new ArrayList<LoginDetails>();
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu39";
			String username = "cs3220stu39";
			String password = "5M21ZE.e";
			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");

			while (rs.next()) {

				LoginDetails entry = new LoginDetails(rs.getString("userId"), rs.getString("username"),
						rs.getString("emailid"), rs.getString("password"), rs.getString("role"));
				userDetails.add(entry);

			}

			if (username.equals("hp") && password.equals("admin")) {

				request.getSession().setAttribute("username", "hp");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("DisplayCandidate.jsp");
				rd.forward(request, response);
			}

			else if (userDetails.size() != 0) {

				for (LoginDetails x : userDetails) {
					if (username.equals(x.getEmailid()) && password.equals(x.getPassword())) {
						request.getSession().setAttribute("emailId", x.getUsername());
						getServletContext().setAttribute("username", x.getUsername());
						response.sendRedirect("DisplayCamdidate");
						return;
					}
				}
			}

			else {
				response.sendRedirect("Login.jsp");
				return;
			}

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

	}
}