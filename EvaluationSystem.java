import java.util.*;
public class EvaluationSystem {
    private List<Examinee> examinees;
    private List<Question> questions;
    private List<Answer> answers;

    Scanner input = new Scanner(System.in);
    
    public EvaluationSystem() {
        examinees = new ArrayList<>();
        questions = new ArrayList<>();
        answers = new ArrayList<>();
    }

    public void addExaminee(Examinee examinee) {
        examinees.add(examinee);
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }
   
    //1 add examinee from user input
    public void addExamineeFromUserInput() {
        System.out.println("Enter examinee details:");

        System.out.print("Enter ID: ");
        String id = input.nextLine();
    
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
    
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
    
        Examinee newExaminee = new Examinee(id, lastName, firstName);

        addExaminee(newExaminee); 
    
        System.out.println("Examinee added successfully.");
    }
    
    //2 add question from user input
    public void addQuestionFromUserInput() {
        System.out.println("Enter question details:");
        System.out.print("Enter code: ");
        String code = input.nextLine();
        System.out.print("Enter description: ");
        String description = input.nextLine();

        System.out.println("Select question type:");
        System.out.println("1. Multiple Choice");
        System.out.println("2. Fill in the Blanks");
        System.out.println("3. Single Word Answer");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                addMultipleChoiceQuestion(code, description);
                break;
            case 2:
                addFillInTheBlanksQuestion(code, description);
                break;
            case 3:
                addSingleWordQuestion(code, description);
                break;
            default:
                System.out.println("Invalid choice. Question not added.");
        }
    }

    //2.1 for multiple choice Question

    private void addMultipleChoiceQuestion(String code, String description) {
        int numOptions = 4; 
        List<String> options = new ArrayList<>();
        for (int i = 0; i < numOptions; i++) {
            System.out.print("Enter option " + (i + 1) + ": ");
            options.add(input.nextLine());
        }
    
        List<Integer> correctAnswers = new ArrayList<>();
        System.out.print("Enter the number of correct answers: ");
        int numCorrectAnswers = input.nextInt();
        input.nextLine();
    
        for (int i = 0; i < numCorrectAnswers; i++) {
            System.out.print("Enter the correct option number " + (i + 1) + ": ");
            correctAnswers.add(input.nextInt());
            input.nextLine(); 
        }
    
        Question newQuestion = new MultipleChoiceQuestion(code, description, options, correctAnswers);
        addQuestion(newQuestion);
        System.out.println("Multiple Choice Question added successfully.");
    }
    //2.2 for FillInTheBlanks Question
    private void addFillInTheBlanksQuestion(String code, String description) {
        System.out.print("Enter the number of words: ");
        int numWords = input.nextInt();
        input.nextLine(); 
    
        List<String> words = new ArrayList<>();
        for (int i = 0; i < numWords; i++) {
            System.out.print("Enter word " + (i + 1) + ": ");
            words.add(input.nextLine());
        }
    
        List<String> correctOrder = new ArrayList<>();
        System.out.println("Enter the correct order of the words:");
        for (int i = 0; i < numWords; i++) {
            System.out.print("Enter the word for position " + (i + 1) + ": ");
            correctOrder.add(input.nextLine());
        }
    
        Question newQuestion = new FillInTheBlanksQuestion(code, description, words, correctOrder);
        addQuestion(newQuestion);
        System.out.println("Fill in the Blanks Question added successfully.");
    }
    

    //2.3 add single word question
    private void addSingleWordQuestion(String code, String description) {
        System.out.print("Enter the correct word: ");
        String correctWord = input.nextLine();

        Question newQuestion = new SingleWordQuestion(code, description, correctWord);
        addQuestion(newQuestion);
        System.out.println("Single Word Question added successfully.");
    }
   
    //3 add Answer from User Input
    public void addAnswerFromUserInput() {
        System.out.println("Enter answer details:");

        System.out.print("Enter examinee ID: ");
        String examineeId = input.nextLine();
        
        //answer needs examinee and question to be registered, if input doesnt match to already existing examinees and questions, answer is not added 

        Examinee examinee = findExamineeById(examineeId);
        if (examinee == null) {
            System.out.println("Examinee with ID " + examineeId + " not found.");
            return;
        }

        System.out.print("Enter question code: ");
        String questionCode = input.nextLine();

        Question question = findQuestionByCode(questionCode);
        if (question == null) {
            System.out.println("Question with code " + questionCode + " not found.");
            return;
        }

        if (question instanceof MultipleChoiceQuestion) {
            addMultipleChoiceAnswer(examinee, (MultipleChoiceQuestion) question);
        } else if (question instanceof FillInTheBlanksQuestion) {
            addFillInTheBlanksAnswer(examinee, (FillInTheBlanksQuestion) question);
        } else if (question instanceof SingleWordQuestion) { 
            addSingleWordAnswer(examinee, (SingleWordQuestion) question);
        } else {
            System.out.println("Unsupported question type.");
        }
    }

    //3.1 add multiplechoice answer
    private void addMultipleChoiceAnswer(Examinee examinee, MultipleChoiceQuestion question) {
        List<Integer> selectedOptions = new ArrayList<>();

        for (int i = 0; i < question.getOptions().size(); i++) {
            System.out.print("Is option " + (i + 1) + " selected? (yes/no): ");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                selectedOptions.add(i + 1);
            }
        }

        Answer answer = new MultipleChoiceAnswer(examinee, question, selectedOptions);
        addAnswer(answer);
        System.out.println("Multiple Choice Answer added successfully.");
    }

    //3.2 add FillInTheBlanks answer
    private void addFillInTheBlanksAnswer(Examinee examinee, FillInTheBlanksQuestion question) {
        List<String> wordsInOrder = new ArrayList<>();

        for (int i = 0; i <= question.getWords().size(); i++) {
            System.out.print("Enter word " + (i + 1) + ": ");
            String word = input.nextLine();
            wordsInOrder.add(word);
        }

        Answer answer = new FillInTheBlanksAnswer(examinee, question, wordsInOrder);
        addAnswer(answer);
        System.out.println("Fill in the Blanks Answer added successfully.");
    }

    //3.3 add SingleWord Answer
    private void addSingleWordAnswer(Examinee examinee, SingleWordQuestion question) {
        System.out.print("Enter the word: ");
        String word = input.nextLine();

        Answer answer = new SingleWordAnswer(examinee, question, word);
        addAnswer(answer);
        System.out.println("Single Word Answer added successfully.");
    }
    //search examinee from ID
    public Examinee findExamineeById(String id) {
        for (Examinee examinee : examinees) {
            if (examinee.getId().equals(id)) {
                return examinee;
            }
                
            
        }
        return null; 
    }
    
    //search question from code
    public Question findQuestionByCode(String code) {
        for (Question question : questions) {
            if (question.getCode().equals(code)) {
                return question;
            }
        }
        return null; 
    }

    //display examinees, questions, answers
    public void displayExaminees() {
        if (examinees.isEmpty()) {
            System.out.println("No examinees found.");
        } else {
            for (Examinee examinee : examinees) {
                System.out.println(examinee);
            }
        }
    } 

    //4 display questions
    public void displayQuestions() {
        if (questions.isEmpty()) {
            System.out.println("No questions found.");
        } else {
            for (Question question : questions) {
                System.out.println(question);
            }
        }
    }

    public void displayAnswers() {
        if (answers.isEmpty()) {
            System.out.println("No answers found.");
        } else {
            for (Answer answer : answers) {
                System.out.println(answer);
            }
        } 
    }

    //5 display answers of a specific examinee
    public void displayAnswersOfExaminee(Examinee examinee) {
        if (answers.isEmpty()) {
            System.out.println("There are no answers to display.");
            return;
        }
        boolean found = false;
        for (Answer answer : answers) {
            if (answer.getExamineeId().equals(examinee.getId())) {
                System.out.println(answer);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No answers found for the examinee.");
        }
    }


    //6 calculate and display the number of correct answers per examinee
    public void displayCorrectAnswersPerExaminee() {
        Map<String, Integer> correctAnswersMap = new HashMap<>();
        
        //6.1 Count correct answers for each examinee
        if (answers.isEmpty()) {
            System.out.println("No answers found.");
        } else {
            for (Answer answer : answers) {
                String examineeid = answer.getExamineeId();
                if (answer.isCorrect()) {
                    correctAnswersMap.put(examineeid, correctAnswersMap.getOrDefault(examineeid, 0) + 1);
                }
            }
        } 
       
        //6.2 Sort by the number of correct answers
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(correctAnswersMap.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        //6.3 Display sorted results
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " correct answers");
        }
    }

    //7 calculate and display the percentage of correct answers per question
    public void displayCorrectAnswerPercentagePerQuestion() {
        Map<String, Integer> correctCountMap = new HashMap<>();
        Map<String, Integer> totalCountMap = new HashMap<>();
        
        //7.1 Count correct answers and total answers for each question
        if (answers.isEmpty()) {
            System.out.println("No answers found.");
        } else {
            for (Answer answer : answers) {
                String questionid = answer.getQuestionId();
                totalCountMap.put(questionid, totalCountMap.getOrDefault(questionid, 0) + 1);
                if (answer.isCorrect()) {
                    correctCountMap.put(questionid, correctCountMap.getOrDefault(questionid, 0) + 1);
                }
            }
        } 
        
        
        //7.2 Calculate and display the percentage of correct answers per question
        for (Question question : questions) {
            int correctCount = correctCountMap.getOrDefault(question, 0);
            int totalCount = totalCountMap.getOrDefault(question, 0);
            double percentage = (double) correctCount / totalCount * 100;
            System.out.println(question.getDescription() + ": " + String.format("%.2f", percentage) + "%");
        }
    }

    //8 calculate and display the percentage of correct answers per examinee
    public void displayCorrectAnswerPercentagePerExaminee() {
        Map<Examinee, Integer> correctCountMap = new HashMap<>();
        Map<Examinee, Integer> totalCountMap = new HashMap<>();
        
        //8.1 Count correct answers and total answers for each examinee
        for (Answer answer : answers) {
            Examinee examinee = answer.getExaminee();
            totalCountMap.put(examinee, totalCountMap.getOrDefault(examinee, 0) + 1);
            if (answer.isCorrect()) {
                correctCountMap.put(examinee, correctCountMap.getOrDefault(examinee, 0) + 1);
            }
        }
        
        //8.2 Calculate and display the percentage of correct answers per examinee
        for (Examinee examinee : examinees) {
            int correctCount = correctCountMap.getOrDefault(examinee, 0);
            int totalCount = totalCountMap.getOrDefault(examinee, 0);
            if (totalCount!=0){
                double percentage = (double) correctCount / totalCount * 100;
                System.out.println(examinee.getFirstName() + " " + examinee.getLastName() + ": " + String.format("%.2f", percentage) + "%");
            }    
        }
    }
    
    ////partB///    
    public void readFiles(){
        
        FileReadingUtils Store = new FileReadingUtils();
        
        examinees=Store.readExamineesFromFile("Examinees.txt");
        questions=Store.readQuestionsFromFile("Questions.txt");
        
        answers=Store.readAnswersFromFile("Answers.txt");
    }

    public void writeFiles(){
        
        CreateFileApp Store = new CreateFileApp();

        Store.CreateExamineeFile(examinees);
        Store.CreateQuestionFile(questions);
        
        Store.CreateAnswerFile(answers);
    }
}

