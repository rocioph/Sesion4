package miproyecto.core.driven_ports;

import java.awt.print.Book;

public interface BookRepository {
	miproyecto.core.domain.Book findById(Long id);
}
