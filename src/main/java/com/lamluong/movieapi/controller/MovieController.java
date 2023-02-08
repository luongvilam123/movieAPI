package com.lamluong.movieapi.controller;


import com.lamluong.movieapi.documents.Movie;
import com.lamluong.movieapi.documents.Review;
import com.lamluong.movieapi.dto.ReviewDto;
import com.lamluong.movieapi.services.MovieService;
import com.lamluong.movieapi.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class MovieController {

    final MovieService movieServiceImp;
    final ReviewService reviewServiceImp;

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieServiceImp.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable String id){
        return movieServiceImp.getById(id);
    }

    @PostMapping("/{id}")
    public Review addReview(@RequestBody ReviewDto body, @PathVariable String id){
        return reviewServiceImp.createReview(id,body.getContent());

    }

    @GetMapping("/object/{id}")
    public Movie getById(@PathVariable ObjectId id){
        return movieServiceImp.getByObjectId(id);
    }
}
