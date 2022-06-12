
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Questy Kuti Mbenza
 */
public class Credentials {
    
    protected String userName, password, userNameConfirm, passwordConfirm,
            firstName, lastName, returnStatus;
    protected String registerUserReturn ="";
    
    
    /***
     * Equates the JTextField variables into String variables.
     * Other methods of this class work with String variables.
     * 
     * @param userNameIn
     * @param passwordIn
     * @param firstNameIn
     * @param lastNameIn 
     */
    public  void inputSetter(JTextField userNameIn, JTextField passwordIn, 
            JTextField firstNameIn, JTextField lastNameIn){
        userName = userNameIn.getText();
        password = passwordIn.getText();
        firstName = firstNameIn.getText(); 
        lastName = lastNameIn.getText();
    }
    
    /***
     * Equates the JTextField variables into String variables.
     * Other methods of this class work with String variables. 
     * 
     * @param userNameIn
     * @param passwordIn 
     */
    public  void inputSetter(JTextField userNameIn, JTextField passwordIn){
        userName = userNameIn.getText();
        password = passwordIn.getText();
    }
    
    /***
     * Makes sure that the username is made of less than five characters,
     * and has an underscore.
     * @return 
     */
    public  boolean checkUserName(){       
        int countName =0; //number of characters
        //for each characters
        for(int i = 0; i < userName.length(); i++) {    
            if(userName.charAt(i) != ' ')
                //increment countName
                countName++;            
            break;
        }           
        return (countName <= 6 && userName.contains("_"));           
    }    
    
    /***
     * Verifies that the password is made of a special character, has a capital 
     * letter, and is longer than 5 characters.
     * @return 
     */
    public  boolean checkPasswordComplexity(){
        //value of letters and special chararcters
        int countPassword = 0, countSpecial = 0;         
        //has digit and has capital letter
        boolean hasDigit = false, hasCapital;  
        //for each character
        for (int i = 0; i < password.length(); i++) {                           
            // Checking the character for not being a
            // letter,digit or space
            if (!Character.isDigit(password.charAt(i))
                && !Character.isLetter(password.charAt(i))
                && !Character.isWhitespace(password.charAt(i))) {
                // Incrementing the countSpecial
                countSpecial++;
            }
        }
        //for each character
        for(int i = 0; i < password.length(); i++) {
            //checking characters for being digits
            if (Character.isDigit(password.charAt(i))) {
                //incrementing hasDigit
            hasDigit = true;
        }
            //counting characters
        if(password.charAt(i) != ' ') 
            //increment countPassword
                countPassword++;    
        }
        
        hasCapital = password.matches(".*[A-Z].*");       

        return countSpecial >= 0 && countPassword >= 7 && hasDigit == true && 
                hasCapital == true;
    }    
    
    /***
     * Gives the necessary messages on the status of registration.
     * @return 
     */
    public String registerUser(){
        int userNameHere=0, passwordHere=0;
        
        if (this.checkPasswordComplexity() == true){
            passwordHere = 1;
        }
        
        if (this.checkUserName() == true){
            userNameHere = 1;
        }
        
        if(userNameHere ==1 && passwordHere ==1){           
            registerUserReturn = """
                                 Account successfully registered
                                 """;
            
        }else if(passwordHere!=1 && userNameHere!=1){
            registerUserReturn = """
                                 Both the password and username are incorrectly 
                                 formatted
                                 
                                 Please ensure that your username contains 
                                 an underscore and is no more p
                                 than 5 characters in length.
                                 
                                 Please ensure that the password 
                                 contains at least 8 characters, a capital 
                                 letter, a number and a special character.
                                 """;
        }
            
            
        if(userNameHere!=1 && passwordHere==1){
        registerUserReturn = """
                             Username is not correctly formatted. 
                                                                                                                       
                             Please ensure that your username contains 
                             an underscore and is no 
                             more than 5 characters in length.
                             """; 
        }else if(passwordHere!=1 && userNameHere==1){
            registerUserReturn = """
                                 Password is not correctly formatted.
                                                                                                                       
                                 Please ensure that the password 
                                 contains at least 8 characters, a capital 
                                 letter, a number and a special character.
                                 """;       
      }
      return registerUserReturn;  
    }    
    
    /**
     * Compares the login details with the saved details.
     * @return true/false
     */
    public boolean loginUser() {
       int userNameCompare = userNameConfirm.compareTo(userName);
         int passwordCompare = passwordConfirm.compareTo(password);       
        return userNameCompare==0 && passwordCompare ==0; 
    }  
    
    /**
    * Returns the necessary message on the login.
    * @return String
    */
    public String returnLoginSatus() {
        
        if(this.loginUser()==false){
           this.returnStatus = """
                           Username or password incorrect, 
                           please try again""";
        }else /*if(loginUser ==false)*/{
             this.returnStatus = "Welcome " +firstName+" "+lastName+", \n" 
            + "It is great to see you.";
        }
        return returnStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRegisterUserReturn() {
        return registerUserReturn;
    }

    public void setRegisterUserReturn(String registerUserReturn) {
        this.registerUserReturn = registerUserReturn;
    }

    public String getUserNameConfirm() {
        return userNameConfirm;
    }

    public void setUserNameConfirm(String userNameConfirm) {
        this.userNameConfirm = userNameConfirm;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }
    
    
    
}
