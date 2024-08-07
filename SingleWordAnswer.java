public class SingleWordAnswer extends Answer {
    private String word;

    public SingleWordAnswer(Examinee examinee, Question question, String word) {
        super(examinee, question);
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean isCorrect() {
        if (getQuestion() instanceof SingleWordQuestion) {
            SingleWordQuestion singleWordQuestion = (SingleWordQuestion) getQuestion();
            String correctWord = singleWordQuestion.getCorrectWord();
            return word.equalsIgnoreCase(correctWord);
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", Word=" + word ;
    }

    //new
    public SingleWordAnswer() {
        super();
        this.word = null;
    }
    public SingleWordAnswer(String examineeid, String questionid, String word) {
        super(examineeid, questionid);
        this.word = word;
    }

    void setWord(String word)  {
        this.word= word;
    }

    public boolean hasNullValues() {
        if (super.hasNullValues()) {
            return true; 
        }else{
            return word == null ;
        }
    }
}

