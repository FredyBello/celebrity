package com.celebrity.model;

import java.util.ArrayList;

public class Team {
   
   ArrayList<Person> members = new ArrayList<Person>();
   
   Team(ArrayList<Person> members){
      this.members = members;
   }
   
   public int getTeamSize(){
      return members.size();
   }
   
}
