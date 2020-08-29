package app

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*

class Home : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        h1("home") {
            +"Animal Shelter"
        }
    }
}