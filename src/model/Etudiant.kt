package model

class Etudiant( nom:String,  prenom:String,  age:Int,  email:String?=null,  val notes: HashMap<Matiere, Float> ?= null, val semestre: Semestre): Personne(nom, prenom, age, email ){


    lateinit var matierePreferee: Matiere
    var matricule:String=""
    companion object {
        private var Counter=0
        fun getCounter()= Counter
    }
    init {
        Counter++
        genererMatricule()
    }

    fun genererMatricule(){
        this.matricule = "ETUDIANT-${getCounter().toString().padStart(4,'0')}"
    }


    fun definierMatierePreferee(matiere: Matiere){
        this.matierePreferee = matiere
    }
    fun  verifierMatierePreferee(){
        if (matierePreferee == null) println("Matiere preferee introuvable")
    }
    override fun afficherInfos(){
        println("Nom : $nom\nPrenom : $prenom \nAge : $age \n" +
                "Email : ${if (email != null) email else "Email introuvable"} \nMatiere preferee : ${if (matierePreferee != null) matierePreferee else "Matiere preferee introuvable"}\nMatricules : $matricule\n" +
                "Semestre : $semestre \nNote/Matiere: ")

        if(notes != null){
            for(n in notes){
                println("${n.key} : ${n.value}")
            }
            println()
        }
        else println("Pas de notes disponibles\n")
    }

}