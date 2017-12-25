package util;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class FileOperationsHelper {
	private static Pattern pattern;
	private static Matcher matcher;
	private static final String LOG_PATTERN = "([^\\s]+(\\.(?i)(log))$)";;
	private static final String DRAWING_PATTERN = "([^\\s]+(\\.(?i)(drwg))$)";;

	/**
	 * Will open JFileChooser and return absolute path if file selected Method will
	 * do extended check for file extension, if no extension is specified it will
	 * append proper extension
	 * 
	 * @return String
	 */
	public static String showFileDialog(String filter) {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setFileFilter(new FileNameExtensionFilter("*." + filter, filter));

		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			pattern = Pattern.compile((filter.toLowerCase().equals("log")) ? LOG_PATTERN : DRAWING_PATTERN);
			matcher = pattern.matcher(selectedFile.getAbsolutePath());
			return matcher.matches() ? selectedFile.getAbsolutePath() : selectedFile.getAbsolutePath() + "." + filter;
		}
		return null;
	}
}
