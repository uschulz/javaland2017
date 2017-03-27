package de.ndesign.javaland.cxf.soap.api;

import java.util.Collection;

import javax.jws.WebService;

@WebService
public interface ShoppingListResource {
	ShoppingList get(Integer id);

	void addOrUpdate(ShoppingList list);

	void addEntry(Integer id, ListEntry entry);

	void delete(Integer id);

	Collection<ShoppingList> getAll();

	Collection<ListEntry> getEntries(Integer id);
}
