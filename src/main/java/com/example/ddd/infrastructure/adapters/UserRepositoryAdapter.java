package com.example.ddd.infrastructure.adapters;

import com.example.ddd.application.ports.UserRepository;
import com.example.ddd.domain.shared.Id;
import com.example.ddd.domain.user.User;
import com.example.ddd.domain.user.Username;
import com.example.ddd.infrastructure.repository.user.UserEntity;
import com.example.ddd.infrastructure.repository.user.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository jpaRepository;

    public UserRepositoryAdapter(UserJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }


    @Override
    public void save(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId().value().toString());
        entity.setUsername(user.getUsername().value());
        entity.setCanBorrow(user.canBorrow());

        jpaRepository.save(entity);
    }

    @Override
    public Optional<User> findById(Id id) {
        Optional<UserEntity> entity = jpaRepository.findById(id.value().toString());
        return entity.map(this::toUser);
    }

    private User toUser(UserEntity entity) {
        return User.of(
                Id.of(entity.getId()),
                Username.of(entity.getUsername()),
                entity.getCanBorrow()
        );
    }
}
