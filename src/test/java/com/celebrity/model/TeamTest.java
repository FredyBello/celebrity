package com.celebrity.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TeamTest {

   ArrayList<Person> members = new ArrayList<Person>();
   ArrayList<Relationship> relationships = new ArrayList<Relationship>();
   
   @Before
   public void init() {
      Person personA = new Person("Person A");
      Person personB = new Person("Person B");

      members.add(personA);
      members.add(personB);
      
      Relationship r01 = new Relationship(personA,personB);
      Relationship r02 = new Relationship(personB,personA);
      
      relationships.add(r01);
      relationships.add(r02);
   }
   
   @Test
   public void canCreateATeamWithMembers() {
      Team team = new Team(members);
      assertTrue(team.getTeamSize() == members.size());
   }
   
   @Test
   public void canCreateATeamWithMembersAndRelationships() {
      Team team = new Team(members);
      team.setRelationships(relationships);
      assertTrue(team.getTeamSize() == members.size());
      assertTrue(team.getRelationships().size() == relationships.size());
   }

}
