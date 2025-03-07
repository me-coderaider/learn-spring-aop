package rtg.learning.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

	@Pointcut("execution(* rtg.learning.learn_spring_aop.aopexample.*.*.*(..))")
	public void businessAndDataPackageConfig() {}
	
	@Pointcut("execution(* rtg.learning.learn_spring_aop.aopexample.business.*.*(..))")
	public void businessPackageConfig() {}
	
	@Pointcut("execution(* rtg.learning.learn_spring_aop.aopexample.data.*.*(..))")
	public void dataPackageConfig() {}
	
	@Pointcut("bean(*Service*)")
	public void dataPackageConfigUsingBean() {}
}
