package org.wpattern.frameworks.test.hibernate4.daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.wpattern.frameworks.hibernate4.daos.CategoryDao;
import org.wpattern.frameworks.hibernate4.entities.CategoryEntity;
import org.wpattern.frameworks.hibernate4.utils.DaoFactory;

public class CategoryRepositoryTest {

	private static final Logger LOGGER = Logger.getLogger(CategoryRepositoryTest.class);

	private CategoryDao categoryDao = DaoFactory.categoryInstance();

	@Test
	public void testFindAll() {
		List<CategoryEntity> categories = this.categoryDao.findAll();

		LOGGER.info(categories);
	}

	@Test
	public void testFindById() {
		Long id = this.save().getId();

		CategoryEntity category = this.categoryDao.findById(id);

		LOGGER.info(category);
	}

	@Test
	public void testInsert() {
		this.save();
	}

	@Test
	public void testDelete() {
		CategoryEntity category = this.save();

		this.categoryDao.delete(category);

		LOGGER.info("Category deleted " + category);
	}

	@Test
	public void testFindCategoryName() {
		List<CategoryEntity> categories = this.categoryDao.findByCategoryName("Beverages");

		LOGGER.info(categories);
	}

	private CategoryEntity save() {
		CategoryEntity category = new CategoryEntity("Name", "Description", null);

		this.categoryDao.save(category);

		LOGGER.info("Category saved " + category);

		return category;
	}

}
