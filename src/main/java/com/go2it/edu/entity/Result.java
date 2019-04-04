package com.go2it.edu.entity;

/**
 * @author Alex Ryzhkov
 */
public class Result {
	private String name;
	private double sum;
	private long count;

	public Result() {
	}

	public Result(String name, long count, double sum) {
		this.name = name;
		this.sum = sum;
		this.count = count;
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

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Result{" + "name='" + name + '\'' + ", sum=" + sum + ", count=" + count + '}';
	}
}