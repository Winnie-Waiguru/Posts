package dev.waiguru.mycreationapplication

data class Posts(var userId:Int,
                 var id:Int,
                 var title:String,
                 var body:String
                 )

data class Comment(
    var postId:Int,
    var id:Int,
    var name:String,
    var email:String,
    var body: String
    )