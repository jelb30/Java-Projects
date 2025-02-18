package com.ltp.contacts.web;

import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.Exception.ContactNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ltp.contacts.service.ContactService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact/{id}")  // ID IS URI.
    public ResponseEntity<Contact> getContact(@PathVariable String id){

        Contact contact = contactService.getContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);

    }

    @PostMapping("/contact")  // ANNOT DESERIALIZE THE JSON INTO JAVA OBJ.
    public ResponseEntity<HttpStatus> saveContact(@Valid @RequestBody Contact contact){

        contactService.saveContact(contact);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/contact/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable String id, @Valid @RequestBody Contact contact){

        contactService.updateContact(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);

    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id){

        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/contact/display")
    public ResponseEntity<List<Contact>> getContacts(){

        List<Contact> contactList = contactService.getContacts();
        return new ResponseEntity<>(contactList, HttpStatus.OK);

    }

}
