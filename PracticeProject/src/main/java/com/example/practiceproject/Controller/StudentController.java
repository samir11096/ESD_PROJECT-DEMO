package com.example.practiceproject.Controller;

import com.example.practiceproject.Bean.Student;
import com.example.practiceproject.Service.StudentService;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("student")
public class StudentController {
    StudentService studentService = new StudentService();

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Student student){
        Student loggedInStudent = studentService.login(student);

        if(loggedInStudent== null){
            return Response.status(401).build();//Unauthorised error
        }
        else{
            return Response.ok().entity(loggedInStudent).build();
        }
    }



}
