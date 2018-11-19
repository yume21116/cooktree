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

import models.Reshipi;
import utils.DBUtil;

/**
 * Servlet implementation class CookTreeIndex
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    EntityManager em = DBUtil.createEntityManager();

    int page;
    try{
        page = Integer.parseInt(request.getParameter("page"));
    }catch(Exception e){
        page = 1;
    }
    List<Reshipi> reshipis = em.createNamedQuery("getAllReshipis",Reshipi.class)
                                .setFirstResult(5 * (page - 1))
                                .setMaxResults(5)
                                .getResultList();

    long reshipis_count = (long)em.createNamedQuery("GetReshipisCount",Long.class)
                                    .getSingleResult();


    response.getWriter().append(Integer.valueOf(reshipis.size()).toString());


    em.close();

    request.setAttribute("reshipis", reshipis);
    request.setAttribute("reshipis_count", reshipis_count);
    request.setAttribute("page", page);

    if(request.getSession().getAttribute("flush") != null){
        request.setAttribute("flush", request.getSession().getAttribute("flush"));
        request.getSession().removeAttribute("flush");

    }

    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reshipis/index.jsp");
    rd.forward(request,response);
    }

}