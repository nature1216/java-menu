package menu.controller;

import menu.domain.Coach;
import menu.service.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RecommendController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RecommendService recommendService;
    private List<Coach> coaches;

    public RecommendController(InputView inputView, OutputView outputView, RecommendService recommendService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.recommendService = recommendService;
    }

    public void run() {
        outputView.printStart();
        getInput();
        makeRecommendation();
    }

    public void getInput() {
        coaches = recommendService.getCoaches(inputView.readName());
        for(Coach coach : coaches) {
            recommendService.setDislikes(coach, inputView.readDislike(coach.getName()));
        }
    }

    public void makeRecommendation() {

    }
}
