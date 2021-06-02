package com.qhala.backend.repositories;

import com.qhala.backend.models.MediaFiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<MediaFiles, Long> {
}
