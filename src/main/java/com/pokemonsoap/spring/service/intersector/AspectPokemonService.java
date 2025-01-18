package com.pokemonsoap.spring.service.intersector;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pokemonsoap.spring.service.RequestLogService;

@Component
@Aspect
public class AspectPokemonService {
	
	@Autowired
    private RequestLogService requestLogService;

	@Before("execution(* com.pokemonsoap.spring.service.PokemonAPIService.*(..))")
	public void logServiceBeforeExcecution( JoinPoint joinPoint ){
		
		Signature signature = joinPoint.getSignature();
		
		System.out.println( "@Before Name: "+ signature.getName() );
		System.out.println( "@Before Args: " + joinPoint.getArgs());
		
		System.out.println( "@Before --:> " );
		
	}
	
	@AfterReturning(pointcut = "execution(* com.pokemonsoap.spring.service.PokemonAPIService.*(..))", returning = "response")
    public void despuesDeRetornar( JoinPoint joinPoint, Object response) {
		
		Signature signature = joinPoint.getSignature();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		
		Object[] args = joinPoint.getArgs();
        StringBuilder requestValues = new StringBuilder();
        for (Object arg : args) {
            requestValues.append(arg).append(";");
        }
        
        String responseValues = (response != null) ? response.toString() : "null";

        requestLogService.saveRequestLog(className,"AfterReturning",signature.getName(), requestValues.toString(), responseValues, null);
        
    }
	
	@AfterThrowing(pointcut = "execution(* com.pokemonsoap.spring.service.PokemonAPIService.*(..))", throwing = "exception")
    public void despuesDeException( JoinPoint joinPoint, Throwable exception) {
		
		Signature signature = joinPoint.getSignature();
		 
        String className = joinPoint.getTarget().getClass().getSimpleName();
        
        Object[] args = joinPoint.getArgs();

        StringBuilder requestValues = new StringBuilder();
        for (Object arg : args) {
            requestValues.append(arg).append(";");
        }
        
        requestLogService.saveRequestLog(className,"AfterThrowing",signature.getName(), requestValues.toString(), null, exception.getMessage());
        
        
    }
	
}
