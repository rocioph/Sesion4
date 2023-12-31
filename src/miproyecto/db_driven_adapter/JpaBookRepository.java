package miproyecto.db_driven_adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import miproyecto.core.domain.Book;
import miproyecto.core.domain.BookDoesNotExistException;
import miproyecto.core.driven_ports.BookRepository;
import miproyecto.db_driven_adapter.domain.BookEntity;
import miproyecto.db_driven_adapter.jparepository.HAAJpaRepository;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Component
public class JpaBookRepository implements BookRepository {
   
@Autowired //enlaza repositorio y servicio
private HAAJpaRepository haaJpaRepository;
    @Override
public Book findById(Long id) {
		java.util.Optional<BookEntity> bookEntityOptional = haaJpaRepository.findById(id);
		BookEntity bookEntity = bookEntityOptional.orElseThrow(BookDoesNotExistException::new);
		return bookEntity.toBook();
	}
}