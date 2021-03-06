package com.personal.spring.aop;

public class Logging {
	/**
	 * * This is the method which I would like to execute * before a selected
	 * method execution.
	 */
	public void beforeAdvice() {
		System.out.println("Inside Logging class : " + "Going to setup student profile.");
	}

	/**
	 * * This is the method which I would like to execute * after a selected
	 * method execution.
	 */
	public void afterAdvice() {
		System.out.println("Inside Logging class : " + "Student profile has been setup.");
	}

	/**
	 * * This is the method which I would like to execute * when any method
	 * returns.
	 */
	public void afterReturningAdvice(Object retVal) {
		System.out.println("Inside Logging class : " + "Returning:" + retVal.toString());
	}

	/**
	 * * This is the method which I would like to execute * if there is an
	 * exception raised.
	 */
	public void AfterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("Inside Logging class : " + "There has been an exception: " + ex.toString());
	}
}