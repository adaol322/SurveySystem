package surveys.DTO;

import java.util.ArrayList;
import java.util.Collection;

public class ErrorMessageDTO {
    Collection<String> errorMessages;

    public ErrorMessageDTO(){
        errorMessages = new ArrayList<>();
    }

    public void addErrorMessage(String errorMessage){
        errorMessages.add(errorMessage);
    }

    public Collection<String> getErrorMessages(){
        return errorMessages;
    }
}
