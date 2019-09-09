package com.chassot.vote.to.eat.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chassot.vote.to.eat.api.model.WinnerHistory;

public interface WinnerHistoryRepository extends JpaRepository<WinnerHistory, Long> {

}
