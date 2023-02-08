package com.lamluong.movieapi.services;


import com.lamluong.movieapi.documents.Movie;
import com.lamluong.movieapi.exception.DomainException;
import org.bson.types.ObjectId;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie getById(String id) throws DomainException;

    Movie getByObjectId(ObjectId id);
}
