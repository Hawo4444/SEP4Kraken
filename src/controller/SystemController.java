package controller;

import view.SystemView;

public class SystemController
{
    private SystemView viewInterface;
    //model interface as var

    public SystemController(SystemView viewInterface) //,model
    {
        this.viewInterface = viewInterface;
    }

    public void retrieveThermalDates() //has the same name as the method it calls
    {
        System.out.println(viewInterface.retrieveThermalDates()[0] + viewInterface.retrieveThermalDates()[1]);
    }

    public void retrievePVDates()
    {
        System.out.println(viewInterface.retrievePVDates()[0] + viewInterface.retrievePVDates()[1]);
    }

    public void executeGetPredictionData()
    {
        System.out.println("Prediction");
    }
}
