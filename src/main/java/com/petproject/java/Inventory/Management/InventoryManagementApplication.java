package com.petproject.java.Inventory.Management;

import com.petproject.java.Inventory.Management.dao.AppDAO;
import com.petproject.java.Inventory.Management.enntity.Role;
import com.petproject.java.Inventory.Management.enntity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createUserWithRoles(appDAO);
//			findUser(appDAO);
//			deleteUser(appDAO);
//			findUserDetail(appDAO);
//			findUserWithRoles(appDAO);
		};
	}

	private void findUserWithRoles(AppDAO appDAO) {
		String userId = "john.s";
		System.out.println("Finding userId: " + userId);
		User tempUser = appDAO.findUserByUserId(userId);
		System.out.println("TempUser: " + tempUser);
		System.out.println("the associated roles: " + tempUser.getRoles());
		System.out.println("Done");
	}

	private void createUserWithRoles(AppDAO appDAO) {
		//create a user
		User tempUser = new User("suvb.S", "ivan", "smith","I.Ivanov2@gmail.com", "$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q", 1);

		//creates some roles
		Role tempRoles1 = new Role("ROLE_EMPLOYEE");
		Role tempRoles2 = new Role("ROLE_MANAGER");

		tempUser.add(tempRoles1);
		tempUser.add(tempRoles2);

		//saving user into DB
		System.out.println("Saving user: " + tempUser);
		System.out.println("The roles: " + tempUser.getRoles());
		appDAO.save(tempUser);

		System.out.println("Done");
	}

	private void deleteUser(AppDAO appDAO) {
		String userId = "john.s";
		System.out.println("Deleting user id: " + userId);
		appDAO.deleteByUserId(userId);
		System.out.println("Done");
	}

	private void findUser(AppDAO appDAO) {
		String userId = "susan.s";
		System.out.println("Finding userId: " + userId);
		User tempUser = appDAO.findUserByUserId(userId);

//		tempUser.setRoles(List.of(new Roles("ROLE_EMPLOYEE")));
		System.out.println("TempUser: " +tempUser);
		System.out.println("The associated roles only: " +tempUser.getRoles()); //doest work


	}

}
