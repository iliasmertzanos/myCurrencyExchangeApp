package com.microservices.zuulapigatewayserver.bean;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulLoggingFilter extends ZuulFilter{
	
	private Logger logger=LoggerFactory.getLogger(ZuulLoggingFilter.class);

	@Override
	public boolean shouldFilter() {
		//we can decise according to the request infos implementing some business logik
		//if we want to filter specific requests
		return true;
	}

	@Override
	public Object run(){
		HttpServletRequest request=RequestContext
				.getCurrentContext()
				.getRequest();
		logger.info("request->{} request uri->{}",request,request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
