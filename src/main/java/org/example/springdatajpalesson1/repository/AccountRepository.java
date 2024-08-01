package org.example.springdatajpalesson1.repository;

import org.example.springdatajpalesson1.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {


}
