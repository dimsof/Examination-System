/*
 * Name: Dimitrios Sofoulis
 */
import java.util.Scanner;


public class mainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        EvaluationSystem evaluationSystem = new EvaluationSystem();
        
        evaluationSystem.readFiles();
        
        
        
        /*
        //Initialize examinees
        evaluationSystem.addExaminee(new Examinee("ID1", "Papadopoulos", "Giannis"));
        evaluationSystem.addExaminee(new Examinee("ID2", "Georgiou", "Maria"));
        evaluationSystem.addExaminee(new Examinee("ID3", "Nikolaidis", "Katerina"));
        evaluationSystem.addExaminee(new Examinee("ID4", "Papadaki", "Nikos"));
        
        // Initialize Multiple Choice Question
        evaluationSystem.addQuestion(new MultipleChoiceQuestion("MCQ1", "What is the capital of France?", 
        Arrays.asList("London", "Paris", "Rome", "Berlin"), Arrays.asList(2)));

        evaluationSystem.addQuestion(new MultipleChoiceQuestion("MCQ2", "Which of the following is a mammal?", 
        Arrays.asList("Fish", "Cat", "Dog", "Turtle"), Arrays.asList(2,3)));

        evaluationSystem.addQuestion(new MultipleChoiceQuestion("MCQ3", "Who is the current president of the USA?", 
        Arrays.asList("Barack Obama", "Donald Trump", "Joe Biden", "George Bush"), Arrays.asList(3)));

        // Initialize Single Word Question
        evaluationSystem.addQuestion(new SingleWordQuestion("SWQ1", "What is the capital of Italy?", "Rome"));

        evaluationSystem.addQuestion(new SingleWordQuestion("SWQ2", "What is the color of the sky?", "Blue"));

        evaluationSystem.addQuestion(new SingleWordQuestion("SWQ3", "What is the opposite of 'hot'?", "Cold"));

        // Initialize Fill In The Blanks Question
        evaluationSystem.addQuestion(new FillInTheBlanksQuestion("FBQ1", "Roses are ?, violets are ?", 
        Arrays.asList("red", "blue"), Arrays.asList("red", "blue")));

        evaluationSystem.addQuestion(new FillInTheBlanksQuestion("FBQ2", "? is bigger than ?", 
        Arrays.asList("Bulgaria","Greece" ), Arrays.asList("Greece","Bulgaria")));

        evaluationSystem.addQuestion(new FillInTheBlanksQuestion("FBQ3", "The sum of the numbers ? and ? is ?.", 
        Arrays.asList("7","3", "4" ), Arrays.asList("3", "4", "7")));
        */

        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Add new examinee");
            System.out.println("2. Add new question");
            System.out.println("3. Add new answer");
            System.out.println("4. Display questions");
            System.out.println("5. Display answers of an examinee");
            System.out.println("6. Display number of correct answers per examinee");
            System.out.println("7. Display percentage of correct answers per question");
            System.out.println("8. Display percentage of correct answers per examinee");
            System.out.println("9. Save progress in txt file");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = input.nextInt();
            input.nextLine(); 
            
            switch (choice) {
                case 1:
                    evaluationSystem.addExamineeFromUserInput();
                    break;
                case 2:
                    evaluationSystem.addQuestionFromUserInput();
                    break;
                case 3:
                    evaluationSystem.addAnswerFromUserInput();
                    break;
                case 4:
                    evaluationSystem.displayQuestions();
                    break;
                case 5:
                    evaluationSystem.displayExaminees();
                    System.out.print("Enter ID: ");
                    String id = input.nextLine();
                    Examinee ExamineeForSearch =  evaluationSystem.findExamineeById(id);
                    if (ExamineeForSearch != null){
                    evaluationSystem.displayAnswersOfExaminee(ExamineeForSearch);
                    }
                    break;
                case 6:
                    evaluationSystem.displayCorrectAnswersPerExaminee();
                    break;
                case 7:
                    evaluationSystem.displayCorrectAnswerPercentagePerQuestion();
                    break;
                case 8:
                    evaluationSystem.displayCorrectAnswerPercentagePerExaminee();
                    break;
                case 9:
                    evaluationSystem.writeFiles();
                    break;
                case 10:
                    evaluationSystem.writeFiles();
                    running = false;
                    break;
                case 11:
                    evaluationSystem.displayExaminees();
                    break;
                case 12:
                    evaluationSystem.displayQuestions();
                    break;
                case 13:
                    evaluationSystem.displayAnswers();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
            }
        }
        
        input.close();
    }
}
