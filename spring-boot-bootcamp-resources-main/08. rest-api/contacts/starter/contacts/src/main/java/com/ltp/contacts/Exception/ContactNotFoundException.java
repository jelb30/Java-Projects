package com.ltp.contacts.Exception;

public class ContactNotFoundException extends RuntimeException{

    public ContactNotFoundException(String id){
        super("CONTACT WITH ID "+id+" DOES NOT EXIST !");
    }
}
