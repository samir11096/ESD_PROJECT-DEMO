package com.example.practiceproject.Controller;

import com.example.practiceproject.Bean.StudentPayments;
import com.example.practiceproject.Service.StudentPaymentService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("studentPayment")
public class StudentPaymentController {
    StudentPaymentService studentPaymentService = new StudentPaymentService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBills(@QueryParam("studentId") Integer studentId){
        List<StudentPayments> studentPaymentsList = studentPaymentService.getPayments(studentId);
        return Response.ok().entity(studentPaymentsList).build();
    }
}
