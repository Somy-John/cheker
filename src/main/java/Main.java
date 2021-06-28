import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        int selectedMenu=-1;
        Answer answer;
        ArrayList<Student> students = new ArrayList<>();
        do{
            selectedMenu = SelectMenu.printMenu();
            if(selectedMenu==1)
                answer = SelectMenu.insertAnswer();
            else if(selectedMenu==2)
                students.add(SelectMenu.insertStudent());

        }while(selectedMenu!=0);
    }
}
