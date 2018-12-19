package pl.javastart.model;

import javax.validation.constraints.NotNull;

import pl.javastart.common.Lang;
import pl.javastart.constraint.NotBadWord;

public class Message {
    @NotNull
   // @NotBadWord - walidator uzytkownika, w przypadku braku argumentu lang uzyje domyslnego z 
    //definicji w adnotacji NotBadWord
    private String title;
    @NotBadWord(lang = {Lang.PL, Lang.EN})
    private String content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Message(@NotNull String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
    
//settery gettery konstruktor
}