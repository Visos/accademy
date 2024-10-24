package com.betacom.sbb.process;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.betacom.sbb.dto.SocioDTO;
import com.betacom.sbb.general.DataToProcess;

public class MyProcess implements ItemProcessor<DataToProcess, DataToProcess>{

    private static final Logger log = LoggerFactory.getLogger(MyProcess.class);

    @Override
    public DataToProcess process(DataToProcess item) throws Exception {
        log.debug("data sixe" + item.data.size());
        item.righe = new ArrayList<String>();
        for (SocioDTO it:item.data) {
            item.righe.add(it.withDelimiter());
        }
        return item;
    }

}
