package com.upscale.Repository;

import com.upscale.entity.POSTINGConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigurationRepository extends JpaRepository<POSTINGConfiguration, Integer>{


    List<POSTINGConfiguration>  getByclientName(String upscale);
}
