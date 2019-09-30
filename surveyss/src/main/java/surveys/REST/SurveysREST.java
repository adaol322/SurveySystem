package surveys.REST;

import surveys.Beans.SurveysBean;
import surveys.DTO.AnswersDTO;
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
        List<SurveysDTO> surveysDTOS = surveysBean.readAll();
        return Response.ok(surveysDTOS).build();
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
    public Response createSurvey(SurveysDTO surveysDTO) {
        if(surveysDTO.getLecturerDTO() == null || surveysDTO.getSubjectDTO() == null)
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(Messages.CHOOSE_LECTURER_AND_SUBJECT)
                    .type(MediaType.TEXT_PLAIN)
                    .build();

        surveysBean.create(surveysDTO);
        return Response.ok(Messages.SURVEY_COMPLETED).build();
    }

    @GET
    @Path("{id}/answers")
    public Response getSurveyAnswers(@PathParam("id") Long id){
        Optional<List<AnswersDTO>> answersDTOS = Optional.ofNullable(surveysBean.getAnswersBySurveyId(id));
        if(!answersDTOS.isPresent()){
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(Messages.WRONG_ID)
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
        return Response.ok(answersDTOS.get()).build();
    }

}
