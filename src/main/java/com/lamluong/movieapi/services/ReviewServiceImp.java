package com.lamluong.movieapi.services;

import com.lamluong.movieapi.documents.Movie;
import com.lamluong.movieapi.documents.Review;
import com.lamluong.movieapi.exception.DomainException;
import com.lamluong.movieapi.exception.ErrorCode;
import com.lamluong.movieapi.repository.MovieRepository;
import com.lamluong.movieapi.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewServiceImp implements ReviewService{

    final ReviewRepository reviewRepository;

    final MovieRepository movieRepository;
    final MongoTemplate mongoTemplate;

    @Override
    public Review createReview(String id, String content) {
        Review review = Review.builder().content(content).build();
        Movie movie = movieRepository.findMovieByImdbId(id).orElseThrow( () -> new DomainException(ErrorCode.GET_BY_ID_ERROR));
        
        reviewRepository.insert(review);
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(id))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }
}
