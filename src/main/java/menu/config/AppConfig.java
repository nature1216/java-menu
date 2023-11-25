package menu.config;

import menu.controller.RecommendController;
import menu.service.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

public class AppConfig {
    public RecommendController recommendController() {
        return new RecommendController(inputView(), outputView(), recommendService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private RecommendService recommendService() {
        return new RecommendService();
    }
}
