import app.headerComponent
import app.mainComponent
import kotlinext.js.*
import react.dom.*
import react.router.dom.browserRouter
import kotlinx.browser.*

fun main() {
    requireAll(require.context("src", true, js("/\\.css$/")))
    render(document.getElementById("root")) {
        browserRouter() {
            headerComponent()
            mainComponent()
        }
    }
}
