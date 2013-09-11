package me.sobolev.sd.snippet;

import net.liftweb._
import http._
import util.Helpers._
import scala.xml.NodeSeq
import me.sobolev.sd.model.Slot

class Slots {
  def render = {    
    "*" #> Slot.findAll.map(s => <li>{s.text}</li>);
  }
}
