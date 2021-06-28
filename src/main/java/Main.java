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
            else if(selectedMenu==3)
                SelectMenu.printResult(students, answer);
            else if(selectedMenu==4)
                SelectMenu.printAnswer(answer);
            else if(selectedMenu==5)
                answer = SelectMenu.modifyAnswer(answer);
        }while(selectedMenu!=0);
    }
}
