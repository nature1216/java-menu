package menu.service;

import menu.domain.Coach;

import java.util.ArrayList;
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
}
