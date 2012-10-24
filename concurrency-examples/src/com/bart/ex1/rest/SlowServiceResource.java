package com.bart.ex1.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bart.ex1.bean.SlowService;

@Path("slow")
@Stateless
public class SlowServiceResource {

	@Inject
	SlowService _slow;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String goSlow() {
		long start = System.currentTimeMillis();
		_slow.invoke();
		long end = System.currentTimeMillis();
		long elapsed = end - start;
		return "elapsed (millis): " + elapsed;
	}
}
