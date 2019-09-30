package surveys.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LecturersDetailsDTO {
    private Long idLecturers;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String title;
}
