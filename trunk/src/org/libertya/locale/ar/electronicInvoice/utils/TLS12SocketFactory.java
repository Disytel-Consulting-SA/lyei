package org.libertya.locale.ar.electronicInvoice.utils;

import java.net.Socket;
import java.util.Hashtable;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

import org.apache.axis.components.net.BooleanHolder;
import org.apache.axis.components.net.JSSESocketFactory;

/* According to: https://stackoverflow.com/questions/34180289/how-to-enforce-an-axis-client-to-use-tlsv1-2-protocol */

public class TLS12SocketFactory extends JSSESocketFactory {
	
    public TLS12SocketFactory(Hashtable attributes) {
        super(attributes);
    }

    @Override
    public Socket create(String host, int port, StringBuffer otherHeaders, BooleanHolder useFullURL) throws Exception{
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
    
}