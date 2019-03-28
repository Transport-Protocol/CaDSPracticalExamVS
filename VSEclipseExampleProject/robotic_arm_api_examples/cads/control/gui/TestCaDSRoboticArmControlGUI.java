package cads.control.gui;

import org.cads.vs.roboticArm.gui.CaDSRoboticArmControlGUI;
import org.cads.vs.roboticArm.gui.ICaDSRoboticArmControlGUIManipulator;
import org.cads.vs.roboticArm.gui.ICaDSRoboticArmControlGUIOutput;
import org.cads.vs.roboticArm.gui.ICaDSRoboticArmControlGUIRefresh;

public class TestCaDSRoboticArmControlGUI implements ICaDSRoboticArmControlGUIRefresh, ICaDSRoboticArmControlGUIOutput{

    public static void main(String... strings) {
        TestCaDSRoboticArmControlGUI test = new TestCaDSRoboticArmControlGUI();
        ICaDSRoboticArmControlGUIManipulator gui = new CaDSRoboticArmControlGUI(test, test);

        gui.addRoboticArmService("Test1");
        gui.addRoboticArmService("Test2");

        gui.startGUIRefresh(1000);
        //gui.stopGUIRefresh();
    }

    private int currentValueCounter = 0;

    private synchronized int getCurrentValueCounterAndIncrement() {
        if (currentValueCounter > 100 || currentValueCounter < 0) {
            currentValueCounter = 0;
        }

        return currentValueCounter++;
    }

    ////////////////////////////////////////////// Control Input provided by the Control GUI
    @Override
    public void newBackForthPercentage(int percentage) {
        System.out.println("Newly set value in GUI forwarded to the consumer - newBackForthPercentage: percentage: " + percentage);
    }


    @Override
    public void newGripperPercentage(int percentage) {
        System.out.println("Newly set value in GUI forwarded to the consumer - newGripperPercentage: percentage: " + percentage);
    }


    @Override
    public void newLeftRightPercentage(int percentage) {
        System.out.println("Newly set value in GUI forwarded to the consumer - newLeftRightPercentage: percentage: " + percentage);
    }


    @Override
    public void newUpDownPercentage(int percentage) {
        System.out.println("Newly set value in GUI forwarded to the consumer - newUpDownPercentage: percentage: " + percentage);
    }

    @Override
    public void update(String comboBoxText) {
        System.out.println("Combo Box updated " + comboBoxText);
    }

    //////////////////////////////////////////////// For GUI Refresh Routine
    //////////////////////////////////////////////// Only needed if a GUI refresh is wanted
    // The values that are provided here have to be between: [0 - 100]
    @Override
    public int getCurrentBackForthPercentage() {
    	// The value that is returned here is shown in the GUI to display the current status of a specific dimension of the robotic arm 
        return getCurrentValueCounterAndIncrement();
    }

    @Override
    public int getCurrentGripperPercentage() {
    	// The value that is returned here is shown in the GUI to display the current status of a specific dimension of the robotic arm 
        return getCurrentValueCounterAndIncrement();
    }


    @Override
    public int getCurrentLeftRightPercentage() {
    	// The value that is returned here is shown in the GUI to display the current status of a specific dimension of the robotic arm 
        return getCurrentValueCounterAndIncrement();
    }


    @Override
    public int getCurrentUpDownPercentage() {
    	// The value that is returned here is shown in the GUI to display the current status of a specific dimension of the robotic arm 
        return getCurrentValueCounterAndIncrement();
    }
}
