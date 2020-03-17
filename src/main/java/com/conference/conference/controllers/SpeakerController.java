package com.conference.conference.controllers;

import com.conference.conference.models.Session;
import com.conference.conference.models.Speaker;
import com.conference.conference.repository.SpeakersRepository;
import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vi/speakers")
public class SpeakerController {

    @Autowired
    private SpeakersRepository speakersRepository;

    @GetMapping
    public List<Speaker> list(){
        return speakersRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return speakersRepository.getOne(id);

    }

    @PostMapping
    public Speaker create(@RequestBody  Speaker speakers){
        return speakersRepository.saveAndFlush(speakers);
    }
    @GetMapping
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        speakersRepository.deleteById(id);
    }

    @GetMapping
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id,@RequestBody  Speaker speakers){
        Speaker existingSpeakers = speakersRepository.getOne(id);
        BeanUtils.copyProperties(speakers,existingSpeakers,"speaker_id");
        return speakersRepository.saveAndFlush(existingSpeakers);



    }




}
