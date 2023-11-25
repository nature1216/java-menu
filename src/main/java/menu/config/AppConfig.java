package menu.config;

import menu.controller.RecommendController;
import menu.service.RecommendService;
import menu.view.InputView;

public class AppConfig {
    public RecommendController recommendController() {
        return new RecommendController(inputView(), recommendService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private RecommendService recommendService() {
        return new RecommendService();
    }
}
