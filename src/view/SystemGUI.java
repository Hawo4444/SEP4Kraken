package view;

import controller.SystemController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class SystemGUI extends Application implements SystemView
{
    public static SystemGUI me;

    private Stage primaryStage;
    private ViewControllerSystem viewController;
    private SystemController controller;

    public SystemGUI()
    {
        if(me == null) me = this;
    }

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        if(this != me)
        {
            me.start(primaryStage);
            return;
        }

        this.primaryStage = primaryStage;
        this.viewController = new ViewControllerSystem(this);
        primaryStage.setScene(viewController.getScene());
        primaryStage.show();
    }


    public void start(SystemController controller) //needed in main method
    {
        this.controller = controller;

        new Thread(new Runnable() {
            @Override
            public void run() {
                Application.launch(SystemGUI.class);
            }
        }).start();
    }

    @Override
    public String[] retrieveThermalDates()
    {
        return viewController.retrieveThermalDates();
    }

    @Override
    public String[] retrievePVDates()
    {
        return viewController.retrievePVDates();
    }

    public SystemController getController()
    {
        return controller;
    }
}
