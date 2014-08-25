import java.io.File;

import javax.swing.filechooser.FileFilter;

public class AttendanceFileFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		if (f.isDirectory() || f.getName().indexOf("CSCI") == 0 && f.getName().toLowerCase().endsWith("csv")) {
			return true;
		}
		return false;
	}

	@Override
	public String getDescription() {
		
		// TODO Auto-generated method stub
		return "attendance Record (.csv)";
	}

}

