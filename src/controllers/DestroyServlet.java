package controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Picture;
import models.Reshipi;
import utils.DBUtil;

/**
 * Servlet implementation class DestroyServlet
 */
@WebServlet("/destroy")
public class DestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestroyServlet() {
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

		    Reshipi r = em.find(Reshipi.class, (Integer)(request.getSession().getAttribute("reshipi_id")));
		    List<Picture> my_p = em.createNamedQuery("GetMyAllPictures",Picture.class)
		                        .setParameter("reshipi_id",r)
		                        .getResultList();

		    List<String> deleteFiles = new ArrayList<>();


		    em.getTransaction().begin();
		    for(Picture p : my_p){
		        String fileName = p.getFile_name();
		        String realPath = request.getServletContext().getRealPath("images/" + fileName);
		        deleteFiles.add(realPath);
		        em.remove(p);
		    }
		    em.remove(r);
		    em.getTransaction().commit();
		    request.getSession().setAttribute("flush", "削除が完了しました。");
		    em.close();

            for(String path : deleteFiles){
                Files.deleteIfExists(Paths.get(path));
            }

		    request.getSession().removeAttribute("reshipi_id");
		    request.getSession().removeAttribute("reshipi_id");



		    response.sendRedirect(request.getContextPath() + "/index");
		}
	}

}
