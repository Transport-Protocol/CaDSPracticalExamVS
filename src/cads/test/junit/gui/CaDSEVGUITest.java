package cads.test.junit.gui;

import org.cads.ev3.gui.CaDSGripperGUIFX;
import org.cads.ev3.gui.ICaDSGUIUpdater;
import org.cads.ev3.rmi.ICADSRMIComsumer;
import org.cads.ev3.swing.CaDSGripperControlGUISwing;
import org.cads.ev3.swing.CaDSGripperGUISwing;
import org.junit.Test;

import cadSRMIInterface.IIDLCaDSEV3RMIMoveGrapper;
import cadSRMIInterface.IIDLCaDSEV3RMIMoveHorizontally;
import cadSRMIInterface.IIDLCaDSEV3RMIMoveVertical;

public class CaDSEVGUITest implements IIDLCaDSEV3RMIMoveGrapper, IIDLCaDSEV3RMIMoveHorizontally,
IIDLCaDSEV3RMIMoveVertical, ICADSRMIComsumer {

	@Test
	public void test() {
		CaDSGripperGUIFX.startGUI(this, this, this, this);
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
