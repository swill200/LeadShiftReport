package forms;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.*;
import org.eclipse.wb.swt.SWTResourceManager;

import main.Code;

public class PreviousReports extends Shell {
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text text, text1, text2, text3, text4, text5, text6, text7, text8, text9;
	private Text textTakedowns, textIdRequests, textEquipment, textMonitoring, txtName, txtDate, txtShift,
			txtOncominglead;
	private static String time, shift;
	protected String[] empArray;
	public Button btnEmployee, btnEmployee_1, btnEmployee_2, btnEmployee_3, btnEmployee_4, btnEmployee_5, btnEmployee_6,
			btnEmployee_7, btnEmployee_8, btnEmployee_9;
	protected boolean[] buttonValues = new boolean[10];

	public PreviousReports(Display display, LocalDate date, String shift)
			throws IllegalArgumentException, IllegalAccessException {
		super(display, SWT.SHELL_TRIM);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginBottom = 25;
		gridLayout.marginRight = 25;
		gridLayout.marginTop = 25;
		gridLayout.marginLeft = 30;
		setLayout(gridLayout);

		setShift(shift);
		try {
			empArray = Code.checkShift(shift);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setTime((date.getMonthValue()) + "/" + date.getDayOfMonth() + "/" + date.getYear());
		DataObject obj = new DataObject();
		try {
			getPassdownData(obj);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if(obj.date == null) {
			System.out.println(obj.date);
			this.close();
		}
		
		ScrolledForm scrldfrmCheyenneTocLead = formToolkit.createScrolledForm(this);
		GridData gd_scrldfrmCheyenneTocLead = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_scrldfrmCheyenneTocLead.widthHint = 1200;
		gd_scrldfrmCheyenneTocLead.heightHint = 600;
		scrldfrmCheyenneTocLead.setLayoutData(gd_scrldfrmCheyenneTocLead);
		formToolkit.paintBordersFor(scrldfrmCheyenneTocLead);
		scrldfrmCheyenneTocLead.setText("Cheyenne TOC Lead Tech Shift Report");

		Composite composite = formToolkit.createComposite(scrldfrmCheyenneTocLead.getBody(), SWT.NONE);
		composite.setBounds(10, 10, 697, 564);
		formToolkit.paintBordersFor(composite);

		Group grpStaff = new Group(composite, SWT.NONE);
		grpStaff.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		grpStaff.setText("Shift Staff and Assignments");
		grpStaff.setBounds(10, 10, 330, 260);
		formToolkit.adapt(grpStaff);
		formToolkit.paintBordersFor(grpStaff);

		btnEmployee = new Button(grpStaff, SWT.CHECK);
		btnEmployee.setBounds(10, 20, 150, 16);
		formToolkit.adapt(btnEmployee, true, true);
		btnEmployee.setText(empArray[0]);
		btnEmployee.setSelection(obj.employee);
		btnEmployee.setEnabled(false);

		btnEmployee_1 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_1.setBounds(10, 40, 150, 16);
		formToolkit.adapt(btnEmployee_1, true, true);
		btnEmployee_1.setText(empArray[1]);
		btnEmployee_1.setSelection(obj.employee1);
		btnEmployee_1.setEnabled(false);

		btnEmployee_2 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_2.setBounds(10, 60, 150, 16);
		formToolkit.adapt(btnEmployee_2, true, true);
		btnEmployee_2.setText(empArray[2]);
		btnEmployee_2.setSelection(obj.employee2);
		btnEmployee_2.setEnabled(false);

		btnEmployee_3 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_3.setBounds(10, 80, 150, 16);
		formToolkit.adapt(btnEmployee_3, true, true);
		btnEmployee_3.setText(empArray[3]);
		btnEmployee_3.setSelection(obj.employee3);
		btnEmployee_3.setEnabled(false);

		btnEmployee_4 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_4.setBounds(10, 100, 150, 16);
		formToolkit.adapt(btnEmployee_4, true, true);
		btnEmployee_4.setText(empArray[4]);
		btnEmployee_4.setSelection(obj.employee4);
		btnEmployee_4.setEnabled(false);

		btnEmployee_5 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_5.setBounds(10, 120, 150, 16);
		formToolkit.adapt(btnEmployee_5, true, true);
		btnEmployee_5.setText(empArray[5]);
		btnEmployee_5.setSelection(obj.employee5);
		btnEmployee_5.setEnabled(false);

		btnEmployee_6 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_6.setBounds(10, 140, 150, 16);
		formToolkit.adapt(btnEmployee_6, true, true);
		btnEmployee_6.setText(empArray[6]);
		btnEmployee_6.setSelection(obj.employee6);
		btnEmployee_6.setEnabled(false);

		btnEmployee_7 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_7.setBounds(10, 160, 150, 16);
		formToolkit.adapt(btnEmployee_7, true, true);
		btnEmployee_7.setText(empArray[7]);
		btnEmployee_7.setSelection(obj.employee7);
		btnEmployee_7.setEnabled(false);

		btnEmployee_8 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_8.setBounds(10, 180, 150, 16);
		formToolkit.adapt(btnEmployee_8, true, true);
		btnEmployee_8.setText(empArray[8]);
		btnEmployee_8.setSelection(obj.employee8);
		btnEmployee_8.setEnabled(false);

		btnEmployee_9 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_9.setBounds(10, 200, 150, 16);
		formToolkit.adapt(btnEmployee_9, true, true);
		btnEmployee_9.setText(empArray[9]);
		btnEmployee_9.setSelection(obj.employee9);
		btnEmployee_9.setEnabled(false);

		text = formToolkit.createText(grpStaff, "", SWT.NONE);
		text.setText(obj.text);
		text.setBounds(180, 20, 140, 18);
		text.setEditable(false);

		text1 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text1.setText(obj.text1);
		text1.setBounds(180, 40, 140, 18);
		text1.setEditable(false);

		text2 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text2.setText(obj.text2);
		text2.setBounds(180, 60, 140, 18);
		text2.setEditable(false);

		text3 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text3.setText(obj.text3);
		text3.setBounds(180, 80, 140, 18);
		text3.setEditable(false);

		text4 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text4.setText(obj.text4);
		text4.setBounds(180, 100, 140, 18);
		text4.setEditable(false);

		text5 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text5.setText(obj.text5);
		text5.setBounds(180, 120, 140, 18);
		text5.setEditable(false);

		text6 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text6.setText(obj.text6);
		text6.setBounds(180, 140, 140, 18);
		text6.setEditable(false);

		text7 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text7.setText(obj.text7);
		text7.setBounds(180, 160, 140, 18);
		text7.setEditable(false);

		text8 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text8.setText(obj.text8);
		text8.setBounds(180, 180, 140, 18);
		text8.setEditable(false);

		text9 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text9.setText(obj.text9);
		text9.setBounds(180, 200, 140, 18);
		text9.setEditable(false);

		Label lblSelectNormalStaff = formToolkit.createLabel(grpStaff,
				"Select normal staff for the shift and where they were assigned for the" + " shift.", SWT.WRAP);
		lblSelectNormalStaff.setLocation(10, 222);
		lblSelectNormalStaff.setSize(310, 30);

		Group grpOngoingOutagesAnd = new Group(composite, SWT.NONE);
		grpOngoingOutagesAnd.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		grpOngoingOutagesAnd.setText("Ongoing Outages and Maintenance");
		grpOngoingOutagesAnd.setBounds(357, 10, 330, 260);
		formToolkit.adapt(grpOngoingOutagesAnd);
		formToolkit.paintBordersFor(grpOngoingOutagesAnd);

		Label lblTicketNumbersAnd = formToolkit.createLabel(grpOngoingOutagesAnd,
				"Ticket numbers and description of any ongoing outages and/or" + " maintenance.", SWT.NONE | SWT.WRAP);
		lblTicketNumbersAnd.setBounds(10, 220, 310, 30);

		Table table = new Table(grpOngoingOutagesAnd, SWT.MULTI | SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
		table.setBounds(10, 22, 310, 192);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		final GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		table.setLayoutData(gd);

		TableColumn col1 = new TableColumn(table, SWT.CENTER);
		col1.setResizable(false);
		col1.setWidth(147);
		col1.setText("Service");
		TableColumn col2 = new TableColumn(table, SWT.CENTER);
		col2.setWidth(146);
		col2.setResizable(false);
		col2.setText("ELVIS Ticket #");
		Color gray = display.getSystemColor(SWT.COLOR_GRAY);
		int count = 0;
		for (int i = 0; i < 22; i += 2) {
			count++;
			TableItem item = new TableItem(table, SWT.BORDER_SOLID);
			item.setText(0, obj.tableData.getItem(i));
			item.setText(1, obj.tableData.getItem(i + 1));
			if (count % 2 == 0) {
				item.setBackground(gray);
			}
		}
//
//		final TableEditor editor = new TableEditor(table);
//		editor.horizontalAlignment = SWT.LEFT;
//		editor.grabHorizontal = true;
//		editor.minimumWidth = 50;
//		table.addListener(SWT.MouseDown, new Listener() {
//			public void handleEvent(Event event) {
//				Rectangle clientArea = table.getClientArea();
//				Point pt = new Point(event.x, event.y);
//				int index = table.getTopIndex();
//				while (index < table.getItemCount()) {
//					boolean visible = false;
//					final TableItem item = table.getItem(index);
//					for (int i = 0; i < table.getColumnCount(); i++) {
//						Rectangle rectangle = item.getBounds(i);
//						if (rectangle.contains(pt)) {
//							final int column = i;
//							final Text text = new Text(table, SWT.NONE);
//							Listener textListener = new Listener() {
//								public void handleEvent(final Event e) {
//									switch (e.type) {
//									case SWT.FocusOut:
//										item.setText(column, text.getText());
//										text.dispose();
//										break;
//									case SWT.Traverse:
//										switch (e.detail) {
//										case SWT.TRAVERSE_RETURN:
//											item.setText(column, text.getText());
//										case SWT.TRAVERSE_ESCAPE:
//											text.dispose();
//											e.doit = false;
//										}
//										break;
//									}
//								}
//							};
//							text.addListener(SWT.FocusOut, textListener);
//							text.addListener(SWT.Traverse, textListener);
//							editor.setEditor(text, item, i);
//							text.setText(item.getText(i));
//							text.selectAll();
//							text.setFocus();
//							return;
//						}
//						if (!visible && rectangle.intersects(clientArea)) {
//							visible = true;
//						}
//					}
//					if (!visible) {
//						return;
//					}
//					index++;
//				}
//			}
//		});

//		table.addSelectionListener(widgetSelectedAdapter(e -> {
//			// Clean up any previous editor control
//			Control oldEditor = editor.getEditor();
//			if (oldEditor != null)
//				oldEditor.dispose();
//
//			// Identify the selected row
//			TableItem item = (TableItem) e.item;
//			if (item == null)
//				return;
//
//			// The control that will be the editor must be a child of the Table
//			Text newEditor = new Text(table, SWT.NONE);
//			newEditor.setText(item.getText(0));
//			newEditor.addModifyListener(me -> {
//				Text text = (Text) editor.getEditor();
//				editor.getItem().setText(0, text.getText());
//			});
//			newEditor.selectAll();
//			newEditor.setFocus();
//			editor.setEditor(newEditor, item, 0);
//			
//			Text newEditor2 = new Text(table, SWT.NONE);
//			newEditor2.setText(item.getText(1));
//			newEditor2.addModifyListener(me -> {
//				Text text = (Text) editor.getEditor();
//				editor.getItem().setText(0, text.getText());
//			});
//			newEditor2.selectAll();
//			newEditor2.setFocus();
//			editor.setEditor(newEditor2, item, 1);
//		}));

		Group grpRequestsFromOther = new Group(composite, SWT.NONE);
		grpRequestsFromOther.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		grpRequestsFromOther.setText("Requests from other departments");
		grpRequestsFromOther.setBounds(357, 276, 330, 136);
		formToolkit.adapt(grpRequestsFromOther);
		formToolkit.paintBordersFor(grpRequestsFromOther);

		textIdRequests = formToolkit.createText(grpRequestsFromOther, "New Text", SWT.NONE);
		textIdRequests.setText(obj.idRequestText);
		textIdRequests.setBounds(10, 22, 310, 75);
		textIdRequests.setEditable(false);

		Label lblEnterAnyInterdepartmental = formToolkit.createLabel(grpRequestsFromOther,
				"Enter any interdepartmental requests that need to be handled on a"
						+ " different shift. Routes, ELVIS updates, etc...",
				SWT.NONE | SWT.WRAP);
		lblEnterAnyInterdepartmental.setBounds(10, 103, 310, 30);

		Group grpEquipmentredundancyIssues = new Group(composite, SWT.NONE);
		grpEquipmentredundancyIssues.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		grpEquipmentredundancyIssues.setText("Equipment/Redundancy Issues");
		grpEquipmentredundancyIssues.setBounds(10, 418, 330, 136);
		formToolkit.adapt(grpEquipmentredundancyIssues);
		formToolkit.paintBordersFor(grpEquipmentredundancyIssues);

		textEquipment = formToolkit.createText(grpEquipmentredundancyIssues, "New Text", SWT.NONE);
		textEquipment.setText(obj.equipmentText);
		textEquipment.setBounds(10, 22, 310, 75);
		textEquipment.setEditable(false);

		Label lblEnterAnyOngoing = formToolkit.createLabel(grpEquipmentredundancyIssues,
				"Enter any ongoing equipment or redundancy issues (e.g. ESPN backup down, OP-2 stand alone 1 not working, "
						+ "etc...)",
				SWT.WRAP);
		lblEnterAnyOngoing.setBounds(10, 103, 310, 30);

		Group grpSpecialMonitoringRequests = new Group(composite, SWT.NONE);
		grpSpecialMonitoringRequests.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		grpSpecialMonitoringRequests.setText("Special Monitoring Requests");
		grpSpecialMonitoringRequests.setBounds(357, 418, 330, 136);
		formToolkit.adapt(grpSpecialMonitoringRequests);
		formToolkit.paintBordersFor(grpSpecialMonitoringRequests);

		textMonitoring = formToolkit.createText(grpSpecialMonitoringRequests, "New Text", SWT.NONE);
		textMonitoring.setText(obj.specialMonitoringText);
		textMonitoring.setBounds(10, 22, 310, 75);
		textMonitoring.setEditable(false);

		Label lblEnterAnySpecial = formToolkit.createLabel(grpSpecialMonitoringRequests,
				"Enter any special monitoring requests (e.g. Negative crawls, "
						+ "high-profile broadcasts or discrepancies, etc...)",
				SWT.WRAP);
		lblEnterAnySpecial.setBounds(10, 103, 310, 30);

		Group grpTakedowns = new Group(composite, SWT.NONE);
		grpTakedowns.setBounds(10, 276, 330, 136);
		grpTakedowns.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		grpTakedowns.setText("Takedowns");
		formToolkit.adapt(grpTakedowns);
		formToolkit.paintBordersFor(grpTakedowns);

		textTakedowns = formToolkit.createText(grpTakedowns, "New Text", SWT.NONE | SWT.WRAP);
		textTakedowns.setText(obj.takedownText);
		textTakedowns.setBounds(10, 22, 310, 75);
		textTakedowns.setEditable(false);

		Label lblTakedownEventsIn =
				formToolkit.createLabel(grpTakedowns, "Takedown events in the next 48 hours.", SWT.NONE);
		lblTakedownEventsIn.setBounds(10, 103, 253, 15);

		Group group = new Group(scrldfrmCheyenneTocLead.getBody(), SWT.NONE);
		group.setBackground(SWTResourceManager.getColor(255, 255, 255));
		group.setBounds(780, 10, 376, 82);
		formToolkit.adapt(group);
		formToolkit.paintBordersFor(group);

		Label lblDate = formToolkit.createLabel(group, "Date and Time:", SWT.NONE);
		lblDate.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblDate.setBounds(10, 22, 95, 17);

		txtDate = formToolkit.createText(group, "New Text", SWT.NONE);
		txtDate.setEditable(false);
		txtDate.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		txtDate.setText(time);
		txtDate.setBounds(111, 21, 123, 20);
		txtDate.setEditable(false);

		Label lblShift = formToolkit.createLabel(group, "Shift:", SWT.NONE);
		lblShift.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblShift.setBounds(259, 22, 40, 15);

		Label lblName = formToolkit.createLabel(group, "Name:", SWT.NONE);
		lblName.setBounds(10, 45, 40, 17);
		lblName.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));

		txtName = formToolkit.createText(group, "New Text", SWT.LEFT);
		txtName.setBounds(56, 45, 178, 20);
		txtName.setEditable(false);
		txtName.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtName.setText(System.getProperty("user.name"));

//		LocalTime dayShift = LocalTime.of(7, 0);
//		LocalTime swingShift = LocalTime.of(15, 0);
//		LocalTime midShift = LocalTime.of(23, 0);
//		LocalTime timeComparison = LocalTime.now();

//		if (timeComparison.equals(dayShift) || timeComparison.isAfter(dayShift) && timeComparison.isBefore(swingShift)) {
//			shift = "Days";
//		} else if (timeComparison.equals(swingShift)
//				|| timeComparison.isAfter(swingShift) && timeComparison.isBefore(midShift)) {
//			shift = "Swings";
//		} else {
//			shift = "Mids";
//		}
		txtShift = formToolkit.createText(group, "New Text", SWT.NONE);
		txtShift.setText(shift);
		txtShift.setBounds(305, 18, 60, 21);
		txtShift.setEditable(false);

		Group grpDailyChecklist = new Group(scrldfrmCheyenneTocLead.getBody(), SWT.NONE);
		grpDailyChecklist.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		grpDailyChecklist.setText("Daily Checklist");
		grpDailyChecklist.setBounds(730, 98, 477, 370);
		formToolkit.adapt(grpDailyChecklist);
		formToolkit.paintBordersFor(grpDailyChecklist);

		Label lblEaWaItx =
				formToolkit.createLabel(grpDailyChecklist, "EA_WA_ITX_Spreadsheet Verified for Accuracy: ", SWT.NONE);
		lblEaWaItx.setBounds(10, 25, 300, 15);

		Label lblEaWaItxPlayout =
				formToolkit.createLabel(grpDailyChecklist, "EA_WA_ITX_Spreadsheet Playouts Verified: \t", SWT.NONE);
		lblEaWaItxPlayout.setBounds(10, 45, 300, 15);

		Label lblChannelLaunchActivities =
				formToolkit.createLabel(grpDailyChecklist, "Channel Launch Verification Spreadsheet:\t", SWT.NONE);
		lblChannelLaunchActivities.setBounds(10, 65, 300, 15);

		Label lblWeatherMaps =
				formToolkit.createLabel(grpDailyChecklist, "Ensure Weather Maps is functioning:\t", SWT.NONE);
		lblWeatherMaps.setBounds(10, 85, 300, 15);

		Label lblMidsOnly = formToolkit.createLabel(grpDailyChecklist, "Mids only:", SWT.NONE);
		lblMidsOnly.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblMidsOnly.setBounds(10, 145, 70, 20);

		Label lblMaintenanceRestored =
				formToolkit.createLabel(grpDailyChecklist, "Verify restoration of scheduled maintenance:\t", SWT.NONE);
		lblMaintenanceRestored.setBounds(10, 165, 300, 15);

		Label lblInteractiveChecks =
				formToolkit.createLabel(grpDailyChecklist, "Perform interactive channel checks:", SWT.NONE);
		lblInteractiveChecks.setBounds(10, 105, 300, 15);

		Label lblDaysOnly = formToolkit.createLabel(grpDailyChecklist, "Days only:", SWT.NONE);
		lblDaysOnly.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblDaysOnly.setBounds(10, 205, 70, 20);

		Label lblTurnerservices =
				formToolkit.createLabel(grpDailyChecklist, "Update the STB Turner Services every Thursday:", SWT.NONE);
		lblTurnerservices.setBounds(10, 225, 300, 15);

		Label lblPreliminaryKciReport =
				formToolkit.createLabel(grpDailyChecklist, "Respond to the Preliminary KCI Report:", SWT.NONE);
		lblPreliminaryKciReport.setBounds(10, 245, 300, 15);

		Label lblSkdlActivation =
				formToolkit.createLabel(grpDailyChecklist, "Ensure SKDL alarms have been uninhibited at 09:00 MT:", SWT.NONE);
		lblSkdlActivation.setBounds(10, 265, 300, 15);

		Label lblSwingsOnly = formToolkit.createLabel(grpDailyChecklist, "Swings only:", SWT.NONE);
		lblSwingsOnly.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblSwingsOnly.setBounds(10, 305, 80, 20);

		Label lblMcSwitches =
				formToolkit.createLabel(grpDailyChecklist, "Ensure all prime-time MC switches are successful:", SWT.NONE);
		lblMcSwitches.setBounds(10, 325, 300, 15);

		Button btnEaWaItxComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnEaWaItxComplete.setEnabled(false);
		btnEaWaItxComplete.setBounds(338, 25, 93, 16);
		formToolkit.adapt(btnEaWaItxComplete, true, true);
		btnEaWaItxComplete.setText("Complete");
		btnEaWaItxComplete.setSelection(obj.eaWaItxComplete);

		Button btnEaWaItxPlayoutComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnEaWaItxPlayoutComplete.setEnabled(false);
		btnEaWaItxPlayoutComplete.setBounds(338, 45, 93, 16);
		formToolkit.adapt(btnEaWaItxPlayoutComplete, true, true);
		btnEaWaItxPlayoutComplete.setText("Complete");
		btnEaWaItxPlayoutComplete.setSelection(obj.eaWaItxPlayoutComplete);

		Button btnChannelLaunchComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnChannelLaunchComplete.setEnabled(false);
		btnChannelLaunchComplete.setBounds(338, 65, 93, 16);
		formToolkit.adapt(btnChannelLaunchComplete, true, true);
		btnChannelLaunchComplete.setText("Complete");
		btnChannelLaunchComplete.setSelection(obj.channelLaunchComplete);

		Button btnWeatherComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnWeatherComplete.setEnabled(false);
		btnWeatherComplete.setBounds(338, 85, 93, 16);
		formToolkit.adapt(btnWeatherComplete, true, true);
		btnWeatherComplete.setText("Complete");
		btnWeatherComplete.setSelection(obj.weatherComplete);

		Button btnInteractiveComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnInteractiveComplete.setEnabled(false);
		btnInteractiveComplete.setBounds(338, 105, 93, 16);
		formToolkit.adapt(btnInteractiveComplete, true, true);
		btnInteractiveComplete.setText("Complete");
		btnInteractiveComplete.setSelection(obj.interactiveComplete);

		Button btnMaintenanceComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnMaintenanceComplete.setEnabled(false);
		btnMaintenanceComplete.setBounds(338, 165, 93, 16);
		formToolkit.adapt(btnMaintenanceComplete, true, true);
		btnMaintenanceComplete.setText("Complete");
		btnMaintenanceComplete.setSelection(obj.maintenanceComplete);

		Button btnTurnerComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnTurnerComplete.setEnabled(false);
		btnTurnerComplete.setBounds(338, 225, 93, 16);
		formToolkit.adapt(btnTurnerComplete, true, true);
		btnTurnerComplete.setText("Complete");
		btnTurnerComplete.setSelection(obj.turnerComplete);

		Button btnPreliminaryKciComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnPreliminaryKciComplete.setEnabled(false);
		btnPreliminaryKciComplete.setBounds(338, 245, 93, 16);
		formToolkit.adapt(btnPreliminaryKciComplete, true, true);
		btnPreliminaryKciComplete.setText("Complete");
		btnPreliminaryKciComplete.setSelection(obj.kciComplete);

		Button btnSkdlComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnSkdlComplete.setEnabled(false);
		btnSkdlComplete.setBounds(338, 265, 93, 16);
		formToolkit.adapt(btnSkdlComplete, true, true);
		btnSkdlComplete.setText("Complete");
		btnSkdlComplete.setSelection(obj.skdlComplete);

		Button btnMcSwitchesComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnMcSwitchesComplete.setEnabled(false);
		btnMcSwitchesComplete.setBounds(338, 325, 93, 16);
		formToolkit.adapt(btnMcSwitchesComplete, true, true);
		btnMcSwitchesComplete.setText("Complete");
		btnMcSwitchesComplete.setSelection(obj.mcSwitchesComplete);

		Label lblOncomingLead = formToolkit.createLabel(scrldfrmCheyenneTocLead.getBody(), "Oncoming Lead:", SWT.NONE);
		lblOncomingLead.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblOncomingLead.setBounds(730, 481, 100, 20);

		txtOncominglead = formToolkit.createText(scrldfrmCheyenneTocLead.getBody(), "New Text", SWT.NONE);
		txtOncominglead.setText(obj.oncomingLead);
		txtOncominglead.setEditable(false);
		txtOncominglead.setBounds(730, 507, 200, 20);

		Button btnPassdownAccepted = new Button(scrldfrmCheyenneTocLead.getBody(), SWT.CHECK);
		btnPassdownAccepted.setEnabled(false);
		btnPassdownAccepted.setBounds(1057, 480, 150, 20);
		formToolkit.adapt(btnPassdownAccepted, true, true);
		btnPassdownAccepted.setText("Passdown Accepted");
		btnPassdownAccepted.setSelection(obj.acceptedChecked);

		Button btnPassdownDeclined = new Button(scrldfrmCheyenneTocLead.getBody(), SWT.CHECK);
		btnPassdownDeclined.setEnabled(false);
		btnPassdownDeclined.setBounds(1057, 507, 150, 20);
		formToolkit.adapt(btnPassdownDeclined, true, true);
		btnPassdownDeclined.setText("Passdown Declined");
		btnPassdownDeclined.setSelection(obj.declinedChecked);

		Label lblEnterTheName = formToolkit.createLabel(scrldfrmCheyenneTocLead.getBody(),
				"Enter the name of the oncoming lead techs and select whether the "
						+ "accept the passdown. Passdowns should be declined if the if the "
						+ "information is unclear or incorrect.",
				SWT.WRAP);
		lblEnterTheName.setBounds(730, 533, 477, 30);
		new Label(this, SWT.NONE);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Report Entry");
		setSize(1300, 800);

	}

	protected void getPassdownData(DataObject obj) throws IOException, IllegalArgumentException, IllegalAccessException {
		ArrayList<String> list = new ArrayList<>();
		for (String line : Files.readAllLines(Paths.get("src\\datastore\\passdown_datastore.pd"), Charset.defaultCharset())) {
			list.add(line);
		}
		boolean ok = false;
//		File data = new File("src\\datastore\\dunno");
//		DateTimeFormatter date = DateTimeFormatter.ofPattern("M/dd/yyyy");
//		LocalDateTime now;
//		StringBuilder sb = new StringBuilder();
//		if (shift == "Mids") {
//			now = LocalDateTime.now().plusDays(1);
//		} else {
//			now = LocalDateTime.now();
//		}
		String formattedDate = getTime();
		System.out.println(formattedDate);
//		System.out.println(formattedDate);
		for (String line : list) {
			if (line.startsWith(formattedDate)) {
				System.out.println("Found date");
				System.out.println(getShift());
				String[] splitLine = line.split(";--");
//				for(int j = 0; j < splitLine.length; j++) {
//					System.out.println(splitLine[j] + "    " +  j);
//				}
				ok = true;

					setDataObject(obj, splitLine);
					System.out.println(obj.shift);
					if (obj.shift.equals(getShift())) {
//							System.out.println("Match #1");
//							System.out.println(obj.shift);
					} else {
						System.out.println("Failed at shift check.");
						setDataObject(obj, null);
						JOptionPane.showMessageDialog(null, "Record not found");
					}

//				if(obj.shift.equals(getShift())) {
//					System.out.println("Match #2");
//					for(Field field : obj.getClass().getDeclaredFields()) {
//						System.out.println(field.getName() + " - " + field.getType() + " - " + field.get(obj));
//					}
//				}
			}
		}
		if (!ok) {
			System.out.println("Failed at date check.");
			JOptionPane.showMessageDialog(null, "Record not found");
		}

//				Scanner reader = new Scanner(data);
//				for(int i = 0; i < count - 1; i++) {
//					System.out.println(reader.nextLine());
//				}
//				reader.useDelimiter(",");
//				for(int i = 0; i < 2; i++) {
//					reader.next();
//				}
//				System.out.println(getShift() + "     SHIFT");
//				System.out.println(reader.next());
//				if(reader.next().contains(getShift())) {
//					System.out.println("Match");
//					System.out.println(line);
//				}
//				reader.close();
//			}
//		}

//		Scanner reader = new Scanner (data);
//		reader.useDelimiter(",");
//		if(reader.hasNext(formattedDate)) {
//			System.out.println("Match");
//			System.out.println(reader.next());
//			System.out.println(reader.next());
//			System.out.println(reader.next());
//		}
//		reader.close();
//		for(int i = 0; i < 10; i++) {
//			if(reader.next().contains("true")) {
//				setButtonValues(true, i);
//			}
//			else {
//				setButtonValues(false, i);
//			}
//			System.out.println(getButtonValues(i));
//		}
//
//		btnEmployee.setSelection(getButtonValues(0));
//		btnEmployee_1.setSelection(getButtonValues(1));
//		btnEmployee_2.setSelection(getButtonValues(2));
//		btnEmployee_3.setSelection(getButtonValues(3));
//		btnEmployee_4.setSelection(getButtonValues(4));
//		btnEmployee_5.setSelection(getButtonValues(5));
//		btnEmployee_6.setSelection(getButtonValues(6));
//		btnEmployee_7.setSelection(getButtonValues(7));
//		btnEmployee_8.setSelection(getButtonValues(8));
//		btnEmployee_9.setSelection(getButtonValues(9));

//		reader.close();
//		sb.append(formattedDate + "," + txtName.getText() + "," + txtShift.getText() + ",");
//		System.out.println(txtName.getText());
//		System.out.println(txtShift.getText());
//		for (int i = 0; i < buttonValues.length; i++) {
//			System.out.println(buttonValues[i]);

//			sb.append(buttonValues[i] + ",");
//		}
//		sb.append(text.getText() + "," + text1.getText() + "," + text2.getText() + "," + text3.getText() + ","
//				+ text4.getText() + "," + text5.getText() + "," + text6.getText() + "," + text7.getText() + ","
//				+ text8.getText() + "," + text9.getText() + ",");
//		TableItem item;
//		System.out.println(table.getItem(0));
//		for(int i = 0; i < 10; i++) {
//			item = table.getItem(i);
//			System.out.println(item.getText(0) + "," + item.getText(1));
//			sb.append(item.getText(0) + "," + item.getText(1) + ",");
//		}
//		sb.append(eaWaItxComplete + "," + eaWaItxPlayoutComplete + "," + channelLaunchComplete + "," + weatherComplete + ","
//				+ interactiveComplete + "," + maintenanceComplete + "," + turnerComplete + "," + preliminaryKciComplete + ","
//				+ skdlComplete + "," + mcSwitchesComplete + ",");
//		sb.append(textTakedowns.getText() + "," + textIdRequests.getText() + "," + textEquipment.getText() + ","
//				+ textMonitoring.getText() + "," + txtOncomingLead.getText() + ",");
//		sb.append(passdownAccepted + "," + passdownDeclined + "\n");

//		System.out.println(text.getText() + " " + text1.getText() + " " + text2.getText() + " " + text3.getText() + " "
//				+ text4.getText() + " " + text5.getText() + " " + text6.getText() + " " + text7.getText() + " "
//				+ text8.getText() + " " + text9.getText());
//		System.out.println(eaWaItxComplete + " EA WA ITX");
//		System.out.println(eaWaItxPlayoutComplete + " EA WA ITX Playouts");
//		System.out.println(channelLaunchComplete + " Channel Launch");
//		System.out.println(weatherComplete + " Weather");
//		System.out.println(interactiveComplete + " Interactive");
//		System.out.println(maintenanceComplete + " Maintenance");
//		System.out.println(turnerComplete + " Turner");
//		System.out.println(preliminaryKciComplete + " Prelim KCI");
//		System.out.println(skdlComplete + " SKDL");
//		System.out.println(mcSwitchesComplete + " MC");
//		System.out.println(textTakedowns.getText());
//		System.out.println(textIdRequests.getText());
//		System.out.println(textEquipment.getText());
//		System.out.println(textMonitoring.getText());
//		System.out.println(txtOncomingLead.getText());
//		FileWriter writer = new FileWriter(data, true);
//		BufferedWriter buffWriter = new BufferedWriter(writer); // creates a buffering character output stream
//		writer.write(sb.toString());
//		writer.close();
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		super.close();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	protected void setTime(String timeSet) {
		time = timeSet;
	}

	protected String getTime() {
		return time;
	}

	protected void setButtonValues(boolean butValues, int index) {
		System.out.println(butValues + "   " + index);
		buttonValues[index] = butValues;
	}

	protected boolean getButtonValues(int index) {
		return buttonValues[index];
	}

	protected static void setShift(String shift) {
		PreviousReports.shift = shift;
	}

	protected static String getShift() {
		return PreviousReports.shift;
	}

	private void setDataObject(DataObject obj, String[] splitLine) {
		System.out.println("Starting object");
		obj.date = splitLine[0];
		obj.user = splitLine[1];
		obj.shift = splitLine[2];
		obj.employee = Boolean.parseBoolean(splitLine[3]);
		obj.employee1 = Boolean.parseBoolean(splitLine[4]);
		obj.employee2 = Boolean.parseBoolean(splitLine[5]);
		obj.employee3 = Boolean.parseBoolean(splitLine[6]);
		obj.employee4 = Boolean.parseBoolean(splitLine[7]);
		obj.employee5 = Boolean.parseBoolean(splitLine[8]);
		obj.employee6 = Boolean.parseBoolean(splitLine[9]);
		obj.employee7 = Boolean.parseBoolean(splitLine[10]);
		obj.employee8 = Boolean.parseBoolean(splitLine[11]);
		obj.employee9 = Boolean.parseBoolean(splitLine[12]);
		obj.text = splitLine[13];
		obj.text1 = splitLine[14];
		obj.text2 = splitLine[15];
		obj.text3 = splitLine[16];
		obj.text4 = splitLine[17];
		obj.text5 = splitLine[18];
		obj.text6 = splitLine[19];
		obj.text7 = splitLine[20];
		obj.text8 = splitLine[21];
		obj.text9 = splitLine[22];
		for (int i = 23; i < 45; i++) {
			obj.tableData.add(splitLine[i]);
		}
		obj.takedownText = splitLine[45];
		obj.idRequestText = splitLine[46];
		obj.equipmentText = splitLine[47];
		obj.specialMonitoringText = splitLine[48];
		obj.eaWaItxComplete = Boolean.parseBoolean(splitLine[49]);
		obj.eaWaItxPlayoutComplete = Boolean.parseBoolean(splitLine[50]);
		obj.channelLaunchComplete = Boolean.parseBoolean(splitLine[51]);
		obj.weatherComplete = Boolean.parseBoolean(splitLine[52]);
		obj.interactiveComplete = Boolean.parseBoolean(splitLine[53]);
		obj.maintenanceComplete = Boolean.parseBoolean(splitLine[54]);
		obj.turnerComplete = Boolean.parseBoolean(splitLine[55]);
		obj.kciComplete = Boolean.parseBoolean(splitLine[56]);
		obj.skdlComplete = Boolean.parseBoolean(splitLine[57]);
		obj.mcSwitchesComplete = Boolean.parseBoolean(splitLine[58]);
		obj.oncomingLead = splitLine[59];
		obj.acceptedChecked = Boolean.parseBoolean(splitLine[60]);
		obj.declinedChecked = Boolean.parseBoolean(splitLine[61]);
		System.out.println("Done");
	}

}