package com.betacom.sbb.writer;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Value;

import com.betacom.sbb.general.DataToProcess;

public class MyWriter implements ItemWriter<DataToProcess>{

    private static final Logger log = LoggerFactory.getLogger(MyWriter.class);
    
    @Value("${output-file}")
    private String output;

    @SuppressWarnings("static-access")
    @Override
    public void write(Chunk<? extends DataToProcess> items) throws Exception {
        log.debug("Start MyWriter");
        log.debug("item size:" + items.getItems().size());
        
        DataToProcess data = items.getItems().get(0);

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "UTF-8"));
        for (String rec:data.righe) {
            out.write(rec);
            out.newLine();
        }

        out.close();
        data.isToExecute = false;
        log.debug("End MyWriter: ");
    }

}
