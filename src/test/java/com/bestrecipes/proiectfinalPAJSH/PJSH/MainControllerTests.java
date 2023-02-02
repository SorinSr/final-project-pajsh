package com.bestrecipes.proiectfinalPAJSH.PJSH;

import com.bestrecipes.proiectfinalPAJSH.PJSH.Controller.MainController;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.Food;
import com.bestrecipes.proiectfinalPAJSH.ProiectFinalPajshApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainControllerTests {

    @Autowired
    private MainController mainController;
    private String[] parameters={""};

    @Test
    public void testDB() {
        ProiectFinalPajshApplication.main(parameters);
        assertNotNull(mainController.testDBConnection(), "Return bean should be configured");
        assertTrue((mainController.testDBConnection() instanceof Food), "Return must be FOOD");
    }

}
