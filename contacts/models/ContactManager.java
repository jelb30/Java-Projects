package models;

import java.util.ArrayList;

public class ContactManager {

    ArrayList<Contact> contacts;

    public ContactManager(){  //CONSTRUCTOR
        contacts = new ArrayList<>();
    }

    public Contact getContact(int index){ //GETTER 
        return new Contact(contacts.get(index));
    }

    public void setContacts(int index, Contact contact){ //SETTER 
        contacts.add(index, new Contact(contact));
    }

    public void addContact(Contact contact){  // ADDING A NEW CONTACT AT LAST
        contacts.add(contact);
    }

    public void removeContact(String contactName){
        if(contacts.size()==0){
            throw new IllegalStateException("No Contects there to remove");
        }
        for (Contact contact : contacts) {
            if(contact.getName().equals(contactName)){
                contacts.remove(contact);
                break;
            }
        }
    }

    public String toString(){
        String temp = "";

        for (Contact contact : contacts) {
            temp = temp + contact.toString()+"\n\n";
        }

        return temp;
    }


}
