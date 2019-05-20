package cads.roboticArm.simulation;

import org.cads.vs.roboticArm.hal.ICaDSRoboticArm;
import org.cads.vs.roboticArm.hal.simulation.CaDSRoboticArmSimulation;

import java.util.concurrent.TimeUnit;

/**
 * Just a class to test GUI without RMI
 * 
 * @author martin becke
 *
 */
public class TestCaDSRoboticArmSimulationStartAndTeardown {
    static int sum = 0;
    private static ICaDSRoboticArm simulation;

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        try {
            simulation = new CaDSRoboticArmSimulation();

            TimeUnit.SECONDS.sleep(4);
            System.out.printf("Simulation Started\n");

            simulation.teardown();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
