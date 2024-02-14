/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import constants.FileNames;
 class CustomerProductDatabase extends Database< CustomerProduct> implements FileNames
{   public CustomerProductDatabase (String filename)
        {
        super(CUSTOMERPRODUCT_FILENAME);
                  
        }

    @Override
    public CustomerProduct createRecordFrom(String line) {
        String[] parts = line.split(",");
        if (parts.length == 3) {
            String[] datearray =parts[2].split("-");
            int day=Integer.parseInt(datearray[0]);
            int month=Integer.parseInt(datearray[1]);
            int year=Integer.parseInt(datearray[2]);
            LocalDate date= LocalDate.of(year, month, day);
            
           return new CustomerProduct(parts[0], parts[1], date);
        } else {
            // Handle the case where the line doesn't have the expected format.
            return null;
        } }

   
    @Override
    public boolean contains(String key) {
        for(Object obj: this.returnAllRecords()){
           if(obj instanceof CustomerProduct){
               CustomerProduct cp=(CustomerProduct) obj;
               if(key.equals(cp.getProductId())){
                   return true;
                   
               }
           }
       }
       return false;
         }

    @Override
    public CustomerProduct getRecord(String key) {
        if(contains(key))
        {
            for(Object obj: this.returnAllRecords())
            {
                if(obj instanceof CustomerProduct)
                {
                   CustomerProduct cp=(CustomerProduct) obj;
                    if(key.equals(cp.getSearchKey()))
                        return cp;
                }
            }
        }
        return null;
    }

    
    
    
}
