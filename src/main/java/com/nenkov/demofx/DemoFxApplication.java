package com.nenkov.demofx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoFxApplication extends Application {

    private ConfigurableApplicationContext springContext;
    private Parent rootNode;

    public static void main(String[] args) {
        launch(DemoFxApplication.class, args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(DemoFxApplication.class);
        SpringFXMLLoader springFXMLLoader = new SpringFXMLLoader(springContext);
        rootNode = (Parent) springFXMLLoader.load("root.fxml");
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(rootNode, 1366, 768);
        stage.setScene(scene);
        stage.setTitle("demofx");
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
    }

    @Override
    public void stop() {
        springContext.close();
        System.exit(0);
    }
}
