package org.launchcode.RecycleMe.models.forms;

import javax.validation.constraints.NotNull;

public class Register extends Login {

//    public void setConfirmPassword(String password) {
//        confirmPassword=checkPassword(confirmPassword);
//        this.confirmPassword = confirmPassword;
//    }
//    private String checkPassword(String confirmPassword) {
//        if (confirmPassword != null
//                && !getPassword().equals(confirmPassword)) {
//            return null;
//        }
//        return confirmPassword;
//    }


    @NotNull(message = "Passwords do not match")
    private String confirmPassword;

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
        checkPasswordForRegistration();
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;

        checkPasswordForRegistration();
    }

    private void checkPasswordForRegistration() {
        if (!getPassword().equals(confirmPassword)) {
            confirmPassword = null;
        }
    }
}
