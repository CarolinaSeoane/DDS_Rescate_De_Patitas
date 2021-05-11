package Password;

public class ValidatePasswordLength implements PasswordCriteria {


    private String descripcion = "Cumple longitud";

    @Override
    public String getDescripcion(){
        return this.descripcion;
    }

    @Override
    public Boolean validatePassword (String password) {

        int minLength = 8;
        int maxLength = 64;

        return password.length() >= minLength && password.length() <= maxLength;

    }
}

