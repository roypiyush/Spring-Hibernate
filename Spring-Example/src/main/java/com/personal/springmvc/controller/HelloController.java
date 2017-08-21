/**
 * 
 */
package com.personal.springmvc.controller;

import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * URL: http://localhost:8080/spring-example/
 * @author piyush
 *
 */
@Controller
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String printHello(ModelMap model, HttpServletRequest request) {
		model.addAttribute("message", "Hello Spring MVC Framework! " + request.getHeader("cookie"));
		System.out.println(request.getHeader("cookie"));
		return "hello"; // This resolves to hello/hello.jsp using property prefix and suffix 
	}
	
	@RequestMapping(value = "/anotherhello", method = RequestMethod.GET)
	public String printAnotherHello(ModelMap model, HttpServletRequest request) {
		model.addAttribute("message", "Hello Spring MVC Framework from another hello! " + request.getHeader("cookie"));
		return "unthorized";
	}
	
	@RequestMapping(value = "/jsppage", method = RequestMethod.GET)
	public ModelMap showJsp(HttpServletRequest request) {
		ModelMap model = new ModelMap();
		
		StringBuilder message = new StringBuilder();
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String header = headerNames.nextElement();
			message.append(String.format("Header: %s Value: %s", header, request.getHeader(header)));
			message.append("</br>");
		}
		
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			message.append(String.format("Cookie {%s = %s} ", cookies[i].getName(), cookies[i].getValue()));
			
		}
		
		model.addAttribute("message", "This is sample jsp page. </br>" + message);
		return model;
	}

}
