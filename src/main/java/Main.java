import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        int selectedMenu=-1;
        Answer answer = null;
        ArrayList<Student> students = new ArrayList<>();
        do{
            selectedMenu = SelectMenu.printMenu();
            if(selectedMenu==1)
                answer = SelectMenu.insertAnswer();
            else if(selectedMenu==2)
                students.add(SelectMenu.insertStudent());
            else if(selectedMenu==3 && students.size()!=0 && answer!=null)
                SelectMenu.printResult(students, answer);
            else if(selectedMenu==4 && answer!=null)
                SelectMenu.printAnswer(answer);
            else if(selectedMenu==5 && answer!=null)
                answer = SelectMenu.modifyAnswer(answer);
            else if(selectedMenu==6 && students.size()!=0)
                students = SelectMenu.modifyStudents(students);
            else if(selectedMenu==7 && students.size()!=0)
                students = SelectMenu.deleteStudents(students);
        }while(selectedMenu!=0);
    }
}
