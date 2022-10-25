package com.bastian545.grocerylist.repo;

import com.bastian545.grocerylist.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Long> {
}
