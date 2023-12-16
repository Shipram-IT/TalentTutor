
public class Main {
    public static void main(String[] args) {
        // Create a company and show the employee list
        Company company = new Company("MyCompany");
        QuestionBank questionBank = new QuestionBank("MyQuestionBank");
        boolean programRunning = true;
        while (programRunning){
            String employeeId = Menu.getEmployeeId();
            if (employeeId.equalsIgnoreCase("Q")){
                System.out.println("Thanks for accessing TalentTutor. Program closing...");
                break;
            }
            Employee employee = company.getEmployeeById(employeeId);
            if (employee != null) {
                String employeeType = employee.getClass().getName();
                System.out.printf("Welcome, %s (%s)\n", employee.name, employeeType);
                if (employee instanceof Manager) {
                    Manager manager = (Manager) employee;
                    Menu.showMenu(company, manager);
                }
                else if (employee instanceof QuizMaster) {
                    QuizMaster quizMaster = (QuizMaster) employee;
                    Menu.showMenu(quizMaster, questionBank);
                }
                else if (employee instanceof RegularEmployee) {
                    RegularEmployee regularEmployee = (RegularEmployee) employee;
                    Menu.showMenu(company, regularEmployee);
                }
                else{
                    System.out.println("Error");
                }
            } else {
                Menu.showAccessDenied();
            }
        }

    }

}