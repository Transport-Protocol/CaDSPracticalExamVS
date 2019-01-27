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
public class TestCaDSRoboticArmSimulation {
    static int sum = 0;
    private static ICaDSRoboticArm simulation;

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        try {
            simulation = new CaDSRoboticArmSimulation();

            TimeUnit.SECONDS.sleep(4);
            System.out.printf("Simulation Started\n");

            while (true){
                System.out.println("Move everything to 100%");
                System.out.println();
                simulation.setLeftRightPercentageTo(191,100);
                TimeUnit.SECONDS.sleep(1);
                simulation.setUpDownPercentageTo(192,100);
                TimeUnit.SECONDS.sleep(1);
                simulation.setBackForthPercentageTo(193, 100);
                TimeUnit.SECONDS.sleep(1);
                simulation.setOpenClosePercentageTo(194, 100);

                TimeUnit.SECONDS.sleep(6);

                System.out.println("Move everything to 0%");
                System.out.println();
                simulation.setLeftRightPercentageTo(201,0);
                TimeUnit.SECONDS.sleep(1);
                simulation.setUpDownPercentageTo(202,0);
                TimeUnit.SECONDS.sleep(1);
                simulation.setBackForthPercentageTo(203, 0);
                TimeUnit.SECONDS.sleep(1);
                simulation.setOpenClosePercentageTo(204, 0);

                TimeUnit.SECONDS.sleep(6);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
