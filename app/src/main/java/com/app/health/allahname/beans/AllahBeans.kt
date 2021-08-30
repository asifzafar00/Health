package com.app.health.allahname.beans

import java.io.Serializable

class AllahBeans(
    var icon: Int,
    var names: String? = null,
    var meaning: String? = null,
    var description: String? = null
) : Serializable {

}