package com.petproject.java.Inventory.Management;

import com.petproject.java.Inventory.Management.dao.AppDAO;
import com.petproject.java.Inventory.Management.enntity.Role;
import com.petproject.java.Inventory.Management.enntity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
//			findRolesForUser(appDAO);
//			findUserWithRolesJoinFetch(appDAO);
//			updateUser(appDAO);
			updateRole(appDAO);
		};
	}

	private void updateRole(AppDAO appDAO) {
		int userId = 2;
		//find the role

		System.out.println("Finding role for : " + userId);
		Role tempRole = appDAO.findRoleByUserId(userId);
		System.out.println("Updating role for user: " + tempRole);
		tempRole.setUserRoles("New role");

		appDAO.update(tempRole);
	}

	private void updateUser(AppDAO appDAO) {
		String userId = "susan.s";
		//find user
		System.out.println("Finding userId: " + userId);
		User tempUser = appDAO.findUserByUserIdJoinFetch(userId);
		System.out.println("TempUser: " + tempUser);
		//update some data for the user
		System.out.println("Updating user id: " + userId);
		tempUser.setLastName("Test Name");
		appDAO.update(tempUser);
		System.out.println("Done!");

	}

	private void findUserWithRolesJoinFetch(AppDAO appDAO) {
		String userId = "susan.s";
		//find user
		System.out.println("Finding userId: " + userId);
		User tempUser = appDAO.findUserByUserIdJoinFetch(userId);
		System.out.println("TempUser: " + tempUser);
		System.out.println("associated roles "+  tempUser.getRoles());
	}

	private void findRolesForUser(AppDAO appDAO) {
		String userId = "susan.s";
		System.out.println("Finding userId: " + userId);
		User tempUser = appDAO.findUserByUserId(userId);
		System.out.println("TempUser: " + tempUser);

		//find roles for user
		System.out.println("Finding roles for user id: " + userId);
//		List<Role> roles = appDAO.findRolesByUserId(userId);
		System.out.println(appDAO.findRolesByUserId(userId));
//		tempUser.setRoles(roles);
//		System.out.println("associated roles "+  tempUser.getRoles());
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


		System.out.println("TempUser: " +tempUser);
		System.out.println("The associated roles only: " +tempUser.getRoles()); //doest work


	}

}
