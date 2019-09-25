package surveys.REST;

import surveys.Beans.SurveysBean;
import surveys.DTO.SurveysDTO;
import surveys.Entities.Surveys;
import surveys.Utility.DTOMapper;
import surveys.Utility.Messages;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("surveys")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SurveysREST {

    @EJB
    SurveysBean surveysBean;

    @GET
    public Response getAllSurveys() {
        List<SurveysDTO> sur = surveysBean.readAll();
        return Response.ok(sur).build();
    }

    @GET
    @Path("{id}")
    public Response getSurveyById(@PathParam("id") Long id){
        Optional<SurveysDTO> surveysDTO = Optional.ofNullable(surveysBean.find(id));
        if(!surveysDTO.isPresent())
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(Messages.WRONG_ID)
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        return Response.ok(surveysDTO.get()).build();
    }

    @POST
    @Path("/add")
    public void createSurvey(SurveysDTO surveysDTO) {
        surveysBean.create(surveysDTO);
    }


}
