package com.celebrity.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


/**
 * @author fredy.orlando
 * 
 * Analyzer Class is used to determine the team's Celebrity, if present
 * 
 */
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

   
   /**
    * @return the celebrity name if itis found, othrwise returns result status
    */
   public String getCelebrityName() {
      String celebrityName = "UNDEFINED";
      ArrayList<Set<Person>> eachMemberKnownPersons = getEachMemberKnownPersons();
      // List of persons that are known by everyone
      Set<Person> celebrityCandidates = getCelebrityCandidates(eachMemberKnownPersons);

      if (celebrityCandidates.size() == 0) {
         celebrityName = "ZERO CELEBRITIES CANDIDATES FOUND";
      } else if (celebrityCandidates.size() == 1) {
         Person candidateCelebrity = celebrityCandidates.iterator().next();
         if (getAllPersonsWhoKnowSomebody().contains(candidateCelebrity)) {
            celebrityName = "THE CANDIDATE CELEBRITY HAS AT LEAST ONE KNOWN PERSON";
         } else {
            celebrityName = celebrityCandidates.iterator().next().getName();
         }

      } else {
         celebrityName = "DATA IS NOT PROPERLY DEFINED, MORE THAN ONE CELEBRITY CANDIDATE WAS FOUND";
      }

      return celebrityName;
   }

   public Set<Person> getTeamMembersAsSet() {
      return new HashSet<Person>(team.getMembers());
   }

   public Set<Person> getAllPersonsWhoKnowSomebody() {
      Set<Person> response = new HashSet<>();

      for (Relationship relationship : team.getRelationships()) {
         response.add(relationship.getMember());
      }

      return response;
   }

   public ArrayList<Set<Person>> getEachMemberKnownPersons() {
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

   
   /**
    * @param eachMemberKnownPersons is the list of sets that represent each team member known Persons
    * @return the Set of Celebrity candidates (All Persons that are known by everybody)
    */
   public Set<Person> getCelebrityCandidates(ArrayList<Set<Person>> eachMemberKnownPersons) {
      // All team members are candidates to be the celebrity
      Set<Person> response = getTeamMembersAsSet();
      for (Set<Person> knownPersonsSet : eachMemberKnownPersons) {
         // if the member doesn't knows somebody: intersection is skipped to avoid empty set
         if (knownPersonsSet.size() > 0)
            response.retainAll(knownPersonsSet); // Recurrent Set intersection
      }
      return response;
   }
}
