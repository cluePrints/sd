package me.sobolev.sd.model;

import net.liftweb.mapper._;

class Slot extends LongKeyedMapper[Slot] {
  def getSingleton = Slot;
 
  def primaryKeyField = id;
  object id extends MappedLongIndex(this);
  object text extends MappedString(this, 100);
}

object Slot extends Slot with LongKeyedMetaMapper[Slot] {
  
}