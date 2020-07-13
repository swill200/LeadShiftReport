package main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import forms.PreviousReports;
import forms.ReportEntry;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Main extends Shell {

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Main shell = new Main(display);
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

		Button btnNewReportEntry = new Button(this, SWT.NONE);
		btnNewReportEntry.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ReportEntry newReport = new ReportEntry(display);
				newReport.open();
			}
		});
		GridData gd_btnNewReportEntry = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnNewReportEntry.widthHint = 175;
		gd_btnNewReportEntry.heightHint = 75;
		btnNewReportEntry.setLayoutData(gd_btnNewReportEntry);
		btnNewReportEntry.setText("New Report Entry");

		Button btnPreviousReports = new Button(this, SWT.NONE | SWT.WRAP);
		GridData gd_btnPreviousReports = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnPreviousReports.widthHint = 175;
		gd_btnPreviousReports.heightHint = 75;
		btnPreviousReports.setLayoutData(gd_btnPreviousReports);
		btnPreviousReports.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PreviousReports newPrevious = new PreviousReports(display);
				newPrevious.open();
			}
		});
		btnPreviousReports.setText("Review Previous Shift Reports");
		new Label(this, SWT.NONE);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(400, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
