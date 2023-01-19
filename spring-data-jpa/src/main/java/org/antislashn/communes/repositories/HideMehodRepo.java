package org.antislashn.communes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;


@NoRepositoryBean
public interface HideMehodRepo<T,ID> extends Repository<T, ID>  {

	Optional<T> findById(ID id);
}
