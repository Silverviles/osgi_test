package org.silverviles.platform;

public class PlatformImpl implements Platform {

	@Override
	public void platformHealth() {
		System.out.println("Platform service is running.");
	}

}
