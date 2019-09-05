package surveys.REST;

import surveys.Beans.SurveysBean;
import surveys.DTO.SurveysDTO;
import surveys.Entities.Surveys;
import surveys.Utility.Mapper;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("surveys")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SurveysREST {

    @EJB
    SurveysBean surveysBean;

    @Inject
    Mapper mapper;

    @GET
    public List<Surveys> getAllQuestions() {
        return surveysBean.readAll();
    }

    @POST
    @Path("/add")
    public void createSurvey(SurveysDTO surveysDTO) {
        surveysBean.create(surveysDTO);
    }


}
