package org.antislashn.communes.repos;

import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface ReadRepository<T, ID> extends Repository<T, ID> {
	Optional<T> findById(ID id);
}
