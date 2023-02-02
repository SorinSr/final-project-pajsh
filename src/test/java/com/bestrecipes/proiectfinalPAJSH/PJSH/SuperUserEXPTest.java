package com.bestrecipes.proiectfinalPAJSH.PJSH;

import com.bestrecipes.proiectfinalPAJSH.PJSH.Configs.ConfigClass;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Controller.MainController;
import com.bestrecipes.proiectfinalPAJSH.PJSH.Model.SuperUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperUserEXPTest {

    @Autowired
    private SuperUser superUser;
    @Autowired
    private SuperUser testSuperUser;


    @Test
    public void testInitPerson() {
        assertEquals(testSuperUser, superUser);
        System.out.println("Super User Test SUCCEEDED");
    }

    private SuperUser testSuperUser() {

        testSuperUser = new SuperUser();
        testSuperUser.setFirstName("Uncle");
        testSuperUser.setLastName("Roger");
        testSuperUser.setEmail("uncle_roger@gmail.com");
        testSuperUser.setPhoneNumber("912345678");
        testSuperUser.setAge(35);
        testSuperUser.setOccupation("Chef");
        testSuperUser.setIsCurrentAdminUser(Boolean.TRUE);

        return testSuperUser;
    }
}
