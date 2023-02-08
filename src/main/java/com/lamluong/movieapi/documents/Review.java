package com.lamluong.movieapi.documents;


import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data
@Builder
public class Review {

    @Id
    private ObjectId id;

    private String content;
}
