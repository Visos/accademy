package com.betacom.fe.response;

import java.util.List;

//Response è una classe utilizzata per raccogliere la risposta di una chiamata REST, 
//in questo di una lista di oggetti
public class Response<T> extends ResponseBase {
		
		public List<T> dati;
		
		public List<T> getDati() {
			return dati;
		}

		public void setDati(List<T> dati) {
			this.dati = dati;
		}

	}



