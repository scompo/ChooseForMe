package com.github.scompo.chooseforme.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AllStuff extends ArrayList<StuffToChoose> {

	private static final long serialVersionUID = 3401471504840787452L;

	public AllStuff() {
		super();
	}

	public AllStuff(Collection<? extends StuffToChoose> c) {
		super(c);
	}

	public AllStuff(int initialCapacity) {
		super(initialCapacity);
	}

	@Override
	public String toString() {
		return "AllStuff [toString()=" + super.toString() + "]";
	}

}
