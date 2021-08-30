package com.app.health.allahname.commm

import com.app.health.allahname.beans.AllahBeans

interface AllahClickListener {
    fun ItemClickLisetner(bean: AllahBeans)
    fun ItemName(bean: String?=null)
}