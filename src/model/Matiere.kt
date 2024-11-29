package model

enum class Matiere(val description:String? = null, val coefficient:Int, val semestre: Semestre ) {
    ALGORITHMIQUE("d", 1, Semestre.S2),
    SYSTEMES_INFORMATIQUES("d", 1, Semestre.S3),
    BASES_DE_DONNEES("d", 1, Semestre.S2),
    RÉSEAUX("d", 3, Semestre.S2),
    GENIE_LOGICIEL("d", 1, Semestre.S5),
    DEVELOPPEMENT_WEB("d", 1, Semestre.S2),
    DEVELOPPEMENT_MOBIL("d", 1, Semestre.S2),
    BIG_DATA("d", 2, Semestre.S6),
    CLOUD_COMPUTING("d", 1, Semestre.S2);

    fun afficherInfos(){
        println("Nom : $name \nDescription(Majuscules) : ${description?.uppercase()}\n" +
                "Description(Minuscules) : ${description?.lowercase()}\n" +
                "Coefficient : $coefficient\nSemestre : ${semestre}\n")
    }

}


