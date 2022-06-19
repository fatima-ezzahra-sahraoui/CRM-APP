package ma.emsi.CRMSAHRAOUI.repositories;

import ma.emsi.CRMSAHRAOUI.entities.Customer;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer,Long>{

Page<Customer> findByfirstNameContains(String Kw,PageRequest pageRequest);



}
