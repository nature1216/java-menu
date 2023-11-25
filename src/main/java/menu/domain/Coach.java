package menu.domain;

import menu.config.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> dislikes;
    private List<String> recommendations;

    public Coach(String name) {
        validateName(name);
        this.name = name;
        this.dislikes = new ArrayList<>();
        this.recommendations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDislike(List<String> menus) {
        validateMenu(menus);
        dislikes.addAll(menus);
    }

    public boolean exist(String menu) {
        return recommendations.contains(menu);
    }

    public boolean isDislike(String menu) {
        return dislikes.contains(menu);
    }

    public int countRecommendations() {
        return recommendations.size();
    }

    public void addRecommendations(String menu) {
        recommendations.add(menu);
    }

    public List<String> getRecommendations() {
        return recommendations;
    }

    private void validateName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH);
        }
    }

    private void validateMenu(List<String> menus) {
        if(menus.get(0).isEmpty() && menus.size() == 1) {
            return;
        }

        for (String menu : menus) {
            if (!MenuType.isValidMenuName(menu)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_MENU_NAME);
            }
        }

    }
}
