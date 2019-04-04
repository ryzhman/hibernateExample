package com.go2it.edu.entity;

/**
 * @author Alex Ryzhkov
 */
public class Result {
	private String name;
	private double sum;

	public Result() {
	}

	public Result(String name, double sum) {
		this.name = name;
		this.sum = sum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "Result{" + "name='" + name + '\'' + ", sum=" + sum + '}';
	}
}
