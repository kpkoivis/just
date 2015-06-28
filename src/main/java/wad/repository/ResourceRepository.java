
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.resource.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
