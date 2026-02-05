import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App {
    //  지역변수를 빼내서 공유할수 있게 만듬
    Scanner sc = new Scanner(System.in); //입력 받는거
    int lastId = 0;
    WiseSaying[] wiseSayings = new WiseSaying[10];
    int lastWiseSayingIndex = -1;

    //run함수가 하는게 너무 많아 함수로 따로 빼둠
    public void run() {

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionWrite(); // 명언 등록 함수
            } else if (cmd.equals("목록")) {
                actionList(); // 명언 목록 보기 함수
            }
        }
    }

    private void actionList() { // 목록 출력
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        List<WiseSaying> wiseSayingList = findList();

        for(WiseSaying wiseSaying : wiseSayingList) {
            System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.author, wiseSaying.content);
        }
    }

    private List<WiseSaying> findList() {

        List<WiseSaying> wiseSayingList = new ArrayList<>();
        for (int i = lastWiseSayingIndex; i >= 0; i--) {
            WiseSaying foundedWiseSaying = wiseSayings[i];
            wiseSayingList.add(foundedWiseSaying);
        }
        return wiseSayingList;
    }

    private void actionWrite() {//명언 등록
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        write(content, author);
        System.out.println(lastId + "번 명언이 등록되었습니다.");
    }

    private void write(String content,String author){
            WiseSaying wiseSaying = new WiseSaying();

            wiseSaying.id = ++lastId;
            wiseSaying.content = content;
            wiseSaying.author = author;

            wiseSayings[++lastWiseSayingIndex] = wiseSaying;
        }
}
