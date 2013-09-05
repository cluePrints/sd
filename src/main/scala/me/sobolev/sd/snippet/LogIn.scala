package me.sobolev.sd.snippet;

import net.liftweb._
import http._
import util.Helpers._
import scala.xml.NodeSeq

class LogIn {
  def render = {
    var name = "";
    
    def process() {
      if (name.length() < 1) {
        S.error("Name should be at least 3 chars long.(Yeah I know it's stupid, I'm just playing with validation)");
      } else {
        CurrentUser.set(name);
        S.redirectTo("/");
      }
    }
    
    "name=name" #> SHtml.onSubmit(name = _) &
    "type=submit" #> SHtml.onSubmitUnit(process);
  }
}
