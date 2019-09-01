package surveys.REST;

import surveys.Beans.SubjectsBean;
import surveys.Entities.Subjects;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectsREST {

    @EJB
    SubjectsBean subjectsBean;

    @GET
    public List<Subjects> getAllQuestions() {
        return subjectsBean.readAll();
    }

    @POST
    @Path("/add")
    public void addLecturer(Subjects subjects) {
        subjectsBean.create(subjects);
    }

}
