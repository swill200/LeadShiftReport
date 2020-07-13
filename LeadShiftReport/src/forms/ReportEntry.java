package forms;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.forms.widgets.*;
import org.eclipse.wb.swt.SWTResourceManager;
import main.Code;

public class ReportEntry extends Shell {
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text text, text1, text2, text3, text4, text5, text6, text7, text8, text9;
	private Text textTakedowns, textIdRequests, textEquipment, textMonitoring, txtName, txtDate, txtShift,
			txtOncomingLead;
	protected String shift;
	protected String[] empArray;

	public ReportEntry(Display display) {
		super(display, SWT.SHELL_TRIM);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginBottom = 25;
		gridLayout.marginRight = 25;
		gridLayout.marginTop = 25;
		gridLayout.marginLeft = 30;
		setLayout(gridLayout);

		ScrolledForm scrldfrmCheyenneTocLead = formToolkit.createScrolledForm(this);
//		scrldfrmCheyenneTocLead.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
		GridData gd_scrldfrmCheyenneTocLead = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_scrldfrmCheyenneTocLead.widthHint = 1200;
		gd_scrldfrmCheyenneTocLead.heightHint = 600;
		scrldfrmCheyenneTocLead.setLayoutData(gd_scrldfrmCheyenneTocLead);
		formToolkit.paintBordersFor(scrldfrmCheyenneTocLead);
		scrldfrmCheyenneTocLead.setText("Cheyenne TOC Lead Tech Shift Report");

		Composite composite = formToolkit.createComposite(scrldfrmCheyenneTocLead.getBody(), SWT.NONE);
//		composite.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
		composite.setBounds(10, 10, 697, 564);
		formToolkit.paintBordersFor(composite);

		Group grpStaff = new Group(composite, SWT.NONE);
		grpStaff.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		grpStaff.setText("Shift Staff and Assignments");
		grpStaff.setBounds(10, 10, 330, 260);
		formToolkit.adapt(grpStaff);
		formToolkit.paintBordersFor(grpStaff);

		Button btnEmployee = new Button(grpStaff, SWT.CHECK);
		btnEmployee.setBounds(10, 20, 150, 16);
		btnEmployee.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		formToolkit.adapt(btnEmployee, true, true);
		btnEmployee.setText("Employee_0");

		Button btnEmployee_1 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_1.setBounds(10, 40, 150, 16);
		formToolkit.adapt(btnEmployee_1, true, true);
		btnEmployee_1.setText("Employee_1");

		Button btnEmployee_2 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnEmployee_2.setBounds(10, 60, 150, 16);
		formToolkit.adapt(btnEmployee_2, true, true);
		btnEmployee_2.setText("Employee_2");

		Button btnEmployee_3 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_3.setBounds(10, 80, 150, 16);
		formToolkit.adapt(btnEmployee_3, true, true);
		btnEmployee_3.setText("Employee_3");

		Button btnEmployee_4 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_4.setBounds(10, 100, 150, 16);
		formToolkit.adapt(btnEmployee_4, true, true);
		btnEmployee_4.setText("Employee_4");

		Button btnEmployee_5 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_5.setBounds(10, 120, 150, 16);
		formToolkit.adapt(btnEmployee_5, true, true);
		btnEmployee_5.setText("Employee_5");

		Button btnEmployee_6 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_6.setBounds(10, 140, 150, 16);
		formToolkit.adapt(btnEmployee_6, true, true);
		btnEmployee_6.setText("Employee_6");

		Button btnEmployee_7 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_7.setBounds(10, 160, 150, 16);
		formToolkit.adapt(btnEmployee_7, true, true);
		btnEmployee_7.setText("Employee_7");

		Button btnEmployee_8 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_8.setBounds(10, 180, 150, 16);
		formToolkit.adapt(btnEmployee_8, true, true);
		btnEmployee_8.setText("Employee_8");

		Button btnEmployee_9 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_9.setBounds(10, 200, 150, 16);
		formToolkit.adapt(btnEmployee_9, true, true);
		btnEmployee_9.setText("Employee_9");

		text = formToolkit.createText(grpStaff, "New Text", SWT.NONE);
		text.setText("");
		text.setBounds(180, 20, 140, 18);

		text1 = formToolkit.createText(grpStaff, "New Text", SWT.NONE);
		text1.setText("");
		text1.setBounds(180, 40, 140, 18);

		text2 = formToolkit.createText(grpStaff, "New Text", SWT.NONE);
		text2.setText("");
		text2.setBounds(180, 60, 140, 18);

		text3 = formToolkit.createText(grpStaff, "New Text", SWT.NONE);
		text3.setText("");
		text3.setBounds(180, 80, 140, 18);

		text4 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text4.setBounds(180, 100, 140, 18);

		text5 = formToolkit.createText(grpStaff, "New Text", SWT.NONE);
		text5.setText("");
		text5.setBounds(180, 120, 140, 18);

		text6 = formToolkit.createText(grpStaff, "New Text", SWT.NONE);
		text6.setText("");
		text6.setBounds(180, 140, 140, 18);

		text7 = formToolkit.createText(grpStaff, "New Text", SWT.NONE);
		text7.setText("");
		text7.setBounds(180, 160, 140, 18);

		text8 = formToolkit.createText(grpStaff, "New Text", SWT.NONE);
		text8.setText("");
		text8.setBounds(180, 180, 140, 18);

		text9 = formToolkit.createText(grpStaff, "New Text", SWT.NONE);
		text9.setText("");
		text9.setBounds(180, 200, 140, 18);

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
//		formToolkit.paintBordersFor(table);
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
		for (int i = 0; i < 10; i++) {
			TableItem item = new TableItem(table, SWT.BORDER_SOLID);
			if (i % 2 == 0) {
				item.setBackground(gray);

			}
			item.setText(new String[] { "", "" });
		}

		final TableEditor editor = new TableEditor(table);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		editor.minimumWidth = 50;
		table.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event event) {
				Rectangle clientArea = table.getClientArea();
				Point pt = new Point(event.x, event.y);
				int index = table.getTopIndex();
				while (index < table.getItemCount()) {
					boolean visible = false;
					final TableItem item = table.getItem(index);
					for (int i = 0; i < table.getColumnCount(); i++) {
						Rectangle rectangle = item.getBounds(i);
						if (rectangle.contains(pt)) {
							final int column = i;
							final Text text = new Text(table, SWT.NONE);
							Listener textListener = new Listener() {
								public void handleEvent(final Event e) {
									switch (e.type) {
									case SWT.FocusOut:
										item.setText(column, text.getText());
										text.dispose();
										break;
									case SWT.Traverse:
										switch (e.detail) {
										case SWT.TRAVERSE_RETURN:
											item.setText(column, text.getText());
										case SWT.TRAVERSE_ESCAPE:
											text.dispose();
											e.doit = false;
										}
										break;
									}
								}
							};
							text.addListener(SWT.FocusOut, textListener);
							text.addListener(SWT.Traverse, textListener);
							editor.setEditor(text, item, i);
							text.setText(item.getText(i));
							text.selectAll();
							text.setFocus();
							return;
						}
						if (!visible && rectangle.intersects(clientArea)) {
							visible = true;
						}
					}
					if (!visible) {
						return;
					}
					index++;
				}
			}
		});

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
		textIdRequests.setText("");
		textIdRequests.setBounds(10, 22, 310, 75);

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
		textEquipment.setText("");
		textEquipment.setBounds(10, 22, 310, 75);

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
		textMonitoring.setText("");
		textMonitoring.setBounds(10, 22, 310, 75);

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
		textTakedowns.setText("");
		textTakedowns.setBounds(10, 22, 310, 75);

		Label lblTakedownEventsIn
				= formToolkit.createLabel(grpTakedowns, "Takedown events in the next 48 hours.", SWT.NONE);
		lblTakedownEventsIn.setBounds(10, 103, 253, 15);

		Group group = new Group(scrldfrmCheyenneTocLead.getBody(), SWT.NONE);
		group.setBackground(SWTResourceManager.getColor(255, 255, 255));
		group.setBounds(780, 10, 376, 82);
		formToolkit.adapt(group);
		formToolkit.paintBordersFor(group);

		Label lblDate = formToolkit.createLabel(group, "Date and Time:", SWT.NONE);
		lblDate.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblDate.setBounds(10, 22, 95, 17);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy, HH:mm");
		LocalDateTime now = LocalDateTime.now();
		String time = dtf.format(now);
		txtDate = formToolkit.createText(group, "New Text", SWT.NONE);
		txtDate.setEditable(false);
		txtDate.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		txtDate.setText(time + " MT");
		txtDate.setBounds(111, 21, 123, 20);

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

		LocalTime dayShift = LocalTime.of(7, 0);
		LocalTime swingShift = LocalTime.of(15, 0);
		LocalTime midShift = LocalTime.of(23, 0);
		LocalTime timeComparison = LocalTime.now();

		if (timeComparison.equals(dayShift) || timeComparison.isAfter(dayShift) && timeComparison.isBefore(swingShift)) {
			shift = "Days";
		} else if (timeComparison.equals(swingShift)
				|| timeComparison.isAfter(swingShift) && timeComparison.isBefore(midShift)) {
			shift = "Swings";
		} else {
			shift = "Mids";
		}
		txtShift = formToolkit.createText(group, "New Text", SWT.NONE);
		txtShift.setText(shift);
		txtShift.setBounds(305, 18, 60, 21);

		Group grpDailyChecklist = new Group(scrldfrmCheyenneTocLead.getBody(), SWT.NONE);
		grpDailyChecklist.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		grpDailyChecklist.setText("Daily Checklist");
		grpDailyChecklist.setBounds(730, 98, 477, 370);
		formToolkit.adapt(grpDailyChecklist);
		formToolkit.paintBordersFor(grpDailyChecklist);

		Label lblEaWaItx
				= formToolkit.createLabel(grpDailyChecklist, "EA_WA_ITX_Spreadsheet Verified for Accuracy: ", SWT.NONE);
		lblEaWaItx.setBounds(10, 25, 300, 15);

		Label lblEaWaItxPlayout
				= formToolkit.createLabel(grpDailyChecklist, "EA_WA_ITX_Spreadsheet Playouts Verified: \t", SWT.NONE);
		lblEaWaItxPlayout.setBounds(10, 45, 300, 15);

		Label lblChannelLaunchActivities
				= formToolkit.createLabel(grpDailyChecklist, "Channel Launch Verification Spreadsheet:\t", SWT.NONE);
		lblChannelLaunchActivities.setBounds(10, 65, 300, 15);

		Label lblWeatherMaps
				= formToolkit.createLabel(grpDailyChecklist, "Ensure Weather Maps is functioning:\t", SWT.NONE);
		lblWeatherMaps.setBounds(10, 85, 300, 15);

		Label lblMidsOnly = formToolkit.createLabel(grpDailyChecklist, "Mids only:", SWT.NONE);
		lblMidsOnly.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblMidsOnly.setBounds(10, 145, 70, 20);

		Label lblMaintenanceRestored
				= formToolkit.createLabel(grpDailyChecklist, "Verify restoration of scheduled maintenance:\t", SWT.NONE);
		lblMaintenanceRestored.setBounds(10, 165, 300, 15);

		Label lblInteractiveChecks
				= formToolkit.createLabel(grpDailyChecklist, "Perform interactive channel checks:", SWT.NONE);
		lblInteractiveChecks.setBounds(10, 105, 300, 15);

		Label lblDaysOnly = formToolkit.createLabel(grpDailyChecklist, "Days only:", SWT.NONE);
		lblDaysOnly.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblDaysOnly.setBounds(10, 205, 70, 20);

		Label lblTurnerservices
				= formToolkit.createLabel(grpDailyChecklist, "Update the STB Turner Services every Thursday:", SWT.NONE);
		lblTurnerservices.setBounds(10, 225, 300, 15);

		Label lblPreliminaryKciReport
				= formToolkit.createLabel(grpDailyChecklist, "Respond to the Preliminary KCI Report:", SWT.NONE);
		lblPreliminaryKciReport.setBounds(10, 245, 300, 15);

		Label lblSkdlActivation
				= formToolkit.createLabel(grpDailyChecklist, "Ensure SKDL alarms have been uninhibited at 09:00 MT:", SWT.NONE);
		lblSkdlActivation.setBounds(10, 265, 300, 15);

		Label lblSwingsOnly = formToolkit.createLabel(grpDailyChecklist, "Swings only:", SWT.NONE);
		lblSwingsOnly.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblSwingsOnly.setBounds(10, 305, 80, 20);

		Label lblMcSwitches
				= formToolkit.createLabel(grpDailyChecklist, "Ensure all prime-time MC switches are successful:", SWT.NONE);
		lblMcSwitches.setBounds(10, 325, 300, 15);

		Button btnEaWaItxComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnEaWaItxComplete.setBounds(338, 25, 93, 16);
		formToolkit.adapt(btnEaWaItxComplete, true, true);
		btnEaWaItxComplete.setText("Complete");

		Button btnEaWaItxPlayoutComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnEaWaItxPlayoutComplete.setBounds(338, 45, 93, 16);
		formToolkit.adapt(btnEaWaItxPlayoutComplete, true, true);
		btnEaWaItxPlayoutComplete.setText("Complete");

		Button btnChannelLaunchComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnChannelLaunchComplete.setBounds(338, 65, 93, 16);
		formToolkit.adapt(btnChannelLaunchComplete, true, true);
		btnChannelLaunchComplete.setText("Complete");

		Button btnWeatherComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnWeatherComplete.setBounds(338, 85, 93, 16);
		formToolkit.adapt(btnWeatherComplete, true, true);
		btnWeatherComplete.setText("Complete");

		Button btnInteractiveComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnInteractiveComplete.setBounds(338, 105, 93, 16);
		formToolkit.adapt(btnInteractiveComplete, true, true);
		btnInteractiveComplete.setText("Complete");

		Button btnMaintenanceComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnMaintenanceComplete.setBounds(338, 165, 93, 16);
		formToolkit.adapt(btnMaintenanceComplete, true, true);
		btnMaintenanceComplete.setText("Complete");

		Button btnTurnerComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnTurnerComplete.setBounds(338, 225, 93, 16);
		formToolkit.adapt(btnTurnerComplete, true, true);
		btnTurnerComplete.setText("Complete");

		Button btnPreliminaryKciComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnPreliminaryKciComplete.setBounds(338, 245, 93, 16);
		formToolkit.adapt(btnPreliminaryKciComplete, true, true);
		btnPreliminaryKciComplete.setText("Complete");

		Button btnSkdlComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnSkdlComplete.setBounds(338, 265, 93, 16);
		formToolkit.adapt(btnSkdlComplete, true, true);
		btnSkdlComplete.setText("Complete");

		Button btnMcSwitchesComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnMcSwitchesComplete.setBounds(338, 325, 93, 16);
		formToolkit.adapt(btnMcSwitchesComplete, true, true);
		btnMcSwitchesComplete.setText("Complete");

		Label lblOncomingLead = formToolkit.createLabel(scrldfrmCheyenneTocLead.getBody(), "Oncoming Lead:", SWT.NONE);
		lblOncomingLead.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblOncomingLead.setBounds(730, 481, 100, 20);

		txtOncomingLead = formToolkit.createText(scrldfrmCheyenneTocLead.getBody(), "Oncoming Lead", SWT.NONE);
		txtOncomingLead.setBounds(730, 507, 200, 20);

		Button btnPassdownAccepted = new Button(scrldfrmCheyenneTocLead.getBody(), SWT.CHECK);
		btnPassdownAccepted.setBounds(940, 480, 127, 20);
		formToolkit.adapt(btnPassdownAccepted, true, true);
		btnPassdownAccepted.setText("Passdown Accepted");

		Button btnPassdownDeclined = new Button(scrldfrmCheyenneTocLead.getBody(), SWT.CHECK);
		btnPassdownDeclined.setBounds(940, 505, 127, 20);
		formToolkit.adapt(btnPassdownDeclined, true, true);
		btnPassdownDeclined.setText("Passdown Declined");

		Label lblEnterTheName = formToolkit.createLabel(scrldfrmCheyenneTocLead.getBody(),
				"Enter the name of the oncoming lead techs and select whether the "
						+ "accept the passdown. Passdowns should be declined if the if the "
						+ "information is unclear or incorrect.",
				SWT.WRAP);
		lblEnterTheName.setBounds(730, 533, 477, 30);

		dtf = DateTimeFormatter.ofPattern("HH:mm");
		time = dtf.format(now);

		try {
			empArray = Code.checkShift(shift);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		btnEmployee.setText(empArray[0]);
		btnEmployee_1.setText(empArray[1]);
		btnEmployee_2.setText(empArray[2]);
		btnEmployee_3.setText(empArray[3]);
		btnEmployee_4.setText(empArray[4]);
		btnEmployee_5.setText(empArray[5]);
		btnEmployee_6.setText(empArray[6]);
		btnEmployee_7.setText(empArray[7]);
		btnEmployee_8.setText(empArray[8]);
		btnEmployee_9.setText(empArray[9]);

		Button btnSave = formToolkit.createButton(scrldfrmCheyenneTocLead.getBody(), "Save and Close", SWT.PUSH);
		btnSave.setForeground(SWTResourceManager.getColor(0, 0, 0));
		btnSave.setBounds(1070, 502, 127, 25);
		btnSave.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
		btnSave.addSelectionListener(widgetSelectedAdapter(e -> saveAndClose()));
		new Label(this, SWT.NONE);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Report Entry");
		setSize(1300, 725);

	}

	protected void saveAndClose() {
		System.out.println(txtOncomingLead.getText());
	}
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
