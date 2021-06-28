import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SelectMenu {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    protected static int printMenu(){
        System.out.println("----- 점수 관리 시스템 -----");
        System.out.println("1. 정답 입력");
        System.out.println("2. 학생 답안 입력");
        System.out.println("3. 결과 출력");
        System.out.println("4. 정답 출력");
        System.out.println("5. 정답 수정");
        System.out.println("6. 학생 답안 수정");
        System.out.println("0. 종료");
        System.out.println("메뉴를 선택하세요 >>> ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    protected static Answer insertAnswer(){
        String sub, ans;
        Answer newSub = null;
        try {
            System.out.println("정답을 입력하시오 (','로 구분)\n>>> ");
            ans = bf.readLine();
            newSub = new Answer(ans);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newSub;
    }
    protected static Student insertStudent(){
        String name, s_id, major, s_answer;
        Student newStudent=null;
        try {
            System.out.println("학생의 이름은? >>> ");
            name = bf.readLine();
            System.out.println("학생의 학번은? >>> ");
            s_id = bf.readLine();
            System.out.println("학생의 전공은? >>> ");
            major = bf.readLine();
            System.out.println("학생의 정답은? (','로 구분)\n>>> ");
            s_answer = bf.readLine();
            newStudent = new Student(name,s_id,major,s_answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newStudent;
    }
    protected static void printResult(ArrayList<Student> students, Answer answer){
        int score;
        List<String> ans = Arrays.asList(answer.getAnswer().split("\\s*,\\s*"));
        List<String> s_ans;
        System.out.println("|  이름  |  학번  |   전공   | 점수 |");
        for(Student currentStudent : students){
            s_ans =  Arrays.asList(currentStudent.getS_answer().split("\\s*,\\s*"));
            score = 0;
            for(String a : ans){
                if(s_ans.remove(0)==a) score++;
            }
            currentStudent.setScore(score);
            System.out.println("|"+currentStudent.getName()+"|"+currentStudent.getS_id()+"|"+currentStudent.getMajor()+"|"+currentStudent.getScore());
        }
    }
    protected static void printAnswer(Answer answer){
        System.out.println(answer.getAnswer());
    }


}
