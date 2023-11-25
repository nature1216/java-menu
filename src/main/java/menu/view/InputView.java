package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.config.NoticeMessage;

public class InputView {
    public String readName() {
        System.out.println(NoticeMessage.READ_COACHES);
        return Console.readLine();
    }
}
