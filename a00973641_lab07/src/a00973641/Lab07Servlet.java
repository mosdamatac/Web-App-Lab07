package a00973641;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import a00973641.database.dao.DbDao;

/**
 * Servlet implementation class Lab07Servlet
 */
public class Lab07Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		String sql = request.getParameter("queryBox");

		// set cookie value
		Cookie sqlCookie = new Cookie("sqlValue", sql);
		response.addCookie(sqlCookie);

		// Set sql string as http session attribute
		HttpSession session = request.getSession();
		session.setAttribute("sqlString", sql);

		// Get data from query
		DbDao.getData(request, response, ctx, sql);

		// Show result page
		RequestDispatcher rd = ctx.getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
