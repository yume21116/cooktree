package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Picture;
import models.Reshipi;
import utils.DBUtil;

/**
 * Servlet implementation class ShowSevlet
 */
@WebServlet("/show")
public class ShowSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.createEntityManager();

		Reshipi r = em.find(Reshipi.class, Integer.parseInt(request.getParameter("id")));


		List<Picture> my_p = em.createNamedQuery("GetMyAllPictures",Picture.class)
		        .setParameter("reshipi_id",r)
		        .getResultList();


		em.close();

		request.setAttribute("my_p", my_p);
		request.setAttribute("reshipi", r);


		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reshipis/show.jsp");
		rd.forward(request, response);
	}

}
