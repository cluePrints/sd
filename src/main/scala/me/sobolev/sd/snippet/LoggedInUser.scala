package me.sobolev.sd.snippet;

import net.liftweb._
import util.Helpers._
import common._;
import net.liftweb.http.SessionVar

class LoggedInUser {
  object currentUser extends SessionVar[String]("Unknown");
  
  def render = "* *" #> currentUser.get
}
