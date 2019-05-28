package cads.roboticArm.simulation.philosophers;

import org.cads.vs.roboticArm.hal.simulation.ICaDSRoboticArmPhilosopherWorkplaceSynchRequests;

import java.util.concurrent.TimeUnit;

public class TestCaDSPhilosopherFeedbackPermissionPrint implements ICaDSRoboticArmPhilosopherWorkplaceSynchRequests {

    @Override
    public boolean workplaceLeft1PickUp() {
        System.out.println("");
        System.out.println("TestCaDSPhilosopherFeedbackPermissionPrint");
        System.out.println("workplaceLeft1PickUp");
        System.out.println("Give permission for operation by return: true.");
        System.out.println("Has to be synchronized!");
        return true;
    }

    @Override
    public boolean workplaceLeft1PutDown() {
        System.out.println("");
        System.out.println("TestCaDSPhilosopherFeedbackPermissionPrint");
        System.out.println("workplaceLeft1PutDown");
        System.out.println("Give permission for operation by return: true.");
        System.out.println("Has to be synchronized!");
        return true;
    }

    @Override
    public boolean workplaceLeft2PickUp() {
        System.out.println("");
        System.out.println("TestCaDSPhilosopherFeedbackPermissionPrint");
        System.out.println("workplaceLeft2PickUp");
        System.out.println("Give permission for operation by return: true.");
        System.out.println("Has to be synchronized!");
        return true;
    }

    @Override
    public boolean workplaceLeft2PutDown() {
        System.out.println("");
        System.out.println("TestCaDSPhilosopherFeedbackPermissionPrint");
        System.out.println("workplaceLeft2PutDown");
        System.out.println("Give permission for operation by return: true.");
        System.out.println("Has to be synchronized!");
        return true;
    }

    @Override
    public boolean workplaceMid1PickUp() {
        System.out.println("");
        System.out.println("TestCaDSPhilosopherFeedbackPermissionPrint");
        System.out.println("workplaceMid1PickUp");
        System.out.println("Give permission for operation by return: true.");
        System.out.println("Has to be synchronized!");
        return true;
    }

    @Override
    public boolean workplaceMid1PutDown() {
        System.out.println("");
        System.out.println("TestCaDSPhilosopherFeedbackPermissionPrint");
        System.out.println("workplaceMid1PutDown");
        System.out.println("Give permission for operation by return: true.");
        System.out.println("Has to be synchronized!");
        return true;
    }

    @Override
    public boolean workplaceRight0PickUp() {
        System.out.println("");
        System.out.println("TestCaDSPhilosopherFeedbackPermissionPrint");
        System.out.println("workplaceRight0PickUp");
        System.out.println("Give permission for operation by return: true.");
        System.out.println("Has to be synchronized!");
        return true;
    }

    @Override
    public boolean workplaceRight0PutDown() {
        System.out.println("");
        System.out.println("TestCaDSPhilosopherFeedbackPermissionPrint");
        System.out.println("workplaceRight0PutDown");
        System.out.println("Give permission for operation by return: true.");
        System.out.println("Has to be synchronized!");
        return true;
    }

    @Override
    public boolean workplaceRight1PickUp() {
        System.out.println("");
        System.out.println("TestCaDSPhilosopherFeedbackPermissionPrint");
        System.out.println("workplaceRight1PickUp");
        System.out.println("Give permission for operation by return: true.");
        System.out.println("Has to be synchronized!");
        return true;
    }

    @Override
    public boolean workplaceRight1PutDown() {
        System.out.println("");
        System.out.println("TestCaDSPhilosopherFeedbackPermissionPrint");
        System.out.println("workplaceRight1PutDown");
        System.out.println("Give permission for operation by return: true.");
        System.out.println("Has to be synchronized!");
        return true;
    }
}
