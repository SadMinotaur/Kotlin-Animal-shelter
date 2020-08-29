package app

import react.RBuilder
import react.dom.*
import react.router.dom.navLink

fun RBuilder.headerComponent() {
    header(classes = "header baseColor") {
        table("centerTable") {
            th(classes = "tableItem") {
                navLink("/") {
                    +"Home"
                }
            }
            th(classes = "tableItem") {
                navLink("/cats") {
                    +"Cats"
                }
            }
            th(classes = "tableItem") {
                navLink("/addCat") {
                    +"Add Cat"
                }
            }
        }
    }
}