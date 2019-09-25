package surveys.REST;

import surveys.Beans.LecturerBean;
import surveys.DTO.LecturersDTO;
import surveys.Entities.Lecturers;
import surveys.Utility.DTOMapper;
import surveys.Utility.Messages;
import surveys.Utility.Result;
import surveys.Utility.Validate;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("lecturers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LecturerREST {
    @EJB
    LecturerBean lecturerBean;

    @Inject
    DTOMapper dtoMapper;

    @GET
    public Response getAllLecturers() {
        return Response.ok(lecturerBean.readAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Long id) {
        Optional<Lecturers> lecturer = Optional.ofNullable(lecturerBean.find(id));
        if(!lecturer.isPresent())
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(Messages.WRONG_ID)
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        return Response.ok(dtoMapper.mapToLecturersDTO(lecturer.get())).build();
    }

    @PUT
    @Path("/modify")
    public Response editLecturer(LecturersDTO lecturersDTO) {
        Result result = lecturerBean.edit(lecturersDTO);
        if(result == Result.FAILURE)
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(Messages.WRONG_ID)
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        return Response.ok(Messages.EDITED_SUCCESSFULLY).type(MediaType.TEXT_PLAIN).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteLecturer(@PathParam("id") Long id){
        Result result = lecturerBean.delete(id);
        if(result == Result.FAILURE)
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(Messages.WRONG_ID)
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        return Response.ok(Messages.DELETED_SUCCESSFULLY).type(MediaType.TEXT_PLAIN).build();
    }

    @POST
    @Path("/add")
    public Response createLecturer(LecturersDTO lecturersDTO){
        if(!Validate.validateString(lecturersDTO.getName()) ||
            !Validate.validateString(lecturersDTO.getSurname()))
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(Messages.NAME_LETTERS_ONLY)
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        lecturerBean.create(lecturersDTO);
        return Response.ok("Lecturer added.").type(MediaType.TEXT_PLAIN).build();
    }
}
