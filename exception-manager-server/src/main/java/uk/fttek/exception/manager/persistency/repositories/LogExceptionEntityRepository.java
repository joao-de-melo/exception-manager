package uk.fttek.exception.manager.persistency.repositories;

import uk.fttek.exception.manager.persistency.model.LogExceptionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogExceptionEntityRepository extends MongoRepository<LogExceptionEntity, String> {
}
