
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Reservation;

public interface MovieRepository extends JpaRepository<Reservation, Long> {
}
