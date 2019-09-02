package surveys.REST;

import surveys.Beans.QuestionsBean;
import surveys.Entities.Questions;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("questions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuestionsREST {

    @EJB
    QuestionsBean questionsBean;

    @GET
    public List<Questions> getAllQuestions() {
        return questionsBean.readAll();
    }

    @POST
    @Path("/add")
    public void createQuestion(Questions questions) {
        questionsBean.create(questions);
    }
}
