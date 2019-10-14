package com.yanesh.loterie.nationale.extractor.bean;

public class LotoTicket {
	
	private int number1;
	private int number2;
	private int number3;
	private int number4;
	private int number5;
	private int number6;
	
	public int getNumber1() {
		return number1;
	}
	public int getNumber2() {
		return number2;
	}
	public int getNumber3() {
		return number3;
	}
	public int getNumber4() {
		return number4;
	}
	public int getNumber5() {
		return number5;
	}
	public int getNumber6() {
		return number6;
	}
	
	public LotoTicket(int number1, int number2, int number3, int number4, int number5, int number6) {
		super();
		this.number1 = number1;
		this.number2 = number2;
		this.number3 = number3;
		this.number4 = number4;
		this.number5 = number5;
		this.number6 = number6;
	}
	public LotoTicket(String number1, String number2, String number3, String number4, String number5, String number6) {
		super();
		this.number1 = Integer.parseInt(number1);
		this.number2 = Integer.parseInt(number2);
		this.number3 = Integer.parseInt(number3);
		this.number4 = Integer.parseInt(number4);
		this.number5 = Integer.parseInt(number5);
		this.number6 = Integer.parseInt(number6);
	}
	
}
