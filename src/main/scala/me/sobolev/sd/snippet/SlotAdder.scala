package me.sobolev.sd.snippet;

import net.liftweb._
import http._
import common._
import util.Helpers._
import js._
import JsCmds._
import JE._
import scala.xml.NodeSeq
import me.sobolev.sd.model.Slot
import net.liftweb.util.Helpers._

class SlotAdder {
  def render = {    
    var text = "";
    
    def process():JsCmd = {
      Slot.create.text(text).save()
      
      SetHtml("eventsList", Slots.renderAsNodes)
    }
    
    "name=text" #> (SHtml.text(text, text = _) ++ SHtml.hidden(process))
  }
}
