package com.lamluong.movieapi.services;

import com.lamluong.movieapi.documents.Review;
import com.lamluong.movieapi.exception.DomainException;

public interface ReviewService {

    public Review createReview(String id, String content) throws DomainException;
}
