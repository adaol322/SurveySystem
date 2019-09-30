package surveys.REST;

import surveys.Beans.LecturerBean;
import surveys.Beans.SurveysBean;
import surveys.DTO.ErrorMessageDTO;
import surveys.DTO.LecturersDetailsDTO;
import surveys.Entities.Lecturers;
import surveys.Entities.Surveys;
import surveys.Utility.DTOMapper;
import surveys.Utility.Messages;
import surveys.Utility.Result;
import surveys.Utility.Validate;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("lecturers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LecturerREST {
    @EJB
    LecturerBean lecturerBean;

    @EJB
    SurveysBean surveysBean;

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

    @GET
    @Path("{id}/details")
    public Response getDetailsById(@PathParam("id") Long id){
        Optional<Lecturers> lecturer = Optional.ofNullable(lecturerBean.find(id));
        if(!lecturer.isPresent())
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(Messages.WRONG_ID)
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        return Response.ok(dtoMapper.mapToLecturersDetailsDTO(lecturer.get())).build();
    }

    @PUT
    @Path("/modify")
    public Response editLecturer(LecturersDetailsDTO lecturersDetailsDTO) {
        ErrorMessageDTO errorMessageDTO = Validate.validateLecturersDetailsDTO(lecturersDetailsDTO);
        if(!errorMessageDTO.getErrorMessages().isEmpty()){
            return getErrorMessageResponse(errorMessageDTO);
        }
        Result result = lecturerBean.edit(lecturersDetailsDTO);
        if(result == Result.FAILURE)
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(Messages.WRONG_ID)
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        return Response.ok(Messages.EDITED_SUCCESSFULLY).type(MediaType.TEXT_PLAIN).build();
    }

    private Response getErrorMessageResponse(ErrorMessageDTO errorMessageDTO) {
        String errorMessage = String.join("\n", errorMessageDTO.getErrorMessages());
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(errorMessage)
                .build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteLecturer(@PathParam("id") Long id){
        List<Surveys> asd = surveysBean.lecturerHasSurvey(id);
        if(!asd.isEmpty()){
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(Messages.LECTURER_IN_SURVEY_CANNOT_REMOVE)
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
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
    public Response createLecturer(LecturersDetailsDTO lecturersDetailsDTO){
        ErrorMessageDTO errorMessageDTO = Validate.validateLecturersDetailsDTO(lecturersDetailsDTO);
        if(!errorMessageDTO.getErrorMessages().isEmpty()){
            return getErrorMessageResponse(errorMessageDTO);
        }
        lecturerBean.create(lecturersDetailsDTO);
        return Response.ok("Lecturer added successfully.").type(MediaType.TEXT_PLAIN).build();
    }
}
