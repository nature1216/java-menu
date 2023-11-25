package menu.controller;

import menu.domain.Coach;
import menu.service.RecommendService;
import menu.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RecommendController {
    private final InputView inputView;
    private final RecommendService recommendService;
    private List<Coach> coaches;

    public RecommendController(InputView inputView, RecommendService recommendService) {
        this.inputView = inputView;
        this.recommendService = recommendService;
    }

    public void run() {
        getInput();
    }

    public void getInput() {
        String names = inputView.readName();
        coaches = recommendService.getCoaches(names);
    }
}
