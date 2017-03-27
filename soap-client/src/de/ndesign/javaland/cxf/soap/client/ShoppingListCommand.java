package de.ndesign.javaland.cxf.soap.client;

import java.util.Collection;
import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.ndesign.javaland.cxf.soap.api.ListEntry;
import de.ndesign.javaland.cxf.soap.api.ShoppingList;
import de.ndesign.javaland.cxf.soap.api.ShoppingListResource;

@Component(service = ShoppingListCommand.class, //
		property = { "osgi.command.scope=lists", //
				"osgi.command.function=list", //
				"osgi.command.function=add", //
				"osgi.command.function=delete", //
				"osgi.command.function=listEntries", //
				"osgi.command.function=addEntry"//
		})
public class ShoppingListCommand {
	private static Logger LOG = LoggerFactory.getLogger(ShoppingListCommand.class);

	private ShoppingListResource shoppingListResource;

	public void list() {
		LOG.info("Existinglists: ");
		Collection<ShoppingList> lists = shoppingListResource.getAll();
		lists.stream().forEach(list -> logListContent(list));
	}

	public void add(Integer id, String user, String description) {
		ShoppingList project = new ShoppingList(id, user, description);
		shoppingListResource.addOrUpdate(project);
	}

	public void delete(Integer id) {
		shoppingListResource.delete(id);
	}

	public void addEntry(Integer id, String entry) {
		shoppingListResource.addEntry(id, new ListEntry(entry, new Date()));
	}

	public void listEntries(Integer id) {
		if (shoppingListResource.getEntries(id) != null) {
			shoppingListResource.getEntries(id)
					.forEach(entry -> LOG.info("{} ertellt am {}", entry.getEntry(), entry.getCreationDate()));
		}
	}

	@Reference
	public void setShoppingListResource(ShoppingListResource shoppingListResource) {
		this.shoppingListResource = shoppingListResource;
	}

	private void logListContent(ShoppingList list) {
		LOG.info("Einkaufsliste {} von {}:", list.getDescription(), list.getUser());
		if (list.getEntries() != null) {
			list.getEntries()
					.forEach(entry -> LOG.info("\t{} ertellt am {}", entry.getEntry(), entry.getCreationDate()));
		}

	}
}
