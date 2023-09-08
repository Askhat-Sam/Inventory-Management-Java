package com.petproject.java.Inventory.Management;

import com.petproject.java.Inventory.Management.dao.AppDAO;
import com.petproject.java.Inventory.Management.enntity.User;
import com.petproject.java.Inventory.Management.enntity.UserDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(AppDAO appDAO){
//		return runner -> {
////			createUser(appDAO);
////			findUser(appDAO);
////			deleteUser(appDAO);
////			findUserDetail(appDAO);
////			deleteUserDetail(appDAO);
//		};
//	}

	private void deleteUserDetail(AppDAO appDAO) {
		int theId = 4;
		System.out.println("Deleting userDetail id: " + theId);
		appDAO.deleteUserDetailById(theId);
		System.out.println("Done");
	}

	private void findUserDetail(AppDAO appDAO) {
		int theId = 3;

		//get the user detail object
		UserDetail tempUserDetail = appDAO.findUserDetailById(theId);

		//print the user detail
		System.out.println("tempUserDetail: " + tempUserDetail);

		//print the associated instructor
		System.out.println("the associated user: " + tempUserDetail.getUser());
	}

	private void deleteUser(AppDAO appDAO) {
		int theId=1;
		System.out.println("Deleting user id: " + theId);
		appDAO.deleteUserById(theId);
		System.out.println("Done");
	}

	private void findUser(AppDAO appDAO) {
		int theId=2;
		System.out.println("Finding user id: " + theId);
		User tempUser = appDAO.findUserById(theId);
		System.out.println("TempUser: " +tempUser);
		System.out.println("The associated userDetail only: " +tempUser.getUserDetail());
	}

	private void createUser(AppDAO appDAO) {
//		//create a user
//		User tempUser = new User("Ivan", "Ivanov", "I.Ivanov@gmail.com");
//		//create the user detail
//		UserDetail tempUserDetail = new UserDetail("Store");

		//create a user
		User tempUser = new User("Ivan2", "Ivanov2", "I.Ivanov2@gmail.com");
		//create the user detail
		UserDetail tempUserDetail = new UserDetail("Accountant");

		//associate the objects
		tempUser.setUserDetail(tempUserDetail);

		//save the user
		System.out.println("Saving user: " + tempUser);
		appDAO.save(tempUser);

		System.out.println("Done!");
	}


}
