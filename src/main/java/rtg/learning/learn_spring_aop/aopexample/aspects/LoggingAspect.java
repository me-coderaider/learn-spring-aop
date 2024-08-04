package rtg.learning.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//Logic of the method
	@Before("rtg.learning.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
	public void logMethodCallBeforeExecution(JoinPoint  joinPoint) {
		logger.info("Before Aspect - {} Method is called, with args - {}", joinPoint, joinPoint.getArgs());
	}
	
	@After("rtg.learning.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
	public void logMethodCallAfterExecution(JoinPoint  joinPoint) {
		logger.info("After Aspect - {} Method is called", joinPoint);
	}
	
	@AfterThrowing(pointcut="rtg.learning.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()", 
			throwing = "exception"
			)
	public void logMethodCallAfterException(JoinPoint  joinPoint, Exception exception) {
		logger.info("AfterThrowing Aspect - {} Method has thrown an exception - {}", joinPoint, exception);
	}
	
	@AfterReturning(pointcut="rtg.learning.learn_spring_aop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()", 
			returning = "resultValue"
			)
	public void logMethodCallAfterSuccessfulExecution(JoinPoint  joinPoint, Object resultValue) {
		logger.info("AfterReturning Aspect - {} Method has returned - {}", joinPoint, resultValue);
	}
}
