package rtg.learning.learn_spring_aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rtg.learning.learn_spring_aop.aopexample.business.BusinessService1;

@SpringBootApplication
public class LearnSpringAopApplication implements CommandLineRunner{
	
	private BusinessService1 businessService1;
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	public LearnSpringAopApplication(BusinessService1 businessService1) {
		super();
		this.businessService1 = businessService1;
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// In the run() method we'd want to run the business logic
		int calculateMax = businessService1.calculateMax();
		logger.info("max values from business service1 is {}",calculateMax);
	}

}
