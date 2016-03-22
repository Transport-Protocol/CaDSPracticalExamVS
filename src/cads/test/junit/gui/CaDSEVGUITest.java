package cads.test.junit.gui;

import org.cads.ev3.gui.CaDSGripperGUIFX;
import org.cads.ev3.gui.ICaDSGUIUpdater;
import org.cads.ev3.rmi.ICADSRMIComsumer;
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
	public void moveVerticalToPercent(int tid, int percent) throws Exception {
		System.out.println("Call to move vertical -  TID: " + tid +  " degree " + percent);
		
	}

	@Override
	public void moveMoveHorizontallyToPercent(int tid, int percent) throws Exception {
		System.out.println("Call to move horizontally -  TID: " + tid +  " degree " + percent);
		
	}

	@Override
	public void stop(int i) throws Exception {
		System.out.println("Stop movement....");
	}

	@Override
	public void closeIT(int i) throws Exception {
		System.out.println("Close....");

	}

	@Override
	public void openIT(int i) throws Exception {
		System.out.println("Open....");
	}

}
