package org.wpattern.frameworks.hibernate4.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.wpattern.frameworks.hibernate4.daos.CategoryDao;
import org.wpattern.frameworks.hibernate4.entities.CategoryEntity;
import org.wpattern.frameworks.hibernate4.utils.DaoFactory;

@WebServlet(urlPatterns = "/category/delete")
public class CategoryDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 2669143672190422783L;

	private static final Logger LOGGER = Logger.getLogger(CategoryDeleteServlet.class);

	private CategoryDao categoryDao = DaoFactory.categoryInstance();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");

		LOGGER.info(String.format("Deleting the category [%s].", id));

		if (id == null) {
			resp.sendRedirect("/category/list.jsp?error=ID not founded.");
			return;
		}

		try {
			CategoryEntity entity = this.categoryDao.findById(Long.parseLong(id));

			if (entity != null) {
				this.categoryDao.delete(entity);

				resp.sendRedirect("/category/list.jsp");
			} else {
				resp.sendRedirect("/category/list.jsp?error=Category not founded.");
			}
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
			resp.sendRedirect("/category/list.jsp?error=" + ex.getMessage());
		}
	}

}
