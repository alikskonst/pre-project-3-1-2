package edu.kata.task312.repository;

import edu.kata.task312.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    //Optional<Role> findOneByName(String name);
}
