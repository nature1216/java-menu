package menu;

import menu.config.AppConfig;
import menu.controller.RecommendController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        RecommendController recommendController = appConfig.recommendController();
        recommendController.run();
    }
}
