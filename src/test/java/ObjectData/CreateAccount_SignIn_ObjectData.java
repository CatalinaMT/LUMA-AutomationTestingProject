package ObjectData;

public class CreateAccount_SignIn_ObjectData
{

    //Creare cont
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;


    //gettere
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }


    //Sign In
    private String emailSignIn;
    private String passwordSignIn;

    //gettere
    public String getEmailSignIn() {
        return emailSignIn;
    }

    public String getPasswordSignIn() {
        return passwordSignIn;
    }


}


