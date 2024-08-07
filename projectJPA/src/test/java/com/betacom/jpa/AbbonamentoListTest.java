package com.betacom.jpa;

import static org.junit.Assert.fail;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.jpa.dto.AbbonamentoViewDTO;
import com.betacom.jpa.service.interfaces.IAbbonamentoService;

@SpringBootTest
public class AbbonamentoListTest {

    @Autowired
    IAbbonamentoService abS;

    @Test
    public void abbonamentoListAllTest() {

        try {
            List<AbbonamentoViewDTO> lA = abS.listAbbonamenti(2);
            Assertions.assertThat(lA.get(0).getAttivita().size()).isEqualTo(2);
        } catch (Exception e) {
            fail("Errore in list");
        }
        
    }
}
