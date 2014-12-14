package org.wpattern.frameworks.hibernate4.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.wpattern.frameworks.hibernate4.daos.CategoryDao;
import org.wpattern.frameworks.hibernate4.entities.CategoryEntity;
import org.wpattern.frameworks.hibernate4.utils.DaoFactory;

@WebServlet(urlPatterns = { "/category/edit", "/category/add" })
public class CategoryEditServlet extends HttpServlet {

	private static final long serialVersionUID = 2669143672190422783L;

	private static final Logger LOGGER = Logger.getLogger(CategoryEditServlet.class);

	private CategoryDao categoryDao = DaoFactory.categoryInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		if ((id == null) || id.trim().isEmpty()) {
			resp.sendRedirect("/category/addEdit.jsp");
			return;
		}

		try {
			CategoryEntity entity = this.categoryDao.findById(Long.parseLong(id));

			if (entity != null) {
				HttpSession session = req.getSession();

				session.setAttribute("id", entity.getId());
				session.setAttribute("categoryName", entity.getCategoryName());
				session.setAttribute("description", entity.getDescription());

				resp.sendRedirect("/category/addEdit.jsp");
			} else {
				resp.sendRedirect(String.format("/category/list.jsp?error=Category entity [%s] not founded.", id));
			}
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			resp.sendRedirect("/category/list.jsp?error=" + ex.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			CategoryEntity entity = this.parseToCategory(req);

			if (entity.getId() != null) {
				this.categoryDao.update(entity);
			} else {
				this.categoryDao.save(entity );
			}

			resp.sendRedirect("/category/list.jsp");
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
			resp.sendRedirect(String.format("/category/list.jsp?error=%s", ex.getMessage()));
		}
	}

	private CategoryEntity parseToCategory(HttpServletRequest req) {
		String id = req.getParameter("id");
		String categoryName = req.getParameter("categoryName");
		String description = req.getParameter("description");

		CategoryEntity category = new CategoryEntity();

		if ((id != null) && !id.trim().isEmpty()) {
			category.setId(Long.parseLong(id));
		}

		category.setCategoryName(categoryName);
		category.setDescription(description);

		return category;
	}

}
