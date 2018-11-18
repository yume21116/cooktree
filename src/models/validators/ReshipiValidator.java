package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Picture;
import models.Reshipi;

public class ReshipiValidator {
    public static List<String> validate(Reshipi r, Picture p){


       List<String> errors = new ArrayList<String>();


        String name_error = _validateName(r.getName());
        if(!name_error.equals("")){
            errors.add("レシピ名が未入力です");
        }

        String content_error = _validateContent(r.getContent());
        if(!content_error.equals("")){
            errors.add("作り方が未入力です");
        }

        String file_name_error = _validatePicture(p.getFile_name());
        if(!file_name_error.equals("")){
            errors.add("画像を選択してください");
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
            return "作り方を入力してください。";
        }
        return "";
    }

    private static String _validatePicture(String file_name){
        if(file_name == null || file_name.equals("")){
            return "画像を選択してください。";
        }
        return "";
    }
}
