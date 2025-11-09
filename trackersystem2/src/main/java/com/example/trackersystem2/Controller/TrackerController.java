package com.example.trackersystem2.Controller;

import com.example.trackersystem2.API.APIResponse;
import com.example.trackersystem2.moudle.Tracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/trackersystem")
public class TrackerController {

    public ArrayList<Tracker> tasksarr = new ArrayList<>();


@GetMapping("/gettasks")
    public ArrayList<Tracker> gettasks(){

    return tasksarr;
    }
    @PostMapping("/addtask")
    public APIResponse addtasks(@RequestBody Tracker task){
    tasksarr.add(task);
    return new APIResponse("add task succfully");
    }
    @PutMapping("/updatetask/{index}")
    public APIResponse updatetask(@PathVariable int index ,@RequestBody Tracker task){
    tasksarr.set(index,task);
        return new APIResponse("update succfully");
    }
    @DeleteMapping("/delete/{index}")
    public APIResponse deletetask(@PathVariable int index ){
   tasksarr.remove(index);
    return new APIResponse("deleted succfully");
    }
    @PutMapping("/changestatus/{index}")
    public APIResponse changestatus(@PathVariable int index){
    if(tasksarr.get(index).getStatus().equalsIgnoreCase("not done")){
        tasksarr.get(index).setStatus("done");
        return new APIResponse("CHANGE succfully");
    }
    else {
        tasksarr.get(index).setStatus("not done");
    }
        return new APIResponse("NULL");
}
@GetMapping("/find-by-title/{title}")
public Tracker findbytitle(@PathVariable String title){
    for(Tracker t : tasksarr){
        if(t.getTitle().equals(title)){
            return t;
        }

    }
    return null;
}
@GetMapping("/findbycompany/{companyname}")
public ArrayList<Tracker> allProjectByCompanyName(@PathVariable String companyname){
    ArrayList <Tracker>allprojects = new ArrayList<>();
    for(Tracker t : tasksarr){
        if(t.getCompanyname().equals(companyname)){
            allprojects.add(t);
        }
    }
    return allprojects;

}






}
