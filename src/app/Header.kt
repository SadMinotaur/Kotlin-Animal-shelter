package app

import react.RBuilder
import react.dom.*
import react.router.dom.navLink

fun RBuilder.headerComponent() {
    header(classes = "Header") {
        navLink("/") {
            +"Home"
        }
        navLink("/cats") {
            +"Cats"
        }
        navLink("/addCat") {
            +"Add Cat"
        }
    }
}