package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDao, MembershipDAO theMembershipDAO){

		return runner->{

			demoTheBeforeAdvice(theAccountDao, theMembershipDAO);

		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDao, MembershipDAO theMembershipDAO) {

		// call the business method
		Account myAccount = new Account();
		theAccountDao.addAccount(myAccount, true);
		theAccountDao.doWork();

		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();


	}

}
