package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.RequestLine;
import org.apache.http.annotation.Immutable;






































@Immutable
public class RequestConnControl
  implements HttpRequestInterceptor
{
  public void process(HttpRequest request, HttpContext context)
    throws HttpException, IOException
  {
    if (request == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    
    String method = request.getRequestLine().getMethod();
    if (method.equalsIgnoreCase("CONNECT")) {
      return;
    }
    
    if (!request.containsHeader("Connection"))
    {

      request.addHeader("Connection", "Keep-Alive");
    }
  }
}