/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import constants.FileNames;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
 class ProductDatabase extends Database< Product > implements FileNames{
    public ProductDatabase(String filename) {
        super(PRODUCT_FILENAME); 
    }

    @Override
    public Product createRecordFrom(String line) {
        String[] parts = line.split(",");
        if (parts.length == 6) {
            return new Product(parts[0], parts[1], parts[2],parts[3],Integer.parseInt(parts[4]),Float.parseFloat(parts[4]));
        } else {
            // Handle the case where the line doesn't have the expected format.
            return null;
        }
    }

    

    @Override
    public boolean contains(String key) {
        for(Object obj: this.returnAllRecords()){
           if(obj instanceof Product){
               Product p=(Product) obj;
               if(key.equals(p.getSearchKey())){
                   return true;
                   
               }
           }
       }
       return false;
        }

    @Override
    public Product getRecord(String key) {
       if(contains(key))
        {
            for(Object obj: this.returnAllRecords())
            {
                if(obj instanceof Product)
                {
                    Product p=(Product) obj;
                    if(key.equals(p.getSearchKey()))
                        return p;
                }
            }
        }
        return null;
    }
   
}
