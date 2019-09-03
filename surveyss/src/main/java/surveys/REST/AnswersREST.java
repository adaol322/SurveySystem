package surveys.REST;

import surveys.Beans.AnswersBean;
import surveys.DTO.AnswersDTO;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

        return Response.ok().build();
    }
}
