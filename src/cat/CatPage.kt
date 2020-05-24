package cat

import app.cats
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button
import react.dom.div
import react.dom.footer
import react.dom.img
import react.router.dom.RouteResultProps
import react.router.dom.navLink

class CatPage : RComponent<RouteResultProps<CatPage.CatProps>, RState>() {

    interface CatProps : RProps {
        var name: String
    }

    override fun RBuilder.render() {
        val cat = cats.firstOrNull {
            it.name == props.match.params.name
        }
        if (cat == null)
            div { +"Sorry, but the cat was not found" }
        else
            div(classes = "Cat-info") {
                div {
                    +"Name: ${cat.name}"
                }
                div {
                    +"Age: ${cat.age}"
                }
                div {
                    +"Breed: ${cat.breed}"
                }
                div {
                    +"Gender: ${cat.gender}"
                }
                img(src = cat.image as? String, classes = "Cat") {}
            }
        footer(classes = "Header") {
            div {
                navLink("/cats") {
                    +"Remove cat"
                }
                attrs.onClickFunction = {
                    cats.remove(cat)
                }
            }
        }
    }
}