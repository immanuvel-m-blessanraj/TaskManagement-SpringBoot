package com.example.springtest.services;

import com.example.springtest.entities.Sample;
import com.example.springtest.exceptions.TaskNotFoundException;
import com.example.springtest.repositories.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService{

    private SampleRepository sampleRepository;
    private SampleService sampleService;


    @Override
    public List<Sample> getAllSamples() {
        List<Sample> sampleList = new ArrayList<>();
        sampleRepository.findAll()
                .forEach(sampleList::add);
        return sampleList;
    }

//    public Sample getOneSample(String taskName) {
//        return sampleRepository.findOne(taskName);
//    }

    //Finds sample by task name
    Optional<Sample> findOne(String taskName) {
        return sampleRepository.findOne(taskName);
    }

    //Finds sample by date created
    List<Sample> findByCreatedDate(Date createdAt) {
        return sampleRepository.findByCreatedDate(createdAt);
    }




    @Override
    public void createSample(String task) {
        samples.stream()
                .filter(t -> t.getTaskName().equals(task))
                .findFirst()
                .get();
    }

    @Override
    public void addSample(Sample sample) {
        sampleRepository.save(sample);
    }

    @Override
    public void updateSample(String id, Sample sample) {
        for (int i = 0; i < samples.size(); i++) {
            Sample s = samples.get(i);
            if (s.getId().equals(id)) {
                samples.set(i, sample);
                return;
            }
        }
    }

    @Override
    public void deleteSample(String id) {
        samples.removeIf(
                t -> t.getId().equals(id)
        );
    }


//    public Sample item(String taskName) {
//        Sample sample = sampleRepository.findByTitle(taskName);
//        if(taskName == null) {
//            throw new TaskNotFoundException("Task does not exist!");
//        } else {
//            return sample;
//        }
//    }

    public Sample user(String id) {
        Sample sample = sampleRepository.findById(id);
        if (id == null) {
            throw new TaskNotFoundException("Task does not exist!");
        } else {
            return sample;
        }
    }
}
