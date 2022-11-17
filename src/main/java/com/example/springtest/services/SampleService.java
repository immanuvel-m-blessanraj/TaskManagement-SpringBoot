package com.example.springtest.services;

import com.example.springtest.entities.Sample;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Service
public interface SampleService {
    List<Sample> samples = new ArrayList<>();

    public List<Sample> getAllSamples();

    public void createSample(String task);

    public void addSample(Sample sample);

    public void updateSample(String id, Sample sample);

    public void deleteSample(String id);

}
