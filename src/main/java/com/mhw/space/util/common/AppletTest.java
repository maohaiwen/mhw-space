package com.mhw.space.util.common;

import java.applet.Applet;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AppletTest extends Applet{

	@Override
	public void init() {
		
	}

	@Override
	public void start() {
		System.out.println("aaaaaaaaaaaaaaa");
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					ServerSocket ss = new ServerSocket(8888);
					while (true) {
						Socket socket = ss.accept();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
