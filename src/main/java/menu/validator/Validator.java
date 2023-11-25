package menu.validator;

import menu.config.ErrorMessage;

import java.util.List;

public class Validator {
    static public void validateName(String input) {
        List<String> names = List.of(input.split(","));
        validateCoachNum(names);
        validateDuplicateName(names);
    }
    static public void validateCoachNum(List<String> names) {
        int num = names.size();
        if (num < 2 || num > 5) {
            throw new IllegalArgumentException(ErrorMessage.EXCEED_COACHES_NUM_RANGE);
        }
    }

    static public void validateDuplicateName(List<String> names) {
        if(names.stream().distinct().count() < names.stream().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NAME);
        }
    }
}
