package com.betacom.sbb.reader;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import com.betacom.sbb.dto.SocioDTO;
import com.betacom.sbb.general.DataToProcess;
import com.betacom.sbb.pojo.Socio;
import com.betacom.sbb.repository.ISocioRepository;

public class MyReader implements ItemReader<DataToProcess>{

    @Autowired
    ISocioRepository socioR;

    private static Logger log = LoggerFactory.getLogger(MyReader.class);
    private DataToProcess requestData = null;

    @SuppressWarnings("static-access")
    @Override
    public DataToProcess read() {
        log.debug("begin reading.....");
        
        if (requestDataIsNotInitialized()) {
            requestData = fetchRequestData();
            if (requestData == null) return null;
        }
        if (!requestData.isToExecute) return null;
        return requestData;
    }

    private boolean requestDataIsNotInitialized() {
        return requestData == null;
    }

    @SuppressWarnings("static-access")
    private DataToProcess fetchRequestData() {
        log.debug("fetching request data.....");
        requestData = new DataToProcess();

        requestData.data = tranformInListDTO(socioR.findAll());
        requestData.isToExecute = true;

        log.debug("fetchRequestData");

        return requestData;
    }

    private List<SocioDTO> tranformInListDTO(List<Socio> resp){
		return resp.stream()
				.map(s -> new SocioDTO(
						s.getId(),
						s.getCognome(),
						s.getNome(),
						s.getcFiscale(),
						(s.getCertificato() != null) ? s.getCertificato().getId() : null,
						(s.getCertificato() != null) ? s.getCertificato().getDataCertificato() : null,
						(s.getCertificato() != null) ? (s.getCertificato().getTipo() ? "Agonistico" : "Normale") : null
						)) 
				.collect(Collectors.toList());
		
	}

}
