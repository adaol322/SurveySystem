package surveys.Utility;

import surveys.DTO.ErrorMessageDTO;
import surveys.DTO.LecturersDetailsDTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static String NAME_PATTERN = "\\p{Lu}\\p{Ll}+";
    public static String PHONE_PATTERN = "(\\d{9})|a^";
    public static String EMAIL_PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

    public static ErrorMessageDTO validateLecturersDetailsDTO(LecturersDetailsDTO lecturersDetailsDTO){
        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO();
        if(!validateName(lecturersDetailsDTO.getName())){
            errorMessageDTO.addErrorMessage(Messages.NAME_LETTERS_ONLY);
        }
        if(!validateName(lecturersDetailsDTO.getSurname())){
            errorMessageDTO.addErrorMessage(Messages.SURNAME_LETTERS_ONLY);
        }
        if(!validatePhoneNumber(lecturersDetailsDTO.getPhone())){
            errorMessageDTO.addErrorMessage(Messages.PHONE_NUMBER_WRONG);
        }
        if(!validateEmailAddress(lecturersDetailsDTO.getEmail())){
            errorMessageDTO.addErrorMessage(Messages.EMAIL_ADDRESS_WRONG);
        }
        return errorMessageDTO;
    }

    public static boolean validateName(String string){
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static boolean validatePhoneNumber(String string){
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static boolean validateEmailAddress(String string){
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    //TODO: send array of strings and fuse them together in client, then display as an alert popup
}
