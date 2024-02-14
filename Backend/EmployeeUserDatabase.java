/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import constants.FileNames;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

 class EmployeeUserDatabase extends Database< EmployeeUser > implements FileNames
{
   public EmployeeUserDatabase(String filename) {
       super(EMPLOYEE_FILENAME);
       //readFromFile();
        }
   
   @Override
    public EmployeeUser createRecordFrom(String line) {
        String[] parts = line.split(",");
        if (parts.length == 5) {
           
            return new EmployeeUser(parts[0], parts[1], parts[2], parts[3], parts[4]);
        } else {
            // Handle the case where the line doesn't have the expected format.
            return null;
        }}
  
  @Override
    public boolean contains(String key )
    {
        for(Object obj: this.returnAllRecords()){
           if(obj instanceof EmployeeUser){
               EmployeeUser emp=(EmployeeUser) obj;
               if(key.equals(emp.getSearchKey())){
                   return true;
              }
           }
       }
       return false;
    }    
   @Override
    public EmployeeUser getRecord(String key){
        if(contains(key))
        {
            for(Object obj: this.returnAllRecords())
            {
                if(obj instanceof EmployeeUser)
                {
                    EmployeeUser emp=(EmployeeUser) obj;
                    if(key.equals(emp.getSearchKey()))
                        return emp;
                }
            }
        }
        return null;
    }
        
  
  
  
   
    
    
}
