package com.celebrity.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AnalyzerTest {
   ArrayList<Person> members = new ArrayList<Person>();
   ArrayList<Relationship> relationships = new ArrayList<Relationship>();

   Person personA = new Person("Person A");
   Person personB = new Person("Person B");
   Person personC = new Person("Person C");
   Person personD = new Person("Person D");
   Person personE = new Person("Person E"); //Person E is the celebrity
   
   @Before
   public void init() {

      members.add(personA);
      members.add(personB);
      members.add(personC);
      members.add(personD);
      members.add(personE);

      Relationship r01 = new Relationship(personA, personB);
      Relationship r02 = new Relationship(personA, personE);

      Relationship r03 = new Relationship(personB, personA);
      Relationship r04 = new Relationship(personB, personE);
      Relationship r05 = new Relationship(personB, personC);

      Relationship r06 = new Relationship(personC, personE);
      Relationship r07 = new Relationship(personC, personB);

      Relationship r08 = new Relationship(personD, personC);
      Relationship r09 = new Relationship(personD, personE);

      relationships.add(r01);
      relationships.add(r02);
      relationships.add(r03);
      relationships.add(r04);
      relationships.add(r05);
      relationships.add(r06);
      relationships.add(r07);
      relationships.add(r08);
      relationships.add(r09);
   }

   @Test
   public void canCreateAnAnalyzer() {
      Team team = new Team(members);
      team.setRelationships(relationships);
      Analyzer analyzer = new Analyzer(team);
      assertTrue(analyzer.getTeam().getTeamSize() == members.size());
      assertTrue(analyzer.getTeam().getRelationships().size() == relationships.size());

      Set<Person> teamMembers = analyzer.getTeamMembersAsSet();
      assertTrue(teamMembers.size() == 5);

      Set<Person> personsThatKnowsSomebody = analyzer.getAllPersonsThatKnowsSomebody();
      assertTrue(personsThatKnowsSomebody.size() == 4);

      Set<Person> knownPersons = analyzer.getAllKnownPersons();
      assertTrue(knownPersons.size() == 4);
      assertEquals(personE.getName(), analyzer.getCelebrityName());
   }
}
