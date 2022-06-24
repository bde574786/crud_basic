package com.tencoding.blog.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice // 화면 요청
// @RestControllerAdvice Json 요청
@RestController
public class ControllerExceptionAdvice {

	@ExceptionHandler(value = Exception.class)
	public String Exception(Exception e) {
		System.out.println("모든 오류메서드 실행");
		return e.getMessage();
	}
	
}
