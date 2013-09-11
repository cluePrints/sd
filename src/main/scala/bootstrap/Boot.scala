package bootstrap.liftweb

import net.liftweb.http.{Html5Properties, LiftRules, Req}
import net.liftweb.sitemap.{Menu, SiteMap}
import net.liftweb.mapper.DB
import net.liftweb.db.DefaultConnectionIdentifier
import me.sobolev.sd.model.User
import net.liftweb.mapper.Schemifier
import me.sobolev.sd.model.Slot

/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  def boot {
    DB.defineConnectionManager(DefaultConnectionIdentifier, myDBVendor)
    
    Schemifier.schemify(true, Schemifier.infoF _, User, Slot)
    
    Slot.create.text("JavaScript/frontend, 2013-Sep-10 23:30 30m").save
    Slot.create.text("Ivan Sobolev, 2013-Sep-11 23:00 1h").save
    Slot.create.text("Some CSS Guru, 2013-Sep-14 23:30 30m").save
    
    // where to search snippet
    LiftRules.addToPackages("me.sobolev.sd")
      
    // Build SiteMap
    def sitemap(): SiteMap = SiteMap(
      Menu.i("Home") / "index"
    )

    // Use HTML5 for rendering
    LiftRules.htmlProperties.default.set((r: Req) => new Html5Properties(r.userAgent))
  }
}
