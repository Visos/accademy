package com.betacom.fe.request;

public class SocioReq {

    private Integer id;
    private String nome;
    private String cognome;
    private String cFiscale;
    private String errorMsg;

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getcFiscale() {
        return cFiscale;
    }

    public void setcFiscale(String cFiscale) {
        this.cFiscale = cFiscale;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
    
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    
}
