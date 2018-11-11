package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Reshipi;

public class ReshipiValidator {
    public static List<String> validate(Reshipi r){
        List<String> errors = new ArrayList<String>();
        
        String name_error = _validateName(r.getName());
        if(!name_error.equals("")){
            errors.add("nameが未入力です");
        }
        
        String content_error = _validateContent(r.getContent());
        if(!content_error.equals("")){
            errors.add("contentが未入力です");
        }
        return errors;

    }

    private static String _validateName(String name){
        if(name == null || name.equals("")){
            return "レシピ名を入力してください。";
        }
        return "";
    }

    private static String _validateContent(String content){
        if(content ==  null || content.equals("")){
            return "レシピを入力してください。";
        }
        return "";
    }
}
