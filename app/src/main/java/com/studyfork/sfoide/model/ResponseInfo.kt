package com.studyfork.sfoide.model

data class ResponseInfo (
    var seed: String,
    var results: Int,
    var page: Int,
    var version: String
)