import java.io.*;
import java.nio.channels.SeekableByteChannel;
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
            else if(selectedMenu==8)
                SelectMenu.saveAnswerFile();
            else if(selectedMenu==9)
                SelectMenu.saveStudentFile();
        }while(selectedMenu!=0);
        System.out.println("Bye...");
    }
    public static int loadFile(){
        File answerFile = new File(data/answer);
        if(file.exists()){
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("파일내용 출력------------------");
            String line = null;
            try {
            while (true){
                    if (!((line = reader.readLine()) != null)) break;
                System.out.println(line);
            }
            System.out.println("------------------------------");
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
