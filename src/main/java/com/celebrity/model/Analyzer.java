package com.celebrity.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Analyzer {

   private Team team;

   Analyzer(Team team) {
      this.team = team;
   }

   public Team getTeam() {
      return team;
   }

   public void setTeam(Team team) {
      this.team = team;
   }

   public String getCelebrityName() {
      String celebrityName = "UNDEFINED";

      ArrayList<Set<Person>> eachMemberKnownPersons = getEachMemberKnownPersonsSet();
      Set<Person> celebrityCandidates = getCelebrityCandidates(eachMemberKnownPersons);
      
      if(celebrityCandidates.size()==0){
         celebrityName = "IT DOES NOT EXIST";
      }else if(celebrityCandidates.size()==1){
         celebrityName = celebrityCandidates.iterator().next().getName();
      }else{
         //
      }
      
      return celebrityName;
   }

   public Set<Person> getTeamMembersAsSet() {
      return new HashSet<Person>(team.getMembers());
   }

   public Set<Person> getAllPersonsThatKnowsSomebody() {
      Set<Person> response = new HashSet<>();

      for (Relationship relationship : team.getRelationships()) {
         response.add(relationship.getMember());
      }

      return response;
   }

   public Set<Person> getAllKnownPersons() {
      Set<Person> response = new HashSet<>();

      for (Relationship relationship : team.getRelationships()) {
         response.add(relationship.getKnowsTo());
      }

      return response;
   }

   public ArrayList<Set<Person>> getEachMemberKnownPersonsSet() {
      ArrayList<Set<Person>> knownPersonPerMember = new ArrayList<Set<Person>>();

      // First we determine each member known persons
      for (Person member : team.getMembers()) {
         Set<Person> currentMemberKnownPersons = new HashSet<Person>();
         for (Relationship relationship : team.getRelationships()) {
            if (relationship.getMember().getName().equals(member.getName())) {
               currentMemberKnownPersons.add(relationship.getKnowsTo());
            }
         }
         knownPersonPerMember.add(currentMemberKnownPersons);
      }

      return knownPersonPerMember;
   }
   
   public Set<Person> getCelebrityCandidates(ArrayList<Set<Person>> eachMemberKnownPersons){
      //All team members are candidates to be the celebrity
      Set<Person> response = getTeamMembersAsSet();
      for (Set<Person> knownPersonsSet : eachMemberKnownPersons){
         //Recurrent intersection
         if(knownPersonsSet.size()>0) //if the member doesnt knowks somebody is ignorated
         response.retainAll(knownPersonsSet);
      }
      return response;
   }
}
