package service;

import entity.Human;

import java.util.ArrayList;
import java.util.List;

public class HumanPool {
    private List<Human> humans = new ArrayList<>();

    public List<Human> addHuman(Human human){

        for(Human _human: humans){
            if(human == _human){
                return humans;
            }else{
                humans.add(human);
            }
        }

        return humans;
    }
}
