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
	public void register(ICaDSGUIUpdater arg0) {
		System.out.println("New Observer");
		arg0.addService("Service 1");
		arg0.addService("Service 2");
		arg0.setChoosenService("Service 2", -1, -1);
	}

	@Override
	public void update(String arg0) {
		// called if Combobox is updated 
		System.out.println("Combo Box updated " + arg0);
	}

	@Override
	public void moveVerticalToDegree(int arg0, int arg1) throws Exception {
		System.out.println("Call to move vertical -  TID: " + arg0 +  " degree " + arg1);
		
	}

	@Override
	public void moveMoveHorizontallyToDegree(int arg0, int arg1) throws Exception {
		System.out.println("Call to move horizontally -  TID: " + arg0 +  " degree " + arg1);
		
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
