package cads.test.junit.simulation;

import static org.junit.Assert.*;

import org.cads.ev3.middleware.CaDSEV3RobotHAL;
import org.cads.ev3.middleware.CaDSEV3RobotType;
import org.cads.ev3.middleware.hal.ICaDSEV3RobotFeedBackListener;
import org.cads.ev3.middleware.hal.ICaDSEV3RobotStatusListener;
import org.json.simple.JSONObject;
import org.junit.Test;

import lejos.utility.Delay;


public class TestProviderUpDown {
	private static CaDSEV3RobotHAL caller = null;
	private class TestListener implements Runnable, ICaDSEV3RobotStatusListener, ICaDSEV3RobotFeedBackListener {

		@Override
		public synchronized void giveFeedbackByJSonTo(JSONObject feedback) {
			System.out.println(feedback);
		}

		@Override
		public synchronized void onStatusMessage(JSONObject status) {
			System.out.println(status);

		}

		@Override
		public void run() {
			try {
				caller = CaDSEV3RobotHAL.createInstance(CaDSEV3RobotType.SIMULATION, this, this);
				boolean on = true;
				while(!Thread.currentThread().isInterrupted()){

					if(on){
						caller.stop_v();	// stops any movement
						caller.moveDown();
					}else{
						caller.stop_v();	// stops any movement
						caller.moveUp();
					}
					on = !on;
					Delay.msDelay(5100);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
			System.exit(0);
		}
	}

	@Test
	public void test() {
		try {
			TestListener l = new TestListener();
			(new Thread(l)).start();
			waithere();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	
	synchronized public void waithere() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
