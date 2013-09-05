package me.sobolev.sd.model;

import net.liftweb.mapper._;

class User extends LongKeyedMapper[User] {
  def getSingleton = User;
 
  def primaryKeyField = id;
  object id extends MappedLongIndex(this);
  object nick extends MappedString(this, 100);
}

object User extends User with LongKeyedMetaMapper[User] {
  
}