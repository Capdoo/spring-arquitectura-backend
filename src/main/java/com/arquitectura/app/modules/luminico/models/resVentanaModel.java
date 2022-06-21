package com.arquitectura.app.modules.luminico.models;
public class resVentanaModel {
	private double m;
	private double t;
	private double r;
	private double fldd;
	
	public resVentanaModel(double m, double t) {
		super();
		this.m = m;
		this.t = t;
		this.r = (1/Math.sqrt(1+ Math.pow(t,2)));
		this.fldd = ((Math.atan(m)*180/Math.PI) - this.r * (Math.atan(m*this.r)*180/Math.PI))/3.6;	
	}
	
	public double getM() {
		return m;
	}
	public void setM(float m) {
		this.m = m;
	}
	public double getT() {
		return t;
	}
	public void setT(float t) {
		this.t = t;
	}
	public double getR() {
		return r;
	}
	public void setR(float r) {
		this.r = r;
	}
	public double getFldd() {
		return fldd;
	}
	public void setFldd(float fldd) {
		this.fldd = fldd;
	}
	
	
}
