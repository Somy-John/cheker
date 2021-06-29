package Executor;

import dataStructure.Answer;
import dataStructure.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcuteChecker {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static Answer insertAnswer() {
        String sub, ans;
        Answer newAns = null;
        try {
            System.out.print("정답을 입력하시오 (','로 구분)\n>>> ");
            ans = bf.readLine();
            newAns = new Answer(ans);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newAns;
    }

    public static Student insertStudent() {
        String name, s_id, major, s_answer;
        Student newStudent = null;
        try {
            System.out.print("학생의 이름은? >>> ");
            name = bf.readLine();
            System.out.print("학생의 학번은? >>> ");
            s_id = bf.readLine();
            System.out.print("학생의 전공은? >>> ");
            major = bf.readLine();
            System.out.print("학생의 정답은? (','로 구분)\n>>> ");
            s_answer = bf.readLine();
            newStudent = new Student(name, s_id, major, s_answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newStudent;
    }

    public static void printResult(ArrayList<Student> students, Answer answer) {
        int score,i;
        List<String> ans = Arrays.asList(answer.getAnswer().split("\\s*,\\s*"));
        List<String> s_ans;
        System.out.println("|  이름  |  학번  |  전공  |  점수  |");
        for (Student currentStudent : students) {
            s_ans = Arrays.asList(currentStudent.getS_answer().split("\\s*,\\s*"));
            score = 0;
            i=0;
            for (String a : ans) {
                if (s_ans.get(i).equals(a)) score++;
                i++;
            }
            currentStudent.setScore(score);
            System.out.println("| " + currentStudent.getName() + " | " + currentStudent.getS_id() + " | " + currentStudent.getMajor() + " |  " + currentStudent.getScore()+"  |");
        }
    }

    public static void printAnswer(Answer answer) {
        System.out.println(answer.getAnswer());
    }

    public static Answer modifyAnswer(Answer answer) {
        String sub, ans;
        Answer modifiedAns = null;
        try {
            System.out.print("수정된 정답을 입력하시오 (','로 구분)\n>>> ");
            ans = bf.readLine();
            modifiedAns = new Answer(ans);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modifiedAns;
    }

    public static ArrayList<Student> modifyStudents(ArrayList<Student> students) {
        System.out.println("|  이름  |  학번  |   전공   |");
        for (Student currentStudent : students) {
            System.out.println("| " + currentStudent.getName() + " | " + currentStudent.getS_id() + " | " + currentStudent.getMajor() + " |");
        }
        try {
            System.out.print("정보를 수정 할 학생의 학번은? >>> ");
            String s_id = bf.readLine();
            for (Student currentStudent : students) {
                if (currentStudent.getS_id().equals(s_id)) {
                    System.out.println("선택된 학생의 이름 : " + currentStudent.getName());
                    System.out.print("변경할 학생의 이름은? >>> ");
                    currentStudent.setName(bf.readLine());
                    System.out.print("변경할 학생의 학번은? >>> ");
                    currentStudent.setS_id(bf.readLine());
                    System.out.print("변경할 학생의 전공은? >>> ");
                    currentStudent.setMajor(bf.readLine());
                    System.out.print("변경할 학생의 정답은? (','로 구분)\n>>> ");
                    currentStudent.setS_answer(bf.readLine());
                    return students;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("System: 해당 학생이 없습니다.");
        return students;
    }

    public static ArrayList<Student> deleteStudents(ArrayList<Student> students) {
        System.out.println("|  이름  |  학번  |   전공   |");
        for (Student currentStudent : students) {
            System.out.println("| " + currentStudent.getName() + " | " + currentStudent.getS_id() + " | " + currentStudent.getMajor() + " |");
        }
        try {
            System.out.print("삭제할 학생의 학번은? >>> ");
            String s_id = bf.readLine();
            for (Student currentStudent : students) {
                if (currentStudent.getS_id().equals(s_id)) {
                    System.out.print("정말 삭제하시겠습니까? (yes: 1, no: 0) >>> ");
                    int accept = Integer.parseInt(bf.readLine());
                    if (accept == 1) {
                        students.remove(currentStudent);
                        System.out.println("System: 삭제 완료");
                    }
                    else if(accept==0) {
                        System.out.println("System: 삭제 취소");
                    }
                    return students;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("System: 해당 학생이 없습니다.");
        return students;
    }
}
