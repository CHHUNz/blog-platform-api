package com.kosign.dev.domain.category;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface CategoryRepository extends JpaRepository<Categories, UUID> {

    @Query("select c from Categories c order by c.name")
    List<Categories> findAllCategories();


    @Query("select c from Categories c where c.id=?1")
    Optional<Categories> updateById(UUID id);

    @Transactional
    @Modifying
    @Query("delete from Categories c where c.id = :id")
    void deleteCategoriesById(UUID id);

    @Query("select c from Categories c where c.name = :name")
    Optional<Categories> findByName(String name);
}
