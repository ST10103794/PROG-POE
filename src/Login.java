
import javax.swing.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import java.lang.String;
import java.util.Scanner;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.OK_OPTION;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.OK_OPTION;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;

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
        
        Credentials user = new Credentials();
        int loopStop=0; //dummy value
        int stopLoop=0; //dummy value

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
        
        /*
        
        
        //some info on purpose of the program
        JOptionPane.showMessageDialog(
                null, "You are going to register an account " +
                        " then login using your details.", "Register", 
                INFORMATION_MESSAGE);
        
        
        
        
        //object creation to retriev multiple input at once
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
        
        //enter the user details 
        JOptionPane.showConfirmDialog(null, detailsOne, "Register", 
                JOptionPane.OK_CANCEL_OPTION);
        JOptionPane.showConfirmDialog(null,  detailsTwo, "Register", 
                JOptionPane.OK_CANCEL_OPTION);
    
        //convert into string
        user.inputSetter(userNameIn, passwordIn, firstNameIn, lastNameIn);
        
        //username check
        user.checkUserName();      
        //password check
        user.checkPasswordComplexity();   
        
        //registration message
        user.registerUser();
        
        //unsuccessfful registration
       while((user.checkUserName() ==false) || 
               (user.checkPasswordComplexity() ==false)){
           
           while((user.checkUserName() ==false) && 
               (user.checkPasswordComplexity() ==false)){
              
               JOptionPane.showMessageDialog(null,user.getRegisterUserReturn(), 
                    "Failed", ERROR_MESSAGE);
               
                JOptionPane.showConfirmDialog(null,  detailsTwo, "Register", 
                    JOptionPane.OK_CANCEL_OPTION);  
               
                //convert into string
                user.inputSetter(userNameIn, passwordIn);
                
                //username check
                user.checkUserName();
                
                if(user.checkUserName() ==true){
                    JOptionPane.showMessageDialog(null, "Username successfully "
                        + "registered", 
                        "successfully", INFORMATION_MESSAGE);
                }
                
                //password check
                user.checkPasswordComplexity(); 
                
                if(user.checkPasswordComplexity() ==true){
                    JOptionPane.showMessageDialog(null, "Password successfully "
                        + "registered", 
                        "successfull", INFORMATION_MESSAGE);
                }
                
                //registration message
            user.registerUser();
           }
           
           while((user.checkUserName() ==false) && 
               (user.checkPasswordComplexity() ==true)){
               
               JOptionPane.showMessageDialog(null,user.getRegisterUserReturn(), 
                    "Failed", ERROR_MESSAGE);
               
               user.setUserName(JOptionPane.showInputDialog(
                       null, "Make a username: "));
               
            //username check
            user.checkUserName();   
            
            //registration message
            user.registerUser();
            
            if(user.checkUserName() ==true){
                JOptionPane.showMessageDialog(null, "Username successfully "
                        + "registered", 
                    "successfully", INFORMATION_MESSAGE);
            }
           }
           
           while((user.checkPasswordComplexity() ==false) && 
                   (user.checkUserName() ==true)){
               
               JOptionPane.showMessageDialog(null,user.getRegisterUserReturn(), 
                    "Failed", ERROR_MESSAGE);
               
               user.setPassword(JOptionPane.showInputDialog(
                       null, "Make a password: "));
               
            //password check
            user.checkPasswordComplexity();   
            
            //registration message
            user.registerUser();
           
           if(user.checkPasswordComplexity() ==true){
                JOptionPane.showMessageDialog(null, "pASSWORD successfully "
                        + "registered", 
                    "successfull", INFORMATION_MESSAGE);
            }
           }
           
        }
       
       JOptionPane.showMessageDialog(null,user.getRegisterUserReturn(), 
                    "Successfull", INFORMATION_MESSAGE);
        
        //input login details    
        JOptionPane.showConfirmDialog(
        null, confirmDetails, "Login", OK_CANCEL_OPTION, INFORMATION_MESSAGE); 
        
        //convert to String
        user.setUserNameConfirm(userNameConfirmIn.getText());                     
        user.setPasswordConfirm(passwordConfirmIn.getText()); 
        
        //login verification
        user.loginUser();       
        
        //message                         
        user.returnLoginSatus();       
        
       while(user.loginUser()==false) {
           
            //unsuccessful login message
           JOptionPane.showMessageDialog(null, user.getReturnStatus(), 
                    "LOGIN FAILED", ERROR_MESSAGE);
           
           //re-enter the login details
           JOptionPane.showConfirmDialog(
        null, confirmDetails, "Login", OK_CANCEL_OPTION); 
           
            //convert to String
        user.setUserNameConfirm(userNameConfirmIn.getText());                     
        user.setPasswordConfirm(passwordConfirmIn.getText());
        
         //login verification
        user.loginUser();
        
        //message
        user.returnLoginSatus();
        
       }
       
        //successfull login message
        JOptionPane.showMessageDialog(null, user.getReturnStatus(), 
            "Welcome", INFORMATION_MESSAGE); 
        
        */
        
        
                         //POE PART 2
        
        
        //Secondary declarations
        Task process = new Task();
        Scanner input = new Scanner(System.in);
        int options; 
        
        //
        //JTextField taskNumShow = new JTextField();
        JTextField taskNameIn = new JTextField("");
        JTextField taskDescIn = new JTextField("");
        JTextField devDetailsIn = new JTextField("");
        JTextField taskDurationIn = new JTextField("");
        
        //taskNumShow = taskNum
        
        Object[] taskIn = {
            "Task name: ", taskNameIn,
            "Task description: ",
            taskDescIn,
            "Developer assigned: ",
            devDetailsIn,
            "Task duration(hours): ",
            taskDurationIn,
        };
        //
        
        
        JOptionPane.showMessageDialog(null, "Welcom to EasyKanan");
        options = Integer.parseInt(JOptionPane.showInputDialog(null,
                """
                Choose what you would like to dofrom the following:
                (Type only the number)
                          
                1) Add task
                2) Show report
                3) Quit
                           """));
        

        while(options >= 1){
            switch (options) {
                case 1:
                    process.setTaskCount(Integer.parseInt(JOptionPane.showInputDialog(
                            null, "How many tasks will you add?",
                            "Add Task", QUESTION_MESSAGE)));
                    for(int i =0; i < process.getTaskCount(); i++){
                        
                        process.taskNum[i] += i;
                        JOptionPane.showMessageDialog(null, "Task "+process.taskNum[i]);
                        
                        JOptionPane.showConfirmDialog(null, taskIn, "Enter Task",
                                OK_OPTION);
                        
                        //sending data from text fields to arrays
                        process.taskName[i] = taskNameIn.getText();
                        process.taskDesc[i] = taskDescIn.getText();
                        process.devDetails[i] = devDetailsIn.getText();
                        String durationConvert = taskDurationIn.getText();
                        process.taskDuration[i] = Integer.parseInt(durationConvert);
                        
                        //resetting the text fields
                        taskNameIn.setText("");
                        taskDescIn.setText("");
                        devDetailsIn.setText("");
                        taskDurationIn.setText("");
                        
                        process.checkTaskDescription(i);
                        
                        while(!process.checkTaskDescription(i)){
                            process.taskDesc[i]= JOptionPane.showInputDialog(null,
                                    "Please enter a task description of less than "
                                            + "50 characters.", "Description",
                                            INFORMATION_MESSAGE);
                            process.checkTaskDescription(i);
                            
                        }
                        
                        process.taskIDSave[i] = process.createTaskID(i);
                        
                        System.out.print(process.taskIDSave[i]);
                        
                        process.setStatusOption(Integer.parseInt(
                                JOptionPane.showInputDialog(
                                        null, """
                                        Choose a task status from the following:
                                        (Input the number)
                                        1) To do
                                        2) Done
                                        3) Doing
                                        """)));
                        
                        while(process.getStatusOption() <1 ||
                                process.getStatusOption() >3){
                            JOptionPane.showMessageDialog(null,
                                    "The option you have chosen is invalid",
                                    "Invalid option", ERROR_MESSAGE);
                            process.setStatusOption(Integer.parseInt(
                                    JOptionPane.showInputDialog(
                                            null, """
                                                  Choose a task status from the following:
                                                  (Input the number)
                                                  1) To do
                                                  2) Done
                                                  3) Doing
                                                  """)));
                        }
                        switch (process.getStatusOption()) {
                            case 1:
                                process.taskStatus[i] = "To do";
                                break;
                            case 2:
                                process.taskStatus[i] = "Done";
                                break;
                            case 3:
                                process.taskStatus[i] = "Doing";
                                break;
                            default:
                                break;
                        }
                    }   JOptionPane.showMessageDialog(null, 
                            "Task successfully captured", "",INFORMATION_MESSAGE);
                    process.setTotalTime(process.returnTotalHours());
                    for(int i=0; i< process.getTaskCount(); i++){
                        process.setPrintDetails(process.printTaskDetails(i));
                        JOptionPane.showMessageDialog(null, process.getPrintDetails());
                    }   JOptionPane.showMessageDialog(null, 
                            "The total amount of time taken for all tasks is "
                                    +process.getTotalTime() );
                    
                    options = Integer.parseInt(JOptionPane.showInputDialog(null,
                """
                Choose what you would like to dofrom the following:
                (Type only the number)
                          
                1) Add task
                2) Show report
                3) Quit
                           """));
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "COMING SOON!!!");
                    
                    options = Integer.parseInt(JOptionPane.showInputDialog(null,
                """
                Choose what you would like to dofrom the following:
                (Type only the number)
                          
                1) Add task
                2) Show report
                3) Quit
                           """));
                    break;
                case 3:
                    System.exit(0);
                default:
                    options = Integer.parseInt(JOptionPane.showInputDialog(null,
                        """
                        The option you have chosen is invalid. Choose
                        from the following:
                        1) Add task
                        2) Show report
                        3) Quit
                        """));
                    break;
            }
            
        }        
        
    }
}