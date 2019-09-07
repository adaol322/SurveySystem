package surveys.REST;

import surveys.Beans.AnswersBean;
import surveys.DTO.AnswersDTO;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("answers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AnswersREST {

    @EJB
    AnswersBean answersBean;

    @POST
    @Path("/add")
    public Response saveAnswer(AnswersDTO answersDTO) {
        answersBean.createAnswer(answersDTO);
        return Response.ok().build();
    }

    @GET
    public Response getAnswers(){
        return Response.ok(answersBean.getAnswers()).build();
    }


}
