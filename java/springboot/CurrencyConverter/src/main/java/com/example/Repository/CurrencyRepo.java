package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Model.Currency;

public interface CurrencyRepo extends JpaRepository<Currency,Long> {

}
