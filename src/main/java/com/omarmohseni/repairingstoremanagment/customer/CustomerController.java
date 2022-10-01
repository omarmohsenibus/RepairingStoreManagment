package com.omarmohseni.repairingstoremanagment.customer;
import com.omarmohseni.repairingstoremanagment.JDBConnection;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.print.attribute.standard.Media;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Path("/customers")
public class CustomerController {
    private final CustomerDao<Customer> dao;

    public CustomerController() throws SQLException {
        JDBConnection.setConnection(JDBConnection.JDBC_Driver_MySQL, JDBConnection.JDBC_URL_MySQL);
        dao = new CustomerDaoImpl(JDBConnection.getConnection());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomerById(@PathParam("id") Integer id){
        try{
            Customer c = dao.read(id);
            if(c != null){
                return new JSONObject(c).toString();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return "null";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomers(){
        try{
            List<Customer> customers = dao.list();
            if(!customers.isEmpty()){
                return new JSONArray(customers).toString();
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }

        return "null";
    }
}
