package cat

import kotlinx.html.js.onClickFunction
import react.*
import react.dom.div
import react.dom.img
import react.router.dom.navLink

class CatItem : RComponent<CatItem.CatProps, CatItem.CatState>() {

    interface CatState : RState {
        var breed: String
        var age: String
        var gender: String
    }

    interface CatProps : RProps {
        var name: String
        var age: String
        var breed: String
        var gender:String
        var image: dynamic
    }

    override fun RBuilder.render() {
        img(src = props.image as? String, classes = "Cat") {
            attrs.onClickFunction = {
                setState {
                    if (age != "" && age != undefined) {
                        breed = ""
                        age = ""
                        gender = ""
                    } else {
                        breed = "Breed: ${props.breed}"
                        age = "Age: ${props.age}"
                        gender = "Gender: ${props.gender}"
                    }
                }
            }
        }
        div {
            navLink("/cats/${props.name}") { +props.name }
        }
        div {
            +state.age
        }
        div {
            +state.breed
        }
        div {
            +state.gender
        }
    }
}


fun RBuilder.catItem(cat: Cat) {
    child(CatItem::class) {
        attrs.name = cat.name
        attrs.age = cat.age.toString()
        attrs.breed = cat.breed
        attrs.gender = cat.gender.toString()
        attrs.image = cat.image
    }
}