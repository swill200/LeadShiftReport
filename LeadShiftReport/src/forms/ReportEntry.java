package forms;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.wb.swt.SWTResourceManager;

import main.Code;
import main.DataObject;

public class ReportEntry extends Shell {
	private final String FILE_PATH = "src\\datastore\\passdown_datastore.pd";
	private final String BACKUP_FILE_PATH = "src\\datastore\\passdown_datastore.bak";
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text text, text1, text2, text3, text4, text5, text6, text7, text8, text9;
	private Text textTakedowns, textIdRequests, textEquipment, textMonitoring, txtName, txtDate, txtShift,
			txtOncomingLead;
	private Table table;
	private boolean eaWaItxComplete, eaWaItxPlayoutComplete, channelLaunchComplete, weatherComplete, interactiveComplete,
			dailySweeps, maintenanceComplete, turnerComplete, preliminaryKciComplete, skdlComplete, mcSwitchesComplete,
			passdownAccepted, passdownDeclined;
	private Label lblEditTime;

	private String shift;
	private String[] empArray;
	private boolean[] buttonValues = new boolean[10];
	private String[] buttonNames = new String[10];

	public ReportEntry(Display display) {
		super(display, SWT.SHELL_TRIM);
		addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {

			}
		});

		// Build the application window
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginBottom = 25;
		gridLayout.marginRight = 25;
		gridLayout.marginTop = 25;
		gridLayout.marginLeft = 30;
		setLayout(gridLayout);

		ScrolledForm scrldfrmCheyenneTocLead = formToolkit.createScrolledForm(this);
		GridData gd_scrldfrmCheyenneTocLead = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_scrldfrmCheyenneTocLead.widthHint = 1200;
		gd_scrldfrmCheyenneTocLead.heightHint = 650;
		scrldfrmCheyenneTocLead.setLayoutData(gd_scrldfrmCheyenneTocLead);
		formToolkit.paintBordersFor(scrldfrmCheyenneTocLead);
		scrldfrmCheyenneTocLead.setText("Cheyenne TOC Lead Tech Shift Report");
		Composite composite = formToolkit.createComposite(scrldfrmCheyenneTocLead.getBody(), SWT.NONE);
		composite.setBounds(10, 10, 697, 564);
		formToolkit.paintBordersFor(composite);

		lblEditTime = new Label(scrldfrmCheyenneTocLead.getBody(), SWT.NONE);
		lblEditTime.setBounds(974, 592, 120, 15);
		formToolkit.adapt(lblEditTime, true, true);
		lblEditTime.setText("");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy, HH:mm:ss");

		ModifyListener modListener = new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				lblEditTime.setText(LocalDateTime.now().format(formatter));
			}
		};

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
				buttonValues[0] = btnEmployee.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
//				System.out.println(buttonValues[0] + " Button 0");
			}
		});
		formToolkit.adapt(btnEmployee, true, true);
		btnEmployee.setText("Employee_0");

		Button btnEmployee_1 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				buttonValues[1] = btnEmployee_1.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
//				System.out.println(buttonValues[1] + " Button 1");
			}
		});
		btnEmployee_1.setBounds(10, 40, 150, 16);
		formToolkit.adapt(btnEmployee_1, true, true);
		btnEmployee_1.setText("Employee_1");
		buttonNames[1] = btnEmployee_1.getText();

		Button btnEmployee_2 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				buttonValues[2] = btnEmployee_2.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
//				System.out.println(buttonValues[2] + " Button 2");
			}
		});
		btnEmployee_2.setBounds(10, 60, 150, 16);
		formToolkit.adapt(btnEmployee_2, true, true);
		btnEmployee_2.setText("Employee_2");

		Button btnEmployee_3 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				buttonValues[3] = btnEmployee_3.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
//				System.out.println(buttonValues[3] + " Button 3");
			}
		});
		btnEmployee_3.setBounds(10, 80, 150, 16);
		formToolkit.adapt(btnEmployee_3, true, true);
		btnEmployee_3.setText("Employee_3");

		Button btnEmployee_4 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				buttonValues[4] = btnEmployee_4.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
//				System.out.println(buttonValues[4] + " Button 4");
			}
		});
		btnEmployee_4.setBounds(10, 100, 150, 16);
		formToolkit.adapt(btnEmployee_4, true, true);
		btnEmployee_4.setText("Employee_4");

		Button btnEmployee_5 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				buttonValues[5] = btnEmployee_5.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
//				System.out.println(buttonValues[5] + " Button 5");
			}
		});
		btnEmployee_5.setBounds(10, 120, 150, 16);
		formToolkit.adapt(btnEmployee_5, true, true);
		btnEmployee_5.setText("Employee_5");

		Button btnEmployee_6 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				buttonValues[6] = btnEmployee_6.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
//				System.out.println(buttonValues[6] + " Button 6");
			}
		});
		btnEmployee_6.setBounds(10, 140, 150, 16);
		formToolkit.adapt(btnEmployee_6, true, true);
		btnEmployee_6.setText("Employee_6");

		Button btnEmployee_7 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				buttonValues[7] = btnEmployee_7.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
//				System.out.println(buttonValues[7] + " Button 7");
			}
		});
		btnEmployee_7.setBounds(10, 160, 150, 16);
		formToolkit.adapt(btnEmployee_7, true, true);
		btnEmployee_7.setText("Employee_7");

		Button btnEmployee_8 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				buttonValues[8] = btnEmployee_8.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
//				System.out.println(buttonValues[8] + " Button 8");
			}
		});
		btnEmployee_8.setBounds(10, 180, 150, 16);
		formToolkit.adapt(btnEmployee_8, true, true);
		btnEmployee_8.setText("Employee_8");

		Button btnEmployee_9 = new Button(grpStaff, SWT.CHECK);
		btnEmployee_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				buttonValues[9] = btnEmployee_9.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
//				System.out.println(buttonValues[9] + " Button 9");
			}
		});
		btnEmployee_9.setBounds(10, 200, 150, 16);
		formToolkit.adapt(btnEmployee_9, true, true);
		btnEmployee_9.setText("Employee_9");

		text = formToolkit.createText(grpStaff, "", SWT.NONE);
		text.setBounds(180, 20, 140, 18);
		text.addModifyListener(modListener);

		text1 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text1.setBounds(180, 40, 140, 18);
		text1.addModifyListener(modListener);

		text2 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text2.setBounds(180, 60, 140, 18);
		text2.addModifyListener(modListener);

		text3 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text3.setBounds(180, 80, 140, 18);
		text3.addModifyListener(modListener);

		text4 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text4.setBounds(180, 100, 140, 18);
		text4.addModifyListener(modListener);

		text5 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text5.setBounds(180, 120, 140, 18);
		text5.addModifyListener(modListener);

		text6 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text6.setBounds(180, 140, 140, 18);
		text6.addModifyListener(modListener);

		text7 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text7.setBounds(180, 160, 140, 18);
		text7.addModifyListener(modListener);

		text8 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text8.setBounds(180, 180, 140, 18);
		text8.addModifyListener(modListener);

		text9 = formToolkit.createText(grpStaff, "", SWT.NONE);
		text9.setBounds(180, 200, 140, 18);
		text9.addModifyListener(modListener);

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

		table = new Table(grpOngoingOutagesAnd, SWT.MULTI | SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
		table.setBounds(10, 22, 310, 192);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		final GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		table.setLayoutData(gd);

		TableColumn col1 = new TableColumn(table, SWT.CENTER);
		col1.setResizable(false);
		col1.setAlignment(SWT.LEFT);
		col1.setWidth(147);
		col1.setText("Service");
		TableColumn col2 = new TableColumn(table, SWT.CENTER);
		col2.setWidth(146);
		col2.setAlignment(SWT.LEFT);
		col2.setResizable(false);
		col2.setText("ELVIS Ticket #");
		Color gray = display.getSystemColor(SWT.COLOR_GRAY);

		for (int i = 0; i <= 10; i++) {
			TableItem item = new TableItem(table, SWT.BORDER_SOLID);
			if (i % 2 == 0) {
				item.setBackground(gray);
			}
			item.setText(new String[] { "", "" });
		}

		// Editor code to handle editing of the table
		final TableEditor editor = new TableEditor(table);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		editor.minimumWidth = 50;
		table.addListener(SWT.MouseDown, new Listener() {
			@Override
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
								@Override
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
										case SWT.TAB:
											table.setSelection(table.getSelectionIndex() + 1);
											e.doit = true;
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

		Group grpTakedowns = new Group(composite, SWT.NONE);
		grpTakedowns.setBounds(10, 276, 330, 136);
		grpTakedowns.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		grpTakedowns.setText("Takedowns");
		formToolkit.adapt(grpTakedowns);
		formToolkit.paintBordersFor(grpTakedowns);

		textTakedowns = formToolkit.createText(grpTakedowns, "", SWT.NONE | SWT.WRAP);
		textTakedowns.setBounds(10, 22, 310, 75);
		textTakedowns.addModifyListener(modListener);

		Label lblTakedownEventsIn = formToolkit.createLabel(grpTakedowns, "Takedown events in the next 48 hours.",
				SWT.NONE);
		lblTakedownEventsIn.setBounds(10, 103, 253, 15);

		Group grpRequestsFromOther = new Group(composite, SWT.NONE);
		grpRequestsFromOther.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		grpRequestsFromOther.setText("Requests from other departments");
		grpRequestsFromOther.setBounds(357, 276, 330, 136);
		formToolkit.adapt(grpRequestsFromOther);
		formToolkit.paintBordersFor(grpRequestsFromOther);

		textIdRequests = formToolkit.createText(grpRequestsFromOther, "", SWT.WRAP);
		textIdRequests.setBounds(10, 22, 310, 75);
		textIdRequests.addModifyListener(modListener);

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

		textEquipment = formToolkit.createText(grpEquipmentredundancyIssues, "", SWT.WRAP);
		textEquipment.setBounds(10, 22, 310, 75);
		textEquipment.addModifyListener(modListener);

		Label lblEnterAnyOngoing = formToolkit.createLabel(grpEquipmentredundancyIssues,
				"Enter any ongoing equipment or redundancy issues (e.g. ESPN backup "
						+ "down, OP-2 stand alone 1 not working, etc...)",
				SWT.WRAP);
		lblEnterAnyOngoing.setBounds(10, 103, 310, 30);

		Group grpSpecialMonitoringRequests = new Group(composite, SWT.NONE);
		grpSpecialMonitoringRequests.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		grpSpecialMonitoringRequests.setText("Special Monitoring Requests");
		grpSpecialMonitoringRequests.setBounds(357, 418, 330, 136);
		formToolkit.adapt(grpSpecialMonitoringRequests);
		formToolkit.paintBordersFor(grpSpecialMonitoringRequests);

		textMonitoring = formToolkit.createText(grpSpecialMonitoringRequests, "", SWT.WRAP);
		textMonitoring.setBounds(10, 22, 310, 75);
		textMonitoring.addModifyListener(modListener);

		Label lblEnterAnySpecial = formToolkit.createLabel(grpSpecialMonitoringRequests,
				"Enter any special monitoring requests (e.g. Negative crawls, "
						+ "high-profile broadcasts or discrepancies, etc...)",
				SWT.WRAP);
		lblEnterAnySpecial.setBounds(10, 103, 310, 30);

		Group group = new Group(scrldfrmCheyenneTocLead.getBody(), SWT.NONE);
		group.setBackground(SWTResourceManager.getColor(255, 255, 255));
		group.setBounds(780, 10, 376, 82);
		formToolkit.adapt(group);
		formToolkit.paintBordersFor(group);

		Label lblDate = formToolkit.createLabel(group, "Date and Time:", SWT.NONE);
		lblDate.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblDate.setBounds(10, 22, 95, 17);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/dd/yyyy, HH:mm");
		LocalDateTime now = LocalDateTime.now();
		String time = dtf.format(now);
		txtDate = formToolkit.createText(group, "New Text", SWT.READ_ONLY);
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

		txtName = formToolkit.createText(group, "New Text", SWT.READ_ONLY);
		txtName.setBounds(56, 45, 178, 20);
		txtName.setEditable(false);
		txtName.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		txtName.setText(System.getProperty("user.name"));

		shift = Code.getShiftText();
		txtShift = formToolkit.createText(group, "", SWT.READ_ONLY);
		txtShift.setText(shift);
		txtShift.setBounds(305, 18, 60, 21);

		Group grpDailyChecklist = new Group(scrldfrmCheyenneTocLead.getBody(), SWT.NONE);
		grpDailyChecklist.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		grpDailyChecklist.setText("Daily Checklist");
		grpDailyChecklist.setBounds(730, 98, 460, 370);
		formToolkit.adapt(grpDailyChecklist);
		formToolkit.paintBordersFor(grpDailyChecklist);

		Label lblEaWaItx = formToolkit.createLabel(grpDailyChecklist, "EA_WA_ITX_Spreadsheet Verified for Accuracy: ",
				SWT.NONE);
		lblEaWaItx.setBounds(10, 25, 300, 15);

		Label lblEaWaItxPlayout = formToolkit.createLabel(grpDailyChecklist, "EA_WA_ITX_Spreadsheet Playouts Verified: \t",
				SWT.NONE);
		lblEaWaItxPlayout.setBounds(10, 45, 300, 15);

		Label lblChannelLaunchActivities = formToolkit.createLabel(grpDailyChecklist,
				"Channel Launch Verification Spreadsheet:\t", SWT.NONE);
		lblChannelLaunchActivities.setBounds(10, 65, 300, 15);

		Label lblWeatherMaps = formToolkit.createLabel(grpDailyChecklist, "Ensure Weather Maps is functioning:\t",
				SWT.NONE);
		lblWeatherMaps.setBounds(10, 85, 300, 15);

		Label lblInteractiveChecks = formToolkit.createLabel(grpDailyChecklist, "Perform interactive channel checks:",
				SWT.NONE);
		lblInteractiveChecks.setBounds(10, 105, 300, 15);

		Label lblDailySweeps = formToolkit.createLabel(grpDailyChecklist, "Daily Lead Sweeps:", SWT.NONE);
		lblDailySweeps.setBounds(10, 125, 300, 15);

		Label lblMidsOnly = formToolkit.createLabel(grpDailyChecklist, "Mids only:", SWT.NONE);
		lblMidsOnly.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblMidsOnly.setBounds(10, 165, 70, 20);

		Label lblMaintenanceRestored = formToolkit.createLabel(grpDailyChecklist,
				"Verify restoration of scheduled maintenance:\t", SWT.NONE);
		lblMaintenanceRestored.setBounds(10, 185, 300, 15);

		Label lblDaysOnly = formToolkit.createLabel(grpDailyChecklist, "Days only:", SWT.NONE);
		lblDaysOnly.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblDaysOnly.setBounds(10, 225, 70, 20);

		Label lblTurnerservices = formToolkit.createLabel(grpDailyChecklist,
				"Update the STB Turner Services every Thursday:", SWT.NONE);
		lblTurnerservices.setBounds(10, 245, 300, 15);

		Label lblPreliminaryKciReport = formToolkit.createLabel(grpDailyChecklist, "Respond to the Preliminary KCI Report:",
				SWT.NONE);
		lblPreliminaryKciReport.setBounds(10, 265, 300, 15);

		Label lblSkdlActivation = formToolkit.createLabel(grpDailyChecklist,
				"Ensure SKDL alarms have been uninhibited at 09:00 MT:", SWT.NONE);
		lblSkdlActivation.setBounds(10, 285, 300, 15);

		Label lblSwingsOnly = formToolkit.createLabel(grpDailyChecklist, "Swings only:", SWT.NONE);
		lblSwingsOnly.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblSwingsOnly.setBounds(10, 325, 80, 20);

		Label lblMcSwitches = formToolkit.createLabel(grpDailyChecklist,
				"Ensure all prime-time MC switches are successful:", SWT.NONE);
		lblMcSwitches.setBounds(10, 345, 300, 15);

		Button btnEaWaItxComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnEaWaItxComplete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				eaWaItxComplete = btnEaWaItxComplete.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
			}
		});
		btnEaWaItxComplete.setBounds(338, 25, 93, 16);
		formToolkit.adapt(btnEaWaItxComplete, true, true);
		btnEaWaItxComplete.setText("Complete");

		Button btnEaWaItxPlayoutComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnEaWaItxPlayoutComplete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				eaWaItxPlayoutComplete = btnEaWaItxPlayoutComplete.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
			}
		});
		btnEaWaItxPlayoutComplete.setBounds(338, 45, 93, 16);
		formToolkit.adapt(btnEaWaItxPlayoutComplete, true, true);
		btnEaWaItxPlayoutComplete.setText("Complete");

		Button btnChannelLaunchComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnChannelLaunchComplete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				channelLaunchComplete = btnChannelLaunchComplete.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
			}
		});
		btnChannelLaunchComplete.setBounds(338, 65, 93, 16);
		formToolkit.adapt(btnChannelLaunchComplete, true, true);
		btnChannelLaunchComplete.setText("Complete");

		Button btnWeatherComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnWeatherComplete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				weatherComplete = btnWeatherComplete.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
			}
		});
		btnWeatherComplete.setBounds(338, 85, 93, 16);
		formToolkit.adapt(btnWeatherComplete, true, true);
		btnWeatherComplete.setText("Complete");

		Button btnInteractiveComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnInteractiveComplete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				interactiveComplete = btnInteractiveComplete.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
			}
		});
		btnInteractiveComplete.setBounds(338, 105, 93, 16);
		formToolkit.adapt(btnInteractiveComplete, true, true);
		btnInteractiveComplete.setText("Complete");

		Button btnDailySweepsComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnDailySweepsComplete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dailySweeps = btnDailySweepsComplete.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
			}
		});
		btnDailySweepsComplete.setBounds(338, 125, 93, 16);
		formToolkit.adapt(btnDailySweepsComplete, true, true);
		btnDailySweepsComplete.setText("Complete");

		Button btnMaintenanceComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnMaintenanceComplete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				maintenanceComplete = btnMaintenanceComplete.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
			}
		});
		btnMaintenanceComplete.setBounds(338, 185, 93, 16);
		formToolkit.adapt(btnMaintenanceComplete, true, true);
		btnMaintenanceComplete.setText("Complete");

		Button btnTurnerComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnTurnerComplete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				turnerComplete = btnTurnerComplete.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
			}
		});
		btnTurnerComplete.setBounds(338, 245, 93, 16);
		formToolkit.adapt(btnTurnerComplete, true, true);
		btnTurnerComplete.setText("Complete");

		Button btnPreliminaryKciComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnPreliminaryKciComplete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				preliminaryKciComplete = btnPreliminaryKciComplete.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
			}
		});
		btnPreliminaryKciComplete.setBounds(338, 265, 93, 16);
		formToolkit.adapt(btnPreliminaryKciComplete, true, true);
		btnPreliminaryKciComplete.setText("Complete");

		Button btnSkdlComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnSkdlComplete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				skdlComplete = btnSkdlComplete.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
			}
		});
		btnSkdlComplete.setBounds(338, 285, 93, 16);
		formToolkit.adapt(btnSkdlComplete, true, true);
		btnSkdlComplete.setText("Complete");

		Button btnMcSwitchesComplete = new Button(grpDailyChecklist, SWT.CHECK);
		btnMcSwitchesComplete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mcSwitchesComplete = btnMcSwitchesComplete.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
			}
		});
		btnMcSwitchesComplete.setBounds(338, 345, 93, 16);
		formToolkit.adapt(btnMcSwitchesComplete, true, true);
		btnMcSwitchesComplete.setText("Complete");

		Label lblOncomingLead = formToolkit.createLabel(scrldfrmCheyenneTocLead.getBody(), "Oncoming Lead:", SWT.NONE);
		lblOncomingLead.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblOncomingLead.setBounds(730, 481, 100, 20);

		txtOncomingLead = formToolkit.createText(scrldfrmCheyenneTocLead.getBody(), "Oncoming Lead", SWT.NONE);
		txtOncomingLead.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				txtOncomingLead.selectAll();
			}
		});
		txtOncomingLead.setBounds(730, 507, 200, 20);
		txtOncomingLead.addModifyListener(modListener);

		Button btnPassdownAccepted = new Button(scrldfrmCheyenneTocLead.getBody(), SWT.CHECK);
		btnPassdownAccepted.setBounds(940, 480, 127, 20);
		formToolkit.adapt(btnPassdownAccepted, true, true);
		btnPassdownAccepted.setText("Passdown Accepted");

		Button btnPassdownDeclined = new Button(scrldfrmCheyenneTocLead.getBody(), SWT.CHECK);
		btnPassdownDeclined.setBounds(940, 505, 127, 20);
		formToolkit.adapt(btnPassdownDeclined, true, true);
		btnPassdownDeclined.setText("Passdown Declined");

		btnPassdownAccepted.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				passdownAccepted = btnPassdownAccepted.getSelection();
				btnPassdownDeclined.setSelection(false);
				passdownDeclined = btnPassdownDeclined.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
			}
		});
		btnPassdownDeclined.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				passdownDeclined = btnPassdownDeclined.getSelection();
				btnPassdownAccepted.setSelection(false);
				passdownAccepted = btnPassdownAccepted.getSelection();
				lblEditTime.setText(LocalDateTime.now().format(formatter));
			}
		});

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
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					saveAndClose();
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSave.setForeground(SWTResourceManager.getColor(0, 0, 0));
		btnSave.setBounds(1070, 498, 120, 25);
		btnSave.setBackground(display.getSystemColor(SWT.COLOR_GRAY));

		Label lblLastEdit = new Label(scrldfrmCheyenneTocLead.getBody(), SWT.NONE);
		lblLastEdit.setBounds(909, 592, 55, 15);
		formToolkit.adapt(lblLastEdit, true, true);
		lblLastEdit.setText("Last edit:");

//		btnSave.addSelectionListener(widgetSelectedAdapter(e -> {
//			try {
//				saveAndClose();
//			} catch (IOException | URISyntaxException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}));

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

	protected void saveAndClose() throws IOException, URISyntaxException {
		DataObject obj = new DataObject();
		File oldBackup = new File(BACKUP_FILE_PATH);
		oldBackup.delete();
		Files.copy(new File(FILE_PATH).toPath(), new File(BACKUP_FILE_PATH).toPath());
		File oldData = new File(FILE_PATH);
		oldData.renameTo(new File(BACKUP_FILE_PATH));

		File data = new File("src\\datastore\\passdown_datastore.pd");

		DateTimeFormatter date = DateTimeFormatter.ofPattern("M/d/yyyy");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime now;
		StringBuilder sb = new StringBuilder();
		if (shift == "Mids") {
			now = LocalDateTime.now().plusDays(1);
		} else {
			now = LocalDateTime.now();
		}
		String formattedDate = date.format(now);
		String formattedTime = time.format(now);
		sb.append(formattedDate + ";--" + txtName.getText() + ";--" + txtShift.getText() + ";--");

		for (int i = 0; i < buttonValues.length; i++) {
			sb.append(buttonValues[i] + ";--");
			if(buttonValues[i] == true) {
				obj.employees[i] = true;
			}
		}
		sb.append(text.getText() + ";--" + text1.getText() + ";--" + text2.getText() + ";--" + text3.getText() + ";--"
				+ text4.getText() + ";--" + text5.getText() + ";--" + text6.getText() + ";--" + text7.getText() + ";--"
				+ text8.getText() + ";--" + text9.getText() + ";--");

		TableItem item;
		for (int i = 0; i <= 10; i++) {
			item = table.getItem(i);
			sb.append(item.getText(0) + ";--" + item.getText(1) + ";--");
		}
		sb.append(textTakedowns.getText() + ";--" + textIdRequests.getText() + ";--" + textEquipment.getText() + ";--"
				+ textMonitoring.getText() + ";--");
		sb.append(eaWaItxComplete + ";--" + eaWaItxPlayoutComplete + ";--" + channelLaunchComplete + ";--" + weatherComplete
				+ ";--" + interactiveComplete + ";--" + dailySweeps + ";--" + maintenanceComplete + ";--" + turnerComplete
				+ ";--" + preliminaryKciComplete + ";--" + skdlComplete + ";--" + mcSwitchesComplete + ";--");
		sb.append(txtOncomingLead.getText() + ";--" + passdownAccepted + ";--" + passdownDeclined);
		for (int i = 0; i < empArray.length; i++) {
			sb.append(";--" + empArray[i]);
		}
		sb.append(";--" + formattedTime + ";--" + lblEditTime.getText());
		sb.append("\n");

		FileWriter writer = new FileWriter(data, true);

		writer.write(sb.toString());
		writer.close();
		this.close();
		

		String line = sb.toString();
		System.out.println(line);
		String[] splitLine = line.split(";--");
//		for(int i = 0; i < splitLine.length; i++) {
//			System.out.println(splitLine[i]);
//		}
		obj = Code.setDataObject(obj, splitLine);
//		System.out.println(obj);
		forms.HtmlEmailSender.sendEMail(obj);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
