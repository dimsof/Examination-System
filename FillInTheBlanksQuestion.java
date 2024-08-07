import java.util.List;

public class FillInTheBlanksQuestion extends Question {
    private List<String> words;
    private List<String> correctOrder;

    public FillInTheBlanksQuestion() {
        super();
        this.words = null;
        this.correctOrder = null;
    }
    public FillInTheBlanksQuestion(String code, String description, List<String> words, List<String> correctOrder) {
        super(code, description);
        this.words = words;
        this.correctOrder = correctOrder;
    }


    public List<String> getWords() {
        return words;
    }

    public List<String> getCorrectOrder() {
        return correctOrder;
    }

    void setWords(List<String> words){
        this.words= words;
    }

    void setCorrectOrder(List<String> correctOrder){
        this.correctOrder = correctOrder;
    }

    public boolean hasNullValues() {
        if (super.hasNullValues()) {
            return true; 
        }else{
            return words == null || correctOrder == null;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Words=" + words + ", CorrectOrder=" + correctOrder ;
    }
}
