package me.sobolev.sd.snippet;

import net.liftweb._
import util.Helpers._
import common._;
import net.liftweb.http.SessionVar

class LoggedInUser {  
  def render = "* *" #> (CurrentUser.set_? match {
    case true => <span>{CurrentUser.get}</span>;
    case false => <span data-lift="lift:embed?what=/templates/loginFormSnippet"/>
  })
}

object CurrentUser extends SessionVar[String]("Unknown");
  