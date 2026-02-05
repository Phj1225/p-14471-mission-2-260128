import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    int lastId = 0;

    WiseSaying[] wiseSayings = new WiseSaying[10];
    int lastWiseSayingIndex = -1;

    public void run() {

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            }
        }
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (int i = lastWiseSayingIndex; i >= 0; i--) {
            WiseSaying foundedWiseSaying = wiseSayings[i];
            System.out.println(foundedWiseSaying.id + " / " + foundedWiseSaying.author + " / " + foundedWiseSaying.content);
        }
    }

    private void actionWrite() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = new WiseSaying();

        wiseSaying.id = ++lastId;
        wiseSaying.content = content;
        wiseSaying.author = author;

        wiseSayings[++lastWiseSayingIndex] = wiseSaying;
        System.out.println(lastId + "번 명언이 등록되었습니다.");
    }
}