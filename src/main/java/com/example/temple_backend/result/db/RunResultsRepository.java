package com.example.temple_backend.result.db;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunResultsRepository extends JpaRepository<RunResultsEntity, Long> {
    // runId로 결과 조회
    Optional<RunResultsEntity> findByRun_RunId(Long runId);

//    // 특정 사용자의 모든 러닝 결과 조회
//    List<RunResultsEntity> findByRun_UserId(Long userId);
}
