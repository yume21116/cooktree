package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Reshipi;
import utils.DBUtil;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _token = (String)request.getParameter("_token");
		if(_token != null && _token.equals(request.getSession().getId())){
		    EntityManager em = DBUtil.createEntityManager();

		    Reshipi r = new Reshipi();

		    String name = request.getParameter("name");
		    r.setName(name);

		    String content = request.getParameter("content");
		    r.setContent(content);

		    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		    r.setCreated_at(currentTime);
		    r.setUpdated_at(currentTime);

		    em.getTransaction().begin();
		    em.persist(r);
		    em.getTransaction().commit();
		    em.close();

		    response.sendRedirect(request.getContextPath() + "/index");

		}
	}

}
