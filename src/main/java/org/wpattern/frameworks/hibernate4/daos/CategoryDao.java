package org.wpattern.frameworks.hibernate4.daos;

import java.util.List;

import org.wpattern.frameworks.hibernate4.entities.CategoryEntity;
import org.wpattern.frameworks.hibernate4.utils.GenericDao;

public class CategoryDao extends GenericDao<CategoryEntity, Long> {

	@SuppressWarnings("unchecked")
	public List<CategoryEntity> findByCategoryName(String categoryName) {
		List<CategoryEntity> categories = (List<CategoryEntity>)
				this.executeQuery("SELECT c FROM CategoryEntity c WHERE c.categoryName = ?0", categoryName);

		return categories;
	}

}
