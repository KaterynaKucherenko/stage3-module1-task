package com.mjc.school.service.Validator;

import com.mjc.school.service.DTO.NewsDTO;
import com.mjc.school.service.ExceptionAndErrors.ValidateException;


public class Validation {
    public Validation(){

    }
    public void validate(NewsDTO newsDTO) throws ValidateException {
        String title =  newsDTO.getTitle();
        if (title.length()<5) throw new ValidateException("Title should not be less than 5.");
        if (title.length()>30) throw new ValidateException("Title should not be greater than 30.");
        String content = newsDTO.getContent();
        if (content.length()<5) throw new ValidateException("Content should not be less than 5.");
        if (content.length()>255) throw new ValidateException("Content should not be greater than 255.");
        long authorID = newsDTO.getAuthorId();
        if(authorID<1 || authorID>20) throw  new ValidateException("Author's ID not in the list.");
        }
    }

