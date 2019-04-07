package def;

import controller.SystemController;
import persistance.JDBCConnector;
import view.SystemGUI;
import view.SystemView;

public class Main
{
    public static void main(String[] args)
    {
        SystemView view = new SystemGUI();
        //model
        SystemController controller = new SystemController(view); //, model

        view.start(controller);

        JDBCConnector connection = new JDBCConnector("bicycleclub"); //name of the schema

        connection.connect(5432, "postgres", "1234"); //change
    }
}
