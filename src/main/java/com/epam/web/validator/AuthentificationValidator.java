package com.epam.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthentificationValidator implements Validator {
    private final static String AUTHENTIFICATION_PATTERN = "^\\b[\\w\\d]{4,50}\\b$";
    private final static Pattern pattern = Pattern.compile(AUTHENTIFICATION_PATTERN);

    public AuthentificationValidator() {
    }

    @Override
    public boolean validate(String content) {
        Matcher matcher = pattern.matcher(content);
        return matcher.find();
    }
}
