package surveys.REST;

import surveys.Beans.SubjectsBean;
import surveys.DTO.SubjectsDTO;
import surveys.Entities.Subjects;
import surveys.Utility.DTOMapper;
import surveys.Utility.Messages;
import surveys.Utility.Result;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectsREST {

    @EJB
    SubjectsBean subjectsBean;

    @Inject
    DTOMapper dtoMapper;

    @GET
    public Response getAllSubjects() {
        return Response.ok(subjectsBean.readAll()).build();
    }

    @POST
    @Path("/add")
    public void createSubject(SubjectsDTO subjectsDTO) {
        subjectsBean.create(subjectsDTO);
    }

    @GET
    @Path("{id}")
    public Response getSubjectById(@PathParam("id") Long id) {
        Optional<Subjects> subjects = Optional.ofNullable(subjectsBean.find(id));
        if (!subjects.isPresent())
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(Messages.WRONG_ID)
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        return Response.ok(dtoMapper.mapToSubjectsDTO(subjects.get())).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteSubjectById(@PathParam("id") Long id) {
        Result result = subjectsBean.delete(id);
        if (result == Result.FAILURE)
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(Messages.WRONG_ID)
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        return Response.ok(Messages.DELETED_SUCCESSFULLY).type(MediaType.TEXT_PLAIN).build();
    }

    @PUT
    @Path("/modify")
    public Response editSubject(SubjectsDTO subjectsDTO) {
        Result result = subjectsBean.edit(subjectsDTO);
        if (result == Result.FAILURE)
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(Messages.WRONG_ID)
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        return Response.ok(Messages.EDITED_SUCCESSFULLY).type(MediaType.TEXT_PLAIN).build();
    }

}
