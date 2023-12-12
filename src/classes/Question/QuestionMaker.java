package classes.Question;

import enums.Department;
import interfaces.utilities.Common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionMaker implements Common {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a list to store questions
        List<Question> questions = new ArrayList<>();

        // Ask the user for questions
        while (true) {
            System.out.println("Enter the type of question (MCQ/TrueFalse/FillInTheBlanks) or 'exit' to finish:");
            String questionType = scanner.nextLine().trim();

            if (questionType.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter the question body:");
            String questionBody = scanner.nextLine();

            System.out.println("Enter the answer:");
            String answer = scanner.nextLine();

            System.out.println("Enter the difficulty level:");
            int difficultyLevel = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter the department (IT/HR/MARKETING):");
            String departmentInput = scanner.nextLine();
            Department department = Common.getDepartment(departmentInput);

            switch (questionType.toUpperCase()) {
                case "MCQ":
                    System.out.println("Enter options for the MCQ (comma-separated):");
                    String optionsInput = scanner.nextLine();
                    List<String> options = List.of(optionsInput.split(","));
                    questions.add(new MCQQuestion(questionBody, answer, difficultyLevel, department, options));
                    break;
                case "TRUEFALSE":
                    questions.add(new TrueFalseQuestion(questionBody, answer, difficultyLevel, department));
                    break;
                case "FILLINTHEBLANKS":
                    questions.add(new FillInTheBlanksQuestion(questionBody, answer, difficultyLevel, department));
                    break;
                default:
                    System.out.println("Invalid question type. Please enter MCQ, TrueFalse, or FillInTheBlanks.");
            }
        }

        // Save questions to Excel file
        saveQuestionsToExcel(questions);

        System.out.println("Questions saved to Excel file.");
    }

    private static void saveQuestionsToExcel(List<Question> questions) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Questions");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Type");
        headerRow.createCell(1).setCellValue("Question Body");
        headerRow.createCell(2).setCellValue("Answer");
        headerRow.createCell(3).setCellValue("Difficulty Level");
        headerRow.createCell(4).setCellValue("Department");

        // Populate data rows
        for (int i = 0; i < questions.size(); i++) {
            Row row = sheet.createRow(i + 1);
            Question question = questions.get(i);
            row.createCell(0).setCellValue(question.getQuestionType());
            row.createCell(1).setCellValue(question.getQuestionBody());
            row.createCell(2).setCellValue(question.getAnswer());
            row.createCell(3).setCellValue(question.getDifficultyLevel());
            row.createCell(4).setCellValue(question.getDepartment());
        }

        // Write the workbook to a file
        try (FileOutputStream fileOut = new FileOutputStream("questions.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
