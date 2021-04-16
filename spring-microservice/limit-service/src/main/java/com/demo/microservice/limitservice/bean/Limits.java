package com.demo.microservice.limitservice.bean;

public class Limits {
	private int maximum;
	private int minimum;
	public Limits(int i, int j) {
		super();
		this.maximum = i;
		this.minimum = j;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	

}
