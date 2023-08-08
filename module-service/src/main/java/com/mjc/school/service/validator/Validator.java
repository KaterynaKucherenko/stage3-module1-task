package com.mjc.school.service.validator;

import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.ExceptionAndErrors.ValidateException;


public class Validator {
    public Validator(){

    }
    public void validate(NewsDto newsDto) throws ValidateException {
        String title =  newsDto.getTitle();
        if (title.length()<5) throw new ValidateException("Title should not be less than 5.");
        if (title.length()>30) throw new ValidateException("Title should not be greater than 30.");
        String content = newsDto.getContent();
        if (content.length()<5) throw new ValidateException("Content should not be less than 5.");
        if (content.length()>255) throw new ValidateException("Content should not be greater than 255.");
        long authorID = newsDto.getAuthorId();
        if(authorID<1 || authorID>20) throw  new ValidateException("Author's ID not in the list.");
        }
    }

