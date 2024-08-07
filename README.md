Project Description: Examination System

This program is designed to manage an examination system where multiple-choice, fill-in-the-blanks, and single-word questions can be stored and evaluated for multiple examinees. The system allows adding new examinees, questions, and answers, and provides functionalities to display the stored data and calculate various statistics related to the performance of examinees. It includes features for reading from and writing to files, ensuring persistent storage of data.

Classes and Their Responsibilities
1.	MainApp Class
	The entry point of the application, providing a menu-driven interface for user interaction.
 Handles the main loop, presenting options to the user and calling appropriate methods from the EvaluationSystem class based on user input.
3.	EvaluationSystem Class
	Manages the core functionality of the system, including adding, finding, and displaying examinees, questions, and answers.
	Provides methods for calculating and displaying statistics such as the number and percentage of correct answers per examinee and per question.
	Includes methods for reading data from and writing data to text files for persistent storage.
4.	Examinee Class
	Represents an examinee with attributes like ID, first name, and last name.
	Includes methods to access examinee details.
5.	Question Class and Subclasses (MultipleChoiceQuestion, FillInTheBlanksQuestion, SingleWordQuestion)
	Represents different types of questions with attributes like code, description, and specific attributes for each question type.
	Each subclass has its own attributes and methods to handle question-specific data.
6.	Answer Class and Subclasses (MultipleChoiceAnswer, FillInTheBlanksAnswer, SingleWordAnswer)
	Represents answers provided by examinees with attributes like examinee, question, and the specific answer details.
	Each subclass has its own attributes and methods to handle answer-specific data.
7.	FileReadingUtils Class
	Contains methods to read examinees, questions, and answers from text files.
	Ensures data is loaded into the system at startup.
8.	CreateFileApp Class
	Contains methods to write examinees, questions, and answers to text files.
	Ensures data is saved for future use before the program exits.

File Operations

Read Files: Loads examinees, questions, and answers from text files at the start of the program.
Write Files: Saves examinees, questions, and answers to text files before exiting the program.
Display Percentage of Correct Answers per Question.
Display Percentage of Correct Answers per Examinee.
Java Features Used: Object-Oriented Programming.

