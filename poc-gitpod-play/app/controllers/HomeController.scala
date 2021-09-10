package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }
  /**
     * Create an Action to render an HTML page.
     *
     * The configuration in the `routes` file means that this method
     * will be called when the application receives a `GET` request with
     * a path of `/`.
     */
    val json: JsValue = Json.obj(
            "name"     -> "Watership Down",
            "location" -> Json.obj("lat" -> 51.235685, "long" -> -1.309197),
            "residents" -> Json.arr(
              Json.obj(
                "name" -> "Fiver",
                "age"  -> 4,
                "role" -> JsNull
              ),
              Json.obj(
                "name" -> "Bigwig",
                "age"  -> 6,
                "role" -> "Owsla"
              )
            )
          )
    def test() = Action { implicit request: Request[AnyContent] =>
      
      Ok(json)
    }
}
