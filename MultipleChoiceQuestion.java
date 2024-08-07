import java.util.List;

public class MultipleChoiceQuestion extends Question {
    private List<String> options ;
    private List<Integer> correctAnswers;
   
    public MultipleChoiceQuestion() {
        super();
        this.options = null;
        this.correctAnswers = null;
    }
    
    
    public MultipleChoiceQuestion(String code, String description, List<String> options, List<Integer> correctAnswers) {
        super(code, description);
        this.options = options;
        this.correctAnswers = correctAnswers;
    }

    public List<String> getOptions() {
        return options;
    }


    public List<Integer> getCorrectAnswers() {
        return correctAnswers;
    }

    void setOptions(List<String> options){
        this.options= options;
    }

    void setCorrectAnswers(List<Integer> correctAnswers){
        this.correctAnswers = correctAnswers;
    }

    public boolean hasNullValues() {
        if (super.hasNullValues()) {
            return true; 
        }else{
            return options == null || correctAnswers == null;
        }
    }


    @Override
    public String toString() {
        return super.toString() + ", Options=" + options + ", CorrectAnswers=" + correctAnswers ;
    }
}
