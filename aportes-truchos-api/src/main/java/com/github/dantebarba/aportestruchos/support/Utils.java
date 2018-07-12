package com.github.dantebarba.aportestruchos.support;

public class Utils {

	public static String normalizar(String data) {
		if (data == null)
			return "";

		return data.trim().replace(".", "").replace("-", "");
	}

}
