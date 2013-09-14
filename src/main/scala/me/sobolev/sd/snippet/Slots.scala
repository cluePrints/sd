package me.sobolev.sd.snippet;

import net.liftweb._
import http._
import util.Helpers._
import scala.xml.NodeSeq
import me.sobolev.sd.model.Slot

object Slots {
  def render = {
    // add content as children 
    "* *+" #> renderAsNodes
  }
  
  def renderAsNodes:NodeSeq = {
    Slot.findAll.map(s => renderSlot(s))
  }
  
  def renderSlot(s:Slot) = {
    <li>{s.text}</li>
  }     
}
