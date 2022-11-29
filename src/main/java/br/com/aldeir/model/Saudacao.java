package br.com.aldeir.model;

public class Saudacao {
   
	private final long id;
	private final String  content;

	public Saudacao(long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	public long getId() {
		return id;
	}
	public String getContent() {
		return content;
	}
	
	
}
