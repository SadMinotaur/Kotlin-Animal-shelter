package app

import cat.Cat
import cat.Cats
import cat.CatPage
import cat.Gender
import react.RBuilder
import react.dom.div
import react.router.dom.route
import react.router.dom.switch

fun RBuilder.mainComponent() {
    div("div") {
        switch() {
            route(
                    exact = true,
                    path = "/",
                    component = Home::class
            )
            route(
                    exact = true,
                    path = "/cats",
                    component = Cats::class
            )
            route(
                    path = "/cats/:name",
                    component = CatPage::class
            )
            route(
                    exact = true,
                    path = "/addCat",
                    component = AddCat::class
            )
        }
    }
}

val cats = arrayListOf(
        Cat(
                "Uksus",
                1,
                "Siamese",
                Gender.Male,
                uksus
        ),
        Cat(
                "Lulu",
                6,
                "Munchkin",
                Gender.Male,
                lulu
        ),
        Cat(
                "Maru",
                10,
                "Scottish Straight",
                Gender.Male,
                maru
        ),
        Cat(
                "Hana",
                4,
                "Tabby",
                Gender.Female,
                hana
        )
)

@JsModule("src/resources/lulu.png")
external val lulu: dynamic

@JsModule("src/resources/maru.PNG")
external val maru: dynamic

@JsModule("src/resources/hana.PNG")
external val hana: dynamic

@JsModule("src/resources/uksus.PNG")
external val uksus: dynamic