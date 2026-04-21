package com.example.federation.service;

import com.example.federation.entity.Activity;
import com.example.federation.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository repo;

    public ActivityService(ActivityRepository repo) {
        this.repo = repo;
    }

    public Activity create(Activity activity) {
        return repo.save(activity);
    }

    public List<Activity> getAll() {
        return repo.findAll();
    }
}