package com.cjburkey.evosim;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Debug {
	
	private static Logger logger = LogManager.getLogger("evosim");
	
	public static void log(Object msg) {
		log(msg, new Object[0]);
	}
	
	public static void log(Object msg, Object... args) {
		logger.info(sanitize(msg), args);
	}
	
	public static void logWarning(Object msg) {
		logWarning(msg, new Object[0]);
	}
	
	public static void logWarning(Object msg, Object... args) {
		logger.warn(sanitize(msg), args);
	}
	
	public static void logError(Object msg) {
		logError(msg, new Object[0]);
	}
	
	public static void logError(Object msg, Object... args) {
		logger.error(sanitize(msg), args);
	}
	
	public static void logException(Throwable t) {
		logger.error(t.getMessage());
		StackTraceElement[] ste = t.getStackTrace();
		for (StackTraceElement e : ste) {
			logger.error("  " + e.toString());
		}
	}
	
	private static String sanitize(Object input) {
		return (input == null) ? "null" : input.toString();
	}
	
}