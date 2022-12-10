package br.com.aldeir.model;

public class Tst{
	int ini=0,fim=25;
	public void print(){
		String a = new String("aldeir");
		String b = new String("aldeir");
		
		System.out.println(a==b);
		System.out.println(ini+fim);
		}
	{ini=fim%7; fim=ini*3;}
	
	public Tst(int a, int b){
		ini+=a; fim+=b;
		}
	
	{ini/=2; fim+=10;}
}

