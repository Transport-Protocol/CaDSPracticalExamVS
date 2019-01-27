package cads.control.gui;

import org.cads.vs.roboticArm.gui.CaDSRoboticArmControlGUI;
import org.cads.vs.roboticArm.gui.ICaDSRoboticArmControlGUIManipulator;
import org.cads.vs.roboticArm.gui.ICaDSRoboticArmControlGUIOutput;
import org.cads.vs.roboticArm.gui.ICaDSRoboticArmControlGUIRefresh;

public class TestCaDSRoboticArmControlGUI implements ICaDSRoboticArmControlGUIRefresh, ICaDSRoboticArmControlGUIOutput{

    public static void main(String... strings) {
        TestCaDSRoboticArmControlGUI test = new TestCaDSRoboticArmControlGUI();
        ICaDSRoboticArmControlGUIManipulator gui = new CaDSRoboticArmControlGUI(test, test);

        gui.addService("Test1");
        gui.addService("Test2");

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
    public int setNewBackForthPercentage(int transactionID, int percentage) {
        System.out.println("Newly set value in GUI forwarded to the consumer - setNewBackForthPercentage: transactionID: " + transactionID + " , percentage: " + percentage);
        return percentage;
    }


    @Override
    public int setNewGripperPercentage(int transactionID, int percentage) {
        System.out.println("Newly set value in GUI forwarded to the consumer - setNewGripperPercentage: transactionID: " + transactionID + " , percentage: " + percentage);
        return percentage;
    }


    @Override
    public int setNewLeftRightPercentage(int transactionID, int percentage) {
        System.out.println("Newly set value in GUI forwarded to the consumer - setNewLeftRightPercentage: transactionID: " + transactionID + " , percentage: " + percentage);
        return percentage;
    }


    @Override
    public int setNewUpDownPercentage(int transactionID, int percentage) {
        System.out.println("Newly set value in GUI forwarded to the consumer - setNewUpDownPercentage: transactionID: " + transactionID + " , percentage: " + percentage);
        return percentage;
    }

    @Override
    public void update(String comboBoxText) {
        System.out.println("Combo Box updated " + comboBoxText);
    }

    //////////////////////////////////////////////// For GUI Refresh Routine
    //////////////////////////////////////////////// Only needed if a GUI refresh is wanted
    @Override
    public int getCurrentBackForthPercentage() {
        return getCurrentValueCounterAndIncrement();
    }


    @Override
    public int getCurrentGripperPercentage() {
        return getCurrentValueCounterAndIncrement();
    }


    @Override
    public int getCurrentLeftRightPercentage() {
        return getCurrentValueCounterAndIncrement();
    }


    @Override
    public int getCurrentUpDownPercentage() {
        return getCurrentValueCounterAndIncrement();
    }
}
