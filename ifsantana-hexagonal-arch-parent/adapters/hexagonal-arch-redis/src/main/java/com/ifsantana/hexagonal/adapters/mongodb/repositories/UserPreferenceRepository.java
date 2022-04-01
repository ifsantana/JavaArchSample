package com.ifsantana.hexagonal.adapters.mongodb.repositories;

import io.lettuce.core.support.caching.RedisCache;
import com.ifsantana.hexagonal.adapters.mongodb.models.UserPreference;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPreferenceRepository extends RedisCache<Long, UserPreference> {

}
