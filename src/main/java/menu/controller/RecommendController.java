package menu.controller;

import menu.service.RecommendService;
import menu.view.InputView;

public class RecommendController {
    private final InputView inputView;
    private final RecommendService recommendService;

    public RecommendController(InputView inputView, RecommendService recommendService) {
        this.inputView = inputView;
        this.recommendService = recommendService;
    }

    public void run() {
        getInput();
    }

    public void getInput() {
        String names = inputView.readName();
        System.out.println(names);
    }
}
