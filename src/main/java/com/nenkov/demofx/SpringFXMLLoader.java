package com.nenkov.demofx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * This component loads FXML files, provides the proper controllers for them and it can be used for
 * injecting data inside the FXML namespace, it also shows one way of using external properties
 */
@Component
public class SpringFXMLLoader {

    private final ApplicationContext springContext;

    @Autowired
    public SpringFXMLLoader(ApplicationContext context) {
        this.springContext = context;
    }

    /**
     * It is important to notice the setControllerFactory - helps javafx to find the proper
     * constructor for the controller with the necessary parameters. The second thing to notice is the
     * setResourceBundle which allows us to use any parameter set inside the aappplication.properties
     * inside the FXML files by simply placing % sign and the name of the variable (like %title,
     * %version, etc.
     *
     * @param fxml is the relative path to the fxml for loading
     * @return an javafx Node generated from the fxml description
     * @throws IOException when the file is not available
     */
    public Node load(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(fxml));
        fxmlLoader.setControllerFactory(springContext::getBean);
        fxmlLoader.setResources(ResourceBundle.getBundle("application"));
        return fxmlLoader.load();
    }

    public Node loadComponent(String s, Object o) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(o.getClass().getResource(s));
        fxmlLoader.setControllerFactory(springContext::getBean);
        fxmlLoader.setResources(ResourceBundle.getBundle("application"));
        return fxmlLoader.load();
    }
}
