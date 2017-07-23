package tw.matt.j2ee;

import java.io.IOException;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

public class MyAsyncListener  implements AsyncListener {

	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		AsyncContext asyncContext =event.getAsyncContext();
		
		
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
		// TODO Auto-generated method stub
		AsyncContext asyncContext =event.getAsyncContext();
		
	  List<AsynContext>	asyncs=(List) asyncContext.getRequest().getServletContext().getAttribute("async");
		asyncs.
		
		
	}

	@Override
	public void onStartAsync(AsyncEvent arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTimeout(AsyncEvent arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
