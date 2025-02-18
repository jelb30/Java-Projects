package com.ltp.contacts.service;

import java.util.List;
import java.util.stream.IntStream;

import com.ltp.contacts.Exception.ContactNotFoundException;
import com.ltp.contacts.pojo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.contacts.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact getContactById(String id) throws ContactNotFoundException {
        return contactRepository.getContact(findIndexById(id));
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepository.saveContact(contact);
    }

    @Override
    public void updateContact(String id, Contact newContact) throws ContactNotFoundException {
        int index = findIndexById(id);
        contactRepository.updateContact(index, newContact);
        contactRepository.getContacts().get(index).setId(id);

    }

    @Override
    public void deleteContact(String id) throws ContactNotFoundException {
        contactRepository.deleteContact(findIndexById(id));
    }

    @Override
    public List<Contact> getContacts() {
        return contactRepository.getContacts();
    }

    private int findIndexById(String id) throws ContactNotFoundException {
        return IntStream.range(0, contactRepository.getContacts().size())
            .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
            .findFirst()
            .orElseThrow(()-> new ContactNotFoundException(id));
    }

}
