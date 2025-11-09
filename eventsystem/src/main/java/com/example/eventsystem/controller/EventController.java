package com.example.eventsystem.controller;

import com.example.eventsystem.Api.ApiResponse;
import com.example.eventsystem.moudle.Event;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Track;
import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/events")
public class EventController {

    ArrayList<Event> eventsarr = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Event> getEvents(){
        return eventsarr;
    }
    @PostMapping("/add")
    public ApiResponse addevents(@RequestBody Event event){
        event.setStartdate(LocalDate.now());
        eventsarr.add(event);
        return new ApiResponse("event add succfuly");
    }
    @PutMapping("/update/{index}")
    public ApiResponse UpdateEvents(@PathVariable int index , @RequestBody Event event){
        event.setStartdate(LocalDate.now());
        eventsarr.set(index,event);
        return new ApiResponse("updated succfully");
    }
    @DeleteMapping("/remove/{index}")
    public ApiResponse Removeevents(@PathVariable int index){
        eventsarr.remove(index);
        return new ApiResponse("deleted succfully");
    }
    @PutMapping("/capacity/{index}/{capacity}")
    public ApiResponse ChangeCapacity(@PathVariable int index , @PathVariable int capacity ){
        eventsarr.get(index).setCapacity(capacity);
        return new ApiResponse("capacity changed");
    }
    @GetMapping("/findbyid/{index}")
    public Event findbyid(@PathVariable String index){
        for(Event e : eventsarr){
            if(e.getId().equals(index)){
               return e;
            }
        }
        return null;
    }



}
