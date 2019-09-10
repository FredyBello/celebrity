package com.celebrity.model;


/**
 * @author fredy.orlando
 * 
 * Relationship class is used to reprsent the relations between Team members
 * 
 * A member knows to another person
 * 
 */
public class Relationship {

   Person member;
   Person knowsTo;

   Relationship(Person member, Person knowsTo){
      this.member = member;
      this.knowsTo = knowsTo;
   }
   
   public Person getMember() {
      return member;
   }

   public void setMember(Person member) {
      this.member = member;
   }

   public Person getKnowsTo() {
      return knowsTo;
   }

   public void setKnowsTo(Person knowsTo) {
      this.knowsTo = knowsTo;
   }

}
