package org.libertya.locale.ar.electronicInvoice.utils;

import java.net.Socket;
import java.util.Hashtable;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

import org.apache.axis.components.net.BooleanHolder;
import org.apache.axis.components.net.JSSESocketFactory;

/* According to: https://stackoverflow.com/questions/34180289/how-to-enforce-an-axis-client-to-use-tlsv1-2-protocol */

public class TLS12SocketFactory extends JSSESocketFactory {
	
	protected static Integer javaMajorVersion = null;
	
    public TLS12SocketFactory(Hashtable attributes) {
        super(attributes);
    }

    @Override
    public Socket create(String host, int port, StringBuffer otherHeaders, BooleanHolder useFullURL) throws Exception{
    	// TLS1.2 es soportado a partir de Java 8
        if (getVersion()!=null && getVersion() < 8)
        	throw new RuntimeException("Se requiere Java 8 o superior para TLS1.2");
        Socket s = super.create(host, port, otherHeaders, useFullURL);
        ((SSLSocket)s).setEnabledProtocols(new String[] {/*"TLSv1.1",*/ "TLSv1.2"});
        return s;
    }
    
    protected void initFactory() throws java.io.IOException {
    	try {
	    	SSLContext context = SSLContext.getInstance("TLSv1.2");
	    	context.init(null, null, null);
	    	sslFactory = context.getSocketFactory();	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    };
    
    /** 
     * Determina la major-version de Java 
     * @return la versión correspondiente o null si no puede identificarlo
     */
    private static Integer getVersion() {
    	// Cached?
    	if (javaMajorVersion!=null) {
    		return javaMajorVersion; 
    	}
    	try {
	        String version = System.getProperty("java.version");
	        // Java 8 or lower: 1.6.0_23, 1.7.0, 1.7.0_80, 1.8.0_211
	        if(version.startsWith("1.")) {
	            version = version.substring(2, 3);
	        } else {
	        	// Java 9 or higher: 9.0.1, 11.0.4, 12, 12.0.1
	            int dot = version.indexOf(".");
	            if(dot != -1) { 
	            	version = version.substring(0, dot); 
	            }
	        } 
	        javaMajorVersion = Integer.parseInt(version);
	        return javaMajorVersion;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
}