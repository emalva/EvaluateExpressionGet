package bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author manito
 */
@ManagedBean
@RequestScoped
public class Accessor {
    FacesContext context;
    
    @PostConstruct
    public void init(){
        context = FacesContext.getCurrentInstance();
    }
    
    private Object getBean(String el, Class clss){
        return context.getApplication().evaluateExpressionGet(context, el, clss);
    }
    
    public String accessProperties(){
        Accessed accessed = (Accessed)getBean("#{accessed}", Accessed.class);
        context.addMessage("msg", new FacesMessage(accessed.getName()));
        return null;
    }
        
}
