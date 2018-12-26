package DAO;

import java.util.List;


import model.Users;

public interface UsersDAO {
	
	void insert(Users c);

	void delete(int cid);

	Users getUsers(int cid);
	Users getUsers(String email,String password);
	List<Users> getUsers();
	
	String getUserAddress( String username );

}
