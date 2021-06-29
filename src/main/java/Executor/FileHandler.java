package Executor;

import dataStructure.Answer;
import dataStructure.Student;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHandler {
    public static Answer loadAnswerFile(){
        Answer answer = null;
        File file = new File("data/answer/answer.txt");
        if(file.exists()){
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                String line = reader.readLine();
                answer = new Answer(line);
                reader.close();
                System.out.println("System: 기존에 저장된 정답 파일을 불러왔습니다.");
                return answer;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else System.out.println("System: 기존에 저장된 정답 파일이 없습니다.");
        return new Answer();
    }
    public static ArrayList<Student> loadStudentFile() {
        ArrayList<Student> students = new ArrayList<Student>();
        File file = new File("data/student/students.txt");
        if(file.exists()){
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                String line = null, name = null, s_id = null, s_answer = null, major = null;
                int score = -1,index1,index2,index3,index4;
                while ((line = reader.readLine()) != null){
                    index1 = line.indexOf("//");                                                             //index of first "//"
                    index2 = line.indexOf("//",index1+1);                                      //index of second "//"
                    index3 = line.indexOf("//",index2+1);                                      //index of third "//"
                    index4 = line.lastIndexOf("//");                                                    //index of last "//"
                    name = line.substring(0,index1);                                                        // Noah//22000646//CS//1,2,3,3//3
                    s_id = line.substring(index1+2,index2);
                    major = line.substring(index2+2,index3);
                    s_answer = line.substring(index3+2,index4);
                    score = Integer.parseInt(line.substring(index4+2));
                    students.add(new Student(name,s_id,major,s_answer,score));
                }
                reader.close();
                System.out.println("System: 기존에 저장된 학생 파일을 불러왔습니다.");
                return students;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else System.out.println("System: 기존에 저장된 학생 파일이 없습니다.");
        return students;
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
        System.out.println("System: 정답 파일을 저장하였습니다.");
    }
    public static void saveStudentFile(ArrayList<Student> students ) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("data/student/students.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0; i<students.size(); i++){
            pw.println(students.get(i).getName()+"//"+students.get(i).getS_id()+"//"+students.get(i).getMajor()+"//"+students.get(i).getS_answer()+"//"+students.get(i).getScore());
        }
        pw.close();
        System.out.println("System: 결과 파일을 저장하였습니다.");
    }
}
