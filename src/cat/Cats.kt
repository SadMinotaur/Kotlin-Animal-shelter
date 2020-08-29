package cat

import app.catFooter
import app.cats
import org.w3c.dom.events.Event
import react.*
import react.dom.*
import react.dom.tr

class Cats : RComponent<CatPage.CatProps, Cats.CatsState>() {

    init {
        state.cats = cats
        state.onSortAge = { sortAge() }
        state.onSortName = { sortName() }
        state.sorted = Sorted.Start
    }

    interface CatsState : RState {
        var cats: ArrayList<Cat>
        var onSortAge: (Event) -> Unit
        var onSortName: (Event) -> Unit
        var sorted: Sorted
    }

    override fun RBuilder.render() {
        table(classes = "Cat-table") {
            for (i in state.cats) {
                tr {
                    catItem(i)
                }
            }
        }
        catFooter(state.onSortAge, state.onSortName)
    }

    private fun sortAge() {
        if (state.sorted == Sorted.ByAgeDesc) {
            setState {
                state.cats.sortBy { cat -> cat.age }
            }
            state.sorted = Sorted.ByAgeAsc
        } else {
            setState {
                state.cats.sortByDescending { cat -> cat.age }
            }
            state.sorted = Sorted.ByAgeDesc
        }
    }

    private fun sortName() {
        if (state.sorted != Sorted.ByNameAsc) {
            setState {
                state.cats.sortBy { cat -> cat.name }
            }
            state.sorted = Sorted.ByNameAsc
        } else {
            setState {
                state.cats.sortByDescending { cat -> cat.name }
            }
            state.sorted = Sorted.ByNameDesc
        }
    }
}