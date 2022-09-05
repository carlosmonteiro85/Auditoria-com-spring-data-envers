package com.prototipo.audit.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Utils {

	/*
	 * Converte o timestamp em LocalDateTime
	 * */
	public static LocalDateTime converterTimestampData(Long timestamp) {
		return new Timestamp(timestamp).toLocalDateTime();
	}

}
