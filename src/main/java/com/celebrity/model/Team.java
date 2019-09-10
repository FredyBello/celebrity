package com.celebrity.model;

import java.util.ArrayList;


/**
 * @author fredy.orlando
 *
 * Team class represent the team container
 * 
 * It has references to members and relationships beteween them 
 * 
 */
public class Team {
   
   ArrayList<Person> members = new ArrayList<Person>();
   
   ArrayList<Relationship> relationships = new ArrayList<Relationship>();
   
   
   Team(ArrayList<Person> members){
      this.members = members;
   }
   
   public int getTeamSize(){
      return members.size();
   }
   
   public ArrayList<Relationship> getRelationships() {
      return relationships;
   }

   public void setRelationships(ArrayList<Relationship> relationships) {
      this.relationships = relationships;
   }
   
   public ArrayList<Person> getMembers() {
      return members;
   }

   public void setMembers(ArrayList<Person> members) {
      this.members = members;
   }
}
