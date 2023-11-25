package menu.controller;

import menu.domain.Coach;
import menu.service.RecommendService;
import menu.validator.Validator;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class RecommendController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RecommendService recommendService;
    private List<Coach> coaches;
    private List<Integer> categoryNums;

    public RecommendController(InputView inputView, OutputView outputView, RecommendService recommendService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.recommendService = recommendService;
        this.categoryNums = recommendService.pickCategories();
    }

    public void run() {
        outputView.printStart();

        getInput();
        makeRecommendation();
        getResult();

        outputView.printFinish();
    }

    public void getInput() {
        getNameInput();
        getMenuInput();
    }

    private void getNameInput() {
        try {
            String names = inputView.readName();
            Validator.validateName(names);
            coaches = recommendService.getCoaches(names);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            getNameInput();
        }
    }

    private void getMenuInput() {
        try {
            for(Coach coach : coaches) {
                recommendService.setDislikes(coach, inputView.readDislike(coach.getName()));
            }
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            getMenuInput();
        }
    }

    public void makeRecommendation() {
        recommendService.recommend(coaches, categoryNums);
    }

    public void getResult() {
        List<String> categoryNames = recommendService.getCategoryNames(categoryNums);
        outputView.printResult(coaches, categoryNames);
    }
}
