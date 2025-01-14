package com.coderhouse.apis;

import java.util.List;

import com.coderhouse.intefaces.UserRestInterface;
import com.coderhouse.models.User;

@Component
public class UserRestApi implements UserRestInterface {

	private final String BASE_URL = "https://6785a8b7f80b78923aa422c4.mockapi.io/users";

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}

}
