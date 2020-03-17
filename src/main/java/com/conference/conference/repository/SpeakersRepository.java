package com.conference.conference.repository;

import com.conference.conference.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakersRepository extends JpaRepository<Speaker,Long> {
}
