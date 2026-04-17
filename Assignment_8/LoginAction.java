package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

    private String name, mobileno, email;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMobileno() { return mobileno; }
    public void setMobileno(String mobileno) { this.mobileno = mobileno; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public ActionErrors validate(ActionMapping m, HttpServletRequest r) {
        ActionErrors e = new ActionErrors();

        if (name == null || name.trim().isEmpty())
            e.add("name", new ActionMessage("error.name.required"));
        else if (!name.matches("[a-zA-Z ]+"))
            e.add("name", new ActionMessage("error.name.invalid"));

        if (mobileno == null || mobileno.trim().isEmpty())
            e.add("mobile", new ActionMessage("error.mobile.required"));
        else if (!mobileno.matches("\\d{10}"))
            e.add("mobile", new ActionMessage("error.mobile.invalid"));

        if (email == null || email.trim().isEmpty())
            e.add("email", new ActionMessage("error.email.required"));
        else if (!email.matches("[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,}"))
            e.add("email", new ActionMessage("error.email.invalid"));

        return e;
    }
}