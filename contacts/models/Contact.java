package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
  
    private String name;
    private String phoneNumber;
    private String birthDate;
    private int age;
    
    public Contact(String name, String phoneNumber, String birthDate) throws ParseException {

        if(name.isBlank() || name=="" || phoneNumber.isEmpty() || phoneNumber=="" || phoneNumber.length()<5 ){
            throw new IllegalArgumentException("Enter Valid argument!");
        }
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.age = toAge(birthDate);

    }

    public Contact(Contact source){
        source.name = this.name;
        source.phoneNumber = this.phoneNumber;
        source.age = this.age;
        source.birthDate = this.birthDate;
    }

    public void setName(String name) {
        if(name.isBlank() || name==""){
            throw new IllegalArgumentException("Enter Valid argument!");
        }
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.isEmpty() || phoneNumber=="" || phoneNumber.length()<5){
            throw new IllegalArgumentException("Enter valid argument");
        }
        this.phoneNumber = phoneNumber;
    }

    private void setAge(int age) { //PRIVATE
        this.age = age;
    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = birthDate;
        try{
            this.age = toAge(birthDate);
        }
        catch(ParseException e){
            System.out.println(e.getMessage());
        }
    }

    public int toAge(String birthDate)throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //for converting string into Date .  
        formatter.setLenient(false); //if there is a exception it will help to throw.
        long diff = new Date().getTime() - formatter.parse(birthDate).getTime(); //difference of todays date's mili and birthdate to get the age.
        
        return (int)TimeUnit.MILLISECONDS.toDays(diff)/365; //RETURNING THE CALCULATED AGE . ACCURATE

    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return "Name: " + this.name + "\n" +

        "Phone number: " + this.phoneNumber + "\n" +
        
        "Birth Date: " + this.birthDate + "\n" +
        
        "Age: " +this.age + " year old\n";
    }
  
  

}
