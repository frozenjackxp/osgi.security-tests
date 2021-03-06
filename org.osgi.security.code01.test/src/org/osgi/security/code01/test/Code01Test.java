/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.osgi.security.code01.test;

import static org.junit.Assert.assertEquals;

import com.sun.jna.Native;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.osgi.security.test.api.OSGiSecurityTestRunner;

/**
 * @author Sogeti High Tech
 * 
 * Load of JNA (Java Native Access) related libraries to execute native code 
 * (programs based on other languages like C, C++, assembler...) from JAVA JVM.
 * 
 * This bundle loads Clibrary.java class (extension of Java Library class 
 * from JNA), which contains C printf function definition. 
 * 
 * Then, the malicious bundle will invoke printf function from this class 
 * and prints a string without using standard System.out.println() JAVA API 
 * function.
 * 
 **/

@RunWith(OSGiSecurityTestRunner.class)
public class Code01Test {
	
    @Test
    public void testCode01(){
    	CLibrary lib = (CLibrary) Native.loadLibrary("c", CLibrary.class);
    	assertEquals("[FAIL] Native code has been loaded and executed by the system,", 0, lib.puts("This line is printed by the puts() native function"));
    }
}