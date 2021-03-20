package com.sheke.walking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheke.walking.model.Expenses;

public interface ExpenseRepository extends JpaRepository<Expenses, Integer> {

}
