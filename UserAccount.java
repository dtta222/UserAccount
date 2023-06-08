//*************************************************************************
//UserAccount.java
//Date: 03/29/2023
//Author: David Taylor
//Purpose: Develop a Java application and create a user-defined Java class to maintain data about a user’s
// credentials to log into an application or system. This will include a user’s name and password and an additional
// piece of data to encrypt the password using a Caesar cipher.
//*************************************************************************

import java.util.Random;

public class UserAccount
{
    //private modifiers
    private String userName;
    private String password;
    private int CaesarShift;

    //default constructor
    UserAccount() {
        userName = "";
        password = "";
        CaesarShift = 0;
    }

    //constructor with 2 parameters
    //All parameters should be validated before updating any class data within UserAccount
    /////The userName must be a minimum of 8 characters and no longer than 16
    /////The password must be a minimum of 8 characters and no longer than 20
    UserAccount(String userName, String password) {
        if(userName.length() < 8 || userName.length() > 16) {
            System.out.println("Invalid Input\n");
        }
        else {
            if (password.length() < 8 || password.length() > 20) {
                System.out.println("Invalid Input\n");
            }
            else {
                System.out.println("Valid Input\n");
                this.userName = userName;
                this.password = password;
            }
        }
    }

    //Accessor
    //return userName
    public String getUserName() {
        return userName;
    }

    //Accessor
    //return password
    public String getPassword() {
        return password;
    }

    //Mutator
    //update password
    public void setPassword(String password) {
        this.password = password;
    }

    //-----------------------------------------------------------------
    //  This method uses a Caesar to encrypt the password.
    //  The shift amount is passed in as a parameter.
    //  It will not encrypt an already encrypted password.
    //  The Caesar cipher shift is not restricted to certain characters
    //  such as letters. It shifts based upon ASCII codes.
    //-----------------------------------------------------------------
    public void encrypt(int shift) {

        if (CaesarShift == 0 && (shift > 0 && shift < 20)) {
            String masked = "";

            for (int index = 0; index < password.length(); index++) {
                masked = masked + (char) (password.charAt(index) + shift);
            }
            password = masked;
            CaesarShift = shift;
        }
    }

    //-----------------------------------------------------------------
    //  This method uses a Caesar to decrypt the password.
    //  The shift amount accessed from the private CaesarShift variable.
    //  It will not decrypt an already decrypted password.
    //  The Caesar cipher shift is not restricted to certain characters
    //  such as letters. It shifts based upon ASCII codes.
    //-----------------------------------------------------------------
    public void decrypt() {
        int shift = CaesarShift;
        String unmasked = "";

        for (int index = 0; index < password.length(); index++) {
            unmasked = unmasked + (char) (password.charAt(index) - shift);
        }
        password = unmasked;
        CaesarShift = 0;
    }

    //checks if CaesarShift = 0
    //if CaesarShift = 0 password is decrypted return false
    //if CaesarShift != 0 password is encrypted return true
    public boolean isEncrypted() {

        if (CaesarShift > 0) {
            return true;
        }
        return false;
    }

    //creates a String and returns the string
    public String toString() {

        System.out.println("username: " + this.userName);
        System.out.println("password: " + this.password);

        return null;
    }


}
