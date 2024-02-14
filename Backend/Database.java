package Backend;

import java.io.*;
import java.util.ArrayList;

 abstract class Database< T extends ProdGeneric> {
    protected String filename;
    protected ArrayList<T> records;

    public Database(String filename) {
        this.filename = filename;
        this.records = new ArrayList<>();
    }

    public void readFromFile()   {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                T record = createRecordFrom(line);
                //System.out.println(record);
                if (record != null) {
                    records.add(record);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
    }

    public abstract T createRecordFrom(String line);

    public  ArrayList<T> returnAllRecords(){
         //System.out.println("Returning all records. Current size of records: " + records.size());
   
        return this.records;
    }

    public boolean contains(String key){
        for (T record : records) {
        if (key.equals(record.getSearchKey())) {
            return true;
        }
    }
    return false;
    }

    public abstract T getRecord(String key);

    public  void insertRecord(T record){
        
         if (!contains((String) record.getSearchKey()))
        {
           
            records.add(record); 
            System.out.println("Record Inserted");
          
        }
        else System.out.println("Already in Records!");
    }

    public void deleteRecord(String key){
         
      T recordToDelete = null;
        for (T record : records)
        {       
           String check=(String)record.getSearchKey();
            if ( key.equals(check) )
                    {
                recordToDelete = record;
                break;
            }
        }

        if (recordToDelete != null) {
            records.remove(recordToDelete);
            saveToFile();
            System.out.println("Record deleted.");
        } else {
            System.out.println("Record not found.");
        }
    }

    public  void saveToFile()
    {
        try{
        BufferedWriter writer=new BufferedWriter(new FileWriter(filename, false));
       for(T record : records)
        {
           String w=(String)record.lineRepresentation();
           writer.write(w);
           writer.newLine();
        }
       
        writer.close();
        }catch(IOException E){
            System.out.println("ERROR");
        }
    }
    
    }

