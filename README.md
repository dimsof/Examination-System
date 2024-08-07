Project Description: Examination System

This program is designed to manage an examination system where multiple-choice, fill-in-the-blanks, and single-word questions can be stored and evaluated for multiple examinees. The system allows adding new examinees, questions, and answers, and provides functionalities to display the stored data and calculate various statistics related to the performance of examinees. It includes features for reading from and writing to files, ensuring persistent storage of data.

Classes and Their Responsibilities
1.	MainApp Class
o	The entry point of the application, providing a menu-driven interface for user interaction.
o	Handles the main loop, presenting options to the user and calling appropriate methods from the EvaluationSystem class based on user input.
2.	EvaluationSystem Class
o	Manages the core functionality of the system, including adding, finding, and displaying examinees, questions, and answers.
o	Provides methods for calculating and displaying statistics such as the number and percentage of correct answers per examinee and per question.
o	Includes methods for reading data from and writing data to text files for persistent storage.
3.	Examinee Class
o	Represents an examinee with attributes like ID, first name, and last name.
o	Includes methods to access examinee details.
4.	Question Class and Subclasses (MultipleChoiceQuestion, FillInTheBlanksQuestion, SingleWordQuestion)
o	Represents different types of questions with attributes like code, description, and specific attributes for each question type.
o	Each subclass has its own attributes and methods to handle question-specific data.
5.	Answer Class and Subclasses (MultipleChoiceAnswer, FillInTheBlanksAnswer, SingleWordAnswer)
o	Represents answers provided by examinees with attributes like examinee, question, and the specific answer details.
o	Each subclass has its own attributes and methods to handle answer-specific data.
6.	FileReadingUtils Class
o	Contains methods to read examinees, questions, and answers from text files.
o	Ensures data is loaded into the system at startup.
7.	CreateFileApp Class
o	Contains methods to write examinees, questions, and answers to text files.
o	Ensures data is saved for future use before the program exits.
