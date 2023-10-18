package com.udemy.repository;

import com.udemy.entity.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//<Entité constituant l'aggregate root, Type de l'identifiant de l'agreggate root>
public interface InvoiceRepositoryInterface extends CrudRepository<Invoice, String> {

}
