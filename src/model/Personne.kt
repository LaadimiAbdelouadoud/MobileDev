package model

abstract class Personne(val nom:String, val prenom:String, val age:Int, val email:String?=null) {
    var adressePostsale: String=""
    constructor(nom: String,  prenom: String,  age: Int, email: String, adressePostale:String):this(nom, prenom, age, email){
        this.adressePostsale=adressePostale
    }

    init {
        if(age < 18) throw AgeInvalideException()
    }
    abstract fun afficherInfos()
}