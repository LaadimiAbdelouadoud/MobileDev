package model

class Enseignant( nom:String,  prenom:String,  age:Int,  email:String?=null, val specialite:String, val salaire:Float, val matieresEnCharge: ArrayList<Matiere>): Personne(nom, prenom, age, email ){

    override fun afficherInfos(){
        println("Nom : $nom\nPrenom : $prenom \nAge : $age \n" +
                "Email : ${if (email != null) email else "Email introuvable"} \nSpecialite : $specialite \nSalaire : $salaire\n ")
    }

}