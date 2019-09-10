package com.celebrity.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TeamTest {
   
   @Test
   public void canCreateATeam() {
       Person personA = new Person("Person A");
       Person personB = new Person("Person B");
       ArrayList<Person> members = new ArrayList<Person>();
       members.add(personA);
       members.add(personB);

       Team team = new Team(members);
       assertTrue(team.getTeamSize() == members.size());
   }

}
