import java.util.List;

public class MultipleChoiceAnswer extends Answer {
    private List<Integer> selectedOptions;

    public MultipleChoiceAnswer(Examinee examinee, Question question, List<Integer> selectedOptions) {
        super(examinee, question);
        this.selectedOptions = selectedOptions;
    }

    public List<Integer> getSelectedOptions() {
        return selectedOptions;
    }
    
    @Override
    public boolean isCorrect() {
        if (getQuestion() instanceof MultipleChoiceQuestion) {
            MultipleChoiceQuestion multipleChoiceQuestion = (MultipleChoiceQuestion) getQuestion();
            List<Integer> correctAnswers = multipleChoiceQuestion.getCorrectAnswers();
            
            return selectedOptions.containsAll(correctAnswers) && selectedOptions.size() == correctAnswers.size();
        }
        return false; 
    }
    @Override
    public String toString() {
        return super.toString() + ", SelectedOptions=" + selectedOptions + "]";
    }

    //new
   
    public MultipleChoiceAnswer() {
        super();
        this.selectedOptions = null;
    }
    public MultipleChoiceAnswer(String examineeid, String questionid, List<Integer> selectedOptions) {
        super(examineeid, questionid);
        this.selectedOptions = selectedOptions;
    }

    void setSelectedOptions(List<Integer> selectedOptions)  {
        this.selectedOptions=selectedOptions;
    }

    public boolean hasNullValues() {
        if (super.hasNullValues()) {
            return true; 
        }else{
            return selectedOptions == null ;
        }
    }
}
