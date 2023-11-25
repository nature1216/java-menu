package menu.domain;

import java.util.ArrayList;
import java.util.List;

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
        for(String menu : menus) {
            dislikes.add(menu);
        }
    }

    public boolean exist(String menu) {
        return recommendations.contains(menu);
    }

    public int countRecommendations() {
        return recommendations.size();
    }

    public void addRecommendations(String menu) {
        recommendations.add(menu);
    }
}
