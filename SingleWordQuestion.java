public class SingleWordQuestion extends Question {
    private String correctWord;

    
    public SingleWordQuestion() {
        super();
        this.correctWord = null;
    }

    public SingleWordQuestion(String code, String description, String correctWord) {
        super(code, description);
        this.correctWord = correctWord;
    }

    public String getCorrectWord() {
        return correctWord;
    }
    void setCorrectWord(String correctWord){
        this.correctWord= correctWord;
    }

    public boolean hasNullValues() {
        if (super.hasNullValues()) {
            return true; 
        }else{
            return correctWord == null;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", " + correctWord ;
    }
}

