package model

class Enseignant( nom:String,  prenom:String,  age:Int,  email:String?=null, val specialite:String, val salaire:Float): Personne(nom, prenom, age, email ){

    val matieresEnCharge: ArrayList<Matiere> by lazy {
        println("Initialisation de la liste des matières...")
        ArrayList<Matiere>()
    }

    override fun afficherInfos(){
        println("Nom : $nom\nPrenom : $prenom \nAge : $age \n" +
                "Email : ${if (email != null) email else "Email introuvable"} \nSpecialite : $specialite \nSalaire : $salaire\n ")
    }

    fun ajouterMatiere(matiere: Matiere) {
        matieresEnCharge.add(matiere)
        println("Matière ajoutée : ${matiere}")
    }

    fun supprimerMatiere(matiere: Matiere) {
        val matiereSupprimee = matieresEnCharge.removeIf { it == matiere }
        if (matiereSupprimee) {
            println("Matière $matiere supprimée.")
        } else {
            println("Aucune matière trouvée avec le nom $matiere.")
        }
    }

    fun afficherMatieres() {
        if (matieresEnCharge.isEmpty()) {
            println("\nL'enseignant ${this.nom} ${this.prenom} n'a aucune matière en charge .")
        } else {
            println("\nL'enseignant ${this.nom} ${this.prenom} est chargé des matières suivantes :")
            matieresEnCharge.forEach { println("- $it") }
        }
    }

}