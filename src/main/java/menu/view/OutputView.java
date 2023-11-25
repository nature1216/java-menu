package menu.view;

import menu.config.NoticeMessage;
import menu.domain.Coach;

import java.util.List;

public class OutputView {
    public void printStart() {
        System.out.println(NoticeMessage.START_SYSTEM);
        System.out.println();
    }

    public void printResult(List<Coach> coaches, List<String> categoryNames) {
        System.out.println(NoticeMessage.PRINT_OUTPUT);
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategory(categoryNames);
        printMenus(coaches);
    }

    public void printCategory(List<String> categories) {
        System.out.println("[ 카테고리 | " +
                String.join(" | ", categories) +
                " ]");
    }

    public void printMenus(List<Coach> coaches) {
        for(Coach coach : coaches) {
            System.out.println("[ " + coach.getName() + " | " +
                    String.join(" | ", coach.getRecommendations()) +
                    " ]");
        }
        System.out.println();
    }

    public void printFinish() {
        System.out.print(NoticeMessage.FINISH_SYSTEM);
    }
}
