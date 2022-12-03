package com.example.practiceproject.Controller;

import com.example.practiceproject.Bean.Bill;
import com.example.practiceproject.Service.BillService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.print.attribute.standard.Media;
import java.util.List;

@Path("bill")
public class BillController {
    BillService billService = new BillService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBills(@QueryParam("paymentId")Integer paymentId){
        List<Bill> billList = billService.getBills(paymentId);
        return Response.ok().entity(billList).build();
    }
}
