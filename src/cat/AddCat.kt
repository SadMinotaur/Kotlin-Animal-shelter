package app

import cat.Cat
import cat.Gender
import kotlinext.js.getOwnPropertyNames
import kotlinx.html.InputType
import kotlinx.html.input
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.html.onChange
import org.w3c.dom.events.Event
import org.w3c.files.Blob
import org.w3c.files.File
import org.w3c.files.FileReader
import react.*
import react.dom.*
import react.router.dom.navLink

class AddCat : RComponent<RProps, AddCat.AddCatState>() {

    init {
        state.gender = Gender.Male
    }

    override fun RBuilder.render() {
        table {
            tbody {
                tr {
                    td {
                        +"Name:"
                        input {
                            attrs.type = InputType.text
                            attrs.onChangeFunction = {
                                state.name = it.target.asDynamic().value as String
                            }
                        }
                    }
                    td {
                        +"Age:"
                        input {
                            attrs.type = InputType.text
                            attrs.onChangeFunction = {
                                state.age = it.target.asDynamic().value
                            }
                        }
                    }
                    td {
                        +"Breed:"
                        input {
                            attrs.type = InputType.text
                            attrs.onChangeFunction = {
                                state.breed = it.target.asDynamic().value as String
                            }
                        }
                    }
                    td {
                        +"Gender:"
                        select {
                            option { +"Male" }
                            option { +"Female" }
                            attrs.onChangeFunction = {
                                state.gender = if (state.gender == Gender.Male)
                                    Gender.Female
                                else
                                    Gender.Male
                            }
                        }
                    }
                }
            }
        }
        div {
            +"Image:"
            input {
                attrs.type = InputType.file
                attrs.onChangeFunction = {
                    val reader = FileReader()
                    reader.readAsDataURL(it.target.asDynamic().files[0])
                    reader.onloadend = {
                        setState {
                            image = reader.result
                        }
                    }
                }
            }
        }
        div {
            attrs.onClickFunction = {
                cats.add(
                        Cat(
                                state.name,
                                state.age,
                                state.breed,
                                state.gender,
                                state.image
                        ))
            }
            navLink("/cats") { +"Send cat" }
        }
        div {
            +"Loaded cat: "
        }
        img(src = state.image as? String) {}
    }

    interface AddCatState : RState {
        var name: String
        var age: Int
        var breed: String
        var gender: Gender
        var image: dynamic
    }
}