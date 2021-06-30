package Executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SelectMenu {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static int menu() {
        System.out.println("\n----- 점수 관리 시스템 -----");
        System.out.println("[1] 정답 입력");
        System.out.println("[2] 학생 답안 입력");
        System.out.println("[3] 학생 정보 출력");
        System.out.println("[4] 결과 출력");
        System.out.println("[5] 정답 출력");
        System.out.println("[6] 정답 수정");
        System.out.println("[7] 학생 정보 수정");
        System.out.println("[8] 학생 삭제");
        System.out.println("[9] 정답 파일 저장");
        System.out.println("[10] 결과 파일 저장");
        System.out.println("[0] 종료");
        System.out.println("-----------------------");
        System.out.print("메뉴를 선택하세요 >>> ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

}