public abstract class Question {
    private String code;
    private String description;
    
    public Question(){
        this.code= null;
        this.description=null;
    }

    Question(String code, String description){
        this.code= code;
        this.description=description;
    }
    String getCode(){
        return code;
    }

    String getDescription(){
        return description;
    }

    void setCode(String code){
        this.code = code;
    }

    void setDescription(String description){
        this.description = description;
    }
    public String toString() {
        return "code: "+ code +" description: "+ description;
    }

    public boolean hasNullValues() {
        return code == null || description == null;
    }
}
