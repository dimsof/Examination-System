import java.util.List;

public class FillInTheBlanksAnswer extends Answer {
    private List<String> wordsInOrder;

    public FillInTheBlanksAnswer(Examinee examinee, Question question, List<String> wordsInOrder) {
        super(examinee, question);
        this.wordsInOrder = wordsInOrder;
    }

    public List<String> getWordsInOrder() {
        return wordsInOrder;
    }

    @Override
    public boolean isCorrect() {
        if (getQuestion() instanceof FillInTheBlanksQuestion) {
            FillInTheBlanksQuestion fillInTheBlanksQuestion = (FillInTheBlanksQuestion) getQuestion();
            return wordsInOrder.equals(fillInTheBlanksQuestion.getCorrectOrder());
        }
        return false;
    }
    

    @Override
    public String toString() {
        return super.toString() + ", FillInTheBlanksAnswer[WordsInOrder=" + wordsInOrder + "]";
    }
     //new
     public FillInTheBlanksAnswer() {
        super();
        this.wordsInOrder = null;
    }
    public FillInTheBlanksAnswer(String examineeid, String questionid, List<String> wordsInOrder) {
        super(examineeid, questionid);
        this.wordsInOrder = wordsInOrder;
    }

    void setwordsInOrder(List<String> wordsInOrder)  {
        this.wordsInOrder= wordsInOrder;
    }

    public boolean hasNullValues() {
        if (super.hasNullValues()) {
            return true; 
        }else{
            return wordsInOrder == null ;
        }
    }
}

