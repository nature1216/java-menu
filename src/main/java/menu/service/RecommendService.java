package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.domain.MenuType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecommendService {
    public List<Coach> getCoaches(String names) {
        List<String> nameList = List.of(names.split(","));
        List<Coach> coaches = new ArrayList<>();
        for(String name : nameList) {
            coaches.add(new Coach(name));
        }
        return coaches;
    }

    public void setDislikes(Coach coach, String dislikes) {
        List<String> dislike = List.of(dislikes.split(","));
        coach.addDislike(dislike);
    }

    public void recommend(List<Coach> coaches) {
        List<Integer> categories = new ArrayList<>();
        while(categories.size() < 5) {
            int category = Randoms.pickNumberInRange(1, 5);
            if(Collections.frequency(categories, category) > 2) {
                continue;
            }
            categories.add(category);
        }
        System.out.print(categories);
        for(Coach coach : coaches) {
            int index = 0;
            while(coach.countRecommendations() < 5) {
                int category = categories.get(index);
                List<String> menuByCategory = MenuType.getMenusByCategory(category);
                String menu = Randoms.shuffle(menuByCategory).get(0);
                System.out.println(menu);
                if(coach.exist(menu)) {
                    continue;
                }
                coach.addRecommendations(menu);
                index++;
            }
            coach.print();
        }
    }
}
