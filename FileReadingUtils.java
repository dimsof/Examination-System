import java.io.*;
import java.util.*;

class FileReadingUtils {
    //1 READ EXAMINEE
    private List<Examinee> examinees = new ArrayList<>();

    List<Examinee> readExamineesFromFile(String fileName) {
        BufferedReader reader = null;
        Examinee examinee = new Examinee(); 
        try {
            //loads file with examinee entities in it
            reader = new BufferedReader (new FileReader(fileName));
			String line = reader.readLine();
            
            while(line!=null){ //makes loop until file ends
                
                
                
                
                StringTokenizer st = new StringTokenizer(line);
                String token = st.nextToken();
            
            
                //1.1 add characteristics of examinee/ratedperson
                if (token.equals("RATEDPERSON")){ //if token equals to RATEDPERSON keyword it makes new examinee 
					examinee = new Examinee();  
				}
                else if(token.equals("CODE")){// sets id if token equals to CODE keyword
                    String Code = st.nextToken(); // Read value next to CODE
                    examinee.setId(Code);

                }
                else if(token.equals("FIRSTNAME")){// sets firstname if token equals to FIRSTNAME keyword
                    String firstName = st.nextToken(); // Read value next to FIRSTNAME
                    examinee.setFirstName(firstName);
                
                }
                else if(token.equals("SURNAME")){// Sets lastname for keyword SURNAME
                    String Surname = st.nextToken(); // Read value next to SURNAME
                    examinee.setLastName(Surname);

                }
                else if(token.equals("}")){
                    if (!examinee.hasNullValues()) {
                        examinees.add(examinee);
                        System.out.println("examinee added");
                      } else {
                        System.out.println("Examinee has null values");
                    }                     
                }
                line+=1;
                line = reader.readLine();     
                       
            }
            
            reader.close();
            
        }
        catch (IOException e){
			System.err.println("Error Reading File...");
		}
        return examinees;
            
    }
    //2 READ QUESTION
    private List<Question> questions = new ArrayList<>();

    public List<Question> readQuestionsFromFile(String fileName) {
        BufferedReader reader = null;
        Question question = null;
        
        try {
            //loads file with question entities in it
            reader = new BufferedReader (new FileReader(fileName));
			String line = reader.readLine();
            

            while(line!=null){ //makes loop until file ends
                StringTokenizer st = new StringTokenizer(line);
                String token = st.nextToken();
                
                //2.1find the type of the question
                if (token.equals("TYPE")){ 
                    String questiontype = st.nextToken();
        
                    if (questiontype.equals("MC")){ //if token equals to MC keyword it new multiplechoice question instance is made 
                        question = new MultipleChoiceQuestion();
                    
                    }else if(questiontype.equals("WORD")){ //if token equals to WORD keyword it new SingleWordQuestion question instance is made 
                        question = new SingleWordQuestion();
                    
                    }else if(questiontype.equals("FILL")){ //if token equals to FILL keyword it new FillInTheBlanks question instance is made 
                        question = new FillInTheBlanksQuestion();           
                    }
                //2.2 add general characteristics of question
                }else if(token.equals("CODE")){// sets id if token equals to CODE keyword
                    String Code = st.nextToken(); // Read value next to CODE
                    question.setCode(Code);
                
                }else if(token.equals("DESCR")){// sets description if token equals to description keyword
                    String Descr = line.substring(token.length() + 1).trim();
                    question.setDescription(Descr);

                //2.3.1 add characteristics of MultipleChoice question   
                }else if(token.equals("ANSWERS")&& question instanceof MultipleChoiceQuestion){//  
                    List<String> options = new ArrayList<>();
                    
                    
                    while (st.hasMoreTokens()) {
                        String opt=st.nextToken();
                        options.add(opt);
                    }
                    ((MultipleChoiceQuestion)question).setOptions(options);
                
                }else if (token.equals("CORRECT") && question instanceof MultipleChoiceQuestion) {
                    List<Integer> correctAnswers = new ArrayList<>();
                    while (st.hasMoreTokens()){
                        correctAnswers.add(Integer.parseInt(st.nextToken()));
                    }
                    ((MultipleChoiceQuestion) question).setCorrectAnswers(correctAnswers);
                
                
                
                //2.3.2 add characteristics of SingleWord question
                }else if(token.equals("WORD")&& question instanceof SingleWordQuestion){// sets id if token equals to CODE keyword
                    ((SingleWordQuestion) question).setCorrectWord(st.nextToken());
                
                
               
                //2.3.3 add characteristics of FillInTheBlanks question
                }else if(token.equals("WORDS")&& question instanceof FillInTheBlanksQuestion){//  
                    List<String> words = new ArrayList<>();
                    while (st.hasMoreTokens()) {
                        words.add(st.nextToken());
                    }
                    ((FillInTheBlanksQuestion)question).setWords(words);
                
                }else if(token.equals("CORRECTORD")&& question instanceof FillInTheBlanksQuestion){//  
                    List<String> correctOrder = new ArrayList<>();
                    while (st.hasMoreTokens()) {
                        correctOrder.add(st.nextToken());
                    }
                    ((FillInTheBlanksQuestion)question).setCorrectOrder(correctOrder);
                
                
                //2.4
                }else if(token.equals("}")){
                //If } is found, it means that a question is ready to set, 
                //or question file is finished

                    if(question != null){//check if question is null, that means question list is finished
                        if (question.hasNullValues()) { //check if any of question characteristics are null
                            System.out.println("Question has null values, something went wrong.");
                        } else {
                            
                            questions.add(question);//that means, all values have been set, so new question is added to the list
                            System.out.println("question added successfully.");
                        }
                        question = null;//set question to null because if question list ends, double adding the last question is prevented
                    }                      
                }
                
                line = reader.readLine();             
            }
            reader.close();
        }
        catch (IOException e){
			System.err.println("Error Reading File...");
		}
        return questions;   
    }

    //3 READ ANSWER FILE
    private List<Answer> answers = new ArrayList<>();

    public List<Answer> readAnswersFromFile(String fileName) {
        BufferedReader reader = null;
        Answer answer = null;
        
        try {
            
            reader = new BufferedReader (new FileReader(fileName));
			String line = reader.readLine();
            

            while(line!=null){ 
                StringTokenizer st = new StringTokenizer(line);
                String token = st.nextToken();
                System.out.println(token);
                System.out.println(line);
                //3.1find the type of the answer
                if (token.equals("TYPE")){ 
                    String answertype = st.nextToken();
        
                    if (answertype.equals("MC")){ //if token equals to MC keyword it new multiplechoice answer instance is made 
                        answer = new MultipleChoiceAnswer();
                    
                    }else if(answertype.equals("WORD")){ //if token equals to WORD keyword it new SingleWordAnswer answer instance is made 
                        answer = new SingleWordAnswer();
                    
                    }else if(answertype.equals("FILL")){ //if token equals to FILL keyword it new FillInTheBlanksAnswer answer instance is made 
                        answer = new FillInTheBlanksAnswer();           
                    }
                //3.2 add general characteristics of answer
                }else if(token.equals("RATEDPERSON_CODE")){// sets ExamineeId if token equals to RATEDPERSON_CODE 
                    
                    answer.setExamineeId(st.nextToken());
                
                }else if(token.equals("QUESTION_CODE")){// sets QuestionId if token equals to QUESTION_CODE 
                    answer.setQuestionId(st.nextToken());
                
                //3.3.1 add characteristics of MultipleChoice answer   
                }else if(token.equals("ANSWERS")&& answer instanceof MultipleChoiceAnswer){//set Selected options if token equals to ANSWERS  
                    List<Integer> ans = new ArrayList<>();
                    while (st.hasMoreTokens()){
                        ans.add(Integer.parseInt(st.nextToken()));
                    }
                    ((MultipleChoiceAnswer)answer).setSelectedOptions(ans);
                
                //3.3.2 add characteristics of SingleWord answer
                }else if(token.equals("WORD")&& answer instanceof SingleWordAnswer){// set Word if token equals to WORD 
                    ((SingleWordAnswer) answer).setWord(st.nextToken());
                
                
                //3.3.3 add characteristics of FillInTheBlanks answer
                }else if(token.equals("WORDLIST")&& answer instanceof FillInTheBlanksAnswer){//  
                    List<String> wordsInOrder = new ArrayList<>();
                    while (st.hasMoreTokens()) {
                        wordsInOrder.add(st.nextToken());
                    }
                    ((FillInTheBlanksAnswer)answer).setwordsInOrder(wordsInOrder);

                //3.4
                }else if(token.equals("}")){
                //If } is found, it means that a answer is ready to set, 
                //or question file is finished

                    if(answer != null){//
                        if (answer.hasNullValues()) { //
                            System.out.println("Answer has null values, something went wrong.");
                        } else {
                            answers.add(answer);
                            System.out.println("Answer added successfully."); 
                        }
                        answer = null;
                    }                      
                }
                line = reader.readLine();             
            }
            reader.close();
        }
        catch (IOException e){
			System.err.println("Error Reading File...");
		}
        return answers;          
    }
   
   
   
   
    Examinee examineesGet(int i){
		return examinees.get(i);
	}


	int examineesSize()	{
		return examinees.size();
	}
    
	
    Question questionGet(int i){
		return questions.get(i);
	}


	int questionSize()	{
		return questions.size();
	}

    
	Answer answerGet(int i){
		return answers.get(i);
	}


	int answerSize()	{
		return answers.size();
	}
}

   
    
