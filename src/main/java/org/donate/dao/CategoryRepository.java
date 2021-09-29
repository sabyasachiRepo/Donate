package org.donate.dao;

import org.donate.entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<ItemCategory,Integer> {
}
