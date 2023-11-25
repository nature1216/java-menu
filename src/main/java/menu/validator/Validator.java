package menu.validator;

import menu.config.ErrorMessage;
import menu.domain.Coach;

public class Validator {
    static public void validateCoachNum(String names) {
        int num = names.split(",").length;
        if(num < 2 || num > 5) {
            throw new IllegalArgumentException(ErrorMessage.EXCEED_COACHES_NUM_RANGE);
        }
    }
}
