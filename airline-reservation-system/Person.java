import java.util.Arrays;

public class Person {
    private String name;
    private String nationality;
    private String dateOfBirth;
    private int seatNumber;
    String[] passport;

    //CONSTRUCTOR
    public Person(String name, String nationality, String dateOfBirth,int seatNumber){
        this.name=name;
        this.nationality=nationality;
        this.dateOfBirth=dateOfBirth;
        this.seatNumber=seatNumber;
        this.passport= new String[3];
    }

    //CONSTRUCTOR
    public Person(String name, String nationality){

        this.name=name;
        this.nationality=nationality;
    }

    //COPY CONSTRUCTOR
    public Person(Person object){
        this.name=object.name;
        this.dateOfBirth=object.dateOfBirth;
        this.nationality=object.nationality;
        this.seatNumber=object.seatNumber;
        this.passport= Arrays.copyOf(object.passport, object.passport.length);
    }

    //toString method prints whatever inside when the object is printed .
    public String toString(){
        return "Name: " +  this.name + "\n" + "Nationality: " + 
        this.nationality + "\n" + "Date of Birth: " + 
        this.dateOfBirth + "\n" + "Seat Number: " +
        this.seatNumber + "\n" + "Passport: " + 
        Arrays.toString(this.passport)  + "\n";
    }

    // GETTERS 
    public String getName(){
        return this.name;
    }

    public String getNationality(){
        return this.nationality;
    }

    public String getDateOfBirth(){
        return this.dateOfBirth;
    }

    public String[] getPassport(){
        return Arrays.copyOf(this.passport, this.passport.length);
    }

    public int getSeatNumber(){
        return this.seatNumber;
    }

    // SETTERS
    public void setName(String name){
        this.name=name;
    }

    public void setNationality(String nationality){
        this.nationality=nationality;
    }

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth=dateOfBirth;
    }

    public void setSeatNumber(int seatNumber){
        this.seatNumber=seatNumber;
    }

    public void setPassport(){
        this.passport = new String[] {this.getName(),this.getNationality(),this.getDateOfBirth()};
    }

    // METHODS 
    public boolean applyPassport(){

        int random = (int)(Math.random()*2);
        //System.out.println(random);
        if(random==0){
            return false;
        }
        return true;


    }
    public int chooseSeat(){
        int random = (int)(Math.random()*11);
        //System.out.println(random+1);
        random+=1;
        return random;
    }

}
