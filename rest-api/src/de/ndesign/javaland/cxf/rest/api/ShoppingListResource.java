package de.ndesign.javaland.cxf.rest.api;

import java.util.Collection;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Produces("application/json")
public interface ShoppingListResource {
	@GET
	@Path("/{id}")
	ShoppingList get(@PathParam("id") Integer id);

	@PUT
	void addOrUpdate(ShoppingList list);

	@PUT
	@Path("/{id}/addEntry")
	void addEntry(@PathParam("id") Integer id, ListEntry entry);

	@DELETE
	@Path("/{id}")
	void delete(@PathParam("id") Integer id);

	@GET
	Collection<ShoppingList> getAll();

	@GET
	@Path("/{id}/entries")
	Collection<ListEntry> getEntries(@PathParam("id") Integer id);
}
