package me.sobolev.sd.snippet;

import net.liftweb._
import http._
import util.Helpers._
import scala.xml.NodeSeq
import me.sobolev.sd.model.Slot

class SlotAdder {
  def render = {    
    var text = "";
    
    def process() {
      Slot.create.text(text).save
    }
    
    "name=text" #> SHtml.onSubmit(text = _) &
    "type=submit" #> SHtml.onSubmitUnit(process);
  }
}
