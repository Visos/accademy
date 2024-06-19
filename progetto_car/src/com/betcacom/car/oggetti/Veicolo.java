package com.betcacom.car.oggetti;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.betcacom.car.service.interfaces.IGestioneVeicolo;
//public abstract class Veicolo implements IGestioneVeicolo{
public abstract class Veicolo{

	private Integer numeroRuote;
	private String tipoVeicolo;				//moto, truck, bici, vettura
	private String tipoAlimentazione;		//benzina, gas, gasolio, elettrica
	private String colore;
	private String marca;
	private Integer Id;
	private Date dtaInserimento;
	private Date dataDopoMese;			

	

	
	public Date getDtaInserimento() {
		return dtaInserimento;
	}
	public void setDtaInserimento(Date dtaInserimento) {
		this.dtaInserimento = dtaInserimento;
	}
	public Integer getNumeroRuote() {
		return numeroRuote;
	}
	public void setNumeroRuote(Integer numeroRuote) {
		this.numeroRuote = numeroRuote;
	}
	public String getTipoVeicolo() {
		return tipoVeicolo;
	}
	public void setTipoVeicolo(String tipoVeicolo) {
		this.tipoVeicolo = tipoVeicolo;
	}
	public String getTipoAlimentazione() {
		return tipoAlimentazione;
	}
	public void setTipoAlimentazione(String tipoAlimentazione) {
		this.tipoAlimentazione = tipoAlimentazione;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	public void stampa() {
		if(this != null) {
			System.out.println("["+" id: "+ getId() +"data inserimento: "+ getDtaInserimento()+"n ruote: "+ getNumeroRuote()+" tipo veicolo: "+ getTipoVeicolo()+" tipo alimentazione: "+ getTipoAlimentazione()+" colore: "+ getColore()+ " colore: "+ getColore()+"]");
		}	
	}
	
	
	@Override
	public String toString() {
		return "Veicolo [numeroRuote=" + numeroRuote + ", tipoVeicolo=" + tipoVeicolo + ", tipoAlimentazione="
				+ tipoAlimentazione + ", colore=" + colore + ", marca=" + marca + ", Id=" + Id + ", dtaInserimento="
				+ dtaInserimento + ", dataDopoMese=" + dataDopoMese + "]";
	}
	public Date getDataDopoMese() {
		return dataDopoMese;
	}
	public void setDataDopoMese() {		
		//mantenere il tipo data e aumentare di 1 il mese
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(getDtaInserimento());
		cal.add(Calendar.MONTH, 1);
		
		
		this.dataDopoMese = cal.getTime();
	}
	
	

}
