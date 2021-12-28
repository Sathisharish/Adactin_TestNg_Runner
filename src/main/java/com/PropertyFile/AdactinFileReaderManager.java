package com.PropertyFile;

import java.io.IOException;

public class AdactinFileReaderManager {

	public AdactinConfigurationReader getAdactinCR() throws IOException {

		AdactinConfigurationReader acr = new AdactinConfigurationReader();
		return acr;
	}

	public static AdactinFileReaderManager getAdactinFRM() {

		AdactinFileReaderManager afrm = new AdactinFileReaderManager();
		return afrm;

	}

	private AdactinFileReaderManager() {

	}
}
