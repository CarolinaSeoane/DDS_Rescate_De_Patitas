package Password;

import java.io.IOException;
import java.util.List;

public class ValidatePassword {

    private List<PasswordCriteria> passwordCriteria;

    public Boolean validatePassword(String password) {
        return this.passwordCriteria.stream()
                .map(criteria -> {
                    try {
                        return this.validarSegun(criteria, password);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                    return null;
                })
                .reduce(Boolean::logicalAnd).get();
    }

    public Boolean validarSegun(PasswordCriteria unCriterio, String unaPassword) throws IOException {
        Boolean aceptada = unCriterio.validatePassword(unaPassword);
        System.out.print(unCriterio.getDescripcion()+ ":  ");
        if(aceptada){
            System.out.println("OK");
        }
        else {
            System.out.println("NOT OK");
        }
        return aceptada;
    }

    public List<PasswordCriteria> getPasswordCriteria() {
        return passwordCriteria;
    }

    public void setPasswordCriteria(List<PasswordCriteria> passwordCriteria) {
        this.passwordCriteria = passwordCriteria;
    }

    public void addCriterios(List<PasswordCriteria> passwordCriteria) {
        this.passwordCriteria = passwordCriteria;
    }
}




