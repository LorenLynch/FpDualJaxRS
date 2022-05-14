package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.dao.City;
import edu.fpdual.webservice.model.manager.impl.CityManagerImpl;
import edu.fpdual.webservice.service.CityService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.print.attribute.standard.Media;
import java.sql.SQLException;
import java.util.List;

@Path("/city")
public class CityController {

    private final CityService cityService;

    public CityController(){
        this.cityService = new CityService(new CityManagerImpl());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> findAll() throws SQLException, ClassNotFoundException{
        return cityService.findAll();
    }





    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCity(@PathParam("id") Integer id) {
        try {
            City cityToDelete = cityService.findById(id);
            if (cityToDelete != null) {
                if (cityService.deleteCity(id)) {
                    return Response.status(200).entity(cityToDelete).build();
                }else{
                    return Response.status(304).entity("City Was Not Deleted").build();
                }
            } else{
                return Response.status(404).entity("City Not Found").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

}
