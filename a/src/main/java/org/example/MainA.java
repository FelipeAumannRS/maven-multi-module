package com.multi_spring_configurable_context;

import com.multi_spring_configurable_context.a.AInitializer;
import javafx.application.Application;;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.multi_spring_configurable_context.a", "com.multi_spring_configurable_context.asd"})
public class MainA {

	public static AbstractApplicationContext contextA;

	public static void main(String[] args) {
		Application.launch(AInitializer.class, args);
	}
}
