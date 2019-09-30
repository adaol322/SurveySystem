package surveys.REST;

import surveys.Beans.QuestionsBean;
import surveys.DTO.QuestionsDTO;
import surveys.Entities.Questions;
import surveys.Utility.DTOMapper;
import surveys.Utility.Messages;
import surveys.Utility.Result;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("questions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuestionsREST {

    @EJB
    QuestionsBean questionsBean;

    @Inject
    DTOMapper dtoMapper;

    @GET
    public Response getAllQuestions() {
        return Response.ok(questionsBean.readAll()).build();
    }

    @POST
    @Path("/add")
    public Response createQuestion(QuestionsDTO questionsDTO) {

        questionsBean.create(questionsDTO);
        return Response.ok(Messages.QUESTION_ADDED).build();
    }

    @GET
    @Path("{id}")
    public Response getQuestionById(@PathParam("id") Long id){
        Optional<Questions> question = Optional.ofNullable(questionsBean.findById(id));
        if(!question.isPresent())
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(Messages.WRONG_ID)
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        return Response.ok(dtoMapper.mapToQuestionsDTO(question.get())).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteQuestion(@PathParam("id") Long id){
        Result result = questionsBean.delete(id);
        if(result == Result.FAILURE)
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(Messages.WRONG_ID)
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        return Response.ok(Messages.DELETED_SUCCESSFULLY).type(MediaType.TEXT_PLAIN).build();
    }
}
