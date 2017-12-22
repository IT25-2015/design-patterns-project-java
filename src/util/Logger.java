package util;

import javax.swing.DefaultListModel;

import model.LoggerModel;
import view.LoggerView;

public class Logger {
	private static Logger instance;
	private LoggerModel loggerModel = new LoggerModel();
	private DefaultListModel<String> dlmLogger = new DefaultListModel<String>();

	private Logger() {
	}

	/**
	 * Will add given string to logger model (List)
	 * 
	 * @param s
	 * @param toConsole
	 *            if true it will print to console as well
	 */
	public void log(String action,String s, boolean toConsole) {
		loggerModel.add(action.toUpperCase() + "_" + s);
		dlmLogger.addElement(loggerModel.peek());
		LoggerView.getLstLogger().ensureIndexIsVisible(dlmLogger.getSize() - 1); //Scroll to bottom of log automatically
		if (toConsole)
			System.out.println(loggerModel.peek());
	}

	/**
	 * Return singleton object Thread safe also using Lazy Loading
	 * 
	 * @return Logger
	 */
	public static Logger getInstance() {
		if (instance == null) {
			synchronized (Logger.class) {
				if (instance == null) {
					instance = new Logger();
				}
			}
		}
		return instance;
	}

	public DefaultListModel<String> getDlmLogger() {
		return dlmLogger;
	}
}
