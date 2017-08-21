package com.personal.spring.springbeans.impl;

import com.personal.spring.interfaces.IOutputGenerator;

public class CsvOutputGenerator implements IOutputGenerator {
	public void generateOutput(){
		System.out.println("Csv Output Generator");
	}
}
