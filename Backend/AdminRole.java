/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
import constants.FileNames;
import java.util.ArrayList;
public class AdminRole  {
    private EmployeeUserDatabase  database;

    public AdminRole() {
       // this.database = new EmployeeUserDatabase("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\Assignment 3\\Employees.txt");
        this.database = new EmployeeUserDatabase(FileNames.EMPLOYEE_FILENAME);
        
       this.database.readFromFile();
    }
    public void addEmployee(String employeeId,String name,String email,String address,String phoneNumber){
   
    EmployeeUser d=new EmployeeUser(employeeId,name,email,address,phoneNumber);
   
    if(!database.contains(employeeId))
    { 
        database.insertRecord(d);
        
        System.out.println("Employee added successfully. Current database size: " + database.returnAllRecords().size());
  
   
    }
    else 
            System.out.println("Employee already in file");
    }
    public EmployeeUser[] getListOfEmployees()
       
    { 
        /*ArrayList<EmployeeUser> list=this.database.returnAllRecords();
        EmployeeUser[] array=new EmployeeUser[list.size()];
        for(int i=0;i<list.size();i++)
           array[i]=list.get(i);
       
        return array;*/
        
       ArrayList<EmployeeUser> employeeList = this.database.returnAllRecords();
        System.out.println(employeeList.size());
    EmployeeUser[] employeeArray = employeeList.toArray(new EmployeeUser[employeeList.size()]);
    System.out.println("Number of employees retrieved: " + employeeArray.length);
    return employeeArray;
        
        
}

public void removeEmployee(String Key){
        this.database.deleteRecord(Key);
        
    }
public boolean present(String Key){
   if(database.contains(Key))
       return true;
   else 
       return false;
    
}
    public void logout(){
        this.database.saveToFile();
    }


}
