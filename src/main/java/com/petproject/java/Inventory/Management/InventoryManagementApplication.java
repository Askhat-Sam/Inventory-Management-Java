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

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createUser(appDAO);
			findUser(appDAO);
		};
	}

	private void findUser(AppDAO appDAO) {
		int theId=1;
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
