package ru.nkuzin.bencode.element;

/**
 * Базовый класс для элементов bencode
 * @author nkuzin
 *
 * @param <V> - тип объекта
 */

public abstract  class Element<V> implements Encodable {

	protected  V value;

	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
}
