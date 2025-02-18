package com.ltp.contacts.pojo;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Contact {

    private String id;

    public static int idGenerator = 0;
    @NotBlank( message = "Name must can not be null !")
    private String name;
    @NotBlank( message = "Phone Number can not be null !")
    private String phoneNumber;


//    public Contact(String id, String name, String phoneNumber) {
//        this.id = id;
//        this.name = name;
//        this.phoneNumber = phoneNumber;
//    }

    public Contact() {
        this.id = Integer.toString(++idGenerator);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
