package de.ndesign.javaland.cxf.soap.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import de.ndesign.javaland.cxf.soap.api.ListEntry;
import de.ndesign.javaland.cxf.soap.api.ShoppingList;
import de.ndesign.javaland.cxf.soap.api.ShoppingListResource;


@Component//
(//
		immediate = true, //
		name = "ShoppingListResource", //
		property = //
		{ //
				"service.exported.interfaces=*", //
				"service.exported.configs=org.apache.cxf.ws", //
				"org.apache.cxf.ws.address=/shoppinglists", //
				"org.apache.cxf.ws.httpservice.context=/soap"//
		} //
)
public class ShoppingListResourceImpl implements ShoppingListResource {
	Map<Integer, ShoppingList> shoppingListMap;

	@SuppressWarnings("serial")
	public ShoppingListResourceImpl() {
		shoppingListMap = new HashMap<Integer, ShoppingList>() {
			{
				put(1, new ShoppingList(1, "Hans", "Einkaufsliste 1"));
				put(2, new ShoppingList(2, "Emil", "Einkaufsliste 2"));
			}
		};

	}

	@Override
	public ShoppingList get(Integer id) {
		return shoppingListMap.get(id);
	}

	@Override
	public void addOrUpdate(ShoppingList list) {
		shoppingListMap.put(list.getId(), list);
	}

	@Override
	public Collection<ShoppingList> getAll() {
		return new ArrayList<ShoppingList>(shoppingListMap.values());
	}

	@Override
	public void delete(Integer id) {
		shoppingListMap.remove(id);
	}

	@Override
	public void addEntry(Integer id, ListEntry entry) {
		shoppingListMap.get(id).getEntries().add(entry);
	}

	@Override
	public Collection<ListEntry> getEntries(Integer id) {
		return shoppingListMap.get(id).getEntries();
	}

}
