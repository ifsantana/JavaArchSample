package repositories;

import io.lettuce.core.support.caching.RedisCache;
import models.UserPreference;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPreferenceRepository extends RedisCache<Long, UserPreference> {

}
