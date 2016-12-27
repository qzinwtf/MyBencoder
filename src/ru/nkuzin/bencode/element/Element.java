package ru.nkuzin.bencode.element;

public abstract  class Element<V> implements Encodable {

	protected  V value;

	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
}
