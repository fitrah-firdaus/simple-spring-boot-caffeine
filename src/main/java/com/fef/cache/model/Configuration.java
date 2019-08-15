package com.fef.cache.model;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "configurations")
@Data
public class Configuration {
    @Id
    @Field("id")
    private String id;

    @JsonRawValue
    private String data;
}
