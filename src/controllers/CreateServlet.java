package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import models.Picture;
import models.Reshipi;
import models.validators.ReshipiValidator;
import utils.DBUtil;


@WebServlet("/create")
@MultipartConfig(maxFileSize = 20971520, maxRequestSize = 20971520, fileSizeThreshold = 1048576)
public class CreateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _token = getParamVal(request.getPart("_token")); // = (String) request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Reshipi r = new Reshipi();
            Picture p = new Picture();

            String name = getParamVal(request.getPart("name")); // = request.getParameter("name");
            r.setName(name);

            String content = getParamVal(request.getPart("content")); // = request.getParameter("content");
            r.setContent(content);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            r.setCreated_at(currentTime);
            r.setUpdated_at(currentTime);

            String file_name = getParamVal(request.getPart("file_name"));
            p.setFile_name(file_name);

            p.setReshipi_id(r);



            //画像フォームから受け取った画像処理
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            Collection<Part> parts = request.getParts();

            for (Part part : parts) {
                String f_name = getFileName(part);
                if(!f_name.contains("no_p_name") && !f_name.isEmpty()){

                part.write(getServletContext().getRealPath("/images") + "/" + f_name);
                response.getWriter().append("アップロード:").append(f_name);
                p.setFile_name(f_name);
                }

            }

            List<String> errors = ReshipiValidator.validate(r,p);
            if (errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("content", r);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reshipis/new.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.persist(r);
                em.persist(p);
                em.getTransaction().commit();
                request.getSession().setAttribute("flush", "登録が完了しました");
                em.close();

                response.sendRedirect(request.getContextPath() + "/index");
            }

        }


    }

    private String getFileName(Part part) {
        for (String cd : part.getHeader("Content-Disposition").split(";")) {
            String str = cd.trim();
            if (str.startsWith("filename")) {
                String str2 = str.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                File f = new File(str2);
                return f.getName();
            }
        }
        return "no_p_name";
    }

    private String getParamVal(Part part) {
        if (part.getContentType() == null) {
            try {
                InputStream inputStream = part.getInputStream();
                BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream));
                return bufReader.lines().collect(Collectors.joining());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    	}
        return null;
    }


}