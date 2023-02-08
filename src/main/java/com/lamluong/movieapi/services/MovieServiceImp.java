package com.lamluong.movieapi.services;

import com.lamluong.movieapi.documents.Movie;
import com.lamluong.movieapi.exception.DomainException;
import com.lamluong.movieapi.exception.ErrorCode;
import com.lamluong.movieapi.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImp implements MovieService {

    final MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @Override
    public Movie getById(String id) {
        return movieRepository.findMovieByImdbId(id).orElseThrow(()-> new DomainException(ErrorCode.GET_ALL_MOVIE_ERROR));
    }

    @Override
    public Movie getByObjectId(ObjectId id) {
        return movieRepository.findById(id).get();
    }
}
