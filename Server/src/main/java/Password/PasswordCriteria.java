package main.java.Password;

import java.io.IOException;

public interface PasswordCriteria {

    Boolean validatePassword(String password) throws IOException;

}
