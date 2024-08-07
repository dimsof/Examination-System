import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateFileApp {

    //1 create Examinee File
    public void CreateExamineeFile (List<Examinee> examinees) {
        FileWriter writer = null;
        try	{
			writer = new FileWriter(new File("Examinees.txt"));
            for (Examinee examinee:examinees){

				if (examinee instanceof Examinee) {
					writer.write ("RATEDPERSON"+"\n"+"{"+"\n"+"\t"+"CODE "+ examinee.getId()
						+ "\n"+"\t"+"SURNAME "+ examinee.getLastName()
						+ "\n"+"\t"+"FIRSTNAME "	+ examinee.getFirstName()
						+ "\n"+"}"+"\n");
				}
                
				
			}
            writer.close();
        }
        catch (IOException e) {
			System.err.println("Error writing file.");
		}	
			
    }

    //2 create Question File
    public void CreateQuestionFile (List <Question> questions) {
        FileWriter writer = null;
        try	{
			writer = new FileWriter(new File("Questions.txt"));
            for (Question question:questions){

				if (question instanceof Question) {
					
                    writer.write("QUESTION"+ "\n" + "{");
                    //2.1 Add MultipleChoiceQuestion
                    if (question instanceof MultipleChoiceQuestion) {
                        MultipleChoiceQuestion mcQuestion = (MultipleChoiceQuestion) question;
                        writer.write("\n" + "\t" + "TYPE MC"
                            + "\n" + "\t" + "CODE " + mcQuestion.getCode()
                            + "\n" + "\t" + "DESCR " + mcQuestion.getDescription()
                            + "\n" + "\t" + "ANSWERS ");
                        
                        List<String> options = mcQuestion.getOptions();
                        for (int i = 0; i < options.size(); i++) {
                            writer.write(options.get(i));
                            if (i < options.size() - 1) {
                                writer.write(" "); // Add a comma if it's not the last option
                            }
                        }

                        writer.write("\n" + "\t" + "CORRECT ");
                        List<Integer> correct = mcQuestion.getCorrectAnswers();
                        for (int i = 0; i < correct.size(); i++) {
                            writer.write(String.valueOf(correct.get(i)));
                            if (i < correct.size() - 1) {
                                writer.write(" "); 
                            }
                        }
                    }
                    
                    //2.2 Add Single Word Question
                    else if (question instanceof SingleWordQuestion){
                        SingleWordQuestion swQuestion = (SingleWordQuestion) question;
                        writer.write("\n" + "\t" + "TYPE WORD"
                            + "\n" + "\t" + "CODE " + swQuestion.getCode()
                            + "\n" + "\t" + "DESCR " + swQuestion.getDescription()
                            + "\n" + "\t" + "WORD "+ swQuestion.getCorrectWord());
                    }
                    
                    //2.3 Add Fill in the blanks Question
                    else if (question instanceof FillInTheBlanksQuestion){
                        FillInTheBlanksQuestion fillQuestion = (FillInTheBlanksQuestion) question;
                        writer.write("\n" + "\t" + "TYPE FILL"
                            + "\n" + "\t" + "CODE " + fillQuestion.getCode()
                            + "\n" + "\t" + "DESCR " + fillQuestion.getDescription()
                            + "\n" + "\t" + "WORDS ");
                        
                        List<String> unordered = fillQuestion.getWords();
                        for (int i = 0; i < unordered.size(); i++) {
                            writer.write(unordered.get(i));
                            if (i < unordered.size() - 1) {
                                writer.write("  "); 
                            }
                        }
                        
                        writer.write("\n" + "\t" + "CORRECTORD ");
                        List<String> inorder = fillQuestion.getCorrectOrder();
                        for (int i = 0; i < inorder.size(); i++) {
                            writer.write(inorder.get(i));
                            if (i < inorder.size() - 1) {
                                writer.write(" "); 
                            }
                        }
                    }
                    writer.write("\n" + "}" + "\n");
				}
				
            }	
            writer.close();
		}
		catch (IOException e) {
			System.err.println("Error writing file.");
		}
    }




    //3 create Answer File
    public void CreateAnswerFile (List <Answer> answers) {
        FileWriter writer = null;
        try	{
			writer = new FileWriter(new File("Answers.txt"));
            for (Answer answer:answers){

				if (answer instanceof Answer) {
					
                    writer.write("ANSWER"+ "\n" + "{");
                    //3.1 Add MultipleChoiceAnswer
                    if (answer instanceof MultipleChoiceAnswer) {
                        MultipleChoiceAnswer mcAnswer = (MultipleChoiceAnswer) answer;
                        writer.write("\n" + "\t" + "TYPE MC"
                                + "\n" + "\t" + "RATEDPERSON_CODE " + mcAnswer.getExamineeId()
                                + "\n" + "\t" + "QUESTION_CODE " + mcAnswer.getQuestionId()
                                + "\n" + "\t" + "ANSWERS ");
                        
                        
                        List<Integer> selected_options = mcAnswer.getSelectedOptions();
                        for (int i = 0; i < selected_options.size(); i++) {
                            writer.write(String.valueOf(selected_options.get(i)));
                            if (i < selected_options.size() - 1) {
                                writer.write(" "); 
                            }
                        }

                       
                    }
                    
                    //3.2 Add Single Word Answer
                    if (answer instanceof SingleWordAnswer) {
                        SingleWordAnswer swAnswer = (SingleWordAnswer) answer;
                        writer.write("\n" + "{" + "\n" + "\t" + "TYPE WORD "
                                + "\n" + "\t" + "RATEDPERSON_CODE " + swAnswer.getExamineeId()
                                + "\n" + "\t" + "QUESTION_CODE " + swAnswer.getQuestionId()
                                + "\n" + "\t" + "WORD "+ swAnswer.getWord());
                    }
                    
                    //3.3 Add Fill in the blanks Answer
                    else if (answer instanceof FillInTheBlanksAnswer) {
                        FillInTheBlanksAnswer fillAnswer = (FillInTheBlanksAnswer) answer;
                        writer.write("\n" + "{" + "\n" + "\t" + "TYPE FILL "
                                + "\n" + "\t" + "RATEDPERSON_CODE " + fillAnswer.getExamineeId()
                                + "\n" + "\t" + "QUESTION_CODE " + fillAnswer.getQuestionId()
                                + "\n" + "\t" + "WORDLIST ");
                        
                        
                        List<String> words_in_order = fillAnswer.getWordsInOrder();
                        for (int i = 0; i < words_in_order.size(); i++) {
                            writer.write(words_in_order.get(i));
                            if (i < words_in_order.size() - 1) {
                                writer.write(" "); 
                            }
                        }

                        
                    }
                    writer.write("\n" + "}" + "\n");
				}
				
			}
            writer.close();
        
        }
        catch (IOException e) {
			System.err.println("Error writing file.");
		}
        

    }
}
