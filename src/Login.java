
import javax.swing.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import java.lang.String;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.OK_OPTION;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *ll
 * @author Questy Kuti Mbenza
 */
public class Login {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //The following block declares JTextFields
        //which will retrieve input from keyboard in JText format
        JTextField firstNameIn = new JTextField();
        JTextField lastNameIn = new JTextField();
        JTextField userNameIn = new JTextField();
        JTextField passwordIn = new JTextField();
        //The below are the input that will be used to
        //confirm the username and password at login
        JTextField userNameConfirmIn = new JTextField();
        JTextField passwordConfirmIn = new JPasswordField();
        JTextField userReConfirmIn = new JTextField();
        JTextField passReConfirmIn = new JTextField();
        
        JOptionPane.showMessageDialog(
                null, "You are going to register an account " +
                        " then login using your details.", "Register", 
                INFORMATION_MESSAGE);
        //Below are object that will retrieve input on a prompt
        //on two separate lines
        Object[] reConfirm = {
            "Username", userReConfirmIn,
            "Password", passReConfirmIn
        };          
        
        Object[] detailsOne = {
            "First name", firstNameIn,
            "Last name", lastNameIn
        };
        Object[] detailsTwo = {
            "Username", userNameIn,
            "Password", passwordIn
        };
        Object[] confirmDetails = {
            "Username", userNameConfirmIn,
            "Password", passwordConfirmIn
        };
        
        //Below the details will be retrieved from the user 
        //and converted into String 
        JOptionPane.showConfirmDialog(null, detailsOne, "Register", 
                JOptionPane.OK_CANCEL_OPTION);
        JOptionPane.showConfirmDialog(null,  detailsTwo, "Register", 
                JOptionPane.OK_CANCEL_OPTION);
        String userName = userNameIn.getText(), password = passwordIn.getText();
        String firstName = firstNameIn.getText(), 
                lastName = lastNameIn.getText();
        
        //username check
        checkUserName(userName);      
        //password check
        checkPasswordComplexity(password);                                      
        //Below are messages on 
        //format of username and password
        if(checkUserName(userName) == true && 
                checkPasswordComplexity(password)==true){
            JOptionPane.showMessageDialog(null, 
                    """
                    Username successfully captured
                    Password successfully captured
                    """, 
                    "Successful", INFORMATION_MESSAGE);
        }else if(checkUserName(userName)==false || 
                checkPasswordComplexity(password)==false){
            if(checkUserName(userName)==false){
            JOptionPane.showMessageDialog(null,
                    """
                Username is not correctly formatted. 
                    
                Please ensure that your username contains 
                an underscore and is no 
                more than 5 characters in length.""", 
                    "Failed", ERROR_MESSAGE);
        
            }if(checkPasswordComplexity(password)==false){
            JOptionPane.showMessageDialog(null, 
                    """
                    Password is not correctly formatted.
                    
                    Please ensure that the password 
                    contains at least 8 characters, a capital 
                    letter, a number and a special character.""", 
                    "Failed", ERROR_MESSAGE);
        }
        }
        
        int loopStop=0; //dummy value
        
        registerUser(
                checkUserName(userName), checkPasswordComplexity(password), 
                userName, password);
        
            //If registration was
            //successful
            if(checkUserName(userName) == true &&                               
                checkPasswordComplexity(password) == true &&                    
                checkPasswordComplexity(password) == true){
            JOptionPane.showMessageDialog(null, 
                registerUser(
                checkUserName(userName), checkPasswordComplexity(password), 
                userName, password), "registered", 
                INFORMATION_MESSAGE);         
        //If registration unsuccessfful  
        //wrong username loop 
        }else{                                                                  
            while(checkUserName(userName) != true && loopStop==0){  
                //error message
                JOptionPane.showMessageDialog(null, 
                    registerUser(
                checkUserName(userName), checkPasswordComplexity(password), 
                userName, password), 
                    "Failed", INFORMATION_MESSAGE);                         
                //re-put username
                userName = JOptionPane.showInputDialog(
                    null, "Make a username: ", 
                    "Register an account", QUESTION_MESSAGE);                    
                checkUserName(userName);                                        
            }
            //wrong password loop
            while(checkPasswordComplexity(password) == false && loopStop==0){   
                //error message
                JOptionPane.showMessageDialog(null, 
                    registerUser(
                    checkUserName(userName), checkPasswordComplexity(password), 
                userName, password), 
                    "Failed", ERROR_MESSAGE);     
                //re-put details
                password = JOptionPane.showInputDialog(
                    null, "Make a better password: ", 
                    "Register an account", QUESTION_MESSAGE);                    
            checkPasswordComplexity(password);                                  
            }
        }
        
        //input login details    
        JOptionPane.showConfirmDialog(
        null, confirmDetails, "Login", OK_CANCEL_OPTION, INFORMATION_MESSAGE); 
        //convert to String
        String userNameConfirm =userNameConfirmIn.getText();                    
        String passwordConfirm = passwordConfirmIn.getText();
        //login verification
        loginUser(userNameConfirm, passwordConfirm, userName,  password);       
        //successful or unsuccessful login
        //message
      returnLoginSatus(loginUserAgain(userReConfirmIn, passReConfirmIn,userName,  
                    password),
            loginUser(userNameConfirm, passwordConfirm, userName,  
                     password), firstName, lastName);                           
                                                                                
        int stopLoop=0; //dummy value
        
        //successfull login
        if(loginUser(userNameConfirm, passwordConfirm, userName,                
                     password) == true){
                //message
                JOptionPane.showMessageDialog(null, 
                returnLoginSatus(loginUserAgain(userReConfirmIn, 
                        passReConfirmIn,userName, password),
            loginUser(userNameConfirm, passwordConfirm, userName,  
                     password), firstName, lastName), 
                    "Welcome", INFORMATION_MESSAGE); 
            //unsuccessful login
            }else{                                                                   
            //wrong details loop
            while(loginUserAgain(userReConfirmIn, passReConfirmIn,userName,  
                    password) != true && stopLoop == 0){                        
                //message
                JOptionPane.showMessageDialog(
                        null, returnLoginSatus(loginUserAgain(userReConfirmIn, 
                                passReConfirmIn,userName,  password),
            loginUser(userNameConfirm, passwordConfirm, userName,  
                     password), firstName, lastName), "Login failed", 
                       ERROR_MESSAGE);                                          
            //input details    
           stopLoop=JOptionPane.showConfirmDialog(
        null, reConfirm, "Login", OK_CANCEL_OPTION, INFORMATION_MESSAGE);       
         //details check  
        loginUser(userNameConfirm, passwordConfirm, userName,  password);       
                           }
            //successful message
            JOptionPane.showMessageDialog(null, 
                returnLoginSatus(loginUserAgain(userReConfirmIn, passReConfirmIn,userName,  
                    password),
            loginUser(userNameConfirm, passwordConfirm, userName,  
                     password), firstName, lastName), 
                    "Welcome", INFORMATION_MESSAGE);                            
        }
    }
    
    /**
     * This method verifies the format of the username
     * @param userName
     * @return true/false
     */
    public static boolean checkUserName(String userName){       
        int countName =0; //number of characters
        //for each characters
        for(int i = 0; i < userName.length(); i++) {    
            if(userName.charAt(i) != ' ')
                //increment countName
                countName++;            
            break;
        }           
        return countName <= 6 && userName.contains("_");           
    }
    
    /**
     * verifies complexity of password
     * @param password
     * @return true/false
     */
    public static boolean checkPasswordComplexity(String password){
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
    
    /**
     * tells if registration was successful or not
     * @param checkPasswordComplexity
     * @param checkUserName
     * @param userName
     * @param password
     * @return String
     */
    public static String registerUser(
            boolean checkPasswordComplexity, boolean checkUserName, 
            String userName, String password){
        String registerUserReturn ="";
        
        if(checkUserName == true && checkPasswordComplexity == true){           
            registerUserReturn = "Account successfully registered";
            
        }else{
            if(checkPasswordComplexity == false && checkUserName == true){        
            registerUserReturn = "The username was incorrectly formatted"; 
        }else if(checkUserName != true && checkPasswordComplexity == true){
            registerUserReturn = "The password was incorrectly formatted";       
      }else if(checkPasswordComplexity == false && checkUserName == false){
            registerUserReturn = "Both the password and username are "
                    + "incorrectly formatted";       
      }
            }
      return registerUserReturn;  
    }

    /**
     * confirms compares login input to saved details
     * @param userNameConfirm
     * @param passwordConfirm
     * @param userName
     * @param password
     * @return true/false
     */
    public static boolean loginUser(String userNameConfirm,  
            String passwordConfirm, String userName,  String password) {
       int userNameCompare = userNameConfirm.compareTo(userName);
         int passwordCompare = passwordConfirm.compareTo(password);       
        return userNameCompare==0 && passwordCompare ==0; 
    }

    /**
     * verifies new input with saved details
     * @param userReConfirmIn
     * @param passReConfirmIn
     * @param userName
     * @param password
     * @return true/false
     */
    public static boolean loginUserAgain(JTextField userReConfirmIn, 
            JTextField passReConfirmIn, String userName, String password) {
        String userReConfirm = userReConfirmIn.getText();
        String passReConfirm = passReConfirmIn.getText();
        
        int userNameCompare = userReConfirm.compareTo(userName);
        int passwordConfirm = passReConfirm.compareTo(password);        
        return passwordConfirm ==0 && userNameCompare == 0;
    }    

    /**
     * verifies if login was successful or not
     * @param loginUserAgain
     * @param loginUser
     * @param firstName
     * @param lastName
     * @return String
     */
    private static String returnLoginSatus(boolean loginUserAgain, boolean loginUser, String firstName, String lastName) {
        String returnStatus=null;
        
        if(loginUser ==true || loginUserAgain ==true){
            returnStatus = " Welcome " +firstName+"\n" 
            +lastName+ ", it is great to see you again";
        }else{
            returnStatus = """
                           Username or password incorrect, 
                           please try again""";
        }
                    return returnStatus;
    }


}
   
    



        

/*
https://www.javatpoint.com/java-program-to-count-the-total-number-of-characters-in-a-string
https://www.delftstack.com/howto/java/how-to-check-if-a-string-contains-character-in-java/
https://stackoverflow.com/questions/33325641/check-if-string-has-digits
https://stackoverflow.com/questions/1795402/check-if-a-string-contains-a-special-character
https://stackoverflow.com/questions/40336374/how-do-i-check-if-a-java-string-contains-at-least-one-capital-letter-lowercase
https://stackoverflow.com/questions/6555040/multiple-input-in-joptionpane-showinputdialog
*/