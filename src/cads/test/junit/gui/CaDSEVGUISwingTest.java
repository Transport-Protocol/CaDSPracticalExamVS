package cads.test.junit.gui;

import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.cads.ev3.gui.CaDSGripperGUIFX;
import org.cads.ev3.gui.ICaDSGUIUpdater;
import org.cads.ev3.rmi.CaDSRMIConsumer;
import org.cads.ev3.rmi.ICADSRMIComsumer;
import org.cads.ev3.swing.CaDSGripperControlGUISwing;
import org.cads.ev3.swing.CaDSGripperGUISwing;
import org.junit.Test;

import cadSRMIInterface.IIDLCaDSEV3RMIMoveGrapper;
import cadSRMIInterface.IIDLCaDSEV3RMIMoveHorizontally;
import cadSRMIInterface.IIDLCaDSEV3RMIMoveVertical;

public class CaDSEVGUISwingTest implements IIDLCaDSEV3RMIMoveGrapper, IIDLCaDSEV3RMIMoveHorizontally,
IIDLCaDSEV3RMIMoveVertical, ICADSRMIComsumer {
	synchronized public void waithere(){
		 try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	@Test
	public void test() {


		  class SwingGUI implements Runnable {
			   CaDSEVGUISwingTest c;
			   public SwingGUI(CaDSEVGUISwingTest _c){
				   c = _c;
			   }
				@Override
				public void run() {
					try {
						new CaDSGripperGUISwing(c, c, c, c);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		  }
		  SwingUtilities.invokeLater(new SwingGUI(this));
		  waithere();
		//fail("Not yet implemented");
	}

	@Override
	public void register(ICaDSGUIUpdater observer) {
		System.out.println("New Observer");
		observer.addService("Service 1");
		observer.addService("Service 2");
		observer.setChoosenService("Service 2", -1, -1);
	}

	@Override
	public void update(String comboBoxText) {
		// called if Combobox is updated
		System.out.println("Combo Box updated " + comboBoxText);
	}

	@Override
	public void moveVerticalToDegree(int tid, int percent) throws Exception {
		System.out.println("Call to move vertical -  TID: " + tid +  " percentage " + percent);

	}

	@Override
	public void moveMoveHorizontallyToDegree(int tid, int percent) throws Exception {
		System.out.println("Call to move horizontally -  TID: " + tid +  " percentage " + percent);

	}

	@Override
	public void stop(int arg0) throws Exception {
		System.out.println("Stop movement....");
	}

	@Override
	public void grap(int arg0) throws Exception {
		System.out.println("Grap....");

	}

	@Override
	public void release(int arg0) throws Exception {
		System.out.println("Release....");
	}

}
