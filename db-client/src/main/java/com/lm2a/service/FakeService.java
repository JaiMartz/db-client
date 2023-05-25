package com.lm2a.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Service;

@Service
public class FakeService {
	
	@Autowired
	private Tracer tracer;
	
	private static final Logger log = LoggerFactory.getLogger(FakeService.class);

	public void printLog() {
		Span span1 = tracer.nextSpan().name("MiSpanA1");
		
		try(Tracer.SpanInScope ws = tracer.withSpan(span1.start())) {
			log.info("Prueba de log A1");
		} finally {
			span1.end();
		}
		
		Span span2 = tracer.nextSpan().name("MiSpanA2");
		
		try(Tracer.SpanInScope ws = tracer.withSpan(span2.start())) {
			log.info("Prueba de log A2");
		} finally {
			span1.end();
		}
		
		Span span3 = tracer.nextSpan().name("MiSpanA3");
		
		try(Tracer.SpanInScope ws = tracer.withSpan(span3.start())) {
			log.info("Prueba de log A3");
		} finally {
			span1.end();
		}
		
		log.info("Prueba de log");
	}
}
