public abstract class Answer {
    private Examinee examinee;
    private Question question;
    
    private String examineeid;
    private String questionid;

   
    public Answer(Examinee examinee, Question question){ 
        this.examinee = examinee;
        this.question = question;
    }

    public Examinee getExaminee(){
        return examinee;
    }

    public Question getQuestion(){ 
        return question;
    }

    public abstract boolean isCorrect();

    public String toString(){
        if (examineeid==null){
            return "Answer[Examinee=" + examinee.getId()+ ", Question=" + question.getCode() +"]";

        }else{
            return "Answer[Examinee=" + examineeid + ", Question=" + questionid +"]";
        }
    }

    //NEW 
    public Answer(){ 
        this.examineeid = null;
        this.questionid = null;
    }
    public Answer(String examineeid, String questionid){ 
        this.examineeid = examineeid;
        this.questionid = questionid;
    }

    public String getExamineeId(){
        if (examineeid==null) {
            return examinee.getId();   
        }else{
            return examineeid;
        }    
    }

    public String getQuestionId(){ 
        return questionid;
    }

    void setExamineeId(String examineeid){
        this.examineeid = examineeid;
        
    }

    void setQuestionId(String questionid){ 
        this.questionid = questionid;    
    }
    
    public boolean hasNullValues() {
        return examineeid == null || questionid == null;
    }
    
   
}
