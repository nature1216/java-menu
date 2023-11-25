package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> dislikes;
    public Coach(String name) {
        this.name = name;
        this.dislikes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDislike(List<String> menus) {
        for(String menu : menus) {
            dislikes.add(menu);
        }
    }
}
