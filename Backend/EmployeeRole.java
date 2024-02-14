/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author ADMIN
 */
import java.util.ArrayList;
import java.time.LocalDate;
import constants.FileNames;

public class EmployeeRole {
    private ProductDatabase productsDatabase;
    private CustomerProductDatabase customerProductDatabase;
    

    public EmployeeRole() {
       // this.productsDatabase=new ProductDatabase("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\Assignment 3\\Products.txt");
        //this.customerProductDatabase=new CustomerProductDatabase("C:\\Users\\ADMIN\\OneDrive\\Documents\\NetBeansProjects\\Assignment 3\\CustomerProducts.txt");
        this.productsDatabase=new ProductDatabase(FileNames.PRODUCT_FILENAME);
        this.customerProductDatabase=new CustomerProductDatabase(FileNames.CUSTOMERPRODUCT_FILENAME);
        
        
        productsDatabase.readFromFile();
        customerProductDatabase.readFromFile();
    }
    
    
    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity,float price)
    {  Product p=new Product(productID,productName,manufacturerName,supplierName,quantity,price);
       //productsDatabase.readFromFile();
       if(!productsDatabase.contains(productID))
       {
           productsDatabase.insertRecord(p);
           //productsDatabase.saveToFile();
           
       }
       else
            System.out.println("Product already in ");
       
      }
  
    public Product[] getListOfProducts(){
        ArrayList<Product> list=this.productsDatabase.returnAllRecords();
        Product[] array=new Product[list.size()];
        for(int i=0;i<list.size();i++)
           array[i]=list.get(i);
       
        return array;
    }
    public CustomerProduct[] getListOfPurchasingOperations(){
        ArrayList<CustomerProduct> list=this.customerProductDatabase.returnAllRecords();
        CustomerProduct[] array=new CustomerProduct[list.size()];
        for(int i=0;i<list.size();i++)
           array[i]=list.get(i);
       
        return array;
    }
   public boolean purchaseProduct(String customerSSN,String productID,LocalDate purchaseDate){
       CustomerProduct cp=new CustomerProduct(customerSSN,productID,purchaseDate);
       Product p=productsDatabase.getRecord(productID);
       if(  p==null || p.getQuantity()==0)
       {System.out.println("Product Not found");
           return false;
       }
       else 
       {    p.setQuantity(p.getQuantity()-1);
            customerProductDatabase.insertRecord(cp);
        
        //productsDatabase.deleteRecord(productID);
      // customerProductDatabase.saveToFile();
       // productsDatabase.saveToFile();

        return true;
   }
   }
 public double returnProduct(String customerSSN, String productID,LocalDate purchaseDate ,LocalDate returnDate){
       Product p=productsDatabase.getRecord(productID);
       if(returnDate.isBefore(purchaseDate) )
          return -1;
       if(!productsDatabase.contains(productID))
          return -1;
       if(!customerProductDatabase.contains(productID))
         return -1;
       
       
       LocalDate cutoffDate = purchaseDate.plusDays(14);
        if (returnDate.isAfter(cutoffDate)) {
            return -1;
        }

        p.setQuantity(p.getQuantity() + 1);
        //productsDatabase.saveToFile();

        customerProductDatabase.deleteRecord(productID);
       //customerProductDatabase.saveToFile();
        System.out.println(p.getPrice());
      return p.getPrice();
   } 
   public void logout() {
        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();
    }
   public boolean present(String key){
       if(productsDatabase.contains(key))
           return true;
       else return false;
   }
   public boolean presentInCusotomerProduct(String key){
       if(customerProductDatabase.contains(key))
           return true;
       else return false;
   }
    
   
}