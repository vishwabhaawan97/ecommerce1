package DAO;

import java.util.List;

import model.category;

public interface CategoryDAO {

	void insert(category c);

	void update(category c);

	void delete(int cid);

	category getCategory(int cid);

	List<category> getCategory();

}
