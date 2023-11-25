package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coach {
    private String name;
    private List<String> dislikes;
    private List<String> recommendations;

    public Coach(String name) {
        this.name = name;
        this.dislikes = new ArrayList<>();
        this.recommendations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDislike(List<String> menus) {
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

    public int countCategory(int category) {
        int count = 0;
        for (String menu : recommendations) {
            if (MenuType.getCategoryNumByMenu(menu) == category) {
                count++;
            }
        }
        return count;
    }

    public void print() {
        System.out.println(name + recommendations);
    }
}
