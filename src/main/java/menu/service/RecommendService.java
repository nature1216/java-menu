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
        List<Integer> categories = pickCategories();
        for(Coach coach : coaches) {
            recommendByCoach(coach, categories);
            coach.print();
        }
    }

    public void recommendByCoach(Coach coach, List<Integer> categories) {
        int index = 0;
        while(coach.countRecommendations() < 5) {
            List<String> menuByCategory = MenuType.getMenusByCategory(categories.get(index));
            String menu = Randoms.shuffle(menuByCategory).get(0);

            if(coach.exist(menu) || coach.isDislike(menu)) {
                continue;
            }

            coach.addRecommendations(menu);
            index++;
        }
    }

    public List<Integer> pickCategories() {
        List<Integer> categories = new ArrayList<>();
        while(categories.size() < 5) {
            int category = Randoms.pickNumberInRange(1, 5);
            if(Collections.frequency(categories, category) >= 2) {
                continue;
            }
            categories.add(category);
        }
        System.out.print(categories);
        return categories;
    }
}
