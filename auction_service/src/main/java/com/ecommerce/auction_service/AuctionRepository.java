package com.ecommerce.auction_service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuctionRepository extends JpaRepository<Auction, Integer> {
    Optional<Auction> findByauctioneditemid(int auctioneditemid);
}
