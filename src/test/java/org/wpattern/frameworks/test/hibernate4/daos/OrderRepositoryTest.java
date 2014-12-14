package org.wpattern.frameworks.test.hibernate4.daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.wpattern.frameworks.hibernate4.daos.OrderDao;
import org.wpattern.frameworks.hibernate4.entities.OrderEntity;
import org.wpattern.frameworks.hibernate4.utils.DaoFactory;

public class OrderRepositoryTest {

	private static final Logger LOGGER = Logger.getLogger(OrderRepositoryTest.class);

	private OrderDao orderDao = DaoFactory.orderInstance();

	@Test
	public void testFindAll() {
		List<OrderEntity> orders = this.orderDao.findAll();

		LOGGER.info(orders);
	}

}
