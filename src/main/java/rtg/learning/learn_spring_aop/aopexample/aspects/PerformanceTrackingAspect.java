package rtg.learning.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {
	
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	@Around("rtg.learning.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
	public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		// 1.Start the timer
		long startTimeMillis = System.currentTimeMillis();
		
		// 2. Execute the method
		Object returnValue = proceedingJoinPoint.proceed();
		
		// 3. Stop the timer
		long stopTimeMillis = System.currentTimeMillis();
		
		long executionDuration = stopTimeMillis - startTimeMillis;
		
		logger.info("Around aspect - {} method executed in {} ms",proceedingJoinPoint,executionDuration);
		
		return returnValue;
	}
}
