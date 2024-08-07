public class Examinee {
    private String id;
    private String lastName;
    private String firstName;

    Examinee(){
        this.id = null;
        this.lastName = null;
        this.firstName = null;
    }

    public Examinee(String id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    
    void setId(String id){
        this.id= id; 
    }

    void setLastName(String lastname){
        this.lastName= lastname;
    }

    void setFirstName(String firstname){
        this.firstName= firstname;
    }

    public String toString() {
        return id + " " + firstName + " " + lastName;
    }

    public boolean hasNullValues() {
        return id == null || lastName == null || firstName == null;
    }
}

   
   
   
