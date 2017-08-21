package com.personal.spring.springbeans.impl;

import com.personal.spring.interfaces.IOutputGenerator;

public class OutputHelper {

	private IOutputGenerator outputGenerator;
	 
	public OutputHelper(){
		outputGenerator = new CsvOutputGenerator();
	}
 
	public void generateOutput(){
		outputGenerator.generateOutput();
	}
	
	/**
	 * Setters is required by spring configuration file
	 * 
	 * @param outputGenerator
	 */
	public void setOutputGenerator(IOutputGenerator outputGenerator){
		this.outputGenerator = outputGenerator;
	}
	
}
