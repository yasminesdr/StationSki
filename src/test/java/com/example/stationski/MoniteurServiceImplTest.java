package com.example.stationski;
import com.example.stationski.entities.Cours;
import com.example.stationski.entities.Moniteur;
import com.example.stationski.services.IMoniteurService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class MoniteurServiceImplTest {
    @Autowired
    IMoniteurService ms;

    @Test
    @Order(1)
    public void testAddMoniteur ()throws ParseException{
        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate dateRecru = LocalDate.of(2020, 1, 8);
        Moniteur m=new Moniteur(1,123L,"testnom","testrenom",dateRecru,100);
        Moniteur moniteur=ms.addMoniteur(m);
        System.out.print("moniteur"+moniteur);
        ms.deleteMoniteur(moniteur.getIdMoniteur());
    }
    public void testDeleteMoniteur(){
        LocalDate dateRecru = LocalDate.of(2022, 1, 1);
        Moniteur m=new Moniteur(2,123L,"testnom","testrenom",dateRecru,100);
        Moniteur moniteur=ms.addMoniteur(m);
        ms.deleteMoniteur(moniteur.getIdMoniteur());
        Assertions.assertNotNull(ms.retrieveMoniteur(moniteur.getIdMoniteur()));
    }
    public void testRetrieveAllMoniteurs(){
        LocalDate dateRecru = LocalDate.of(2023, 2, 1);
        Moniteur m=new Moniteur(3,123L,"testnom","testrenom",dateRecru,100);
        List<Moniteur> moniteurs=ms.retrieveAllMoniteurs();
        int expected=moniteurs.size();
        Moniteur moniteur=ms.addMoniteur(m);
        Assertions.assertEquals(expected+1,ms.retrieveAllMoniteurs().size());
        ms.deleteMoniteur(moniteur.getIdMoniteur());
    }
}
