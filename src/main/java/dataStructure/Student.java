package dataStructure;

public class Student {
    private String name;
    private String s_id;
    private String s_answer;
    private String major;
    private int score;
    public Student(String name, String s_id, String major, String s_answer){
        this.name = name;
        this.s_id = s_id;
        this.major = major;
        this.s_answer = s_answer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    public String getS_answer() {
        return s_answer;
    }

    public void setS_answer(String s_answer) {
        this.s_answer = s_answer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
