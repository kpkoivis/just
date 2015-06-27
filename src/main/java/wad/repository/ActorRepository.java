
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.SpaceResource;

public interface ActorRepository extends JpaRepository<SpaceResource, Long> {
}
