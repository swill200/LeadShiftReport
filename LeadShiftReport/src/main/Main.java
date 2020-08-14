package main;

import java.io.IOException;
import java.time.LocalDate;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import forms.ReportEntry;
import forms.ReportEntryFilled;

public class Main extends Shell {
	private static LocalDate date;
	private static String shift;
	private static String time;
	private static Main shell;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			shell = new Main(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public Main(Display display) {
		super(display, SWT.SHELL_TRIM);
		GridLayout gridLayout = new GridLayout(1, true);
		gridLayout.marginTop = 10;
		gridLayout.marginLeft = 100;
		setLayout(gridLayout);
		new Label(this, SWT.NONE);
		setDate(LocalDate.now());
		setShift(Code.getShiftText());
		if (shift != "Mids") {
			setTime((getDate().getMonthValue()) + "/" + getDate().getDayOfMonth() + "/" + getDate().getYear());
		} else {
			setTime((getDate().getMonthValue()) + "/" + (getDate().getDayOfMonth() + 1) + "/" + getDate().getYear());
		}
		// Button to create a new report
		Button btnNewReportEntry = new Button(this, SWT.NONE);
		GridData gd_btnNewReportEntry = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		btnNewReportEntry.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setShellVisible(false);
				try {
					Code.getPassdownData(getTime(), getShift());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!Code.getOk()) {
					ReportEntry newReport = new ReportEntry(display);
					newReport.open();
					newReport.addListener(SWT.Dispose, new Listener() {
						// Handle dispose event for new report window.
						// Main.this.setActive() brings the main window back into focus.
						@Override
						public void handleEvent(Event arg0) {
							// TODO Auto-generated method stub
							setShellVisible(true);
							Main.this.setActive();
						}
					});
				} else {
					ReportEntryFilled newReport;
					try {
						newReport = new ReportEntryFilled(display, getDate(), getShift());
						newReport.open();
						newReport.addListener(SWT.Dispose, new Listener() {
							// Handle dispose event for the filled report window.
							// Main.this.setActive() brings the main window back into focus.
							@Override
							public void handleEvent(Event arg0) {
								setShellVisible(true);
								Main.this.setActive();
							}
						});
					} catch (IllegalArgumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		gd_btnNewReportEntry.widthHint = 175;
		gd_btnNewReportEntry.heightHint = 75;
		btnNewReportEntry.setLayoutData(gd_btnNewReportEntry);
		btnNewReportEntry.setText("New Report Entry");

		// Button to view existing reports
		Button btnPreviousReports = new Button(this, SWT.NONE | SWT.WRAP);
		GridData gd_btnPreviousReports = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		btnPreviousReports.setText("Review Previous Shift Reports");
		gd_btnPreviousReports.widthHint = 175;
		gd_btnPreviousReports.heightHint = 75;
		btnPreviousReports.setLayoutData(gd_btnPreviousReports);
		btnPreviousReports.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				setShellVisible(false);
				DateSelection dateSelection = new DateSelection(display);
				dateSelection.open();
				dateSelection.addListener(SWT.Dispose, new Listener() {

					// Handle dispose event for previous report window.
					// Main.this.setActive() brings the main window back into focus.
					@Override
					public void handleEvent(Event arg0) {
						// TODO Auto-generated method stub
						setShellVisible(true);
						Main.this.setActive();
					}

				});
			}

		});

		new Label(this, SWT.NONE);
		createContents();
	}

	private void setTime(String timeSet) {
		time = timeSet;
	}

	private String getTime() {
		return time;
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Lead Tech Reporting Service");
		setSize(400, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	protected static void setDate(LocalDate date) {
		Main.date = date;
	}

	protected static LocalDate getDate() {
		return date;
	}

	public static void setShift(String shift) {
		Main.shift = shift;
	}

	protected static String getShift() {
		return shift;
	}

	protected void setShellVisible(boolean bool) {
		Main.shell.setVisible(bool);
	}

}
