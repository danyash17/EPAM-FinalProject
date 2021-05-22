package com.epam.web.validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuthentificationValidatorTest {
private final String CORRECT_TEXT="johndoe";
private final String INVALID_TEXT="j<>Oh!ndoe";
    @Test
    public void tryCorrectTestValidation() {
    //given
        AuthentificationValidator validator=new AuthentificationValidator();
        //when
        boolean actual=validator.validate(CORRECT_TEXT);
        //then
        assertTrue(actual);
    }
    @Test
    public void tryInvalidTestValidation() {
        //given
        AuthentificationValidator validator=new AuthentificationValidator();
        //when
        boolean actual=validator.validate(INVALID_TEXT);
        //then
        assertFalse(actual);
    }
}