package com.firstonesoft.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

/**
 * 
 * @author Bismarck Villca Soliz
 *
 */
public class FacesUtil {

    public static Object getSessionAttribute(String attribute) {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) context.getSession(false);
        Object o = null;
        if (session != null) {
            o = session.getAttribute(attribute);
        }
        return o;
    }

    public static void setSessionAttribute(String attribute, Object value) {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) context.getSession(false);
        session.setAttribute(attribute, value);
    }

    public static void removeSessionAttribute(String attribute) {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) context.getSession(false);
        session.removeAttribute(attribute);
    }
    
    public static int ERROR = 1;
    public static int FATAL = 2;
    public static int INFO = 3;
    public static int WARN = 4;
    public static void showMessage(String texto, int tipo) {
        switch (tipo) {
        case 1:
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, texto, "ERROR"));
            break;
        case 2:
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, texto, "ERROR FATAL"));
            break;
        case 3:
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, texto, "INFORMACION"));
            break;
        case 4:
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, texto, "ADVERTENCIA"));
            break;
        }
    }
    
    public static void setParametro(String key, Object o) {
        RequestContext context = RequestContext.getCurrentInstance();
        context.addCallbackParam(key, o);
    }
    
    public static Object getParametro(String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getExternalContext().getRequestParameterMap().get(key);
    }
    
    public static void openDialog(String widgetVarDialog) {
    	String ejecutar = String.format("PF('%s').show()", widgetVarDialog);
	RequestContext.getCurrentInstance().execute(ejecutar);
    }
    
    public static void cerrarDialog(String widgetVarDialog) {
    	String ejecutar = String.format("PF('%s').hide()", widgetVarDialog);
	RequestContext.getCurrentInstance().execute(ejecutar);
    }
    
}
