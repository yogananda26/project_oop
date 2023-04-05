package home_page;

import java.util.ArrayList;

public class database {
    // this is for get the pasangger
    private static ArrayList<plane_page> list = new ArrayList<>();
    
    //this is for getter setter
    void add_history_user(plane_page input){
        list.add(input);
    }
    void get_history(int index){
        list.get(index);
    }
    ArrayList<plane_page>get_array_plane(){
        return list;
    }

}

