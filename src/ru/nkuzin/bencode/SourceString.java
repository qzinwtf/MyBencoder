package ru.nkuzin.bencode;

public class SourceString {

	private String sourceString;
	private Integer index;
	
	public SourceString(String sourceString,Integer index){
		
		this.sourceString = sourceString;
		this.index = index;
	}
	
	public String getSourceString() {
		return sourceString;
	}
	public void setSourceString(String sourceString) {
		this.sourceString = sourceString;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public char getCurrentLetter(){
		
		return sourceString.charAt(index);
	}
	
	
	
	
}
