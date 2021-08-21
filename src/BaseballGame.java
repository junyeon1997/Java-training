import java.util.Random;
import java.util.Scanner;

public class BaseballGame{

    static final int MAXNUM = 3;

    public static void main(String[] args) {
        int[] comArr = new int[MAXNUM];
        int[] userArr = new int[MAXNUM];
        boolean userNumErr;
        comArr = makeCom(comArr);
        while (true){
            userNumErr = makeUser(userArr);
            if (userNumErr==true) continue;
            int strikeCnt = compare(comArr, userArr);
            if (strikeCnt==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    //컴퓨터 생성
    public static int[] makeCom(int[] comArr) {
        comArr = comOverlap();
        System.out.print("컴퓨터 : ");
        for (int i=0 ; i<MAXNUM; i++) {
            System.out.print(comArr[i]);
        }
        System.out.println();
        return comArr;

    }
    //컴퓨터 숫자 중복 체크
    public static int[] comOverlap() {
        Random rd = new Random();
        int[] comArr = new int[MAXNUM];
        for (int i=0; i<MAXNUM; i++) {
            comArr[i]=rd.nextInt(9) + 1;
        }
        for (int i=0; i<MAXNUM; i++) {
            if (i>0 && comArr[i]==comArr[i-1]) i--;
            if (i==(MAXNUM-1) && comArr[i]==comArr[0]) i--;
        }
        return comArr;

    }
    //사용자 생성
    public static boolean makeUser(int[] userArr) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String userNum = sc.next();
        if (posCheck(userNum)==true){
            return true;
        }

        for (int i=0; i<MAXNUM; i++) {
            userArr[i]=userNum.charAt(i)-'0'; //'0'의 아스키코드값을 빼줘야 정수값이 나온다
        }
        if (userOverlap(userNum)==true){
            return true;
        }

        return false;
    }

    //사용자 숫자 중복 체크
    public static boolean userOverlap(String userNum) {
        char[] check = userNum.toCharArray();
        for (int i=0; i<MAXNUM; i++) {
            if (i>0 && check[i]==check[i-1]) {
                System.out.println("중복된 숫자가 있습니다. 다시 입력 해주세요.");
                return true;
            }
            if (i==(MAXNUM-1) && check[0]==check[i]){
                System.out.println("중복된 숫자가 있습니다. 다시 입력 해주세요.");
                return true;
            }
        }
        return false;

    }
    //사용자 숫자 자리수 체크
    public static boolean posCheck(String userNum) {
        if (userNum.length()!=MAXNUM){
            System.out.println("숫자를 "+MAXNUM+"개 입력해주세요.");
            return true;
        }
        return false;
    }
//    컴퓨터와 사용자 배열 비교
    public static int compare(int[] comArr, int[] userArr) {
        int strike=0, ball=0;
        String comStr = "";
        for (int c : comArr) {
            comStr+=c;
        }
        for (int i=0; i<MAXNUM; i++) {
            if (comArr[i]==userArr[i]) strike++;
            else if (comStr.contains(Integer.toString(userArr[i]))) ball++; /**String 클래스의 contains 메소드 사용하기위해
                                                                              Integer.toString로 문자열로 변환**/
            }
        System.out.println(strike +" 스트라이크 " + ball +" 볼");
        return strike;
    }

}
