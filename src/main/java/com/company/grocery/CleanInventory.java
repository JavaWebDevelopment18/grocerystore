package com.company.grocery;

import org.springframework.data.repository.CrudRepository;

public interface CleanInventory extends CrudRepository<CleaningItem, Long> {
}
