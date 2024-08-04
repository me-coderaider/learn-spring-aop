package rtg.learning.learn_spring_aop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {
	// as this is a DataService class, so this must to talking to
	// some database and it'd return some data back.
	
	public int[] retrieveData() {
		return new int[] {11,22,33,4,5};
	}
}
