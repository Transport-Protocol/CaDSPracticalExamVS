package cads.roboticArm.real;

import org.cads.vs.roboticArm.hal.ICaDSRoboticArm;
import org.cads.vs.roboticArm.hal.real.CaDSRoboticArmReal;
import java.util.concurrent.TimeUnit;

/**
 * Created by habu on 21.01.19.
 */
public class TestCaDSRoboticArmReal {
    static int sum = 0;
    private static ICaDSRoboticArm real;

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        try {
        	// TODO Enter the correct Address and Port to access the right robot
            real = new CaDSRoboticArmReal("127.0.0.1", 50051);

            TimeUnit.SECONDS.sleep(3);
            System.out.printf("Simulation Started\n");

            while (true){
                System.out.println("Move everything to 100%");
                System.out.println();
                real.setLeftRightPercentageTo(100);
                TimeUnit.SECONDS.sleep(1);
                real.setUpDownPercentageTo(100);
                TimeUnit.SECONDS.sleep(1);
                real.setBackForthPercentageTo(100);
                TimeUnit.SECONDS.sleep(1);
                real.setOpenClosePercentageTo(100);

                TimeUnit.SECONDS.sleep(6);

                System.out.println("Move everything to 0%");
                System.out.println();
                real.setLeftRightPercentageTo(0);
                TimeUnit.SECONDS.sleep(1);
                real.setUpDownPercentageTo(0);
                TimeUnit.SECONDS.sleep(1);
                real.setBackForthPercentageTo(0);
                TimeUnit.SECONDS.sleep(1);
                real.setOpenClosePercentageTo(0);

                TimeUnit.SECONDS.sleep(6);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

