package com.gabriel.finalexercise.Repositories;

import com.gabriel.finalexercise.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
