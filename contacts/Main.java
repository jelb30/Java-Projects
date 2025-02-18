import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import models.*;

public class Main {
    
    static ContactManager contactManager = new ContactManager();  // CLASS VARIABLE !!

    public static void main(String[] args) throws FileNotFoundException{  //MAIN
        
        System.out.println("\n");
        
        //WRITING FROM THE FILE (1)
        loadContacts("contacts.txt");

        System.out.println("CONTACTS LOADED\n\n");
        System.out.println(contactManager);

        //USER INTERACTION (2)
        manageContacts();
        System.exit(0);

    }
    
    // (1)
    // WRITING THE CONTACTS FROM THE FILE .
    public static void loadContacts(String fileName) throws FileNotFoundException{

        try{
            Scanner scan = new Scanner(new FileInputStream(fileName));
            while(scan.hasNextLine()){
                try{
                    Contact contact = new Contact(scan.next(),scan.next(),scan.next());
                    contactManager.addContact(contact);
                }
                catch(ParseException e ){
                    System.out.println(e.getMessage());
                }
                
            }
            
        }
        catch(Exception e ){
            System.out.println(e);
        }
        
    }

    //(2)
    // METHOD FOR ADDDING AND REMOVING CONTATCS ACCORDING TO USER .
     public static void manageContacts(){
        Scanner scanf = new Scanner(System.in);

        while(true){
            System.out.println("Would you like to");
            System.out.println("\t\ta) Add another contact");
            System.out.println("\t\tb) Delete a contact");
            System.out.println("\t\tc) Exit");
            String status = scanf.next();

            // FOR ADDING
            if(status.equals("a")){
                System.out.print("\tName: ");
                String name = scanf.next();
                System.out.print("\tPhone Number: ");
                String number = scanf.next();
                System.out.print("\tBirth Date: ");
                String bDate = scanf.next();

                if(number.length()<10){
                    System.out.println("Illegal phone number please enter a valid one");
                    continue;
                }
                try{
                    contactManager.addContact(new Contact(name, number, bDate));
                }
                catch(ParseException e ){
                    System.out.println(e.getMessage());
                }
                finally{
                    System.out.println("\n\nUPDATED CONTACTS\n\n");
                    System.out.println(contactManager);
                }
                continue;
            }

            //FOR REMOVING
            if(status.equals("b")){
                System.out.println("Who would you like to remove ?");
                String nameToRemove = scanf.next();
                contactManager.removeContact(nameToRemove); 
                System.out.println("\n\nUPDATED CONTACTS\n\n");
                System.out.println(contactManager);
                continue;
            }
                 
            //END
            if(status.equals("c")){
                scanf.close();
                break;
            }
               
            System.out.println("Couldn't recognise the command please try it again!");

            }
        }
        
     }