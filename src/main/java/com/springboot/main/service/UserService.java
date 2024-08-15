package com.springboot.main.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Admin;
import com.springboot.main.model.Customer;
import com.springboot.main.model.Host;
import com.springboot.main.model.User;
import com.springboot.main.repository.AdminRepository;
import com.springboot.main.repository.CustomerRepository;
import com.springboot.main.repository.HostRepository;
import com.springboot.main.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private HostRepository hostRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// TO SAVE A USER IN DB

	public User addNewUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user = userRepository.save(user);
		if (user.getRole().equals("HOST")) {
			Host host = new Host();
			host.setHostEmail(user.getEmailId());
			host.setHostName(user.getUsername());
			host.setHostContact(user.getMobile());
			host.setUser(user);
			hostRepository.save(host);
		} else if (user.getRole().equals("CUSTOMER")) {
			Customer c = new Customer();
			c.setMobile(user.getMobile());
			c.setEmailId(user.getEmailId());
			c.setAge(user.getAge());
			c.setArea(user.getArea());
			c.setCity(user.getCity());
			c.setDate(new Date());
			c.setUser(user);
			customerRepository.save(c);
		} else if(user.getRole().equals("ADMIN")) {
			Admin a = new Admin();
			a.setAdminName(user.getUsername());
			a.setEmail(user.getEmailId());
			a.setPhoneNo(user.getMobile());
			a.setUser(user);
			adminRepository.save(a);
		}
		return user;
	}

	// GET ALL USERS
	public List<User> getAllUsers(Pageable pageable) {

		return userRepository.findAll(pageable).getContent();
	}

	// GET USER BY ID
	public User getById(int uid) throws InvalidIdException {
		Optional<User> optional = userRepository.findById(uid);
		if (!optional.isPresent())
			throw new InvalidIdException("UserID Invalid");
		return optional.get();
	}

	// TO DELETE A USER

	public void deleteUser(int uid) {
		userRepository.deleteById(uid);

	}

}
