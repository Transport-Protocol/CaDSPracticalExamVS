package cads.roboticArm.simulation.philosophers;

import org.cads.vs.roboticArm.hal.ICaDSRoboticArm;
import org.cads.vs.roboticArm.hal.ICaDSRoboticArmPhilosopher;
import org.cads.vs.roboticArm.hal.simulation.CaDSPhilosopherFeedbackPrint;
import org.cads.vs.roboticArm.hal.simulation.CaDSRoboticArmPhilosopherSimulation;
import org.cads.vs.roboticArm.hal.simulation.CaDSRoboticArmPhilosopherSimulationPosition;
import org.cads.vs.roboticArm.hal.simulation.ICaDSRoboticArmPhilosopherSimulationWorkplaceGUISynchronisation;

import java.util.concurrent.TimeUnit;

/**
 * Just a class to test GUI without RMI
 * 
 * @author martin becke
 *
 */
public class TestCaDSRoboticArmSimulationPhilosophersOwnPlaces {

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        try {
            CaDSRoboticArmPhilosopherSimulation sim = new CaDSRoboticArmPhilosopherSimulation(CaDSRoboticArmPhilosopherSimulationPosition.NORTH, new TestCaDSPhilosopherFeedbackPermissionPrint());
            // Robotic Arm Control interface
            ICaDSRoboticArm simulation = sim;
            // Robotic Arm Status and Workplace action interface
            ICaDSRoboticArmPhilosopher roboticArmPhilosopher = sim;
            // Workplace Simulation GUI manipulation interface
            ICaDSRoboticArmPhilosopherSimulationWorkplaceGUISynchronisation roboticArmWorkplaceSynch = sim;

            TimeUnit.SECONDS.sleep(2);
            System.out.printf("Simulation Started\n");
            System.out.printf("Places not synchronized\n");

            roboticArmWorkplaceSynch.workplacesLeftNotSynchronized();
            roboticArmWorkplaceSynch.workplacesMidNotSynchronized();
            roboticArmWorkplaceSynch.workplacesRightNotSynchronized();

            TimeUnit.SECONDS.sleep(3);

            while (true){
                // OWN
                System.out.println("Move OWN 1 Take");
                simulation.setLeftRightPercentageTo(50);
                simulation.setUpDownPercentageTo(25);
                simulation.setBackForthPercentageTo(40);
                simulation.setOpenClosePercentageTo(0);

                while (!roboticArmPhilosopher.isHoldingResource()){
                    TimeUnit.MILLISECONDS.sleep(200);
                }

                System.out.println("Move Own 0 Put Back");
                simulation.setLeftRightPercentageTo(100);
                simulation.setUpDownPercentageTo(25);
                simulation.setBackForthPercentageTo(40);
                simulation.setOpenClosePercentageTo(100);

                while (roboticArmPhilosopher.isHoldingResource()){
                    TimeUnit.MILLISECONDS.sleep(200);
                }

                System.out.println("Move OWN 1 try to Take");
                simulation.setLeftRightPercentageTo(50);
                simulation.setUpDownPercentageTo(25);
                simulation.setBackForthPercentageTo(40);
                simulation.setOpenClosePercentageTo(0);
                TimeUnit.SECONDS.sleep(4);

                while (roboticArmPhilosopher.isHoldingResource()){
                    TimeUnit.MILLISECONDS.sleep(200);
                }

                System.out.println("Another RoboticArm tries to put down another resource at own 2.");
                System.out.println("Attempted Operation is successful? " + roboticArmPhilosopher.checkWorkplaceAndPutDownOwn2());

                System.out.println("Move Own 0 Take");
                simulation.setLeftRightPercentageTo(100);
                simulation.setUpDownPercentageTo(25);
                simulation.setBackForthPercentageTo(40);
                simulation.setOpenClosePercentageTo(0);

                while (!roboticArmPhilosopher.isHoldingResource()){
                    TimeUnit.MILLISECONDS.sleep(200);
                }

                System.out.println("Move Own 2 Put back");
                simulation.setLeftRightPercentageTo(0);
                simulation.setUpDownPercentageTo(25);
                simulation.setBackForthPercentageTo(40);
                simulation.setOpenClosePercentageTo(100);
                TimeUnit.SECONDS.sleep(4);

                while (roboticArmPhilosopher.isHoldingResource() && !roboticArmPhilosopher.workplaceUsedOwn2()){
                    TimeUnit.MILLISECONDS.sleep(200);
                }

                System.out.println("Move Own 2 Take");
                simulation.setLeftRightPercentageTo(0);
                simulation.setUpDownPercentageTo(25);
                simulation.setBackForthPercentageTo(40);
                simulation.setOpenClosePercentageTo(0);

                while (!roboticArmPhilosopher.isHoldingResource() && roboticArmPhilosopher.workplaceUsedOwn2()){
                    TimeUnit.MILLISECONDS.sleep(200);
                }

                System.out.println("Move OWN 1 Put back");
                simulation.setLeftRightPercentageTo(50);
                simulation.setUpDownPercentageTo(25);
                simulation.setBackForthPercentageTo(40);
                simulation.setOpenClosePercentageTo(100);

                while (roboticArmPhilosopher.isHoldingResource()){
                    TimeUnit.MILLISECONDS.sleep(200);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
