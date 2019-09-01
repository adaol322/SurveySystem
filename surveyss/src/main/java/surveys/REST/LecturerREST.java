package surveys.REST;

import surveys.Beans.LecturerBean;
import surveys.Entities.Lecturers;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("lecturers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LecturerREST {
    @EJB
    LecturerBean lecturerBean;

    @GET
    public List<Lecturers> getAllLecturers() {
        return lecturerBean.readAll();
    }

    @GET
    @Path("{id}")
    public String getById(@PathParam("id") Long id) {
        Lecturers lecturers = lecturerBean.find(id);
        return String.valueOf(lecturers.getName());
    }

    @POST
    @Path("/add")
    public void addLecturer(Lecturers lecturers) {
        lecturerBean.create(lecturers);
    }

    @PUT
    @Path("/modify/{id}")
    public void editLecturer(@PathParam("id") Long id) {
        lecturerBean.edit(id);
    }
}
