package ru.nkuzin.bencode.element;

public abstract class Element<V> {

	protected  V value;
	public abstract String encode(); /// ��, ��� ���������� � ������ bencode
	
	
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
}
