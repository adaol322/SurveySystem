package surveys.REST;

import surveys.Beans.LecturerBean;
import surveys.DTO.LecturersDTO;
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
    public Lecturers getById(@PathParam("id") Long id) {
        Lecturers lecturer = lecturerBean.find(id);
        return lecturer;
    }

    @POST
    @Path("/add")
    public void createLecturer(LecturersDTO lecturersDTO) {
        lecturerBean.create(lecturersDTO);
    }

    @PUT
    @Path("/modify/{id}")
    public void editLecturer(@PathParam("id") Long id) {
        lecturerBean.edit(id);
    }
}
