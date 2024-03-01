package com.polina.spring.springboot.spring_course_springboot_data_jpa.exception;

public class NoSuchEmployeeException extends RuntimeException {
    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
