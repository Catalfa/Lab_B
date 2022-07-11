package ClientCV.CentriVaccinali.Controller;

import ClientCV.CentriVaccinali.View.HomePageView;
import ClientCV.CentriVaccinali.View.MainLoginFrameView;

public class HomePageController {
    
    HomePageView homePageView;

    public HomePageController(HomePageView homePageView){
        this.homePageView = homePageView;
    }

    public void createLoginFrame(){
        MainLoginFrameView f = new MainLoginFrameView();
        f.setVisible(true);
        homePageView.dispose();
    }
}
