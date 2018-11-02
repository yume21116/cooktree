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
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  EntityManager em = DBUtil.createEntityManager();
	  em.getTransaction().begin();

	  Reshipi r = new Reshipi();

	  String name = "おはぎ";
	  r.setName(name);

	  String content = "おいしく作れるかな？";
	  r.setContent(content);

	  
	  Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	  r.setCreated_at(currentTime);
	  r.setUpdated_at(currentTime);

	  em.persist(r);
	  em.getTransaction().commit();

	  response.getWriter().append(Integer.valueOf(r.getId()).toString());

	  em.close();
	}

}
