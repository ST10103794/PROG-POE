
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Questy Kuti Mbenza
 */
public class Task {
     protected String taskID="", printDetails = null;
     protected int taskCount=0, totalTime=0, statusOption =0;
        
     
     protected String[] taskIDSave = {"", "", "", "", "", "", "", "", "", "", ""};
     protected String[] taskName = {"", "", "", "", "", "", "", "", "", "", ""}; 
     protected String taskDesc[] = {"", "", "", "", "", "", "", "", "", "", ""};
     protected String[] taskStatus ={"", "", "", "", "", "", "", "", "", "", ""};
     protected String[] devDetails ={"", "", "", "", "", "", "", "", "", "", ""}; 
     protected int[] taskNum = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 
     protected int[] taskDuration = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    
     boolean checkTaskDescription(int i){
        int len = taskDesc[i].length();
        boolean ans;
        
        ans = len <= 50;
        
        return ans;
    }
    
    String createTaskID(int i){
        setTaskID("");
        String nameBegin = taskName[i].substring(0, 2);
        String nameEnd = devDetails[i].substring(devDetails[i].length() -3);
        setTaskID(nameBegin.toUpperCase() + ":" + i + ":" + 
                nameEnd.toUpperCase());
        return getTaskID();
    }
    
    String printTaskDetails(int i){
        String printDetails=
                "             ......................"+"\n"+
                "| Task status             - " +taskStatus[i]+"\n"+
                "| Developer name      - " +devDetails[i]+"\n"+
                "| Task number           - " +taskNum[i]+"\n"+
                "| Task Name              - " +taskName[i]+"\n"+
                "| Task description    - " +taskDesc[i]+"\n"+
                "| Task ID                     - " +taskIDSave[i]+"\n"+
                "| Task duration         - " +taskDuration[i]+" hours"+"\n"+
                "             ......................";
        return printDetails;
    }
    
    int returnTotalHours(){
        int totalHours=0;
        
        for(int i=0; i<= taskCount; i++){
            totalHours += taskDuration[i];
        }
        return totalHours;
    }

    /**
     * @return the taskID
     */
    public String getTaskID() {
        return taskID;
    }

    /**
     * @param taskID the taskID to set
     */
    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getPrintDetails() {
        return printDetails;
    }

    public void setPrintDetails(String printDetails) {
        this.printDetails = printDetails;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public int getStatusOption() {
        return statusOption;
    }

    public void setStatusOption(int statusOption) {
        this.statusOption = statusOption;
    }

    public String[] getTaskIDA() {
        return taskIDSave;
    }

    public void setTaskIDA(String[] taskIDSave) {
        this.taskIDSave = taskIDSave;
    }

    public String[] getTaskName() {
        return taskName;
    }

    public void setTaskName(String[] taskName) {
        this.taskName = taskName;
    }

    public String[] getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String[] taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String[] getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String[] taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String[] getDevDetails() {
        return devDetails;
    }

    public void setDevDetails(String[] devDetails) {
        this.devDetails = devDetails;
    }

    public int[] getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(int[] taskNum) {
        this.taskNum = taskNum;
    }

    public int[] getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(int[] taskDuration) {
        this.taskDuration = taskDuration;
    }
    
    
    
}
