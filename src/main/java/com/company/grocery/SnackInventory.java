package com.company.grocery;

import org.springframework.data.repository.CrudRepository;

public interface SnackInventory extends CrudRepository<Snack, Long> {
}
