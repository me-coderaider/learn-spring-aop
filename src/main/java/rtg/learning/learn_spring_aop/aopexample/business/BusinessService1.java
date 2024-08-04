package rtg.learning.learn_spring_aop.aopexample.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import rtg.learning.learn_spring_aop.aopexample.annotations.TrackTime;
import rtg.learning.learn_spring_aop.aopexample.data.DataService1;

@Service
public class BusinessService1 {
	// Contains Business Logic
	// To execute business-logic, this class needs some data
	// which obviously come from a Data Service
	
	private DataService1 dataService1;

	public BusinessService1(DataService1 dataService1) {
		super();
		this.dataService1 = dataService1;
	}
	
	@TrackTime
	public int calculateMax() {
		int[] data=dataService1.retrieveData();
//		throw new RuntimeException("Something went wrong!!");
		return Arrays.stream(data).max().orElse(0);
	}
}
