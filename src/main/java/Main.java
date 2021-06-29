import Executor.ExcuteChecker;
import Executor.FileHandler;
import Executor.SelectMenu;
import dataStructure.Answer;
import dataStructure.Student;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        int selectedMenu=-1;
        Answer answer = FileHandler.loadAnswerFile();
        ArrayList<Student> students = FileHandler.loadStudentFile();
        do{
            selectedMenu = SelectMenu.menu();
            switch(selectedMenu){
                case 1:
                    answer = ExcuteChecker.insertAnswer();
                    break;
                case 2:
                    students.add(ExcuteChecker.insertStudent());
                    break;
                case 3:
                    if(students.size()!=0 && answer!=null)
                        students = ExcuteChecker.printResult(students, answer);
                    break;
                case 4:
                    if(answer!=null)
                    ExcuteChecker.printAnswer(answer);
                    break;
                case 5:
                    if(answer!=null)
                    answer = ExcuteChecker.modifyAnswer(answer);
                    break;
                case 6:
                    if(students.size()!=0)
                        students = ExcuteChecker.modifyStudents(students);
                    break;
                case 7:
                    if(students.size()!=0)
                        students = ExcuteChecker.deleteStudents(students);
                    break;
                case 8:
                    FileHandler.saveAnswerFile(answer);
                    break;
                case 9:
                    FileHandler.saveStudentFile(students);
                    break;
            }
        }while(selectedMenu!=0);
        System.out.println("System: Bye :)");
    }
}
