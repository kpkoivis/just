
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.resource.HumanResource;

public interface HumanResourceRepository extends JpaRepository<HumanResource, Long> {
}
