package com.ltp.contacts.service;

import com.ltp.contacts.Exception.ContactNotFoundException;
import com.ltp.contacts.pojo.Contact;

import java.util.List;

public interface ContactService {

    Contact getContactById(String id) throws ContactNotFoundException;

    void saveContact(Contact contact);

    void updateContact(String id, Contact newContact) throws ContactNotFoundException;

    void deleteContact(String id) throws ContactNotFoundException;

    List<Contact> getContacts();
}
