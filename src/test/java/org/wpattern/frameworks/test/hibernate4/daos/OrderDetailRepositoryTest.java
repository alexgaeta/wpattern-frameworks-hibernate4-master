package org.wpattern.frameworks.test.hibernate4.daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.wpattern.frameworks.hibernate4.daos.OrderDetailDao;
import org.wpattern.frameworks.hibernate4.entities.OrderDetailEntity;
import org.wpattern.frameworks.hibernate4.utils.DaoFactory;

public class OrderDetailRepositoryTest {

	private static final Logger LOGGER = Logger.getLogger(OrderDetailRepositoryTest.class);

	private OrderDetailDao orderDetailDao = DaoFactory.orderDetailInstance();

	@Test
	public void testFindAll() {
		List<OrderDetailEntity> orderDetails = this.orderDetailDao.findAll();

		LOGGER.info(orderDetails);
	}

}
