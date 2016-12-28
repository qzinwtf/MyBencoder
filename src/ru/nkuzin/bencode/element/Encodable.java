package ru.nkuzin.bencode.element;

public interface Encodable {

	/**
	 * Сериализация объекта в bencode
	 * @return строка, представляющая объект
	 */
	public String encode();
}
