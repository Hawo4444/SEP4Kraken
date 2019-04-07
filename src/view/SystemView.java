package view;

import controller.SystemController;

public interface SystemView
{
    public void start(SystemController controller);

    public String[] retrieveThermalDates();

    public String[] retrievePVDates();
}
