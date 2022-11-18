package com.example.springtest.entities;

import com.example.springtest.enums.Status;
import com.example.springtest.exceptions.StatusDoesNotExist;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {
    @Override
    public String convertToDatabaseColumn(Status status) {
        if (status == null) {
            return null;
        }
        return status.getCode();
    }

    @Override
    public Status convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        return Stream.of(Status.values())
                .filter(t -> t.getCode().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

    }
}
