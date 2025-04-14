package com.example.usereventconsumer.model;

public class UserEvent {
    private int usuarioId;
    private String accion;
    private String pagina;

    public UserEvent() {
    }

    public UserEvent(int usuarioId, String accion, String pagina) {
        this.usuarioId = usuarioId;
        this.accion = accion;
        this.pagina = pagina;
    }

    // Getters y setters
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }
}