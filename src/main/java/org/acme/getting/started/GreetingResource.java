package org.acme.getting.started;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.labbs.quarkusmonitor.runtime.MonitorMetrics;
import br.com.labbs.quarkusmonitor.runtime.request.RequestEvent;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    	RequestEvent requestEvent = new RequestEvent()
    		    .setType("gprc")
    		    .setStatus("OK")
    		    .setMethod("GET")
    		    .setAddress("myAddress")
    		    .setIsError(true)
    		    .setErrorMessage("my error message");
    		    
    		  //Instant start = Instant.now();
    		  
    		  //your_method();  
    		  //double timeElapsed = MonitorMetrics.calcTimeElapsedInSeconds(start);
    		  MonitorMetrics.INSTANCE.addRequestEvent(requestEvent, 1);
    		  
        return "Hello, Daysa!";
    }
}