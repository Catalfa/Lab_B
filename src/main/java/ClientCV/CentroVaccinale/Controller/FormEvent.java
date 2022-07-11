package ClientCV.CentroVaccinale.Controller;

import java.util.EventObject;
public class FormEvent extends EventObject{

    private String username;
    private String password;
    private boolean controlloUsername;
    private String controlloPassword;

    public FormEvent(Object source, String username, String password, boolean checkUsername, String controlloPassword) {
        super(source);
        this.username = username;
        this.password = password;
        this.controlloUsername = checkUsername;
        this.controlloPassword = controlloPassword;
    }

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String username, String password) {
        super(source);
        this.username = username;
        this.password = password;
    }

    public boolean isControlloUsername() {
        return controlloUsername;
    }

    public void setControlloUsername(boolean checkUsername) {
        this.controlloUsername = checkUsername;
    }

    public String getControlloPassword() {
        return controlloPassword;
    }

    public void setControlloPassword(String controlloPassword) {
        this.controlloPassword = controlloPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
