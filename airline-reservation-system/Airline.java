public class Airline {

    private Person[] persons;
    private Person[] seats;

    public Airline(){
        //this.persons = new Person[11];
        this.seats = new Person[11];
    }

    // SETTING THE PERSON OBJECT TO THE GIVEN INDEX OF THE PERSON ARRAY OF AIRLINE CLASS !
    public void setPersons(Person person,int index){
        // new Person to return the new copy TO PREVENT REFERENCE TRAP !

        // new Person(OBJECT) --> CALLS THE CONSTRUCTOR OF ARGUMENT WITH THE OBJECT, REFER THE PERSON FILE !
        this.persons[index] = new Person(person);
    }

    // GETTING THE PERSON OBJECT FROM THE PERSON ARRAY OF THE AIRLINE CLASS !
    public Person getPerson(int index){
        // new Person to return the new copy TO PREVENT REFERENCE TRAP !
        return new Person(this.persons[index]);
    }

    public void createReservation(Person person){
        while(seats[person.getSeatNumber()-1]!=null){
            System.out.println("\n" + person.getName() + ", seat: " + person.getSeatNumber() + 
            " is already taken. Please choose another seat.\n");
            person.setSeatNumber(person.chooseSeat());
        }

        int index=person.getSeatNumber()-1;
        seats[index]= new Person(person);
        System.out.println("Thank you " + person.getName() + 
        " for flying with Java airlines. Your seat number is " + person.getSeatNumber() + ".\n");

    }

    public String toString(){
        String temp = "";
        for (int i = 0; i < this.seats.length; i++) {
           if (seats[i] != null) {                      
                temp += seats[i].toString();
                temp += "\n\n";    
           } 
            else {
                temp += "Seat " + (i+1) + " is empty.";
                temp += "\n\n";
            }
        }
        return temp;
    }
    
}
