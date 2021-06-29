package Executor;

import dataStructure.Answer;
import dataStructure.Student;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHandler {
    public static void loadAnswerFile(){
        File file = new File("data/answer");
        if(file.exists()){

            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                String line = null;
                while (true){
                    if (!((line = reader.readLine()) != null)) break;
                    System.out.println(line);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else System.out.println("System: 기존에 저장된 정답 파일이 없습니다.");
    }
    public static void loadStudentFile() {

    }
    public static void saveAnswerFile(Answer answer){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("data/answer/answer.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.print(answer.getAnswer());
        pw.close();
        System.out.println("System: 정답파일을 저장하였습니다.");
    }
    public static void saveStudentFile(ArrayList<Student> students ) {

    }
    public static void saveBothFile(Answer answer, ArrayList<Student> students ) {

    }
}
