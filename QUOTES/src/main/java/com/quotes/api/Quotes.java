package com.quotes.api;

public class Quotes {

	private String anime;
	private String character;
	private String quote;

	public String getAnime() {
		return anime;
	}

	public void setAnime(String anime) {
		this.anime = anime;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	@Override
	public String toString() {
		return "Quotes [anime=" + anime + ", character=" + character + ", quote=" + quote + "]";
	}

}
