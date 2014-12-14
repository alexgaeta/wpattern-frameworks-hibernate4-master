package org.wpattern.frameworks.test.hibernate4.daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.wpattern.frameworks.hibernate4.daos.ProductDao;
import org.wpattern.frameworks.hibernate4.entities.ProductEntity;
import org.wpattern.frameworks.hibernate4.utils.DaoFactory;

public class ProductRepositoryTest {

	private static final Logger LOGGER = Logger.getLogger(ProductRepositoryTest.class);

	private ProductDao productDao = DaoFactory.productInstance();

	@Test
	public void testFindAll() {
		List<ProductEntity> products = this.productDao.findAll();

		LOGGER.info(products);
	}

}
