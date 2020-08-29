package app

import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.RBuilder
import react.dom.button
import react.dom.div
import react.dom.footer

fun RBuilder.catFooter(sortAge: (Event) -> Unit, sortName: (Event) -> Unit) {
    footer(classes = "footer baseColor") {
        button(classes = "buttonFooter") {
            +"Sort by age"
            attrs.onClickFunction = sortAge
        }
        button(classes = "buttonFooter") {
            +"Sort by name"
            attrs.onClickFunction = sortName
        }
    }
}