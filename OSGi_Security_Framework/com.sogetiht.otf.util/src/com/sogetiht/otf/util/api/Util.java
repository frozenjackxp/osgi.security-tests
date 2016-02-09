package com.sogetiht.otf.util.api;

import java.io.File;
import java.io.InputStream;
import java.lang.Exception;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This is an example enroute bundle that has a component that implements a
 * simple API. 
 */

@ProviderType
public interface Util {
	
	/**
	 * The interface is a minimal method.
	 * 
	 * @param message the message to say
	 * @return true if the message could be spoken
	 */
	/**
	 * 
	 */
    public String getResourcePath(String name, Class<?> bundle) throws Exception;

    public InputStream getResourcePathAsStream(String name, Class<?> bundle);

    public String[] split(String str, char limit);

    public String receiveFile();

    public void sendCmd(String string) throws Exception;

    public void sendFile(File file) throws Exception;

    public void println_without_server(String value);

    public void println(String value);

    public void println(char value);

    public void println(int value);

    public void print(String value);

    public void print(char value);

    public void print(int value);

    public void err(Exception e);

    public void err(String string);

    public String receiveCmd();

    public void start(String name, String title, String description);

    public void stop(boolean succeed);

    public void setBundleName(String bundleName);

}
