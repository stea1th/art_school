package art.school.repository.datajpa;

import art.school.entity.NachrichtUpdater;
import art.school.entity.NachrichtUpdaterId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudNachrichtUpdaterRepository extends JpaRepository<NachrichtUpdater, NachrichtUpdaterId> {

    @org.jetbrains.annotations.NotNull @NotNull
    @Override
    Optional<NachrichtUpdater> findById(@org.jetbrains.annotations.NotNull NachrichtUpdaterId updaterId);




}
