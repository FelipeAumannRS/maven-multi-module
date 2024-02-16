package org.example;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class MainA {

	public static AbstractApplicationContext contextA;

	public static void main(String[] args) {
		Application.launch(AInitializer.class, args);
	}
}
