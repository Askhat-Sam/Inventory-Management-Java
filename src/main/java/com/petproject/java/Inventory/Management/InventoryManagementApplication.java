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
			createUser(appDAO);
		};
	}

	private void createUser(AppDAO appDAO) {
		//create a user
		User tempUser = new User("Ivan", "Ivanov", "I.Ivanov@gmail.com");
		//create the user detail
		UserDetail tempUserDetail = new UserDetail("Store");

		//associate the objects
		tempUser.setUserDetail(tempUserDetail);

		//save the user
		System.out.println("Saving user: " + tempUser);
		appDAO.save(tempUser);

		System.out.println("Done!");
	}


}
