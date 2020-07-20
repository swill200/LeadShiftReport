package forms;

import java.awt.List;

public class DataObject {
	protected String date;
	protected String user;
	protected String shift;
	protected boolean employee, employee1, employee2, employee3, employee4, employee5, employee6,
		employee7, employee8, employee9;
	protected String text, text1, text2, text3, text4, text5, text6, text7, text8, text9;
	protected List tableData = new List();
	protected boolean eaWaItxComplete, eaWaItxPlayoutComplete, channelLaunchComplete,
		weatherComplete, interactiveComplete, maintenanceComplete, turnerComplete, kciComplete,
		skdlComplete, mcSwitchesComplete;
	protected String takedownText, idRequestText, equipmentText, specialMonitoringText;
	protected String oncomingLead;
	protected boolean acceptedChecked, declinedChecked;
}
